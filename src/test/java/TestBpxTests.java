import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.channels.ConnectionPendingException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBpxTests {
    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Vaia");
        $("[id=lastName]").setValue("Petrov");
        $("#userEmail").setValue("test@test.com");
        $("#gender-radio-1").sendKeys(" ");
        $("#userNumber").setValue("790000000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("2")).click();
        $("#subjectsInput").setValue("Mat").pressEnter();
        $("#hobbies-checkbox-1").sendKeys(" ");
        $("#hobbies-checkbox-2").sendKeys(" ");
        $("#uploadPicture").uploadFromClasspath("pictures/pic.png");
        $("#currentAddress").setValue("Lenina");
        $("#react-select-3-input").setValue("ncr").pressEnter();   //вместо клика лишнего
        $("#react-select-4-input").setValue("noi").pressEnter();
        $("#submit").click();
        $(".modal-body").shouldHave(text("Vaia"),text("Petrov"), text("test@test.com"),
                text("Male"), text("7900000000"), text("02 May,1990"), text("Math"), text("Sports"),
                text("Reading"), text("pic.png"), text("Lenina"), text("ncr"), text("Noida"));
    }
}
