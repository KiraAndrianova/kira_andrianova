package com.epam.tc.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise2Test {

    @Test
    public void exercise2Check() {

        //setup Chrome Driver
        System.setProperty("webdriver.chrome.driver", "/absolute/path/to/binary/chromedriver");
        WebDriverManager.chromedriver().setup();

        //setup options for Chrome Driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "start-maximized");

        WebDriver driver = new ChromeDriver(options);

        //step 1 - navigate to the site
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        SoftAssertions softAssertions = new SoftAssertions();

        //step 2 - assert browser title
        softAssertions.assertThat(driver.getTitle()).contains("Page Home");

        //step 3 - perform login
        WebElement element = driver.findElement(By.id("user-icon"));
        element.click();

        element = driver.findElement(By.id("name"));
        element.click();
        element.sendKeys("Roman");

        element = driver.findElement(By.id("password"));
        element.click();
        element.sendKeys("Jdi1234");

        element = driver.findElement(By.id("login-button"));
        element.click();

        //step 4 - Assert Username is loggined
        driver.findElement(By.id("user-name"));
        softAssertions.assertThat(driver.getTitle()).isEqualTo("Roman Iovlev");

        //step 5 - Open through the header menu Service -> Different Elements Page
        element = driver.findElement(By.xpath("//*[contains(@class,'m-l8')]/li/a/span"));
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

        //Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox

        List<WebElement> webElementLogs = driver.findElements(By.cssSelector("qul.panel-body-list.logs"));
        for (WebElement l : webElementLogs) {
            if (l.getText().contains("Water: condition changed to true")) {
                softAssertions.assertThat(l.getText().contains("Water: condition changed to true")).isEqualTo(true);
            }

            if (l.getText().contains("Wind: condition changed to true")) {
                softAssertions.assertThat(l.getText().contains("Wind: condition changed to true")).isEqualTo(true);
            }

            //for radio button there is a log row and value is corresponded to the status of radio button
            if (l.getText().contains("metal: value changed to  Selen")) {
                softAssertions.assertThat(l.getText().contains("metal: value changed to  Selen")).isEqualTo(true);
            }

            //for dropdown there is a log row and value is corresponded to the selected value
            if (l.getText().contains("Colors: value changed to Yellow")) {
                softAssertions.assertThat(l.getText().contains("Colors: value changed to Yellow")).isEqualTo(true);
            }

        }

        //Closer browser
        driver.quit();
    }

}
