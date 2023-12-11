package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class AccountTest extends BaseTest{

    @Test
    public void createAccount() {

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
                createAccount("Anna", "12345645", "3752985555", "3658554",
                "www.tms.by", "www.tms.by/gfgf", "5555", "50", "150000",
                "4545", "Lenina,12", "New Minsk","Minsk", "New MinskCity",
                "454","Belarus", "5465465", "China", "15615",
                "54", "New Street", "Old Street", "Dangerous cargo!!").
                saveDate();

        assertEquals(accountCreationPage.getTitle(),"Activity", "The account has not been created");
    }
}
