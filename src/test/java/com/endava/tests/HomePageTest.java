package com.endava.tests;

import com.endava.pages.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.containsString;


import static org.hamcrest.core.Is.is;


public class HomePageTest {
    protected static HomePage homePage;
    private static WebDriver webDriver;
    AfterLoginPage afterLoginPage = homePage.login("amagureanu", "birku2104");


    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/amagureanu/Documents/My Received Files/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost/joomla/");
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        webDriver.manage().window().maximize();
    }

//    @After
//    public static void after(){
//        homePage.logout();
//    }


    @Test
    public void AfterLoginTest() {
        Assert.assertEquals("Alohaaa!", homePage.verifyTitle());
        afterLoginPage.verifyElem();
        Assert.assertThat(homePage.greeting(), is(true));
        homePage.logout();
    }

    @Test
    public void addArticle() {
        SubmitArticlePage submitArticlePage = afterLoginPage.addArticle();
        SubmitArticlePage submit = new SubmitArticlePage(webDriver);
        Assert.assertEquals("Article submitted.", submitArticlePage.submitAnArticle("yoyo", "new article"));
        submit.seePath();
        afterLoginPage.verifyArticle("yoyo");
        Assert.assertEquals("yoyo", afterLoginPage.verifLastArticle());
        homePage.logout();
    }

    @Test
    public void editBasicSettingsTest() {
        EditProfilePage editProfilePage = afterLoginPage.editProfile();
        Assert.assertEquals("Edit Your Profile", afterLoginPage.editYourProf());
        editProfilePage.basicSettings(0, "Bucharest", 2, 0, 6, 0);
        Assert.assertTrue(afterLoginPage.saved());
        homePage.logout();
    }

    @Test
    public void adminTest() {
        SiteAdministratorPage administratorPage = afterLoginPage.siteadmin();
        Assert.assertTrue(administratorPage.loginBox());
        administratorPage.login("amagureanu", "birku2104");
        Assert.assertEquals("Control Panel", administratorPage.controlPanel());
        Assert.assertThat(administratorPage.readMessages(), containsString("Messages"));
    }

//    @Test
//    public void seePath() {
//        //TemplateSettingsPage submit = afterLoginPage.template();
//        SubmitArticlePage submit = new SubmitArticlePage(webDriver);
//        submit.seePath();
//    }

    @Test
    public void editAnArticle() {
        EditArticlePage editArticlePage = afterLoginPage.clickOnArticle("hey");
        Assert.assertEquals("hey", editArticlePage.article());
        Assert.assertThat(editArticlePage.editArticle(1), containsString("saved"));
        Assert.assertThat(editArticlePage.editPublishing(1), containsString("saved"));
        editArticlePage.goToHomePage();
        SubmitArticlePage submit = new SubmitArticlePage(webDriver);
        submit.seePath();
    }

    @Test
    public void searchTag() {
        JoomlaPage joomlaPage = afterLoginPage.popTag();
        joomlaPage.searchTag("tag");
        Assert.assertTrue(joomlaPage.seeResults());
    }

    @Test
    public void addArticlePhoto() {
        SubmitArticlePage submitArticlePage = afterLoginPage.addArticle();
        SubmitArticlePage submit = new SubmitArticlePage(webDriver);
        Assert.assertEquals("Article submitted.", submitArticlePage.submitAnArticlePhoto("hey", "new article", "http://localhost/joomla/images/sampledata/parks/banner_cradle.jpg"));
        submit.seePath();
        afterLoginPage.verifyArticle("hey");
        Assert.assertEquals("hey", afterLoginPage.verifLastArticle());
        homePage.logout();

    }

    @Test
    public void editLatestArticles() {
        afterLoginPage.editArticlesBlock("10");
        Assert.assertTrue(afterLoginPage.saved());
        homePage.logout();
    }

    @Test
    public void changeSiteSettings() {
        SiteSettingsPage siteSettingsPage = afterLoginPage.goToSiteSettings();
        siteSettingsPage.changeSettings("Alohaaa!", "Public", "25");
        Assert.assertThat(siteSettingsPage.saveConfig(), containsString("saved"));
        siteSettingsPage.goToHomePage();
        homePage.logout();

    }
}
