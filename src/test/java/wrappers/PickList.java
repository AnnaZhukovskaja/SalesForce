package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Log4j2
public class PickList {
    WebDriver driver;
    String label;

    public PickList(WebDriver driver, String label) {
        this.driver=driver;
        this.label = label;
    }
    public void select(String option) {
        log.info("Selecting '{}' inside picklist '{}'",option,label);
        WebElement element = driver.findElement(By.xpath(String.format("//label[text()='%s']//following::div[@class='slds-combobox_container']",label)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
        driver.findElement(By.xpath(String.format("//lightning-base-combobox-item//span[text()='%s']",option))).click();
    }
}
