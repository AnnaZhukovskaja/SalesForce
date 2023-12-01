package pages;

import org.openqa.selenium.WebDriver;
import wrappers.Input;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public void createAccount() {
        //new Input(driver,"Account Name").write("Anna Zh");
        //new Input(driver,"Account Number").write("12345678");
    }

    public void openAccountCreationPage() {
        driver.get(BASE_URL + "lightning/o/Account/new");
    }

}
