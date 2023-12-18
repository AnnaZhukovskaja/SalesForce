package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;
@Log4j2
public class AccountCreationPage extends BasePage{

    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']");
    private  final By TITLE = By.xpath("//*[@title='Activity']/a");

    public AccountCreationPage(WebDriver driver){
        super(driver);
    }

    public AccountCreationPage open() {
        log.info("Opening creation page");
        driver.get(BASE_URL + "lightning/o/Account/new");
        return this;
    }
    @Step("Creating account: '{account.accountName}'")
    public AccountCreationPage createAccount(Account account) {
        log.info("Creating account: '{}'", account);
        new PickList(driver,"Rating").select("Cold");
        new Input(driver,"Account Name").write(account.getAccountName() + Math.random());
        new Input(driver,"Phone").write(account.getPhone());
        new Input(driver,"Fax").write(account.getFax());
        new Input(driver,"Account Number").write(account.getAccountNumber());
        new Input(driver,"Website").write(account.getWebsite());
        new Input(driver,"Account Site").write(account.getAccountSite());
        new Input(driver,"Ticker Symbol").write(account.getTickerSymbol());
        new PickList(driver,"Type").select("Installation Partner");
        new PickList(driver,"Ownership").select("Private");
        new Input(driver,"Employees").write(account.getEmployees());
        new Input(driver,"Annual Revenue").write(account.getAnnualRevenue());
        new Input(driver,"SIC Code").write(account.getSicCode());
        new PickList(driver,"Industry").select("Banking");
        new TextArea(driver,"Billing Street").write(account.getBillingStreet());
        new TextArea(driver,"Shipping Street").write(account.getShippingStreet());
        new Input(driver,"Billing City").write(account.getBillingCity());
        new Input(driver,"Billing State/Province").write(account.getBillingStateProvince());
        new Input(driver,"Shipping City").write(account.getShippingCity());
        new Input(driver,"Shipping State/Province").write(account.getShippingStateProvince());
        new Input(driver,"Billing Zip/Postal Code").write(account.getBillingZipPostalCode());
        new Input(driver,"Billing Country").write(account.getBillingCountry());
        new Input(driver,"Shipping Zip/Postal Code").write(account.getShippingZipPostalCode());
        new Input(driver,"Shipping Country").write(account.getShippingCountry());
        new PickList(driver,"Customer Priority").select("High");
        new PickList(driver,"SLA").select("Gold");
        new Input(driver,"SLA Serial Number").write(account.getSlaSerialNumber());
        new Input(driver,"Number of Locations").write(account.getNumberOfLocations());
        new PickList(driver,"Active").select("Yes");
        new PickList(driver,"Upsell Opportunity").select("No");
        new TextArea(driver,"Description").write(account.getDescription());
        return this;
    }
    public void saveDate() {
        log.info("Saving date for an account");
        driver.findElement(SAVE_BUTTON).click();
    }

    public String getTitle() {
        log.info("Getting title after saving");
        waitForPageLoaded();
        return driver.findElement(TITLE).getText();
    }
}
