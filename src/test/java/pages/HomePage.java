package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class HomePage extends BasePage {

    private By loginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By logoutLink = By.linkText("Logout");
    private By automationText = By.xpath("//span[text()='Automation']");
    private By categoryOnHomePage = By.xpath("//h2[text()='Category']");
    private By featuredItemOnPage = By.xpath("//h2[text()='Features Items']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        elementsUtil.click(loginLink);
    }

    public void clickLogout() {
        elementsUtil.click(logoutLink);
    }

    public void performValidationOfText() {
        Assert.assertTrue("Automation text not displayed", elementsUtil.isDisplayed(automationText));
        Assert.assertTrue("Category section not displayed", elementsUtil.isDisplayed(categoryOnHomePage));
        Assert.assertTrue("Featured Items section not displayed", elementsUtil.isDisplayed(featuredItemOnPage));
    }
}
