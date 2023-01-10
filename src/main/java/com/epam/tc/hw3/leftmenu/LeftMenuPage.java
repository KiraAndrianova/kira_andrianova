package com.epam.tc.hw3.leftmenu;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {

    @FindBy(xpath = "//*[contains(@class,'sidebar-menu')]/li/a/span")
    private List<WebElement> leftMenu;

    public List<String> getLeftMenu() {
        return leftMenu.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
