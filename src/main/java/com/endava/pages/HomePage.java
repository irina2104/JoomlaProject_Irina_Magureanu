package com.endava.pages;

import com.endava.pages.AfterLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.core.Is.is;

public class HomePage {

    public WebDriver driver;

    @FindBy(className = "site-title")
    private WebElement siteTitle;

    @FindBy(id = "modlgn-username")
    private WebElement username;

    @FindBy(id = "modlgn-passwd")
    private WebElement password;

    @FindBy(css = ".btn.btn-primary.login-button")
    private WebElement loginButton;

    @FindBy(className = "login-greeting")
    private WebElement loginGreeting;

    @FindBy(css = ".logout-button input")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AfterLoginPage login(String user, String pass) {
        username.click();
        username.sendKeys(user);
        password.click();
        password.sendKeys(pass);
        loginButton.click();
        return PageFactory.initElements(driver, AfterLoginPage.class);
    }

    public Boolean greeting(){
        return loginGreeting.isDisplayed();
    }

    public String verifyTitle(){
        return siteTitle.getText();
    }

    public AfterLoginPage logout() {
        logoutButton.click();
        return PageFactory.initElements(driver, AfterLoginPage.class);
    }

}
