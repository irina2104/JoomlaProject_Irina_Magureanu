package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplateSettingsPage {
    public WebDriver driver;

    public TemplateSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='page-site']/div/fieldset/div[1]/div[2]/div/span/span")
    private WebElement templateColor;

    @FindBy(xpath = ".//*[@id='page-site']/div/fieldset/div[1]/div[2]/div/div/div[3]/div[1]")
    private WebElement popUpTempColor;

    @FindBy(xpath = ".//*[@id='page-site']/div/fieldset/div[2]/div[2]/div/span/span")
    private WebElement backColor;

    @FindBy(xpath = ".//*[@id='page-site']/div/fieldset/div[2]/div[2]/div/div/div[3]/div[1]")
    private WebElement popUpBackColor;

    @FindBy(xpath = ".//*[@id='templates-form']/div/div[1]/div[1]/button")
    private WebElement saveButton;


}
