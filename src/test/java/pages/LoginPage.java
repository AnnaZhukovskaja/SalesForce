package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LoginPage extends BasePage{

    private final By USER_NAME  = By.id("username");
    private final By PASSWORD  = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage open() {
        log.info("Opening login page");
        driver.get(BASE_URL);
        return this;
    }
@Step("Log in using credentials: '{email}','{password}'")
    public MainPage login(String email, String password) {
        log.info("Log in using credentials : '{}','{}'",email,password);
        driver.findElement(USER_NAME).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    return  new MainPage(driver);}
}
