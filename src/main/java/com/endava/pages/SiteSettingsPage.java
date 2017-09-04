package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SiteSettingsPage {
    public WebDriver driver;

    public SiteSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".controls #jform_sitename")
    private WebElement siteName;

    @FindBy(css = ".btn-group.radio .btn.active.btn-danger")
    private WebElement siteOnline;

    @FindBy(css = "#jform_access_chzn .chzn-single")
    private WebElement privacy;

    @FindBy(css = "#jform_access_chzn .chzn-drop")
    private WebElement privacyBlock;

    @FindBy(css = "#jform_access_chzn .chzn-results li")
    private List<WebElement> privacyType;

    @FindBy(css = ".btn.btn-primary .icon-ok")
    private WebElement saveButton;

    @FindBy(css = "#jform_list_limit_chzn .chzn-single")
    private WebElement limit;

    @FindBy(css = "#jform_list_limit_chzn .chzn-drop")
    private WebElement limitBlock;

    @FindBy(css = "#jform_list_limit_chzn .chzn-results li")
    private List<WebElement> limitList;

    @FindBy(css = ".alert.alert-success div")
    private WebElement configSaved;

    @FindBy(css = ".item-101.default a")
    private WebElement homePageButton;

    public void changeSettings(String name, String tip, String nr) {
        siteName.clear();
        siteName.sendKeys(name);
        siteOnline.click();
        privacy.click();
        if (privacyBlock.isDisplayed()) for (WebElement type : privacyType) {
            if (type.getText().equals(tip)) type.click();
        }
        limit.click();
        if (limitBlock.isDisplayed()) for (WebElement elem : limitList) {
            if (elem.getText().equals(nr)) elem.click();
        }
        saveButton.click();

    }

    public String saveConfig(){
        return configSaved.getText();
    }

    public void goToHomePage(){
        homePageButton.click();
    }
}
