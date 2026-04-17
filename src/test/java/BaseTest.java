import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

import java.io.IOException;
import java.time.Duration;

import static util.Constants.IMPLICIT_WAIT;

public class BaseTest {
    WebDriver driver;
    @Before
    public void startUp() throws IOException {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.driverInit();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}
