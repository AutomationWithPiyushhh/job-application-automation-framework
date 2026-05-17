package utils;

import models.RecruiterData;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<RecruiterData> getRecruiterData(
            String filePath) {

        List<RecruiterData> recruiters =
                new ArrayList<>();

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheetAt(0);

            int rows =
                    sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rows; i++) {

                XSSFRow row = sheet.getRow(i);

                recruiters.add(
                        new RecruiterData(
                                row.getCell(0).getStringCellValue(),
                                row.getCell(1).getStringCellValue(),
                                row.getCell(2).getStringCellValue(),
                                row.getCell(3).getStringCellValue()
                        )
                );
            }

            workbook.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to read excel");
        }

        return recruiters;
    }
}