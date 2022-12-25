package com.epam.tc.hw3.test;

import static java.util.Arrays.asList;

import com.epam.tc.hw3.pages.homepage.HomePage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void homePageTest() {

        HomePage homePage = PageFactory
                .initElements(webDriver, HomePage.class);

        List<String> expectedHeaderMenu = asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        softAssertions.assertThat(homePage.getHeader())
                .containsExactlyElementsOf(expectedHeaderMenu);

        softAssertions.assertThat(homePage.getListImages())
                .allMatch(t -> t == true)
                .hasSize(4);

        List<String> expectedListTexts = asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base"
                        + "\n(about 20 internal and"
                        + "\nsome external projects),"
                        + "\nwish to get more…");

        softAssertions.assertThat(homePage.getListTexts())
                .hasSize(4)
                .containsExactlyElementsOf(expectedListTexts);

        //Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(homePage.getFrame().isDisplayed()).isTrue();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(homePage.getFrame());

        softAssertions.assertThat(homePage.getFrameButton().isDisplayed()).isTrue();

        //Switch to original window back
        webDriver.switchTo().defaultContent();

        softAssertions.assertAll();
    }
}
