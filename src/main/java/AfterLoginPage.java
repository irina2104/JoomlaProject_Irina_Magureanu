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

    @FindBy(xpath = ".//*[@id='aside']/div[1]/h3")
    private WebElement popularTags;

    @FindBy(css = ".tagspopular>ul>li>a")
    private WebElement joomlaTag;

    @FindBy(xpath = ".//*[@id='aside']/div[2]/h3")
    private WebElement latestArticles;

    @FindBy(xpath = ".//*[@id='aside']/div[3]/h3")
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

    @FindBy(xpath = ".//*[@id='aside']/div[2]")
    private WebElement latestArticlesBlock;

    @FindBy(xpath = ".//*[@id='aside']/div[2]/ul/li/a/span")
    private List<WebElement> latestArticlesList;

    @FindBy(css = ".btn.jmodedit")
    private WebElement editButton;
    @FindBy(xpath = ".//*[@id='collapseTypes']/div[1]/div[1]/strong/a")
    private WebElement options;

    @FindBy(xpath = ".//*[@id='collapse0']/div")
    private WebElement optionsBlock;

    @FindBy(xpath = ".//*[@id='jform_params_count']")
    private WebElement noOfArticles;

    @FindBy(css = ".btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = ".alert.alert-success")
    private WebElement messageBlock;

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
        // System.out.println(submitArticle.getText());
        Assert.assertThat(submitArticle.isDisplayed(), is(true));
        submitArticle.click();
        return PageFactory.initElements(driver, SubmitArticlePage.class);
    }

    public EditProfilePage editProfile() {
        Assert.assertThat(profile.isDisplayed(), is(true));
        profile.click();
        return PageFactory.initElements(driver, EditProfilePage.class);
    }

    public SiteAdministratorPage siteadmin() {
        Assert.assertThat(siteAdmin.isDisplayed(), is(true));
        siteAdmin.click();
        return PageFactory.initElements(driver, SiteAdministratorPage.class);
    }

    public TemplateSettingsPage template() {
        Assert.assertThat(templateSettings.isDisplayed(), is(true));
        templateSettings.click();
        return PageFactory.initElements(driver, TemplateSettingsPage.class);
    }

    public EditArticlePage clickOnArticle(String text) {
        Assert.assertThat(latestArticlesBlock.isDisplayed(), is(true));
        for (WebElement article : latestArticlesList) {
            if (article.getText().equals(text)) {
                article.click();
                break;
            }
        }
        return PageFactory.initElements(driver, EditArticlePage.class);
    }

    public JoomlaPage popTag() {
        Assert.assertThat(popularTags.isDisplayed(), is(true));
        joomlaTag.click();
        return PageFactory.initElements(driver, JoomlaPage.class);
    }

    public SubmitArticlePage verifyArticle(String text) {
        for (WebElement elem : latestArticlesList) {
            if (elem.getText().equals(text)) Assert.assertThat(elem.isDisplayed(), is(true));
        }
        return PageFactory.initElements(driver, SubmitArticlePage.class);
    }

    public void editArticlesBlock(String nr) {
        latestArticlesBlock.click();
        editButton.click();
        options.click();
        Assert.assertThat(optionsBlock.isDisplayed(), is(true));
        noOfArticles.clear();
        noOfArticles.sendKeys(nr);
        saveButton.click();
        Assert.assertThat(messageBlock.isDisplayed(), is(true));
    }

    public SiteSettingsPage goToSiteSettings() {
        siteSettings.click();
        return PageFactory.initElements(driver, SiteSettingsPage.class);
    }
}
