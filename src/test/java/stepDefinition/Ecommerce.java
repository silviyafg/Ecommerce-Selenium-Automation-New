package stepDefinition;

import config.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EcommercePages;

import static Utils.Constant.AUTOMATION_EXERCISE;


public class Ecommerce {
    WebDriver driver = DriverFactory.getDriver();
    EcommercePages ecommercePages = new EcommercePages(driver);

    @Given("I am on the landing page of the e-commerce website")
    public void user_is_on_the_home_page_of_the_ecommerce_website() {

        if (driver.getTitle() != null) {
            Assert.assertTrue(driver.getTitle().contains(AUTOMATION_EXERCISE));
        }
    }

    @Then("User clicks on the \"Login button\"")
    public void user_clicks_on_the_login_button() {
        ecommercePages.clickLoginButton();

    }

    @Then("User enters username and password")
    public void user_enters_username_and_password() {
        ecommercePages.enter_username("jf.silviya@gmail.com");
        ecommercePages.enter_password("india@123");

    }

    @Then("User clicks on the login button in login page")
    public void user_clicks_on_the_button()  {
        ecommercePages.clickLoginBtnInLoginPage();

    }

    @Then("User validates that the user is logged in successfully")
    public void user_validates_that_the_user_is_logged_in_successfully() {
       ecommercePages.checkloginsuccess();
       Assert.assertTrue(ecommercePages.checkloginsuccess());

    }

    @Then("User performs validates the home page is displayed successfully")
    public void user_performs_validates_the_home_page_is_displayed_successfully() {
        ecommercePages.performValidationOfText();
    }

    @Then("User clicks the products button")
    public void user_clicks_product_button() {

       ecommercePages.clickonProductsButton();
    }

    @Then("User enters the product name in the search bar")
    public void user_enters_the_product_name_in_the_search_bar() {
        ecommercePages.performValidationOnSearch();

    }

    @When("User clicks on the first product in the search results")
    public void user_clicks_on_the_first_product_in_the_search_results() {
        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='productinfo text-center']//a"));
        firstProduct.click();
    }

    @Then("User validates that the product details page is displayed successfully")
    public void user_validates_that_the_product_details_page_is_displayed_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"));
    }

    @Then("User validates that the product is added to the cart successfully")
    public void user_validates_that_the_product_is_added_to_the_cart_successfully() {
        WebElement cart = driver.findElement(By.xpath("//u[contains(text(),'View Cart')]"));
        Assert.assertTrue(cart.isDisplayed());
    }

    @Then("User validates that the cart page is displayed successfully")
    public void user_validates_that_the_cart_page_is_displayed_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));
    }

    @Then("User validates that the checkout page is displayed successfully")
    public void user_validates_that_the_checkout_page_is_displayed_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));
    }

    @When("User enters the shipping address and payment details")
    public void user_enters_the_shipping_address_and_payment_details() {
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Test User");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("123 Test St");
    }

    @Then("User validates that the order is placed successfully")
    public void user_validates_that_the_order_is_placed_successfully() {
        WebElement success = driver.findElement(By.xpath("//h2[contains(text(),'Order Placed!')]"));
        Assert.assertTrue(success.isDisplayed());
    }

    @Then("User enters the payment details")
    public void user_enters_the_payment_details() {
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='card_number']"));
        cardNumber.sendKeys("4111111111111111");
        WebElement expiry = driver.findElement(By.xpath("//input[@name='expiry_month']"));
        expiry.sendKeys("12");
        WebElement year = driver.findElement(By.xpath("//input[@name='expiry_year']"));
        year.sendKeys("2025");
        WebElement cvv = driver.findElement(By.xpath("//input[@name='cvv']"));
        cvv.sendKeys("123");
    }

    @Then("User validates that the payment is processed successfully")
    public void user_validates_that_the_payment_is_processed_successfully() {
        WebElement confirm = driver.findElement(By.xpath("//h2[contains(text(),'Congratulations!')]"));
        Assert.assertTrue(confirm.isDisplayed());
    }

    @Then("User performs validates the congratulations page is displayed successfully")
    public void user_performs_validates_the_congratulations_page_is_displayed_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("payment_done"));
    }

    @Then("User validates that the user is logged out successfully")
    public void user_validates_that_the_user_is_logged_out_successfully() {
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        Assert.assertTrue(login.isDisplayed());
    }
}






