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

    @FindBy(xpath = ".//*[@id='content']/ul")
    private WebElement block;

    @FindBy(css = ".btn.jmodedit")
    private WebElement editButton;

    @FindBy(css = ".btn.dropdown-toggle")
    private WebElement editText;

    @FindBy(css = ".edit-icon>a")
    private WebElement edit;

    @FindBy(css = "iframe#jform_articletext_ifr")
    private WebElement textSelect;

    @FindBy(xpath = ".//*[@id='mceu_66-body']/div[1]/div/div")
    private List<WebElement> textFormat;

    @FindBy(xpath = ".//*[@id='mceu_66-body']/div[2]/div/div")
    private List<WebElement> alignText;

    @FindBy(xpath = ".//*[@id='mceu_10-open']")
    private WebElement font;

    @FindBy(xpath = ".//*[@id='mceu_122']/div")
    private WebElement fontPopUp;

    @FindBy(css = ".item-page>div>p")
    private WebElement articleContent;

    @FindBy(xpath = ".//*[@id='adminForm']/div/div[1]/button")
    private WebElement saveButton;

    @FindBy(xpath = ".//*[@id='system-message']/div")
    private WebElement successBlock;

    @FindBy(xpath = ".//*[@id='com-content-formTabs']/li[2]/a")
    private WebElement publishingButton;
    @FindBy(xpath = ".//*[@id='jform_state_chzn']/a")
    private WebElement status;
    @FindBy(xpath = ".//*[@id='jform_state_chzn']/div")
    private WebElement statusBlock;
    @FindBy(xpath = ".//*[@id='jform_state_chzn']/div/ul/li")
    private List<WebElement> statusList;

    @FindBy(xpath = ".//*[@id='jform_published']/label[2]")
    private WebElement unpublished;

    @FindBy(xpath = ".//*[@id='adminForm']/div/div[1]/button")
    private WebElement saveModuleButton;

    @FindBy(xpath = ".//*[@id='top']/div/nav/div[2]/ul/li/a")
    private WebElement homeButton;

    public void editArticle(int i, String option, int index) {
        if (articleContent.isDisplayed()) {
            editText.click();
            edit.click();
            driver.switchTo().frame(textSelect);
            driver.findElement(By.id("tinymce")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            driver.switchTo().defaultContent();
            textFormat.get(i).click();
            alignText.get(i).click();
//        font.click();
//
//        driver.findElement(By.xpath(".//*[@id='mceu_10-open']")).click();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        List<WebElement> options = driver.findElements(By.xpath(".//*[@id='mceu_122']/div/div/span"));
//        for (WebElement elem : options) {
//            if (elem.getText().equals(option)) {
//                elem.click();
//            }
//        }
            saveButton.click();
            Assert.assertThat(successBlock.isDisplayed(), is(true));
            //block.click();
            editText.click();
            edit.click();
            publishingButton.click();
//            Assert.assertThat(editButton.isDisplayed(),is(true));
//            editButton.click();
//            unpublished.click();
            status.click();
            if (statusBlock.isDisplayed()) statusList.get(index).click();
            saveModuleButton.click();
            Assert.assertThat(successBlock.isDisplayed(), is(true));
            if (homeButton.isDisplayed()) homeButton.click();

        }
        // throw new NoSuchElementException("Can't find " + option + " in dropdown");
        // Assert.assertThat(fontPopUp.isDisplayed(),is(true));


    }
}
