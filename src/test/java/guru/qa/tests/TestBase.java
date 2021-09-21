package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Test passed");
    }
}
