import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EditProfilePage {
    public WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='jform_params_editor_chzn']/a")
    private WebElement dropDownEdit;
    @FindBy(xpath = ".//*[@id='jform_params_editor_chzn']/div/ul")
    private WebElement editorPopUp;
    @FindBy(xpath = ".//*[@id='jform_params_editor_chzn']/div/ul/li")
    private List<WebElement> editorList;

    @FindBy(xpath = ".//*[@id='jform_params_timezone_chzn']/a")
    private WebElement timeZoneField;
    @FindBy(xpath = ".//*[@id='jform_params_timezone_chzn']/div")
    private WebElement timeZonePopUp;
    @FindBy(xpath = ".//*[@id='jform_params_timezone_chzn']/div/div/input")
    private WebElement timeZoneInput;

    @FindBy(xpath = ".//*[@id='jform_params_language_chzn']/a")
    private WebElement dropDownFrontend;
    @FindBy(xpath = ".//*[@id='jform_params_language_chzn']/div/ul")
    private WebElement frontendPopUp;
    @FindBy(xpath = ".//*[@id='jform_params_language_chzn']/div/ul/li")
    private List<WebElement> frontendLanguageList;

    @FindBy(xpath = ".//*[@id='jform_params_admin_style_chzn']/a")
    private WebElement dropDownBackendTem;
    @FindBy(xpath = ".//*[@id='jform_params_admin_style_chzn']/div/ul")
    private WebElement backendTemPopUp;
    @FindBy(xpath = ".//*[@id='jform_params_admin_style_chzn']/div/ul/li[contains(@class,'active-result')]")
    private List<WebElement> backendTemplateList;

    @FindBy(xpath = ".//*[@id='jform_params_admin_style_chzn']/a")
    private WebElement dropDownBackendLang;
    @FindBy(xpath = ".//*[@id='jform_params_admin_language_chzn']/div/ul")
    private WebElement backendLangPopUp;
    @FindBy(xpath = ".//*[@id='jform_params_admin_language_chzn']/div/ul/li")
    private List<WebElement> backendLanguageList;

    @FindBy(xpath = ".//*[@id='jform_params_helpsite_chzn']/a")
    private WebElement dropDownHelp;
    @FindBy(xpath = ".//*[@id='jform_params_helpsite_chzn']/div/ul")
    private WebElement helpPopUp;
    @FindBy(xpath = ".//*[@id='jform_params_helpsite_chzn']/div/ul/li")
    private List<WebElement> helpSiteList;

    @FindBy(xpath = ".//*[@id='helpsite-refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = ".//*[@id='member-profile']/div/div/button")
    private WebElement submitButton;

    @FindBy(xpath = ".//*[@id='member-profile']/div/div/a")
    private WebElement cancelButton;

    public void basicSettings(int i, String zone, int index, int nr, int no, int cnt) {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        //wait.until(ExpectedConditions.visibilityOf(dropDownEdit));
        dropDownEdit.click();
        //wait.until(ExpectedConditions.visibilityOf(editorList));
        if (editorPopUp.isDisplayed()) editorList.get(i).click();
        //wait.until(ExpectedConditions.visibilityOf(timeZoneField));

        timeZoneField.click();
        if (timeZonePopUp.isDisplayed()) {
            timeZoneInput.sendKeys(zone);
            timeZoneInput.sendKeys(Keys.ENTER);
        }
        //  wait.until(ExpectedConditions.visibilityOf(dropDownFrontend));

        dropDownFrontend.click();
        if (frontendPopUp.isDisplayed()) frontendLanguageList.get(index).click();
        // wait.until(ExpectedConditions.visibilityOf(dropDownBackendTem));

        dropDownBackendTem.click();

        if (backendTemPopUp.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(backendTemplateList.get(nr)));
            // backendTemplateList.get(nr).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(dropDownBackendLang));

        dropDownBackendLang.click();
        //wait.until(ExpectedConditions.visibilityOf(backendLangPopUp));

        if (backendLangPopUp.isDisplayed()) backendLanguageList.get(no).click();
        // wait.until(ExpectedConditions.visibilityOf(dropDownHelp));

        dropDownHelp.click();
        if (helpPopUp.isDisplayed()) helpSiteList.get(cnt).click();

        submitButton.click();
    }


}
