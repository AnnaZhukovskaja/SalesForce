package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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