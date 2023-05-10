package properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void simplePropertyTest() {
        String browser = System.getProperty("browser");
    }
}
