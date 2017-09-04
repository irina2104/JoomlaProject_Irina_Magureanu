package com.endava.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.core.Is.is;

public class SiteAdministratorPage {
    public WebDriver driver;

    public SiteAdministratorPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(id = "mod-login-username")
    private WebElement usernameField;

    @FindBy(id = "mod-login-password")
    private WebElement passwordField;

    @FindBy(css = ".btn.btn-primary.btn-block.btn-large.login-button span")
    private WebElement loginButton;

    @FindBy(css = ".span12 .row-fluid:nth-of-type(1) .alert.alert-info")
    private WebElement messagesNotif;

    @FindBy(css = ".span12 .row-fluid:nth-of-type(1) .alert.alert-info p a")
    private WebElement readButton;

    @FindBy(css = "#element-box")
    private WebElement joomlaBox;

    @FindBy(css = ".page-title")
    private WebElement title;

    public Boolean loginBox() {
        return joomlaBox.isDisplayed();
    }

    public String controlPanel() {
        return title.getText();
    }

    public void login(String user, String pass) {
        usernameField.click();
        usernameField.sendKeys(user);
        passwordField.click();
        passwordField.sendKeys(pass);
        loginButton.click();
    }

    public String readMessages() {
        if (messagesNotif.isDisplayed()) readButton.click();
        return title.getText();
    }


}
