package guru.qa.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Viktoria");
        $("#lastName").setValue("Savvina");
        $("#userEmail").setValue("vsavvina@gu.com");
        $(byText("Female")).click();
        $(By.id("userNumber")).setValue("9529578960");
        $(By.id("dateOfBirthInput")).click();
        //$(byText("February")).click();
        //$(byText("1998")).click();
        $(By.id("dateOfBirthInput")).setValue("06 Jul 1998");
        sleep(3000);
    }

}
