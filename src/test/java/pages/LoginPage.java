package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By USER_NAME  = By.id("username");
    private By PASSWORD  = By.id("password");
    private By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String email, String password) {
        driver.findElement(USER_NAME).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}
