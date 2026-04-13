package stepDefinition;

import config.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

import static Utils.Constant.AUTOMATION_EXERCISE;

public class Ecommerce {

    WebDriver driver = DriverFactory.getDriver();

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    // ─── Home Page ────────────────────────────────────────────────────────────

    @Given("I am on the landing page of the e-commerce website")
    public void user_is_on_the_home_page_of_the_ecommerce_website() {
        Assert.assertTrue("Page title does not match", driver.getTitle().contains(AUTOMATION_EXERCISE));
    }

    @Then("User performs validates the home page is displayed successfully")
    public void user_performs_validates_the_home_page_is_displayed_successfully() {
        homePage.performValidationOfText();
    }

    // ─── Login ────────────────────────────────────────────────────────────────

    @Then("User clicks on the \"Login button\"")
    public void user_clicks_on_the_login_button() {
        homePage.clickLoginLink();
    }

    @Then("User enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterEmail("jf.silviya@gmail.com");
        loginPage.enterPassword("india@123");
    }

    @Then("User clicks on the login button in login page")
    public void user_clicks_on_the_button() {
        loginPage.clickLoginButton();
    }

    @Then("User validates that the user is logged in successfully")
    public void user_validates_that_the_user_is_logged_in_successfully() {
        Assert.assertTrue("User is not logged in", loginPage.isLoginSuccessful());
    }

    @Then("User validates that the user is logged out successfully")
    public void user_validates_that_the_user_is_logged_out_successfully() {
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        Assert.assertTrue("Logout was not successful", login.isDisplayed());
    }

    // ─── Products ─────────────────────────────────────────────────────────────

    @Then("User clicks the products button")
    public void user_clicks_product_button() {
        productsPage.clickProductsButton();
    }

    @Then("User enters the product name in the search bar")
    public void user_enters_the_product_name_in_the_search_bar() {
        productsPage.searchForProduct("dress");
    }

    @When("User clicks on the first product in the search results")
    public void user_clicks_on_the_first_product_in_the_search_results() {
        productsPage.clickViewFirstProduct();
    }

    @Then("User validates that the product details page is displayed successfully")
    public void user_validates_that_the_product_details_page_is_displayed_successfully() {
        Assert.assertTrue("Product details page not loaded", driver.getCurrentUrl().contains("product_details"));
    }

    @Then("User validates that the product is added to the cart successfully")
    public void user_validates_that_the_product_is_added_to_the_cart_successfully() {
        WebElement cart = driver.findElement(By.xpath("//u[contains(text(),'View Cart')]"));
        Assert.assertTrue("Product was not added to cart", cart.isDisplayed());
    }

    // ─── Cart ─────────────────────────────────────────────────────────────────

    @Then("User validates that the cart page is displayed successfully")
    public void user_validates_that_the_cart_page_is_displayed_successfully() {
        Assert.assertTrue("Cart page not loaded", driver.getCurrentUrl().contains("view_cart"));
    }

    // ─── Checkout ─────────────────────────────────────────────────────────────

    @Then("User validates that the checkout page is displayed successfully")
    public void user_validates_that_the_checkout_page_is_displayed_successfully() {
        Assert.assertTrue("Checkout page not loaded", driver.getCurrentUrl().contains("checkout"));
    }

    @When("User enters the shipping address and payment details")
    public void user_enters_the_shipping_address_and_payment_details() {
        driver.findElement(By.id("name")).sendKeys("Test User");
        driver.findElement(By.id("address")).sendKeys("123 Test St");
    }

    @Then("User enters the payment details")
    public void user_enters_the_payment_details() {
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("4111111111111111");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2025");
        driver.findElement(By.xpath("//input[@name='cvv']")).sendKeys("123");
    }

    @Then("User validates that the payment is processed successfully")
    public void user_validates_that_the_payment_is_processed_successfully() {
        WebElement confirm = driver.findElement(By.xpath("//h2[contains(text(),'Congratulations!')]"));
        Assert.assertTrue("Payment was not processed", confirm.isDisplayed());
    }

    @Then("User validates that the order is placed successfully")
    public void user_validates_that_the_order_is_placed_successfully() {
        WebElement success = driver.findElement(By.xpath("//h2[contains(text(),'Order Placed!')]"));
        Assert.assertTrue("Order was not placed", success.isDisplayed());
    }

    @Then("User performs validates the congratulations page is displayed successfully")
    public void user_performs_validates_the_congratulations_page_is_displayed_successfully() {
        Assert.assertTrue("Payment done page not loaded", driver.getCurrentUrl().contains("payment_done"));
    }
}