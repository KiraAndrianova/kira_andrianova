package com.epam.tc.hw3.driverutils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverActions {

    private WebDriverWait webDriverWait;

    public WebDriverActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public WebElement WaitUntilCondition(ExpectedCondition<WebElement> p) {
        return webDriverWait.ignoring(NoSuchElementException.class)
                .until(p);
    }

    public void switchToOpenedWindow(WebDriver webDriver) {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
    }
}
