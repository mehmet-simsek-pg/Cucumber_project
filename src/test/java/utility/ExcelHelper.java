package utility;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.*;

public class ExcelHelper {

    public static ArrayList<ArrayList<String>> read(String filePath, String sheetName, int columnNumber) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        Sheet sheet = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);

            Workbook workbook = WorkbookFactory.create(fileInputStream);

            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int row = 0; row < sheet.getPhysicalNumberOfRows(); row++) {

            ArrayList<String> rows = new ArrayList<>();

            for (int column = 0; column < columnNumber ; column++) {
                rows.add(sheet.getRow(row).getCell(column).toString());
            }
            table.add(rows);
        }

        return table;
    }
}
