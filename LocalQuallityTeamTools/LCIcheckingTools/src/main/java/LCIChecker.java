import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class LCIChecker {
    Table lCIReport;
    Table astro;
    static int count =0;
    int rowNum;



    public LCIChecker() {
        lCIReport = new Table(12, true);
        astro = new Table(0, false);
        while (astro.iterator.hasNext()){
            count++;
            astro.row = astro.iterator.next();
            astro.readValues = astro.readValues(4,5,0, 7,10);
            lCIReport.iterator = lCIReport.sheet.iterator();
            lCIReport.count = -1;
            while (lCIReport.iterator.hasNext()) {
                lCIReport.count++;
                lCIReport.iterator.next();
                if (lCIReport.count < lCIReport.startRead) {
                    continue;
                }
                lCIReport.row = lCIReport.sheet.getRow(lCIReport.count);
                lCIReport.readValues = lCIReport.readValues(3,9,10,11,18);



                if (astro.readValues[0].equals(lCIReport.readValues[0]) && astro.readValues[1].equals(lCIReport.readValues[1])){
                    try {
                        new Data(astro.readValues[0],astro.readValues[1],astro.readValues[2],astro.readValues[3],astro.readValues[4],lCIReport.readValues[2],lCIReport.readValues[3],lCIReport.readValues[4]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        getResult();

    }
    public void getResult(){
        rowNum =0;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("result");
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("packageID");
        row.createCell(1).setCellValue("article");
        row.createCell(2).setCellValue("supplier");
        row.createCell(3).setCellValue("division");
        row.createCell(4).setCellValue("status");
        row.createCell(5).setCellValue("docNumberDocVersionWhatsWrong");
        for (int i = 0 ; i < Data.dataList.size(); i++) {
            createSheetHeader(sheet, ++rowNum);


        }
        String createPath = Settings.readPath("./LCIResult.txt");
        try (FileOutputStream out = new FileOutputStream(new File(createPath));) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createSheetHeader(HSSFSheet sheet, int rowNum) {
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(Data.dataList.get(rowNum-1).getPackageID());//this.packageID.get(rowNum-1));
        row.createCell(1).setCellValue(Data.dataList.get(rowNum-1).getArticle());//this.article.get(rowNum-1));
        row.createCell(2).setCellValue(Data.dataList.get(rowNum-1).getSupplier());//this.supplier.get(rowNum-1));
        row.createCell(3).setCellValue(Data.dataList.get(rowNum-1).getDivision());//this.division.get(rowNum-1));
        row.createCell(4).setCellValue(Data.dataList.get(rowNum-1).getStatus());//this.status.get(rowNum-1));
        row.createCell(5).setCellValue(Data.dataList.get(rowNum-1).getDocNumberVersionWhatsWrong());//this.docNumberVersionWhatsWrong.get(rowNum-1));
    }

    class Table{
        Workbook workbook;
        Sheet sheet;
        Row row;
        String pathToTable;
        public String[] readValues = new String[5];
        int startRead;
        int count = -1;
        Iterator<Row> iterator;
        public Table(int startRead, boolean isXlsx){
            this.startRead = startRead;


            if (isXlsx){
                try {
                    pathToTable = Settings.readPath("./LCICheckingReport.txt");
                    workbook = new XSSFWorkbook(pathToTable);
                } catch (IOException e) {
                    e.printStackTrace();
                }
           }else {
               try {
                   pathToTable = Settings.readPath("./ASTRO.txt");
                   workbook = new HSSFWorkbook ((new POIFSFileSystem(new File(pathToTable))));
               } catch (IOException e) {
                   e.printStackTrace();
               }
          }


            sheet = workbook.getSheetAt(0);

            iterator = sheet.iterator();

        }
        public String readValue(int cellNum){
            String value = getValue(row.getCell(cellNum));
            return value;
        }
        public String[] readValues(int i, int j , int m, int n, int t){
            String[] readValues = new String[5];
            readValues[0]= readValue(i);//art 3
            readValues[1] = readValue(j);//sup 9
            readValues[2] = readValue(m);//docNum 10
            readValues[3] = readValue(n);//docVer 11
            readValues[4] = readValue(t);//wrong 18
            return readValues;
        }

        public String getValue (Cell cell){
            switch (cell.getCellTypeEnum()) {
                case _NONE:
                    return "";
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case BLANK:
                    return "";
                case NUMERIC:
                    return String.valueOf(cell.getNumericCellValue());
                case STRING:
                    return cell.getStringCellValue();
                case ERROR:
                    return "!";
            }
            return "";
        }
    }
}
