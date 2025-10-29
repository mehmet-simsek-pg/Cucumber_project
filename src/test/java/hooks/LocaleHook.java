package hooks;

import io.cucumber.java.BeforeAll;
import java.util.Locale;

public class LocaleHook {
    @BeforeAll
    public static void forceEnglish() {
        Locale.setDefault(Locale.ENGLISH);
    }
}
