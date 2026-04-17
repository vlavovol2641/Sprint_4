import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.OrderPage;

import static util.Constants.*;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String metro;
    private final String date;
    private final String days;
    private final String color;


    public ScooterOrderTest(String name, String surname, String address, String phone, String metro, String date, String days, String color) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.metro = metro;
        this.date = date;
        this.days = days;
        this.color = color;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][]{
                {"Акакий", "Афанасьев", "Улица Пушкина, 4", "89173574403", "Охотный Ряд", "14.05.2026", "1", BLACK},
                {"Олег", "Нумиргалиев", "Улица Октябрьская, 11", "89174441122", "Черкизовская", "15.05.2026", "2", GREY},
        };
    }

    @Test
    public void scooterOrderTest()
    {
        driver.get(ORDER_PAGE_URL);
        OrderPage orderPage= new OrderPage(driver);
        orderPage.fillFieldOrderName(name);
        orderPage.fillFieldOrderLastName(surname);
        orderPage.fillFieldOrderAddress(address);
        orderPage.fillFieldOrderPhone(phone);
        orderPage.fillFieldOrderMetro(metro);
        orderPage.clickButtonOrderNext();
        orderPage.fillFieldOrderDate(date);
        orderPage.fillFieldOrderDays(days);
        orderPage.choiceFieldOrderColor(color);
        orderPage.clickButtonOrderFinish();
        orderPage.clickButtonOrderYes();
        Assert.assertEquals("Посмотреть статус", orderPage.getTextButtonOrderViewStatus());
    }
}
