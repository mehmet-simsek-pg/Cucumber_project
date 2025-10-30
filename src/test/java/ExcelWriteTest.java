import utility.ExcelHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class ExcelWriteTest {
    public static void main(String[] args) {

        // satir sütun olmasi icin 2 boyutlu bir arraylist tanimladik
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        // 2 boyutlu arrayliste ekleme yaparken benden bir boyutlu bir arrylist istiyoru.
        // O yüzden new ArrayList kullandik. Bilgileri tek tek eklemekle ugrasmamak icin ise
        // Arrays.asList methodunu kullandik.
        // Ilk satir yazdiklarimiz excel de baslik kismini olusturuyor
        data.add(new ArrayList<>(Arrays.asList("Name", "Title", "Age")));
        data.add(new ArrayList<>(Arrays.asList("Seyma", "Tester", "34")));
        data.add(new ArrayList<>(Arrays.asList("Zilha", "SDET", "29")));
        data.add(new ArrayList<>(Arrays.asList("Rüya", "API Tester", "29")));

        // ilk parametre dosyanin ciktisinin nereye olacagi,
        // 2. parametre excel dosyasindaki sheet name
        // son parametre ise hücrelere yazilacak bilgiler
        ExcelHelper.write("src/test/resources/students.xlsx", "Batch 8", data);
    }
}
