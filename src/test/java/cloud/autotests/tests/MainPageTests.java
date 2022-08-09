package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @DisplayName("При клике на пункт меню `О компании` должна открыться страница `О компании` с заголовком `О компании`")
    void burgerMenuTest() {
        step("Открыть страницу `дом.рф`", () ->
                open("https://xn--d1aqf.xn--p1ai/"));

        step("Кликнуть на бургер-меню", () ->
                $(".header-buttons__burger-button").click());

        step("Кликнуть на пункт меню `О компании`", () ->
                $x("//a[text()='О компании']").click());

        step("Заголовок h1 должен содержать текст `О компании`", () ->
                $("h1").shouldHave(Condition.text("О компании")));
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldHaveNotErrorsTest() {
        step("Open url `дом.рф`", () ->
                open("https://xn--d1aqf.xn--p1ai/"));

        step("Console logs should not contain text `SEVERE`", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}