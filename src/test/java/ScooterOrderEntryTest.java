import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

import static util.Constants.*;

@RunWith(Parameterized.class)
public class ScooterOrderEntryTest extends BaseTest{
private final String entryChoice;

    public ScooterOrderEntryTest(String entryChoice) {
        this.entryChoice = entryChoice;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {HEADER},
                {MAIN}
        };
    }
    @Test
    public void scooterOrderEntryTest()
    {
        driver.get(MAIN_PAGE_URL);
        MainPage mainPage= new MainPage(driver);
        mainPage.clickButtonOrder(entryChoice);
        Assert.assertEquals(ORDER_PAGE_URL, driver.getCurrentUrl());
    }
}
