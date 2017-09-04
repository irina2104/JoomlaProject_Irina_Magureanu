package com.endava.pages;

import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;

public class EditArticlePage {
    public WebDriver driver;

    public EditArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".btn.jmodedit")
    private WebElement editButton;

    @FindBy(css = ".btn.dropdown-toggle")
    private WebElement editText;

    @FindBy(css = ".edit-icon>a")
    private WebElement edit;

    @FindBy(css = "iframe#jform_articletext_ifr")
    private WebElement textSelect;

    @FindBy(css = "#mceu_67-body div")
    private List<WebElement> textFormat;

    @FindBy(css = "#mceu_68-body div")
    private List<WebElement> alignText;

    @FindBy(css = ".item-page>div>p")
    private WebElement articleContent;

    @FindBy(css= ".btn-group .btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = ".alert.alert-success div")
    private WebElement articleSaved;

    @FindBy(css = "#com-content-formTabs li:nth-of-type(2)")
    private WebElement publishingButton;
    @FindBy(css = "#jform_state_chzn .chzn-single")
    private WebElement status;
    @FindBy(css = "#jform_state_chzn .chzn-drop")
    private WebElement statusBlock;
    @FindBy(css = "#jform_state_chzn .chzn-results li")
    private List<WebElement> statusList;

    @FindBy(css = ".item-101.default a")
    private WebElement homeButton;

    @FindBy(css = ".page-header h2")
    private WebElement articleTitle;

    public String article() {
        return articleTitle.getText();
    }

    public String editArticle(int i) {
        if (articleContent.isDisplayed()) {
            editText.click();
            edit.click();
            driver.switchTo().frame(textSelect);
            driver.findElement(By.id("tinymce")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            driver.switchTo().defaultContent();
            textFormat.get(i).click();
            alignText.get(i).click();
            saveButton.click();
        }
        return articleSaved.getText();
    }

    public String editPublishing(int index) {
        editText.click();
        edit.click();
        publishingButton.click();
        status.click();
        if (statusBlock.isDisplayed()) statusList.get(index).click();
        saveButton.click();
        return articleSaved.getText();

    }

    public void goToHomePage(){
        if (homeButton.isDisplayed()) homeButton.click();
    }


}

