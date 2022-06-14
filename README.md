## Автотесты, написанные с целью проверки основных элементов на странице регистрации VK.
### Используемый стек технологий:
<p align="center">
<img width="5%" title="Allure_Report" src="imeg/Allure_Report.svg">
<img width="5%" title="Github" src="imeg/Github.svg">
<img width="5%" title="Intelij_IDEA" src="imeg/Intelij_IDEA.svg">
<img width="5%" title="Java" src="imeg/Java.svg">
<img width="5%" title="JUnit5" src="imeg/JUnit5.svg">
<img width="5%" title="Selenide" src="imeg/Selenide.svg">
<img width="5%" title="Selenoid" src="imeg/Selenoid.svg">
<img width="5%" title="Telegram" src="imeg/Telegram.svg">
</p>

### Автотестами покрыт следующий функционал:
* окрытие сайта
* проверка заголовка формы регистрации
* проверка версии VK для Andriod
* проверка версии VK для iOS
* проверка строки поиска на странице регистрации VK

### Параметры для запуска тестов в Jenkins:
```
gradle clean test
-DprojectName=${PROJECT_NAME}
-Denv=${ENVIRONMENT}
-DreportLink=${BUILD_URL}
-Dbuild.report.link=${BUILD_URL}
-DconfigFile=src/test/java/resource/notifications/telegram.json
-jar allure-notifications-4.1.jar
```

### Allure отчет:
 ```
allure serve build/allure-results
 ```

### Сборка автотестов параметризована:
![](src/test/java/resource/Jenk.png)

### Отчёт о прохождении автотестов в Allure Report:
![](src/test/java/resource/allure_1.jpg)

### Итоги прохожденяи тестов наглядно можно изучить с помощью сформированных скриншотов, видео, log-файлов: 
![](src/test/java/resource/allure_2.jpg)

### Уведомление об успешном прохождении тестов отпарвляется с помощтью Чат-бота в Telegram. Флагом для формирования сообщения служит запись в логе BUILD SUCCESSFUL: 
![](src/test/java/resource/teleg_bot.jpg)