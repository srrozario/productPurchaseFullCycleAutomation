package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SignupPage {
    WebDriver driver;

    By titleEl = By.xpath("//input[@type='radio'][contains(@id,'gender1')]");
    By passwordEl = By.xpath("//input[@id='password']");
    By dayEl = By.id("days");
    By monthEl = By.id("months");
    By yearEl = By.id("years");
    By newsLttrEl = By.id("newsletter");
    By firstNameEl = By.id("first_name");
    By lastNameEl = By.id("last_name");
    By addressEl = By.id("address1");
    By countryEl = By.id("country");
    By stateEl = By.id("state");
    By cityEl = By.id("city");
    By zipcodeEl = By.id("zipcode");
    By mobileNumberEl = By.id("mobile_number");
    By createAccEl = By.xpath("//button[contains(text(),'Create Account')]");
    By accCreatedMsgEl = By.xpath("//b[normalize-space()='Account Created!']");
    By continueBttn = By.xpath("//a[normalize-space()='Continue']");
    By saveAddressCancel = By.xpath("//a[normalize-space()='Contact us']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void formFillUp(String password, String firstName, String lastName, String address, String state, String city,
                           String zipcode, String mobileNumber) throws InterruptedException {
        driver.findElement(titleEl).click();
        Thread.sleep(2000);
        //Use java script executor to scroll to the element
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(lastNameEl));
        driver.findElement(passwordEl).sendKeys(password);
        Select day = new Select(driver.findElement(dayEl));
        //day.selectByValue("15");
        Select month = new Select(driver.findElement(monthEl));
        Select year = new Select(driver.findElement(yearEl));
        driver.findElement(newsLttrEl).click();
        driver.findElement(firstNameEl).sendKeys(firstName);
        driver.findElement(lastNameEl).sendKeys(lastName);
        Thread.sleep(2000);
        //Use java script executor to scroll to the element
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        jsExe.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(mobileNumberEl));
        driver.findElement(addressEl).sendKeys(address);
        Select country = new Select(driver.findElement(countryEl));
        driver.findElement(stateEl).sendKeys(state);
        driver.findElement(cityEl).sendKeys(city);
        driver.findElement(zipcodeEl).sendKeys(zipcode);
        driver.findElement(mobileNumberEl).sendKeys(mobileNumber);
        Thread.sleep(2000);
        //Use java script executor to scroll to the element
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(createAccEl));
        Thread.sleep(2000);
    }

    public void createAccBttnClick()  {
        driver.findElement(createAccEl).click();
    }

    public String getAccCreatedText() {
        return driver.findElement(accCreatedMsgEl).getText();
    }

    public void continueBttnClick() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(continueBttn).click();
        Thread.sleep(2000);
    }

}