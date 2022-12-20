package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.Locale;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Exercise1Test {

    @Test
    public void exercise1Check() {

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

        //Assert that there are 4 items on the header section are displayed
        List<WebElement> webElementList = driver.findElements(By.xpath("//*[contains(@class,'m-l8')]/li/a"));
        softAssertions.assertThat(webElementList.size()).isEqualTo(4);

        // and they have proper texts
        softAssertions.assertThat(webElementList.get(0).getText()
                .toLowerCase(Locale.ROOT)).isEqualTo("home");
        softAssertions.assertThat(webElementList.get(1).getText()
                .toLowerCase(Locale.ROOT)).isEqualTo("contact form");
        softAssertions.assertThat(webElementList.get(2).getText()
                .toLowerCase(Locale.ROOT)).isEqualTo("service");
        softAssertions.assertThat(webElementList.get(3).getText()
                .toLowerCase(Locale.ROOT)).isEqualTo("metals & colors");

        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> webElementListImages = driver.findElements(By.className("icons-benefit"));
        softAssertions.assertThat(webElementListImages.size()).isEqualTo(4);

        softAssertions.assertThat(webElementListImages.get(0).isDisplayed()).isEqualTo(true);
        softAssertions.assertThat(webElementListImages.get(1).isDisplayed()).isEqualTo(true);
        softAssertions.assertThat(webElementListImages.get(2).isDisplayed()).isEqualTo(true);
        softAssertions.assertThat(webElementListImages.get(3).isDisplayed()).isEqualTo(true);

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> webElementListTexts = driver.findElements(By.className("benefit-txt"));
        softAssertions.assertThat(webElementListTexts.size()).isEqualTo(4);

        softAssertions.assertThat(webElementListTexts.get(0).getText())
                .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        softAssertions.assertThat(webElementListTexts.get(1).getText())
                .isEqualTo("To be flexible and\ncustomizable");
        softAssertions.assertThat(webElementListTexts.get(2).getText())
                .isEqualTo("To be multiplatform");
        softAssertions.assertThat(webElementListTexts.get(3).getText())
                .isEqualTo("Already have good base"
                        + "\n(about 20 internal and"
                        + "\nsome external projects),"
                        + "\nwish to get more…");

        //Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(driver.findElement(By.id("frame")).isDisplayed()).isEqualTo(true);

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssertions.assertThat(driver.findElement(By.id("frame-button")).isDisplayed()).isEqualTo(true);

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> webElementListLeftMenu = driver
                .findElements(By.xpath("//*[contains(@class,'sidebar-menu')]/li/a/span"));
        softAssertions.assertThat(webElementListLeftMenu.size()).isEqualTo(5);

        softAssertions.assertThat(webElementListLeftMenu.get(0).getText())
                .isEqualTo("Home");
        softAssertions.assertThat(webElementListLeftMenu.get(1).getText())
                .isEqualTo("Contact form");
        softAssertions.assertThat(webElementListLeftMenu.get(2).getText())
                .isEqualTo("Service");
        softAssertions.assertThat(webElementListLeftMenu.get(3).getText())
                .isEqualTo("Metals & Colors");
        softAssertions.assertThat(webElementListLeftMenu.get(4).getText())
                .isEqualTo("Elements packs");

        //Closer browser
        driver.quit();
    }
}
