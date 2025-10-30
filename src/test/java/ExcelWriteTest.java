import utility.ExcelHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class ExcelWriteTest {
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> data = new ArrayList<>();

        data.add(new ArrayList<>(Arrays.asList("Name", "Title", "Age")));
        data.add(new ArrayList<>(Arrays.asList("Seyma", "Tester", "34")));
        data.add(new ArrayList<>(Arrays.asList("Zilha", "SDET", "29")));
        data.add(new ArrayList<>(Arrays.asList("Rüya", "API Tester", "29")));

        ExcelHelper.write("src/test/resources/students.xlsx", "Batch 8", data);
    }
}
