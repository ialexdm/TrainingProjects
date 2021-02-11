import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<String> packageID;
    private List<String> article;
    private List<String> supplier;
    private List<String> division;
    private List<String> status;
    private List<String> docNumberVersionWhatsWrong;
    private int count;
    private int rowNum;
    public Data(){
        count=0;
        rowNum=0;
        packageID = new ArrayList<>();
        article = new ArrayList<>();
        supplier = new ArrayList<>();
        division = new ArrayList<>();
        status = new ArrayList<>();
        docNumberVersionWhatsWrong = new ArrayList<>();
    }

    public void addAll(String article, String supplier, String division, String packageID, String status, String docNumber, String docVersion, String whatsWrong){
        count++;
        this.article.add(article);
        this.supplier.add(supplier);
        this.division.add(division);
        this.packageID.add(packageID);
        this.status.add(status);
        this.docNumberVersionWhatsWrong.add(docNumber + "-" + docVersion + " = " + whatsWrong);
        System.out.println(packageID + " " + article + " " + supplier + " " + division + " " + status + " " + docNumber + "-" + docVersion + " = " + whatsWrong);
    }
    public void writeAll(HSSFWorkbook workbook){
        workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("result");
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("packageID");
        row.createCell(1).setCellValue("article");
        row.createCell(2).setCellValue("supplier");
        row.createCell(3).setCellValue("division");
        row.createCell(4).setCellValue("status");
        row.createCell(5).setCellValue("docNumberDocVersionWhatsWrong");
        for (int i = 0 ; i < count; i++) {
            createSheetHeader(sheet, ++rowNum);
        }
        try (FileOutputStream out = new FileOutputStream(new File("src/main/resources/LCI2.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }

    private void createSheetHeader(HSSFSheet sheet, int rowNum) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(this.packageID.get(rowNum-1));
        row.createCell(1).setCellValue(this.article.get(rowNum-1));
        row.createCell(2).setCellValue(this.supplier.get(rowNum-1));
        row.createCell(3).setCellValue(this.division.get(rowNum-1));
        row.createCell(4).setCellValue(this.status.get(rowNum-1));
        row.createCell(5).setCellValue(this.docNumberVersionWhatsWrong.get(rowNum-1));
    }
}
