package com.screenp.automatizationfront.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private final String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public String[] getUserData(int rowNumber) throws IOException {
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNumber);

            String[] userData = new String[2];
            userData[0] = getCellValue(row, 0); // First Name
            userData[1] = getCellValue(row, 1); // Last Name

            return userData;

        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    private String getCellValue(Row row, int cellIndex) {
        if (row == null) {
            return ""; // Manejar filas nulas si es necesario
        }
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            return ""; // Devuelve una cadena vacía si la celda es nula
        }
        return cell.getStringCellValue(); // O el tipo de dato necesario, si es diferente
    }
}
