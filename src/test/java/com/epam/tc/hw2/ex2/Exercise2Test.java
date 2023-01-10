package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseHW2Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseHW2Test {

    @Test
    public void exercise2Check() {

        loginTest();

        //step 5 - Open through the header menu Service -> Different Elements Page
        WebElement element = driver.findElement(By.xpath("//*[contains(@class,'m-l8')]/li/a/span"));
        element.click();

        element = driver.findElement(By.xpath(".//a[text() = 'Different elements']"));
        element.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("main-content")));

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        //step 6 - Select checkboxes Water, Wind
        List<WebElement> webElementList = driver.findElements(By.cssSelector("label.label-checkbox"));
        for (WebElement w : webElementList) {
            if (w.getText().contains("Water") || w.getText().contains("Wind")) {
                w.click();
            }
        }

        //Select radio Selen
        List<WebElement> webElementRadio = driver.findElements(By.cssSelector("label.label-radio"));
        for (WebElement w : webElementRadio) {
            if (w.getText().contains("Selen")) {
                w.click();
            }
        }

        //Select in dropdown Yellow
        Select dropDown = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        dropDown.selectByVisibleText("Yellow");

        softAssertions.assertThat(driver.findElement(By.cssSelector("ul.panel-body-list.logs")).getText())
                .contains("Water: condition changed to true")
                .contains("Wind: condition changed to true")
                .contains(" metal: value changed to Selen")
                .contains("Colors: value changed to Yellow");

        softAssertions.assertAll();

    }

}
