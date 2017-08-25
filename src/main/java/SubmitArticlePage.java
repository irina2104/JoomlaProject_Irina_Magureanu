import com.gargoylesoftware.htmlunit.Page;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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

    @FindBy(xpath = ".//*[@id='adminForm']/div/div[1]/button")
    private WebElement saveButton;

    @FindBy(xpath = ".//*[@id='adminForm']/div/div[2]/button")
    private WebElement cancelButton;

    @FindBy(xpath = ".//*[@id='mceu_54']/button")
    private WebElement addImageButton;

    @FindBy(xpath = ".//*[@id='mceu_99']")
    private WebElement addImagePopUp;

    @FindBy(css = ".pathway span")
    private List<WebElement> pathList;
    @FindBy(css = "iframe#jform_articletext_ifr")
    private WebElement articleFrame;
    @FindBy(xpath = ".//*[@id='mceu_111']/div/div[2]/iframe")
    private WebElement imagePopUpFrame;
    @FindBy(css = ".btn.btn-success.button-save-selected")
    private WebElement insertButton;

    public void submitAnArticle(String title, String text) {

        Assert.assertThat(articleTitle.isDisplayed(), is(true));
        articleTitle.sendKeys(title);
        Assert.assertThat(articleAlias.isDisplayed(), is(true));
        //Assert.assertThat(articleText.isDisplayed(), is(true));
        articleBody.click();

        driver.switchTo().frame(articleFrame);
        driver.findElement(By.id("tinymce")).sendKeys(text);
        driver.switchTo().defaultContent();

        // articleText.sendKeys(text);
        Assert.assertThat(saveButton.isDisplayed(), is(true));
        Assert.assertThat(cancelButton.isDisplayed(), is(true));
        saveButton.click();

        // return PageFactory.initElements(driver, AfterLoginPage.class);
    }

    // List<String> listForPath = new ArrayList<String>();
    public void seePath() {
        String result = StringUtils.join(pathList, "/ ");
        System.out.println(result);
    }

    public void submitAnArticlePhoto(String title, String text, String url) {

        Assert.assertThat(articleTitle.isDisplayed(), is(true));
        articleTitle.sendKeys(title);
        Assert.assertThat(articleAlias.isDisplayed(), is(true));
        //Assert.assertThat(articleText.isDisplayed(), is(true));
        articleBody.click();

        driver.switchTo().frame(articleFrame);
        driver.findElement(By.id("tinymce")).sendKeys(text);
        driver.switchTo().defaultContent();

        addImageButton.click();
        WebDriverWait buzz = new WebDriverWait(driver, 3);
        buzz.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@id,'-body')]/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath(".//div[contains(@id,'-body')]/iframe")));
        driver.findElement(By.id("f_url")).sendKeys(url);
//        List<WebElement> folders = driver.findElements(By.cssSelector(".small"));
//        for (WebElement folder:folders) {
//            if(folder.getText().equals(nume)) folder.click();
//        }
        insertButton.click();
        driver.switchTo().defaultContent();


        Assert.assertThat(saveButton.isDisplayed(), is(true));
        Assert.assertThat(cancelButton.isDisplayed(), is(true));
        saveButton.click();

        // return PageFactory.initElements(driver, AfterLoginPage.class);
    }
}
