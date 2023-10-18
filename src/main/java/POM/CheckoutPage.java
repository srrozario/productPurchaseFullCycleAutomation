package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CheckoutPage {
    WebDriver driver;
    By placeOrderBttn = By.xpath("//a[normalize-space()='Place Order']");
    By commentEl = By.xpath("//textarea[@name='message']");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void scrollToComment(){
        //Use java script executor to scroll to the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(placeOrderBttn));
    }
    public void commentAndProceed(String comment) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(commentEl).sendKeys(comment);
        Thread.sleep(2000);
        driver.findElement(placeOrderBttn).click();
        Thread.sleep(2000);
    }
}
