package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @DisplayName("При клике на пункт главного меню `Аналитика и цены` и подменю `Аналитика рынка` должна открыться страница `Аналитика` с заголовком `Аналитика`")
    void mainMenuTest() {
        step("Открыть страницу `дом.рф`", () ->
                open("https://xn--d1aqf.xn--p1ai/"));

        step("Кликнуть на пункт меню `Аналитика и цены`", () ->
                $(byText("Аналитика и цены")).click());

        step("Кликнуть на пункт меню `О компании`", () ->
                $(byText("Аналитика рынка")).click());

        step("Заголовок h1 должен содержать текст `Аналитика`", () ->
                $("h1").shouldHave(Condition.text("Аналитика")));
    }

    @Test
    @DisplayName("При клике на пункт бургер-меню `О компании` должна открыться страница `О компании` с заголовком `О компании`")
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
    @DisplayName("При клике на новость на странице `Аналитика` открывается страница новости")
    void newsTest() {
        step("Открыть страницу `дом.рф/analytics/`", () ->
                open("https://xn--d1aqf.xn--p1ai/analytics/"));

        step("Кликнуть на последнюю новость в списке", () ->
                $$(".an-news").last().click());

        step("Проверить, что перешли на страницу новости`", () ->
                $(".category__text").shouldHave(Condition.text("Новости")));
    }

    @Test
    @DisplayName("В консоле не должно быть критичных ошибок")
    void consoleShouldHaveNotErrorsTest() {
        step("Открыть страницу `дом.рф`", () ->
                open("https://xn--d1aqf.xn--p1ai/"));

        step("В консоле не должно быть ошибок со статусом `SEVERE`", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}