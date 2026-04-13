package pages;
import Utils.ElementsUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.Elements;
import java.time.Duration;
import java.util.List;

public class EcommercePages {
    private WebDriver driver;
    private ElementsUtil elementsUtil;


    public EcommercePages(WebDriver driver) {
        this.driver = driver;
        elementsUtil = new ElementsUtil(driver);

    }

    private By loginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By userName = By.xpath("//input[@data-qa='login-email']");
    private By passWord = By.xpath("//input[@data-qa='login-password']");
    private By loginBtnInLoginPage = By.xpath("//button[@data-qa='login-button']");
    private By logout = By.linkText("Logout");
    private By automationText = By.xpath("//span[text()='Automation']");
    private By categoryOnHomePage = By.xpath("//h2[text()='Category']");
    private By featueItemOnPage = By.xpath("//h2[text()='Features Items']");
    private By productsButton = By.xpath("//a[text()=' Products']");
    private By searchProduct = By.xpath("//input[@id='search_product']");
    private By clickonSearchIcon = By.xpath("//i[@class='fa fa-search']");
    private By searchText = By.xpath("//h2[text()='Searched Products']");
    private By clickAddProductsButton = By.xpath("//a[text()='View Product'][1]");
    private By addToCartButton = By.xpath("//button[normalize-space()='Add to cart']");





    public void clickLoginButton() {
        elementsUtil.click(loginLink);
    }

    public void enter_username(String email) {
        elementsUtil.type(userName, email);

    }


    public void enter_password(String password) {
        elementsUtil.type(passWord, password);

    }

    public void clickLoginBtnInLoginPage() {
        elementsUtil.click(loginBtnInLoginPage);
    }

    public boolean checkloginsuccess() {
        return elementsUtil.isDisplayed(logout);
    }

    public void clickonProductsButton() {
        elementsUtil.click(productsButton);
        Assert.assertTrue(elementsUtil.isDisplayed(productsButton));


    }

    public void performValidationOfText() {
        Assert.assertTrue(elementsUtil.isDisplayed(automationText));
        Assert.assertTrue(elementsUtil.isDisplayed(categoryOnHomePage));
        Assert.assertTrue(elementsUtil.isDisplayed(featueItemOnPage));

    }

    public void clickonOnAddProductsButton() {
        elementsUtil.click(clickAddProductsButton);
            Assert.assertTrue(elementsUtil.isDisplayed(clickAddProductsButton));


    }

    public void performValidationOnSearch() {

        {

            elementsUtil.click(searchProduct);
            elementsUtil.type(searchProduct, "dress");
            elementsUtil.click(clickonSearchIcon);
        }
    }






}


