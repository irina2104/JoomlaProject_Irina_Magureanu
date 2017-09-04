package com.endava.pages;

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

    @FindBy(css = "#jform_params_editor_chzn .chzn-single")
    private WebElement dropDownEdit;
    @FindBy(css = "#jform_params_editor_chzn .chzn-drop")
    private WebElement editorPopUp;
    @FindBy(css = "#jform_params_editor_chzn .chzn-drop li")
    private List<WebElement> editorList;

    @FindBy(css = "#jform_params_timezone_chzn .chzn-single")
    private WebElement timeZoneField;
    @FindBy(css = "#jform_params_timezone_chzn .chzn-drop")
    private WebElement timeZonePopUp;
    @FindBy(css = "#jform_params_timezone_chzn .chzn-search input")
    private WebElement timeZoneInput;

    @FindBy(css = "#jform_params_language_chzn .chzn-single")
    private WebElement dropDownFrontend;
    @FindBy(css = "#jform_params_language_chzn .chzn-drop")
    private WebElement frontendPopUp;
    @FindBy(css = "#jform_params_language_chzn .chzn-results li")
    private List<WebElement> frontendLanguageList;

    @FindBy(css = "#jform_params_admin_style_chzn .chzn-single")
    private WebElement dropDownBackendTem;
    @FindBy(css = "#jform_params_admin_style_chzn .chzn-drop")
    private WebElement backendTemPopUp;
    @FindBy(css = "#jform_params_admin_style_chzn .chzn-results li")
    private List<WebElement> backendTemplateList;

    @FindBy(css = "#jform_params_admin_language_chzn .chzn-single")
    private WebElement dropDownBackendLang;
    @FindBy(css = "#jform_params_admin_language_chzn .chzn-drop")
    private WebElement backendLangPopUp;
    @FindBy(css = "#jform_params_admin_language_chzn .chzn-drop li")
    private List<WebElement> backendLanguageList;

    @FindBy(css = "#jform_params_helpsite_chzn .chzn-single")
    private WebElement dropDownHelp;
    @FindBy(css = "#jform_params_helpsite_chzn .chzn-drop")
    private WebElement helpPopUp;
    @FindBy(css = "#jform_params_helpsite_chzn .chzn-drop li")
    private List<WebElement> helpSiteList;

    @FindBy(css = ".controls .btn.btn-primary.validate")
    private WebElement submitButton;

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
         wait.until(ExpectedConditions.visibilityOf(dropDownFrontend));

        dropDownFrontend.click();
        if (frontendPopUp.isDisplayed()) frontendLanguageList.get(index).click();
        // wait.until(ExpectedConditions.visibilityOf(dropDownBackendTem));

        dropDownBackendTem.click();

        if (backendTemPopUp.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(backendTemplateList.get(nr)));
             backendTemplateList.get(nr).click();
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
