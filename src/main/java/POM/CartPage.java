package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class CartPage {
    WebDriver driver;

    By checkoutBttn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    By regOrLoginBttn = By.xpath("//u[contains(text(),'Register / Login')]");
    By pageTabEl= By.xpath("//li[contains(text(),'Shopping Cart')]");

    public CartPage(WebDriver driver){
        this.driver=driver;
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void checkoutBttnClick(){
        driver.findElement(checkoutBttn).click();
    }
    public void regOrLoginBttnClick() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(regOrLoginBttn).click();
    }
    public String getTabTitleText() {
        return driver.findElement(pageTabEl).getText();
    }

}
