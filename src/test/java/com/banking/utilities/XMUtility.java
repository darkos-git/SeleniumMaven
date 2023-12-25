package com.banking.utilities;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalDateTime;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMUtility {
    public static FileInputStream fis;
    public static FileOutputStream fos;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFCell cell;
    public static XSSFRow row;

    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        fis = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(xlsheet);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fis.close();
        return rowCount;

    }

    public static int getCellCount(String xlfile, String xlsheat, int rowNum) throws IOException {
        fis = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(xlsheat);
        row = ws.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fis.close();
        return cellCount;

    }

    public static String getCellData(String xlfile, String xlsheat, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(xlsheat);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);
        String data;

        try {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        fis.close();
        return data;

    }

    public static void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data) throws IOException {
        fis = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);
        fos = new FileOutputStream(xlfile);
        wb.write(fos);
        wb.close();
        fis.close();
        fos.close();


    }


}