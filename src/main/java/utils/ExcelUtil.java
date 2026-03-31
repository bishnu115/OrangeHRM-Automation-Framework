package utils;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelUtil {

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;

    // 1. First, we need a method to "Open" the excel file
    public static void oepnExcel(String path, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("Excel file not found at: " + path);
        }
    }

    // 2. The method you asked for: Pass Row and Col, get the Value
    public static String getSpecificData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter(); // This ensures data comes as String
        XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
        return formatter.formatCellValue(cell);
    }
}