package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    By nameEl = By.xpath("//input[@placeholder='Name']");
    By emailEl = By.xpath("//input[@data-qa='signup-email']");
    By signupBttn = By.xpath("//button[contains(text(),'Signup')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameEl).sendKeys(name);
        driver.findElement(emailEl).sendKeys(email);
    }

    public void signupBttnClick() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(signupBttn).click();
    }

}

