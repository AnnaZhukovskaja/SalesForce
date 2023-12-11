package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

    final private By MAIN_PAGE_ICONS = By.xpath("//*[@class='carousel']//descendant::*[@class='tileHelp'][3]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage isPageOpened() {
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_ICONS));
        return this;
    }
}