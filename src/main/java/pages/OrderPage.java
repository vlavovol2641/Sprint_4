package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //поле Имя
    private final By fieldOrderName = By.xpath(".//input[@placeholder='* Имя']");
    //поле Фамилия
    private final By fieldOrderLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле Адрес
    private final By fieldOrderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле Телефон
    private final By fieldOrderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //поле Станция Метро
    private final By fieldOrderMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    //выбор станции Метро
    private final String choiceOrderMetro = ".//*[text()='";
    //кнопка Далее
    private final By buttonOrderNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    //поле Дата
    private final By fieldOrderDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //выбор даты
    private final By choiceOrderDate = By.xpath(".//div[@class='react-datepicker__week']/*[@tabindex='0']");
    //поле Срок аренды
    private final By fieldOrderDays = By.className("Dropdown-placeholder");
    //выбор Срока аренды
    private final String choiceOrderDays = "div.Dropdown-option:nth-child(";
    //кнопка Заказать
    private final By buttonOrderFinish = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    //кнопка Да
    private final By buttonOrderYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Да']");
    //кнопка "Посмотреть статус"
    private final By buttonOrderViewStatus = By.xpath(".//div[@class='Order_NextButton__1_rCA']//button[text()='Посмотреть статус']");


    //заполняем поле Имя
    public void fillFieldOrderName(String name) {
        driver.findElement(fieldOrderName).sendKeys(name);
    }
    //заполняем поле Фамилия
    public void fillFieldOrderLastName(String lastName) {
        driver.findElement(fieldOrderLastName).sendKeys(lastName);
    }
    //заполняем поле Адрес
    public void fillFieldOrderAddress(String address) {
        driver.findElement(fieldOrderAddress).sendKeys(address);
    }
    //заполняем поле Телефон
    public void fillFieldOrderPhone(String phone) {
        driver.findElement(fieldOrderPhone).sendKeys(phone);
    }
    //заполняем поле Метро и кликаем на "Охотный ряд"
    public void fillFieldOrderMetro(String metro) {
        driver.findElement(fieldOrderMetro).sendKeys(metro);
        driver.findElement(By.xpath(choiceOrderMetro+metro+"']")).click();
    }
    //кликаем на "Далее"
    public void clickButtonOrderNext() {
        driver.findElement(buttonOrderNext).click();
    }
    //заполняем поле Дата и кликаем на выбранную дату
    public void fillFieldOrderDate(String date) {
        driver.findElement(fieldOrderDate).sendKeys(date);
        driver.findElement(choiceOrderDate).click();
    }
    //заполняем поле Срок Аренды и кликаем на выбранный срок (сутки в данном тесте)
    public void fillFieldOrderDays(String days) {
        driver.findElement(fieldOrderDays).click();
        driver.findElement(By.cssSelector(choiceOrderDays+days+")")).click();
    }
    //выбираем черный цвет
    public void choiceFieldOrderColor(String color) {
        driver.findElement(By.id(color)).click();
    }
    //кликаем на "Заказать"
    public void clickButtonOrderFinish() {
        driver.findElement(buttonOrderFinish).click();
    }
    //кликаем на "Да"
    public void clickButtonOrderYes() {
        driver.findElement(buttonOrderYes).click();
    }
    //получаем текст кнопки "Посмотреть статус" для ассерта
    public String getTextButtonOrderViewStatus() {
        return driver.findElement(buttonOrderViewStatus).getText();
    }

}

