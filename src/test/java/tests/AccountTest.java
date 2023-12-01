package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

import java.time.Duration;


public class AccountTest extends BaseTest{

    @Test
    public void createAccount() {

        loginPage.open();
        loginPage.login("drak@tms.sandbox","Password01!!" );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".oneUserProfileCardTrigger"))));
        //driver.get("https://tms41-dev-ed.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        //driver.findElement(By.cssSelector("[title=New]")).click();
        accountPage.openAccountCreationPage();

        new Input(driver,"Account Name").write("Anna Zh");
        new Input(driver,"Account Number").write("12345678");
        new PickList(driver,"Rating").select("Hot");
        new TextArea(driver,"Billing Street").write("Lenina,23");
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();



    }
}
