package com.epam.tc.hw3.test;

import com.epam.tc.hw3.pages.loginpage.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void loginTest() {

        LoginPage loginPage = PageFactory
                .initElements(webDriver, LoginPage.class);

        loginPage.login("Roman", "Jdi1234");

        //step 2 - assert browser title
        softAssertions.assertThat(webDriver.getTitle()).contains("Home Page");

        //step 4 - Assert Username is loggined
        softAssertions.assertThat(loginPage.getUserName())
                .isEqualTo("ROMAN IOVLEV");

        softAssertions.assertAll();
    }
}
