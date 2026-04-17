import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

import static util.Constants.MAIN_PAGE_URL;
import static util.Constants.ORDER_PAGE_URL;

public class ScooterOrderEntryTest extends BaseTest{
    @Test
    public void scooterOrderHeaderTest()
    {
        driver.get(MAIN_PAGE_URL);
        MainPage mainPage= new MainPage(driver);
        mainPage.clickButtonOrderHeader();
        Assert.assertEquals(ORDER_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    public void scooterOrderMainTest()
    {
        driver.get(MAIN_PAGE_URL);
        MainPage mainPage= new MainPage(driver);
        mainPage.clickButtonOrderMain();
        Assert.assertEquals(ORDER_PAGE_URL, driver.getCurrentUrl());
    }
}
