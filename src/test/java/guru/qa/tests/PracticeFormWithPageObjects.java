package guru.qa.tests;

import guru.qa.page.SubmittingFormPage;
import guru.qa.page.UserDataPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.tests.TestData.*;

public class PracticeFormWithPageObjects extends TestBase {

    UserDataPage userDataPage = new UserDataPage();
    SubmittingFormPage subFormPage = new SubmittingFormPage();

    @Test
    void practiceFormTests() {

        userDataPage.typeName(name);
        userDataPage.typeSurename(surname);
        userDataPage.typeEmail(email);
        userDataPage.typeGander();
        userDataPage.typePhoneNumber(phonenumber);

        $(By.id("dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption(month); // %s
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();

        userDataPage.typeSubject(subjects1);
        userDataPage.typeSubject(subjects2);
        userDataPage.typeHobbies1();
        userDataPage.typeHobbies2();
        userDataPage.typeHobbies3();
        userDataPage.scroll();
        userDataPage.typePicture(pathpoto);
        userDataPage.typeAdress(adress);
        userDataPage.stateType();
        userDataPage.cityType();
        userDataPage.clickBtn();

        subFormPage.tableVisible();
        subFormPage.nameIsCorrect();

        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text(email));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text(gander));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text(phonenumber));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("19 February" + "," + "1998"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text(subjects1 + ", " + subjects2));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text(hobbies1 + ", " + hobbies2 + ", " + hobbies3));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text(photo));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text(adress));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text(state + " " + city));
    }
}
