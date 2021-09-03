package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


import java.io.File;

public class PracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void practiceFormTests() {
        String name = "Viktoria";
        String surname = "Savvina";
        String email = "vsavvina@gu.com";
        String gander = "Female";
        String phomenumber = "9529578960";
        String subjects1 = "Maths";
        String subjects2 = "Physics";
        String hobbies1 = "Sports";
        String hobbies2 = "Reading";
        String hobbies3 = "Music";
        String pathpoto = "src/test/java/attachments/foto.jpg";
        String photo = "foto.jpg";
        String adress = "15 Zhelyabova Street, apartment 18, Voronezh, Russia";
        String state = "Haryana";
        String city = "Panipat";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $(byText(gander)).click();
        $(By.id("userNumber")).setValue(phomenumber);
        $(By.id("dateOfBirthInput")).click();
        $(byText("February")).click();
        $(byText("1998")).click();
        $(byXpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]")).click();
        $("#subjectsInput").setValue(subjects1).pressEnter().setValue(subjects2).pressEnter();
        $(byText(hobbies1)).click();
        $(byText(hobbies2)).click();
        $(byText(hobbies3)).click();
        $("#submit").scrollIntoView(true);
        $("#uploadPicture").uploadFile(new File(pathpoto));
        $("#currentAddress").setValue(adress);
        $("#submit").scrollIntoView(true);
        $(byXpath("//*[@id=\"state\"]/div/div[2]/div")).click();
        $(byText(state)).click();
        $(byXpath("//*[@id=\"city\"]/div/div[2]/div")).click();
        $(byText(city)).click();
        $("#submit").click();
        //sleep(3000);

        $(".modal-content").shouldBe(Condition.visible);
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text(name + " " + surname));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text(email));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text(gander));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text(phomenumber));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("19 February" + "," + "1998"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text(subjects1 + ", " + subjects2));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text(hobbies1 + ", " + hobbies2 + ", " + hobbies3));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text(photo));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text(adress));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text(state + " " + city));
    }
}
