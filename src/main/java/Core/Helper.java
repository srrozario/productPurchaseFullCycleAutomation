package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.sql.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Helper {
    public WebDriver driver;

    public WebDriver ChromeTest() {
        String url = "https://automationexercise.com/";
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();

        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);

        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        // Disable Chrome's password manager, credential saving and autofill profile
        prefs.put("autofill.profile_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        //ad blocker extension file path
        options.addExtensions(new File("src/main/java/Extensions/AdBlock.crx"));
        //allow loading of local files
//        options.addArguments("--allow-file-access-from-files");
//        options.addArguments("--disable-web-security");
//        options.addArguments("--disable-site-isolation-trials");
//        options.addArguments("--user-data-dir");


        //headless automation
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--headless");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

        // Capture the current window handle
        String originalWindowHandle = driver.getWindowHandle();

        // Check if a new tab is opened (adjust the selector as needed)
        if (driver.getWindowHandles().size() > 1) {
            // Switch to the new tab
            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                if (!handle.equals(originalWindowHandle)) {
                    driver.switchTo().window(handle);
                    driver.close();
                    // Switch back to the original tab
                    driver.switchTo().window(originalWindowHandle);
                    //the break statement is used inside the for loop to exit the loop once the new tab is found
                    break;
                }
            }
        }
        return driver;
    }

}
