package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.AccountCreationPage;
import pages.ContactCreationPage;
import pages.LoginPage;


import java.time.Duration;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    AccountCreationPage accountCreationPage;
    ContactCreationPage contactCreationPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Настройка браузера")
    public void setup(@Optional("chrome") String browser, ITestContext iTestContext) {
        log.info("Setup browser");
        System.out.println(System.getProperty("t"));
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        iTestContext.setAttribute("driver",driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        contactCreationPage = new ContactCreationPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown() {
        log.info("Closing the browser");
        if(driver != null) {
            driver.quit();
        }
        driver.quit();
    }
}
