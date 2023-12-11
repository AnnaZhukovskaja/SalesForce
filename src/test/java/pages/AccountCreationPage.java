package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

public class AccountCreationPage extends BasePage{

    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']");
    private  final By TITLE = By.xpath("//*[@title='Activity']/a");

    public AccountCreationPage(WebDriver driver){
        super(driver);
    }

    public AccountCreationPage open() {
        driver.get(BASE_URL + "lightning/o/Account/new");
        return this;
    }

    public AccountCreationPage createAccount(String accountName, String accountNumber, String phone, String fax, String website,
                              String accountSite, String tickerSymbol,String employees, String annualRevenue, String sicCode,
                              String billingCity, String billingStateProvince, String shippingCity, String shippingStateProvince,
                              String billingZipPostalCode, String billingCountry, String shippingZipPostalCode, String shippingCountry,
                              String slaSerialNumber, String numberOfLocations, String billingStreet, String shippingStreet, String description) {

        new PickList(driver,"Rating").select("Cold");
        new Input(driver,"Account Name").write(accountName + Math.random());
        new Input(driver,"Phone").write(phone);
        new Input(driver,"Fax").write(fax);
        new Input(driver,"Account Number").write(accountNumber);
        new Input(driver,"Website").write(website);
        new Input(driver,"Account Site").write(accountSite);
        new Input(driver,"Ticker Symbol").write(tickerSymbol);
        new PickList(driver,"Type").select("Other");
        new PickList(driver,"Ownership").select("Public");
        new Input(driver,"Employees").write(employees);
        new Input(driver,"Annual Revenue").write(annualRevenue);
        new Input(driver,"SIC Code").write(sicCode);
        new PickList(driver,"Industry").select("Banking");
        new TextArea(driver,"Billing Street").write(billingStreet);
        new TextArea(driver,"Shipping Street").write(shippingStreet);
        new Input(driver,"Billing City").write(billingCity);
        new Input(driver,"Billing State/Province").write(billingStateProvince);
        new Input(driver,"Shipping City").write(shippingCity);
        new Input(driver,"Shipping State/Province").write(shippingStateProvince);
        new Input(driver,"Billing Zip/Postal Code").write(billingZipPostalCode);
        new Input(driver,"Billing Country").write(billingCountry);
        new Input(driver,"Shipping Zip/Postal Code").write(shippingZipPostalCode);
        new Input(driver,"Shipping Country").write(shippingCountry);
        new PickList(driver,"Customer Priority").select("High");
        new PickList(driver,"SLA").select("Gold");
        new Input(driver,"SLA Serial Number").write(slaSerialNumber);
        new Input(driver,"Number of Locations").write(numberOfLocations);
        new PickList(driver,"Active").select("Yes");
        new PickList(driver,"Upsell Opportunity").select("No");
        new TextArea(driver,"Description").write(description);
        return this;
    }
    public void saveDate() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public String getTitle() {
        waitForPageLoaded();
        return driver.findElement(TITLE).getText();
    }
}
