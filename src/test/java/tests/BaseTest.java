package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.LoginPage;


import java.time.Duration;

@Listeners(TestListener.class)
public abstract class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Настройка браузера")
    public void setup(@Optional("chrome") String browser, ITestContext iTestContext) {
        System.out.println(System.getProperty("t"));
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            //options.addArguments("headless");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("opera")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        iTestContext.setAttribute("driver",driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

        System.out.println(System.getenv("user"));
        System.out.println(System.getenv("password"));
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown() {
        driver.quit();
    }
}
