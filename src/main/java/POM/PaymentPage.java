package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PaymentPage {
    WebDriver driver;

    By cardName = By.xpath("//input[@name='name_on_card']");
    By cardNumber = By.xpath("//input[@name='card_number']");
    By cvc = By.xpath("//input[@placeholder='ex. 311']");
    By cardExpMnth = By.xpath("//input[@placeholder='MM']");
    By cardExpYr = By.xpath("//input[@placeholder='YYYY']");
    By confirmOrd = By.xpath("//button[@id='submit']");
    By orderSuccessMessage = By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']");
    By logoutBttnEl = By.xpath("//a[normalize-space()='Logout']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void enterCardDetails(String CardName, String CardNumber, String CVC, String ExpirationMonth, String ExpirationYear) {
        driver.findElement(cardName).sendKeys(CardName);
        driver.findElement(cardNumber).sendKeys(CardNumber);
        driver.findElement(cvc).sendKeys(CVC);
        driver.findElement(cardExpMnth).sendKeys(ExpirationMonth);
        driver.findElement(cardExpYr).sendKeys(ExpirationYear);
    }

    public void confirmOrder() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(confirmOrd).click();
        Thread.sleep(3000);
    }

    public String getOrderConfirmMessage() {
        return driver.findElement(orderSuccessMessage).getText();
    }

    public void logout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(logoutBttnEl).click();
        Thread.sleep(2000);
        driver.close();
    }
}
