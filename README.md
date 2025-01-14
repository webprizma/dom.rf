# Автоматизация тестирования страниц сайта дом.рф
## :link: <a target="_blank" href="https://xn--d1aqf.xn--p1ai/">дом.рф</a>

## :page_with_curl: Содержание:

- <a href="#computer-сode_stack">Технологии и инструменты</a>
- <a href="#clipboard-реализованные-проверки">Реализованные проверки</a>
- <a href="#robot-сборки-в-Jenkins">Сборки в Jenkins</a>
- <a href="#keyboard-запуск-из-терминала">Запуск из терминала</a>
- <a href="#bar_chart-allure-отчет">Allure отчет</a>
- <a href="#bar_chart-allure-testops-отчет">Allure TestOps отчет</a>
- <a href="#clipboard-пример-issue-в-jira">Пример Issue в JIRA</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Технологии и инструменты
<p align="left">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :clipboard: Реализованные проверки

- UI тесты сайта wildberries.ru
- API тесты reqres.in
- Мобильные тесты приложения Wildberries

## :robot: Сборки в Jenkins
<p align="center">
<img title="Jenkins Job Run with parameters" src="images/screenshots/jenkins-run.png">
</p>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-dashboard-all.png">
</p>


## :keyboard: Запуск из терминала
Локальный запуск всех тестов:
```
gradle clean test
```

Локальный запуск UI тестов:
```
gradle clean web
```

Удаленный запуск UI тестов:
```
clean
web
 -Dbrowser=${BROWSER}
 -DbrowserVersion=${BROWSER_VERSION}
 -DbrowserSize=${BROWSER_SIZE}
 -DbaseUrl=${BASE_URL}
 -Dremote=${REMOTE}
```

Локальный запуск API тестов:
```
gradle clean api
```

Локальный запуск мобильных тестов:
```
gradle clean mobile
```

## :keyboard: Команда запуска тестов локально в IntelliJ в терминале

С использованием Browserstack:
```
gradle clean test -DdeviceHost=browserstack
```

С использованием эмулятора Android:
```
gradle clean test -DdeviceHost=emulation
```

С использованием реального смартфона:
```
gradle clean test -DdeviceHost=real
```

С использованием Selenoid:
```
gradle clean test -DdeviceHost=selenoid
```

Можно запустить отдельно тесты на поиск (заменить test на search) и на OnBoarding экран (заменить test на onboard)




## :bar_chart: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure-test-page.png">
</p>

## :bar_chart: Allure TestOps отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure TestOps Overview Dashboard" src="images/screenshots/allure-test-ops-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure TestOps Test Page" src="images/screenshots/allure-test-ops-test-page.png">
</p>

## :clipboard: Пример issue в JIRA
- ### JIRA Issue
<p align="center">
<img title="JIRA Issue" src="images/screenshots/jira.png">
</p>

## :robot: Отчет в Telegram
- ### Telegram notification message (all results)
<p align="center">
<img title="Telegram notification message (all results)" src="images/screenshots/telegram-bot.png">
</p>

## :film_projector: Видео пример прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/test-run.gif">
</p>
