package com.epam.tc.hw3.test;

import com.epam.tc.hw3.pages.differentelementspage.DifferentElementsPage;
import com.epam.tc.hw3.pages.loginpage.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DifferentElementsTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void differentElementsTest() {

        LoginPage loginPage = PageFactory
                .initElements(webDriver, LoginPage.class);

        DifferentElementsPage differentElementsPage = PageFactory
                .initElements(webDriver, DifferentElementsPage.class);

        loginPage.login("Roman", "Jdi1234");

        differentElementsPage.openDifferentElementsPage();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(differentElementsPage.getMainContent()));

        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }

        //step 6 - Select checkboxes Water, Wind
        differentElementsPage.tickCheckbox("Water");
        differentElementsPage.tickCheckbox("Wind");

        //Select radio Selen
        differentElementsPage.tickRadios("Selen");

        //Select in dropdown Yellow
        differentElementsPage.tickDropDownItem("Yellow");

        softAssertions.assertThat(differentElementsPage.getLogs())
                .contains("Water: condition changed to true")
                .contains("Wind: condition changed to true")
                .contains(" metal: value changed to Selen")
                .contains("Colors: value changed to Yellow");

        softAssertions.assertAll();

    }

}
