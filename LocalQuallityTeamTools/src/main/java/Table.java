import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Table {

    String pathToTable;
    BufferedReader reader;
    HSSFWorkbook workbook;
    HSSFWorkbook workbook2;
    POIFSFileSystem fs;
    Data data = new Data();


    public Table () throws IOException {
        reader = new BufferedReader(new FileReader("src/main/resources/path.txt"));
        pathToTable = reader.readLine();
        try {
            workbook = new HSSFWorkbook ((new POIFSFileSystem(new File(pathToTable))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheetLCI = workbook.getSheetAt(1);
        HSSFSheet pallets = workbook.getSheetAt(0);
        int count =-1;
        HSSFRow rowLCI;
        HSSFRow rowPallets;
        Iterator<Row> iteratorPallets = pallets.iterator();
        Iterator<Row> iteratorLCI;
      while (iteratorPallets.hasNext()){
          Row palletsRow = iteratorPallets.next();
          Cell packageID = palletsRow.getCell(0);
          Cell palletsArticle = palletsRow.getCell(1);
          Cell palletsSupplier = palletsRow.getCell(2);
          Cell status = palletsRow.getCell(3);
          Cell regDate = palletsRow.getCell(4);
          Cell division = palletsRow.getCell(5);
          String palletsPackageId = switchCellType(packageID).toString();
          String articlePalletsString = switchCellType(palletsArticle);
          String supplierPalletsString = switchCellType(palletsSupplier);
          String statusPalletsString = switchCellType(status);
          String divisionPalletsString = switchCellType(division);

          iteratorLCI = sheetLCI.iterator();
          while(iteratorLCI.hasNext()){
              count++;
              iteratorLCI.next();
              if (count<12){
                  continue;
              }
              rowLCI = sheetLCI.getRow(count);
              Cell articleLCI = rowLCI.getCell(3);
              Cell supplierLCI = rowLCI.getCell(9);
              Cell docNumber = rowLCI.getCell(10);
              Cell docVersion = rowLCI.getCell(11);
              Cell whatWrong = rowLCI.getCell(18);
              String articleLCIString = switchCellType(articleLCI);
              String supplierLCIString =switchCellType(supplierLCI);
              String docNumberLCIString =switchCellType(docNumber);
              String docVersionLCIString =switchCellType(docVersion);
              String whatWrongLCIString =switchCellType(whatWrong);
              if (articlePalletsString.equals(articleLCIString) && supplierPalletsString.equals(supplierLCIString)){
                  data.addAll(articlePalletsString,supplierPalletsString,divisionPalletsString,palletsPackageId,statusPalletsString,docNumberLCIString,docVersionLCIString,whatWrongLCIString);
              }
          }

          count =-1;
      }data.writeAll(workbook2);

    }
    public String switchCellType(Cell cell){
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
