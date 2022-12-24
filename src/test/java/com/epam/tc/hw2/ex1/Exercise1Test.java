package com.epam.tc.hw2.ex1;

import static java.util.Arrays.asList;

import com.epam.tc.hw2.BaseHW2Test;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseHW2Test {

    @Test
    public void exercise1Check() {

        loginTest();

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> headerMenuActual = driver.findElements(By.xpath("//*[contains(@class,'m-l8')]/li/a"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> headerMenuExpected = asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        softAssertions.assertThat(headerMenuActual).hasSize(4).containsExactlyElementsOf(headerMenuExpected);

        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> webElementListImages = driver.findElements(By.className("icons-benefit"));
        softAssertions.assertThat(webElementListImages).hasSize(4);

        softAssertions.assertThat(webElementListImages.get(0).isDisplayed()).isTrue();
        softAssertions.assertThat(webElementListImages.get(1).isDisplayed()).isTrue();
        softAssertions.assertThat(webElementListImages.get(2).isDisplayed()).isTrue();
        softAssertions.assertThat(webElementListImages.get(3).isDisplayed()).isTrue();

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> webElementListTexts = driver.findElements(By.className("benefit-txt"));
        softAssertions.assertThat(webElementListTexts).hasSize(4);

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
        softAssertions.assertThat(driver.findElement(By.id("frame")).isDisplayed()).isTrue();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssertions.assertThat(driver.findElement(By.id("frame-button")).isDisplayed()).isTrue();

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> actualElems = driver.findElements(By.xpath("//*[contains(@class,'sidebar-menu')]/li/a/span"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedElems = asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        softAssertions.assertThat(actualElems).hasSize(5).containsExactlyElementsOf(expectedElems);

        softAssertions.assertAll();

    }
}
