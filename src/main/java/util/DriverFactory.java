package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

public class DriverFactory {
    public WebDriver driverInit() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");
        BrowserType browserType = BrowserType.valueOf(browserProperty);
        switch (browserType)
        {
            case CHROME:
            {return WebDriverManager.chromedriver().create();}
            case FIREFOX:
            {return WebDriverManager.firefoxdriver().create();}
            default:
                throw new RemoteException("Browser undefined");
        }
    }
}
