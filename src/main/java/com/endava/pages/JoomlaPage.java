package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoomlaPage {
    public WebDriver driver;

    public JoomlaPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "filter-search")
    private WebElement searchBox;

    @FindBy(css = ".btn .icon-search")
    private WebElement searchButton;

    @FindBy(css = "#adminForm p")
    private WebElement noResult;

    public void searchTag(String text) {
        searchBox.click();
        searchBox.sendKeys(text);
        searchButton.click();
    }

    public Boolean seeResults(){
        return noResult.isDisplayed();
    }
}
