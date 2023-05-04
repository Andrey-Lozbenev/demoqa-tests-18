package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class SetBasePageSettings {
    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
