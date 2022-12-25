package com.epam.tc.hw3.test;

import static java.util.Arrays.asList;

import com.epam.tc.hw3.pages.leftmenu.LeftMenuPage;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LeftMenuTest extends BaseTest {

    public SoftAssertions softAssertions = new SoftAssertions();

    @Test
    public void leftMenuTest() {

        LeftMenuPage leftMenu = PageFactory
                .initElements(webDriver, LeftMenuPage.class);

        List<String> expectedElems = asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        softAssertions.assertThat(leftMenu.getLeftMenu())
                .containsExactlyElementsOf(expectedElems);

        softAssertions.assertAll();
    }
}
