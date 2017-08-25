import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SiteSettingsPage {
    public WebDriver driver;

    public SiteSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='jform_sitename']")
    private WebElement siteName;

    @FindBy(xpath = ".//*[@id='jform_offline']/label[2]")
    private WebElement siteOnline;

    @FindBy(xpath = ".//*[@id='jform_access_chzn']/a")
    private WebElement privacy;

    @FindBy(xpath = ".//*[@id='jform_access_chzn']/div/ul")
    private WebElement privacyBlock;

    @FindBy(xpath = ".//*[@id='jform_access_chzn']/div/ul/li")
    private List<WebElement> privacyType;

    @FindBy(xpath = ".//*[@id='application-form']/div/div[1]/div[1]/button")
    private WebElement saveButton;

    @FindBy(xpath = ".//*[@id='jform_list_limit_chzn']/a")
    private WebElement limit;

    @FindBy(xpath = ".//*[@id='jform_list_limit_chzn']/div/ul")
    private WebElement limitBlock;

    @FindBy(xpath = ".//*[@id='jform_list_limit_chzn']/div/ul/li")
    private List<WebElement> limitList;

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
}
