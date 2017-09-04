package com.endava.pages;

import com.gargoylesoftware.htmlunit.Page;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.hamcrest.core.Is.is;

public class AfterLoginPage {
    public WebDriver driver;

    public AfterLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".well:nth-child(1) h3")
    private WebElement popularTags;

    @FindBy(css = ".tagspopular>ul>li>a")
    private WebElement joomlaTag;

    @FindBy(css = "#aside div:nth-of-type(2) h3")
    private WebElement latestArticles;

    @FindBy(css = "#aside div:nth-of-type(3) h3")
    private WebElement userMenu;

    @FindBy(css = ".item-102>a")
    private WebElement profile;

    @FindBy(css = ".item-104>a")
    private WebElement submitArticle;

    @FindBy(css = ".item-103>a")
    private WebElement siteAdmin;

    @FindBy(css = ".item-106>a")
    private WebElement templateSettings;

    @FindBy(css = ".item-107>a")
    private WebElement siteSettings;

    @FindBy(css = "#aside div:nth-of-type(2)")
    private WebElement latestArticlesBlock;

    @FindBy(css = ".latestnews li a span")
    private List<WebElement> latestArticlesList;

    @FindBy(css = ".btn.jmodedit")
    private WebElement editButton;
    @FindBy(css = ".accordion-group:nth-of-type(1)")
    private WebElement options;

    @FindBy(css = ".controls #jform_params_count")
    private WebElement noOfArticles;

    @FindBy(css = ".btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = ".alert.alert-success")
    private WebElement messageBlock;

    @FindBy(css = "fieldset:nth-of-type(1) legend")
    private WebElement editYourProfile;

    @FindBy(css = ".alert-message")
    private WebElement profileSaved;

    public void verifyElem() {
        Assert.assertThat(popularTags.isDisplayed(), is(true));
        Assert.assertThat(latestArticles.isDisplayed(), is(true));
        Assert.assertThat(userMenu.isDisplayed(), is(true));
        Assert.assertThat(profile.isDisplayed(), is(true));
        Assert.assertThat(submitArticle.isDisplayed(), is(true));
        Assert.assertThat(siteAdmin.isDisplayed(), is(true));
        Assert.assertThat(templateSettings.isDisplayed(), is(true));
        Assert.assertThat(siteSettings.isDisplayed(), is(true));
    }

    public SubmitArticlePage addArticle() {
        submitArticle.click();
        return PageFactory.initElements(driver, SubmitArticlePage.class);
    }

    public EditProfilePage editProfile() {
        profile.click();
        return PageFactory.initElements(driver, EditProfilePage.class);
    }

    public String editYourProf(){
        return editYourProfile.getText();
    }

    public Boolean saved(){
        return profileSaved.isDisplayed();
    }

    public SiteAdministratorPage siteadmin() {
        siteAdmin.click();
        return PageFactory.initElements(driver, SiteAdministratorPage.class);
    }

    public TemplateSettingsPage template() {
        templateSettings.click();
        return PageFactory.initElements(driver, TemplateSettingsPage.class);
    }

    public EditArticlePage clickOnArticle(String text) {
        for (WebElement article : latestArticlesList) {
            if (article.getText().equals(text)) {
                article.click();
                break;
            }
        }
        return PageFactory.initElements(driver, EditArticlePage.class);
    }

    public JoomlaPage popTag() {
        joomlaTag.click();
        return PageFactory.initElements(driver, JoomlaPage.class);
    }

    public SubmitArticlePage verifyArticle(String text) {
        for (WebElement elem : latestArticlesList) {
            if (elem.getText().equals(text)) Assert.assertThat(elem.isDisplayed(), is(true));
        }
        return PageFactory.initElements(driver, SubmitArticlePage.class);
    }

    public String verifLastArticle(){
        return latestArticlesList.get(0).getText();
     }

    public void editArticlesBlock(String nr) {
        latestArticlesBlock.click();
        editButton.click();
        options.click();
        noOfArticles.clear();
        noOfArticles.sendKeys(nr);
        saveButton.click();
    }

    public SiteSettingsPage goToSiteSettings() {
        siteSettings.click();
        return PageFactory.initElements(driver, SiteSettingsPage.class);
    }
}
