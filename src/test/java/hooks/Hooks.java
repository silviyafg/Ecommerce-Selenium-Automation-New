package hooks;

import config.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Set;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.initBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");


    }

    @BeforeClass
    public void setup() {
        //To add Extension to Chrome Automated Browser

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\Admin\\Downloads\\Ad-Blocker-Stands-AdBlocker-Chrome-Web-Store.crx"));
        driver = new ChromeDriver(options);
        System.out.println("i am running");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        driver.manage().window().maximize();
    }

    @Test
    public void DisableAdsTest() {
        // Navigate to the webpage
        String mainHandle = driver.getWindowHandle();
        driver.get("https://automationexercise.com/");

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate over all window handles
        for (String handle : windowHandles) {
            // Switch to each window/tab
            driver.switchTo().window(handle);
            if (!driver.getTitle().equals("Automation Exercise")) {
                driver.close();
                try {
                    Thread.sleep(500);// Close the tab
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Switch back to the original window
        driver.switchTo().window(mainHandle);
        try {
            Thread.sleep(500);// Close the tab
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}


