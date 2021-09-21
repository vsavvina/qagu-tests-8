package guru.qa.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static guru.qa.tests.TestData.name;
import static guru.qa.tests.TestData.surname;

public class SubmittingFormPage {

    private SelenideElement
            visibleTable = $(".modal-content"),
            visibleName = $x("//td[text()='Student Name']/following-sibling::td"),
            visibleEmail = $x("//td[text()='Student Email']/following-sibling::td");

    public void tableVisible () {
        visibleTable.shouldBe(Condition.visible);
    }
    public void nameIsCorrect() {
        visibleName.shouldHave(text(name + " " + surname));
    }
    private void emailIsCorrect() {
        visibleEmail.shouldHave()
    }
}
