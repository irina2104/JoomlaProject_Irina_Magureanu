package com.endava.pages;

import com.endava.pages.AfterLoginPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class SubmitArticlePage {
    public WebDriver driver;
    public AfterLoginPage elems = new AfterLoginPage(driver);

    public SubmitArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#jform_title")
    private WebElement articleTitle;

    @FindBy(css = "#jform_alias")
    private WebElement articleAlias;

    @FindBy(css = "#mceu_95")
    private WebElement articleBody;

    @FindBy(css = ".mce-content-body>p")
    private WebElement articleText;

    @FindBy(css = ".btn.btn-primary .icon-ok")
    private WebElement saveButton;

    @FindBy(css = "#mceu_54 button")
    private WebElement addImageButton;

    @FindBy(css = ".pathway span")
    private List<WebElement> pathList;
    @FindBy(css = "iframe#jform_articletext_ifr")
    private WebElement articleFrame;

    @FindBy(css = ".btn.btn-success.button-save-selected")
    private WebElement insertButton;

    @FindBy(css = ".alert-success div")
    private WebElement successMessage;

    public String submitAnArticle(String title, String text) {
        articleTitle.sendKeys(title);
        articleBody.click();
        driver.switchTo().frame(articleFrame);
        driver.findElement(By.id("tinymce")).sendKeys(text);
        driver.switchTo().defaultContent();
        saveButton.click();
        return successMessage.getText();
    }

    public void seePath() {
        String result = StringUtils.join(pathList, "/ ");
        System.out.println(result);
    }

    public String submitAnArticlePhoto(String title, String text, String url) {
        articleTitle.sendKeys(title);
        articleBody.click();
        driver.switchTo().frame(articleFrame);
        driver.findElement(By.id("tinymce")).sendKeys(text);
        driver.switchTo().defaultContent();
        addImageButton.click();
        WebDriverWait buzz = new WebDriverWait(driver, 3);
        buzz.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@id,'-body')]/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath(".//div[contains(@id,'-body')]/iframe")));
        driver.findElement(By.id("f_url")).sendKeys(url);
        insertButton.click();
        driver.switchTo().defaultContent();
        saveButton.click();
        return successMessage.getText();
    }
}
