package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    Actions actions;

    By addToCartBttnEl = By.xpath("(//a[@data-product-id='1'][contains(.,'Add to cart')])[1]");
    By viewCartBttnEl = By.xpath("//u[contains(text(),'View Cart')]");
    By topCartBttnEl = By.xpath("(//a[@href='/view_cart'][contains(.,'Cart')])[1]");
    By loggedInBttnEl = By.partialLinkText("Logged in");
    By sliderEl = By.xpath("//a[@class='right control-carousel hidden-xs']//i[@class='fa fa-angle-right']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Method to check if the home page is visible
    public boolean isHomePageVisible() {
        try {
            return  driver.findElement(sliderEl).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addToCart() throws InterruptedException {
        //Use java script executor to scroll to the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(addToCartBttnEl));
        Thread.sleep(2000);
        driver.findElement(addToCartBttnEl).click();
    }


    public void viewCartBttnClick() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(viewCartBttnEl).click();
        Thread.sleep(4000);
    }

//    public String loggedInBttnVerify() {
//        return driver.findElement(loggedInBttnEl).getText();
//    }

    public boolean isLoggedButtonVisible() {
        try {
            WebElement loggedInButtonElement = driver.findElement(loggedInBttnEl);
            return loggedInButtonElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void topCartMenuClick() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(topCartBttnEl).click();
        Thread.sleep(2000);
    }

}