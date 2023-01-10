package com.epam.tc.hw3.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    public void login(String name, String password) {
        userIcon.click();
        this.user.sendKeys(name);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

}
