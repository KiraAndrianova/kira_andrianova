package com.epam.tc.hw3.driverutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static void setupChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/absolute/path/to/binary/chromedriver");
        WebDriverManager.chromedriver()
                .setup();
    }

    public static WebDriver setupDriver() {
        setupChromeDriver();
        //setup options for Chrome Driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "start-maximized");

        WebDriver webDriver = new ChromeDriver(options);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

}
