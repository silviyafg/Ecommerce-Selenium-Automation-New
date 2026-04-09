package Utils;

import config.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.DriverFactory.driver;

public class ElementsUtil {

    private WebDriver driver;
    private WebDriverWait webDriverWait ;
    private WebDriverWait wait;

    public ElementsUtil(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement waitForElementVisible(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void click(By locator) {
    waitForElementVisible(locator).click();
    }
    public void type (By locator,String text) {
        WebElement element  = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);

    }
    public boolean isDisplayed(By locator) {
        return waitForElementVisible(locator).isDisplayed();
    }
    public void clickUsingJS(By locator) {
        WebElement element = waitForElementVisible(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

    }


    public void clickFrame(By locator) {
        try {
            waitForElementClickable(locator).click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("⚠️ Click intercepted, using JS click...");
            clickUsingJS(locator);
        }
    }


    public void scrollIntoView(By locator) {
        try {
            java.util.List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty()) {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView(true);",
                                elements.get(0));
                System.out.println("✅ Scrolled into view");
            } else {
                System.out.println("⚠️ Element not found for scroll: " + locator);
            }
        } catch (Exception e) {
            System.out.println("⚠️ Scroll failed: " + e.getMessage());
        }
    }

    public void removeAds() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;


            js.executeScript(
                    "var iframes = document.querySelectorAll('iframe');" +
                            "for(var i = 0; i < iframes.length; i++) {" +
                            "   if(iframes[i].title === 'Advertisement' || " +
                            "      iframes[i].id.includes('aswift') || " +
                            "      iframes[i].id.includes('google_ads')) {" +
                            "       iframes[i].parentNode.removeChild(iframes[i]);" +
                            "   }" +
                            "}"
            );
            System.out.println("✅ Ads removed successfully");

            // Wait for page to settle after removal
            Thread.sleep(500);

        } catch (Exception e) {
            System.out.println("ℹ️ No ads to remove: " + e.getMessage());
        }
    }
    public void closeAdIfPresent() {
        try {
            // ✅ Wait for ad close button and click it
            WebElement closeBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[@id='ad_position_box']//button")));
            closeBtn.click();
            System.out.println("✅ Ad closed successfully");
        } catch (TimeoutException e) {
            System.out.println("ℹ️ No ad found, continuing...");
        }
    }
}