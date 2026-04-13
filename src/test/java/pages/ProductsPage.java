package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class ProductsPage extends BasePage {

    private By productsButton = By.xpath("//a[text()=' Products']");
    private By searchInput = By.xpath("//input[@id='search_product']");
    private By searchIcon = By.xpath("//i[@class='fa fa-search']");
    private By searchedProductsText = By.xpath("//h2[text()='Searched Products']");
    private By viewFirstProductButton = By.xpath("//a[text()='View Product'][1]");
    private By addToCartButton = By.xpath("//button[normalize-space()='Add to cart']");
    private By cartIcon = By.xpath("//a[@href='/view_cart']");
    private By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
    private By payAndConfirmButton = By.xpath("//button[@id='submit']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickProductsButton() {
        elementsUtil.click(productsButton);
        Assert.assertTrue("Products page not loaded", elementsUtil.isDisplayed(productsButton));
    }

    public void searchInput(String productName) {
        elementsUtil.type(searchInput, productName);
    }

    public void clickSearchIcon() {
        elementsUtil.click(searchIcon);
    }

    public void searchForProduct(String productName) {
        searchInput(productName);
        clickSearchIcon();
    }

    public boolean isSearchResultsDisplayed() {
        return elementsUtil.isDisplayed(searchedProductsText);
    }

    public void clickViewFirstProduct() {
        elementsUtil.click(viewFirstProductButton);
    }

    public void clickAddToCart() {
        elementsUtil.click(addToCartButton);
    }

    public void clickCartIcon() {
        elementsUtil.click(cartIcon);
    }

    public void clickProceedToCheckout() {
        elementsUtil.click(proceedToCheckoutButton);
    }

    public void clickPlaceOrder() {
        elementsUtil.click(placeOrderButton);
    }

    public void clickPayAndConfirm() {
        elementsUtil.click(payAndConfirmButton);
    }
}
