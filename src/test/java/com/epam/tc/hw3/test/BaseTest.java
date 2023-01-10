package com.epam.tc.hw3.test;

import com.epam.tc.hw3.driverutils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void prepareToTest() {
        webDriver = DriverManager.setupDriver();

        String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";
        webDriver.navigate().to(baseURL);
    }

    @AfterClass
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
