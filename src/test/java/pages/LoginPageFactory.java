package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage{

    @FindBy(id="username")
    WebElement userNameInput;
    @FindBy(id="password")
    WebElement passwordInput;
    @FindBy(id="Login")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        userNameInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        loginButton.click();
    }
}
