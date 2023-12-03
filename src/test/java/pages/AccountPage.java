package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

public class AccountPage extends BasePage{

    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']");
    private final By MUM_S_EMAIL = By.xpath("//*[contains(text(),'mom')]/ancestor::lightning-input//input");
    private  final By TITLE = By.cssSelector("[title='Activity']");

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public void openAccountCreationPage() {
        driver.get(BASE_URL + "lightning/o/Account/new");
    }

    public void createAccount(String accountName, String accountNumber, String phone, String fax, String website,
                              String accountSite, String tickerSymbol,String employees, String annualRevenue, String sicCode,
                              String billingCity, String billingStateProvince, String shippingCity, String shippingStateProvince,
                              String billingZipPostalCode, String billingCountry, String shippingZipPostalCode, String shippingCountry,
                              String slaSerialNumber, String numberOfLocations, String billingStreet, String shippingStreet, String description) {
        new Input(driver,"Account Name").write(accountName + Math.random());
        new Input(driver,"Account Number").write(accountNumber);
        new Input(driver,"Phone").write(phone);
        new Input(driver,"Fax").write(fax);
        new Input(driver,"Website").write(website);
        new Input(driver,"Website").write(website);
        new Input(driver,"Account Site").write(accountSite);
        new Input(driver,"Ticker Symbol").write(tickerSymbol);
        new Input(driver,"Employees").write(employees);
        new Input(driver,"Annual Revenue").write(annualRevenue);
        new Input(driver,"SIC Code").write(sicCode);
        new Input(driver,"Billing City").write(billingCity);
        new Input(driver,"Billing State/Province").write(billingStateProvince);
        new Input(driver,"Shipping City").write(shippingCity);
        new Input(driver,"Shipping State/Province").write(shippingStateProvince);
        new Input(driver,"Shipping State/Province").write(shippingStateProvince);
        new Input(driver,"Billing Zip/Postal Code").write(billingZipPostalCode);
        new Input(driver,"Billing Country").write(billingCountry);
        new Input(driver,"Shipping Zip/Postal Code").write(shippingZipPostalCode);
        new Input(driver,"Shipping Country").write(shippingCountry);
        new Input(driver,"SLA Serial Number").write(slaSerialNumber);
        new Input(driver,"Number of Locations").write(numberOfLocations);

        new TextArea(driver,"Billing Street").write(billingStreet);
        new TextArea(driver,"Shipping Street").write(shippingStreet);
        new TextArea(driver,"Description").write(description);

        new PickList(driver,"Rating").select("Hot");
        new PickList(driver,"Type").select("Other");
        new PickList(driver,"Ownership").select("Other");
        new PickList(driver,"Industry").select("Other");
        new PickList(driver,"Customer Priority").select("High");
        new PickList(driver,"SLA").select("Gold");
        new PickList(driver,"Upsell Opportunity").select("No");
        new PickList(driver,"Active").select("No");
    }

    public void saveDateOfNewAccount() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void openContactCreationPage() {
        driver.get(BASE_URL + "lightning/o/Contact/new?count=1&nooverride=1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=170144377101826998");
    }
    public void createContact(String phone, String homePhone, String firstName, String lastName, String mobile,
                              String title, String otherPhone, String department, String fax, String email, String assistant,
                              String asstPhone, String momsEmail, String mailingCity, String mailingStateProvince, String otherCity,
                              String otherStateProvince, String mailingZipPostalCode, String mailingCountry, String otherZipPostalCode,
                              String otherCountry, String languages, String mailingStreet, String otherStreet, String description) {
        new Input(driver,"Phone").write(phone);
        new Input(driver,"Home Phone").write(homePhone);
        new Input(driver,"First Name").write(firstName);
        new Input(driver,"Last Name").write(lastName + Math.random());
        new Input(driver,"Mobile").write(mobile);
        new Input(driver,"Title").write(title);
        new Input(driver,"Other Phone").write(otherPhone);
        new Input(driver,"Department").write(department);
        new Input(driver,"Fax").write(fax);
        new Input(driver,"Email").write(email);
        new Input(driver,"Assistant").write(assistant);
        new Input(driver,"Asst. Phone").write(asstPhone);
        new Input(driver,"Mailing City").write(mailingCity);
        new Input(driver,"Mailing State/Province").write(mailingStateProvince);
        new Input(driver,"Other City").write(otherCity);
        new Input(driver,"Other State/Province").write(otherStateProvince);
        new Input(driver,"Mailing Zip/Postal Code").write(mailingZipPostalCode);
        new Input(driver,"Mailing Country").write(mailingCountry);
        new Input(driver,"Other Zip/Postal Code").write(otherZipPostalCode);
        new Input(driver,"Other Country").write(otherCountry);
        new Input(driver,"Languages").write(languages);

        new TextArea(driver,"Mailing Street").write(mailingStreet);
        new TextArea(driver,"Other Street").write(otherStreet);
        new TextArea(driver,"Description").write(description);

        driver.findElement(MUM_S_EMAIL).sendKeys(momsEmail);
        new PickList(driver,"Salutation").select("Prof.");
        new PickList(driver,"Lead Source").select("Web");
        new PickList(driver,"Level").select("Primary");
    }

    public void saveDateOfNewContact() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}
