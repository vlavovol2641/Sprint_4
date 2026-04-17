package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.Constants.EXPLICIT_WAIT;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //кнопка Заказать в шапке сайта
    private final By buttonOrderHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    //кнопка Заказать в теле страницы сайта
    private final By buttonOrderMain = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
    //блок "Вопросы о важном"
    private final By faqBlock = By.cssSelector(".Home_FAQ__3uVm4");
    //локатор вопросов
    private final String faqQuestion =".//*[text()='";
    //локатор раскрытого ответа
    private final By faqAnswer = By.cssSelector("div[aria-expanded = 'true']");




    //нажатие на кнопку Заказать в шапке сайта
    public void clickButtonOrderHeader() {
    driver.findElement(buttonOrderHeader).click();
    }
    //нажатие на кнопку Заказать в теле страницы сайта
    public void clickButtonOrderMain() {
        WebElement element = driver.findElement(buttonOrderMain);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buttonOrderMain));
        driver.findElement(buttonOrderMain).click();
    }
    //скролл до блока "Вопросы о важном"
    public void scrollFaqBlock() {
        WebElement element = driver.findElement(faqBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(faqBlock));
    }
    //нажатие на вопрос
    public void clickFaqQuestion(String question){
        driver.findElement(By.xpath(faqQuestion+question+"']")).click();
    }
    //получение ответа
    public String getFaqAnswer(){
        String questionId = driver.findElement(faqAnswer).getAttribute("id");
        String answerIdSelector = "#accordion__panel-"+questionId.substring(19);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(answerIdSelector)));
        return driver.findElement(By.cssSelector(answerIdSelector)).getText();
    }
    }
