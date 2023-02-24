import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.channels.ConnectionPendingException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Vaia Pupkin");
        $("#userEmail").setValue("test@test.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Some address 1");
        $("#submit").click();
        $("#output").shouldHave(text("Vaia Pupkin"),text("Vaia Pupkin"), text("test@test.com"),
                text("Some address 1"), text("Some address 1"));
    }
}
