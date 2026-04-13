package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userName = By.xpath("//input[@data-qa='login-email']");
    private By passWord = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");
    private By logout = By.linkText("Logout");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        elementsUtil.type(userName, email);
    }

    public void enterPassword(String password) {
        elementsUtil.type(passWord, password);
    }

    public void clickLoginButton() {
        elementsUtil.click(loginBtn);
    }

    public boolean isLoginSuccessful() {
        return elementsUtil.isDisplayed(logout);
    }
}
