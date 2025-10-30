package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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


    public static void write(String filePath, String sheetName, ArrayList<ArrayList<String>> table) {

        // javanin anlamasi icin sanal bir calisma kitabi olusturduk
        Workbook workbook = new XSSFWorkbook();

        // disaridan aldigimiz sheet ismi ile yeni bir sheet ekledik woorkbook icerisine
        Sheet sheet = workbook.createSheet(sheetName);

        // bu nested loop ta ise disaridan aldigimiz tablonun bilgilerine göre
        // satir ve sütunlari hücrelere ekledik
        for (int i = 0; i < table.size(); i++) {
            // tablo uzunluguna göre satir olusturuyoruz
            Row row = sheet.createRow(i);
            // tablodaki satirlardaki bilgileri list icerisine aldik
            ArrayList<String> rowData = table.get(i);
            // Sirasiyla satir icerisinde gezip sütunlari dolduruyoruz
            for (int j = 0; j < rowData.size(); j++) {
                // bu asamada sütun ayni zamanda hücreyi temsil ediyor.
                // O yüzden her adimda yeni hücre olusturuyoruz
                Cell cell = row.createCell(j);
                // hücre olusturduktan sonra ise icerisine bilgiyi ekliyoruz
                cell.setCellValue(rowData.get(j));
            }
        }

        try {
            // dosya ciktisi icin uzantiyi belirttik
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            // sanal calisma kitabindaki bilgileri olusturulan dosyaya yazdik
            workbook.write(fileOutputStream);
            // sanal calisma kitabini kapattik
            workbook.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
