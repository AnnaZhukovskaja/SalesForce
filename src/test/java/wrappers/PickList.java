package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PickList {
    WebDriver driver;
    String label;

    public PickList(WebDriver driver, String label) {
        this.driver=driver;
        this.label = label;
    }
    public void select(String option) {
        //driver.findElement(By.xpath(String.format("//*[text()='%s']/ancestor::lightning-picklist//*[@icon-name='utility:down']",label))).click();
        driver.findElement(By.xpath(String.format("//label[text()='%s']//following::div[@class='slds-combobox_container']",label))).click();
        driver.findElement(By.xpath(String.format("//lightning-base-combobox-item//span[text()='%s']",option))).click();
    }
}
