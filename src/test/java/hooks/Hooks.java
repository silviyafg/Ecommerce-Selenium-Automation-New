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

import java.io.File;
import java.time.Duration;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.initBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));

        // Dismiss cookie/ad banners if present
        try {
            WebElement closeBtn = driver.findElement(
                    By.cssSelector("button[id*='close'], button[class*='dismiss']")
            );
            closeBtn.click();
        } catch (NoSuchElementException ignored) {}

    }

    public class BaseTest {

        public WebDriver driver;

        @BeforeMethod
        public void setup() {

            ChromeOptions options = new ChromeOptions();

            options.addExtensions(new File("C:\\Users\\Admin\\Downloads\\Ad-Blocker-Stands-AdBlocker-Chrome-Web-Store.crx"));

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
        }
    }






    @BeforeStep

    public void removeAdsBeforeEachStep() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "document.querySelectorAll('iframe[id*=\"aswift\"]')" +
                            ".forEach(el => el.remove());"
            );
        } catch (Exception e) {
            // ignore
        }
    }
    @After
        public void tearDown () {
            DriverFactory.quitDriver();
        }
    }