package com.epam.tc.hw3.pages.homepage;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//*[contains(@class,'m-l8')]/li/a")
    private List<WebElement> headerMenuActual;

    @FindBy(className = "icons-benefit")
    private List<WebElement> webElementListImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> webElementListTexts;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public List<String> getHeader() {
        return headerMenuActual.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Boolean> getListImages() {
        return webElementListImages.stream().map(WebElement::isDisplayed).collect(Collectors.toList());
    }

    public List<String> getListTexts() {
        return webElementListTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

}
