package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;
@Log4j2
public class ContactCreationPage extends BasePage {

    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']");
    private  final By TITLE = By.xpath("//*[@title='Activity']/a");
    private final By MUM_S_EMAIL = By.xpath("//*[contains(text(),'mom')]/ancestor::lightning-input//input");

    public ContactCreationPage(WebDriver driver){
        super(driver);
    }

    public ContactCreationPage open() {
        log.info("Opening creation page");
        driver.get(BASE_URL + "lightning/o/Contact/new");
        return this;
    }

    public ContactCreationPage createContact(String phone, String homePhone, String firstName, String lastName, String mobile,
                              String title, String otherPhone, String department, String fax, String email, String assistant,
                              String asstPhone, String momsEmail, String mailingCity, String mailingStateProvince, String otherCity,
                              String otherStateProvince, String mailingZipPostalCode, String mailingCountry, String otherZipPostalCode,
                              String otherCountry, String languages, String mailingStreet, String otherStreet, String description) {
        log.info("Creating contact");
        new Input(driver,"Phone").write(phone);
        new Input(driver,"Home Phone").write(homePhone);
        new PickList(driver,"Salutation").select("Prof.");
        new Input(driver,"First Name").write(firstName);
        new Input(driver,"Last Name").write(lastName + Math.random());
        new Input(driver,"Mobile").write(mobile);
        new Input(driver,"Title").write(title);
        new Input(driver,"Other Phone").write(otherPhone);
        new Input(driver,"Department").write(department);
        new Input(driver,"Fax").write(fax);
        new Input(driver,"Email").write(email);
        new Input(driver,"Assistant").write(assistant);
        new PickList(driver,"Lead Source").select("Web");
        new Input(driver,"Asst. Phone").write(asstPhone);
        driver.findElement(MUM_S_EMAIL).sendKeys(momsEmail);
        new TextArea(driver,"Mailing Street").write(mailingStreet);
        new TextArea(driver,"Other Street").write(otherStreet);
        new Input(driver,"Mailing City").write(mailingCity);
        new Input(driver,"Mailing State/Province").write(mailingStateProvince);
        new Input(driver,"Other City").write(otherCity);
        new Input(driver,"Other State/Province").write(otherStateProvince);
        new Input(driver,"Mailing Zip/Postal Code").write(mailingZipPostalCode);
        new Input(driver,"Mailing Country").write(mailingCountry);
        new Input(driver,"Other Zip/Postal Code").write(otherZipPostalCode);
        new Input(driver,"Other Country").write(otherCountry);
        new Input(driver,"Languages").write(languages);
        new PickList(driver,"Level").select("Primary");
        new TextArea(driver,"Description").write(description);
        return this;
    }

    public void saveDate() {
        log.info("Saving date for an contact");
        driver.findElement(SAVE_BUTTON).click();
    }

    public String getTitle() {
        log.info("Getting title after saving");
        waitForPageLoaded();
        return driver.findElement(TITLE).getText();
    }
}
