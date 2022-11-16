package ui.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest extends BaseUITest {

    @BeforeClass
    public void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }
}
