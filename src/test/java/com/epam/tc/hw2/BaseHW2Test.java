package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseHW2Test {

    public static WebDriver driver;

    public SoftAssertions softAssertions = new SoftAssertions();

    @BeforeClass
    public void webDriverStart() {

        System.setProperty("webdriver.chrome.driver", "/absolute/path/to/binary/chromedriver");
        WebDriverManager.chromedriver().setup();

        //setup options for Chrome Driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "start-maximized");

        driver = new ChromeDriver(options);

        //step 1 - navigate to the site
        String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";
        driver.navigate().to(baseURL);
    }

    @BeforeMethod
    public void loginTest() {

        //step 2 - assert browser title
        softAssertions.assertThat(driver.getTitle()).contains("Home Page");

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
        softAssertions.assertThat(driver.findElement(By.id("user-name")).getText())
                .isEqualTo("ROMAN IOVLEV");

        softAssertions.assertAll();
    }

    @AfterClass
    public void driverQuit() {
        //Closer browser
        driver.quit();
    }

}
