package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelHelper {

    public static ArrayList<ArrayList<String>> read(String filePath, String sheetName, int columnNumber) {
        // excel deki bilgileri okumak icin baslangicta 2 boyutlu bir list olusturduk
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        // try blogu disinda da sheet kullanicagim icin burda tanimladik ve baslangic degerine null atadik
        Sheet sheet = null;
        try {
            // Dosya uzantisini vererek doyayi okuduk
            FileInputStream fileInputStream = new FileInputStream(filePath);

            // okudugumuz dosyayi yani exceli sanal calisma kitabina ekledik
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            // sanal calisma kitabinda bir sheet olusturduk bunun ismini de parametreden aldik
            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Excel deki dolu olan tüm satirlari getPhysicalNumberOfRows method ile okuduk
        for (int row = 0; row < sheet.getPhysicalNumberOfRows(); row++) {

            // Her satirda sütunlara göre birden fazla eleman olabilir o yüzden List tanimladik
            ArrayList<String> rows = new ArrayList<>();

            for (int column = 0; column < columnNumber ; column++) {
                // yukaridaki listeye sirasiyla sütunlardaki hücrelerin bilgilerini ekledik
                rows.add(sheet.getRow(row).getCell(column).toString());
            }
            // en son bu satirlari sütunlarda dahil olacak sekilde tabloya ekledik
            table.add(rows);
        }

        // bu tablo exceli 2 boyutlu list halinde javanin anlayacagi bir yapiya dönüstürdü
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

    public static void writeReport(String filePath, String scenarioName, String testResult) {

        // Parametre olarak file path verdim ve File clasiyla dosya olusturdum
        File file = new File(filePath);

        // Burada testi calistirdigimda ne zaman calistigini görmek icin LocalDateTime kullandik
        String testTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        try {
            // Verdigim dosya uzantisinda eger dosya yoksa islemleri
            if (!file.exists()) {
                // Sanal bir calisma kitabi olusturduk
                Workbook workbook = new XSSFWorkbook();
                // Bu calisma kitabinda sheet icin isim verdik
                Sheet sheet = workbook.createSheet("Test Result");

                // Header yani baslik kismi icin 0. satiri olusturduk
                Row row = sheet.createRow(0);

                // 0. satirin ilk hücresi yani ilk sütunu olusturduk ve deger atadik
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(scenarioName);

                // 0. satirin ikinci hücresi yani ikinci sütunu olusturduk ve deger atadik
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(testResult);

                // 0. satirin 3. hücresi yani 3. sütunu olusturduk ve deger atadik
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(testTime);

                // Burada ise workbook ta olusturdugumuz dosyayi parametre olarak
                // verilen dosya uzantisina cikardik
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                // Calisma kitabindaki bilgileri dosyaya yazdik
                workbook.write(fileOutputStream);
                // Sanal calisma kitabini kapattik
                workbook.close();
            } else {
                // Eger parametrede verilen dosya uzantisinda excel dosyasi varsa bölümü
                // Dosyayi okuduk
                FileInputStream fileInputStream = new FileInputStream(filePath);
                // Sanal calisma kitabi icerisine aktardik
                Workbook workbook = new XSSFWorkbook(fileInputStream);

                // Dosyadaki ilk sheeti cagirdik
                Sheet sheet = workbook.getSheetAt(0);

                // sheet icerisinde olan satirlari olusturduk
                Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

                // ilk satira 1. hücreyi ekledik
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(scenarioName);

                // ilk satira 2. hücreyi ekledik
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(testResult);

                // ilk satira 3. hücreyi ekledik
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(testTime);

                // dosya okuma nesnesini kapattik
                fileInputStream.close();

                // olusan dosyayi cikarmak icin parametre olarak aldigimiz dosya uzantisini kullandik
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                // sanal calisma kitabinda olusan belgeyi dosyaya yazdik
                workbook.write(fileOutputStream);
                // sanal calisma kitabini kapattik
                workbook.close();
                // dosya yazma nesnesini kapattik
                fileOutputStream.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
