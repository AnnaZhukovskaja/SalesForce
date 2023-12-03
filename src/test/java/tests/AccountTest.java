package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


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
        accountPage.createAccount("Anna", "12345645", "3752985555", "3658554",
                "www.tms.by", "www.tms.by/gfgf", "5555", "50", "150000",
                "4545", "Lenina,12", "New Minsk","Minsk", "New MinskCity",
                "454","Belarus", "5465465", "China", "15615",
                "54", "New Street", "Old Street", "Dangerous cargo!!");
        accountPage.saveDateOfNewAccount();

    }

    @Test
    public void createContact() {
        loginPage.open();
        loginPage.login("drak@tms.sandbox","Password01!!" );
        accountPage.openContactCreationPage();
        accountPage.createContact("3752589555", "37245854455", "Laura", "Smidt", "546545645","Cargo",
                "785145556", "Sunshine", "9552455", "abc@gh.com",
                "Ivanov", "959599797", "momom@mom.mom", "Grodno", "Belucha",
                "Mogilev", "White State","322626", "RF", "7474741",
                "USA", "English","Vivo Street", "Nova Street", "Be happy!!");
        accountPage.saveDateOfNewContact();

    }

}
