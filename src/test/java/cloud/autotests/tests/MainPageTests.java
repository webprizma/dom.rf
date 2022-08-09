package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Dom.rf tests")
    void generatedTest() {
        step("Open дом.рф", () -> {
            step("// todo: just add selenium action");
        });

        step("Сlick menu", () -> {
            step("// todo: just add selenium action");
        });

        step("Go to `about`", () -> {
            step("// todo: just add selenium action");
        });

        step("Check heading", () -> {
            step("// todo: just add selenium action");
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldHaveNotErrorsTest() {
        step("Open url `https://xn--d1aqf.xn--p1ai/about/`", () ->
            open("https://xn--d1aqf.xn--p1ai/about/"));

        step("Console logs should not contain text `SEVERE`", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}