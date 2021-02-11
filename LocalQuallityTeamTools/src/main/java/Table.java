import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Table {
    String name;
    String pathToTable;
    BufferedReader reader;
    HSSFWorkbook workbook;
    POIFSFileSystem fs;


    public Table () throws IOException {
        reader = new BufferedReader(new FileReader("src/main/resources/path.txt"));
        pathToTable = reader.readLine();
        try {
            workbook = new HSSFWorkbook ((new POIFSFileSystem(new File(pathToTable))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = workbook.getSheetAt(0);
        int count =-1;
        Iterator<Row> iterator = sheet.iterator();
        HSSFRow row;

        while(iterator.hasNext()){
            count++;
            iterator.next();
            if (count<12){
                continue;
            }
            row = sheet.getRow(count);
            Cell article = row.getCell(3);
            Cell supplier = row.getCell(9);
            Cell docNumber = row.getCell(10);
            Cell docVersion = row.getCell(11);
            Cell whatWrong = row.getCell(18);
            switchCellType(article);
            switchCellType(supplier);
            switchCellType(docNumber);
            switchCellType(docVersion);
            switchCellType(whatWrong);
            System.out.println();
        }
      //  HSSFRow hssfrow = sheet.getRow(13);
      //  HSSFCell cell = hssfrow.getCell(3);
      //  String value = cell.getStringCellValue();
      //  System.out.println(value);

    }
    public void switchCellType(Cell cell){
        switch (cell.getCellTypeEnum()) {
            case _NONE:
                System.out.print("");
                System.out.print("\t");
                break;
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                System.out.print("\t");
                break;
            case BLANK:
                System.out.print("");
                System.out.print("\t");
                break;
            case FORMULA:
                // Formula
                System.out.print(cell.getCellFormula());
                System.out.print("\t");

                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                // Print out value evaluated by formula
                System.out.print(evaluator.evaluate(cell).getNumberValue());
                break;
            case NUMERIC:
                System.out.print(cell.getNumericCellValue());
                System.out.print("\t");
                break;
            case STRING:
                System.out.print(cell.getStringCellValue());
                System.out.print("\t");
                break;
            case ERROR:
                System.out.print("!");
                System.out.print("\t");
                break;

        }

    }


}
