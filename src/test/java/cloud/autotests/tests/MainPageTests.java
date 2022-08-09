package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.CollectionCondition;
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
    @DisplayName("При клике на иконку `Личный кабинет` открывается форма авторизации")
    void authPageTest() {
        step("Открыть страницу `дом.рф`", () ->
                open("https://xn--d1aqf.xn--p1ai/"));

        step("Кликнуть на иконку `Личный кабинет`", () ->
                $(".header-buttons__lk-button").click());

        step("Проверить, что есть форма авторизации", () -> {
            switchTo().window(1);
            $("form#loginform").shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Поиск по вакансиям работает")
    void vacanciesTest() {
        step("Открыть страницу `дом.рф/career/vacancies/`", () ->
                open("https://xn--d1aqf.xn--p1ai/career/vacancies/"));

        step("Выбрать город `Москва`", () ->
                $("#cities-list-selectized").setValue("Москва").pressEnter());

        step("Ввести в поле `Поиск по вакансиям` слово `QA инженер`", () ->
                $("#search-on-vacancies").setValue("QA инженер"));

        step("Проверить, что есть вакансия на тестировщика", () -> {
            $$(".vacancies__item").first().shouldHave(Condition.text("QA инженер (ЦК Интеграционный слой)"));
        });
    }

    @Test
    @DisplayName("Уроки по инвестициям закрыты, пока не изучен первый урок")
    void investmentsTest() {
        step("Открыть страницу `дом.рф/academy/investments/`", () ->
                open("https://xn--d1aqf.xn--p1ai/academy/investments/"));

        step("Кликнуть на кнопку `Начать учиться`", () ->
                $(byText("Начать учиться")).click());

        step("Проверить, что первый урок доступен", () -> {
            $$(".ai-lesson").first().click();
            $(".mp-header__leader-title").shouldBe(Condition.visible).shouldHave(Condition.text("Введение"));
        });

        step("Проверить, что второй урок не доступен", () -> {
            back();
            $$(".ai-lesson").get(2).click();
            $("#disabled-lesson").shouldHave(Condition.text("Изучите предыдущий урок"));
        });
    }

    @Test
    @DisplayName("Фильтр по апартаментам работает")
    void apartmentsTest() {
        step("Открыть страницу `аренда.дом.рф/apartment/`", () ->
                open("https://xn--80aald4bq.xn--d1aqf.xn--p1ai/apartment/"));

        step("Выбрать в фильтре объект", () -> {
            $$(".filter-row__item").get(0).click();
            $(byText("Символ")).click();
        });

        step("Выбрать в фильтре количество комнат", () -> {
            $$(".filter-row__item").get(1).click();
            $(byText("3-комн.")).click();
        });

        step("Выбрать в фильтре тип квартиры", () -> {
            $$(".filter-row__item").get(2).click();
            $(byText("Евро")).click();
        });

        step("Выбрать в фильтре стоимость", () -> {
            $("[data-analytics='main-filter-price-range']").$$("input").get(0).setValue("100000");
            $("[data-analytics='main-filter-price-range']").$$("input").get(1).setValue("200000");
        });

        step("Проверить, что результаты поиска не пустые", () -> {
            $$(".card-apart").shouldBe(CollectionCondition.sizeGreaterThan(0));
            $(".card-apart__desc").shouldHave(Condition.text("Москва, ш. Энтузиастов, д. 3, корп. 1"));
        });
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