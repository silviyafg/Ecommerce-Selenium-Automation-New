package pages;

import Utils.ElementsUtil;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected ElementsUtil elementsUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.elementsUtil = new ElementsUtil(driver);
    }
}
