package tests;

import dto.Account;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class AccountTest extends BaseTest{

    @Test
    public void createAccount() {

        Account account = Account.builder()
                .accountName("Anna")
                .accountNumber("12345645")
                .phone("3752985555")
                .fax("3658554")
                .website("www.tms.by")
                .accountSite("www.tms.by/gfgf")
                .tickerSymbol("5555")
                .employees("50")
                .annualRevenue("150000")
                .sicCode("4545")
                .billingCity("Lenina,12")
                .billingStateProvince("New Minsk")
                .shippingCity("Minsk")
                .shippingCity("Minsk")
                .shippingStateProvince("New MinskCity")
                .billingZipPostalCode("454")
                .billingCountry("Belarus")
                .shippingZipPostalCode("5465465")
                .shippingCountry("China")
                .slaSerialNumber("15615")
                .numberOfLocations("54")
                .billingStreet("New Street")
                .shippingStreet("Old Street")
                .description("Dangerous cargo!!")
                .build();
        loginPage.
                open().
                login("drak@tms.sandbox","Password01!!").
                isPageOpened();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".oneUserProfileCardTrigger"))));
        //driver.get("https://tms41-dev-ed.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        //driver.findElement(By.cssSelector("[title=New]")).click();

        accountCreationPage.
                open().
                createAccount(account).
                saveDate();

        assertEquals(accountCreationPage.getTitle(),"Activity", "The account has not been created");
    }
}
