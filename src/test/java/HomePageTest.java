import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageTest {
    protected static HomePage homePage;
    private static WebDriver webDriver;
    AfterLoginPage afterLoginPage = homePage.login("amagureanu", "birku2104", "Hi Irina Magureanu,");
    //  SubmitArticlePage submitArticlePage = afterLoginPage.addArticle();
    //  EditProfilePage editProfilePage = afterLoginPage.editProfile();
    //  SiteAdministratorPage administratorPage = afterLoginPage.siteadmin();

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/amagureanu/Documents/My Received Files/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost/joomla/");
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        webDriver.manage().window().maximize();

        //afterLoginPage = PageFactory.initElements(webDriver,AfterLoginPage.class);
        // submitArticlePage = PageFactory.initElements(webDriver,SubmitArticlePage.class);

        // homePage.verifyTitle("Irinaa's Site!");
        // homePage.login("amagureanu","birku2104", "Hi Irina Magureanu,");
    }

//    @After
//    public static void after(){
//        homePage.logout();
//    }


    @Test
    public void AfterLoginTest() {
        afterLoginPage.verifyElem();
        homePage.logout();
    }

    @Test
    public void addArticle() {
        SubmitArticlePage submitArticlePage = afterLoginPage.addArticle();
        SubmitArticlePage submit = new SubmitArticlePage(webDriver);
        submitArticlePage.submitAnArticle("hey", "new article");
        submit.seePath();
        afterLoginPage.verifyArticle("hey");
        homePage.logout();
    }

    @Test
    public void editBasicSettingsTest() {
        EditProfilePage editProfilePage = afterLoginPage.editProfile();
        editProfilePage.basicSettings(0, "Bucharest", 2, 0, 6, 0);
        homePage.logout();
    }

    @Test
    public void adminTest() {
        SiteAdministratorPage administratorPage = afterLoginPage.siteadmin();
        administratorPage.login("amagureanu", "birku2104");
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
        editArticlePage.editArticle(1, "Comic Sans MS", 0);
        SubmitArticlePage submit = new SubmitArticlePage(webDriver);
        submit.seePath();
    }

    @Test
    public void searchTag() {
        JoomlaPage joomlaPage = afterLoginPage.popTag();
        joomlaPage.searchTag("tag");
    }

    @Test
    public void addArticlePhoto() {
        SubmitArticlePage submitArticlePage = afterLoginPage.addArticle();
        SubmitArticlePage submit = new SubmitArticlePage(webDriver);
        submitArticlePage.submitAnArticlePhoto("hey", "new article", "http://localhost/joomla/images/sampledata/parks/banner_cradle.jpg");
        submit.seePath();
        afterLoginPage.verifyArticle("hey");
    }

    @Test
    public void editLatestArticles() {
        afterLoginPage.editArticlesBlock("10");
    }

    @Test
    public void changeSiteSettings() {
        SiteSettingsPage siteSettingsPage = afterLoginPage.goToSiteSettings();
        siteSettingsPage.changeSettings("Alohaaa!", "Public", "25");
    }
}
