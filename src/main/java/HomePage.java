import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.core.Is.is;

public class HomePage {

    public WebDriver driver;

    @FindBy(css = ".site-title")
    private WebElement siteTitle;

    @FindBy(css = "#modlgn-username")
    private WebElement username;

    @FindBy(css = "#modlgn-passwd")
    private WebElement password;

    @FindBy(css = ".btn.btn-primary.login-button")
    private WebElement loginButton;

    @FindBy(css = ".login-greeting")
    private WebElement loginGreeting;

    @FindBy(css = ".logout-button input")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyTitle(String user) {
        siteTitle.isDisplayed();
        Assert.assertThat(siteTitle.isDisplayed(), is(true));
        Assert.assertEquals(user, siteTitle.getText());
    }

    public AfterLoginPage login(String user, String pass, String greeting) {
        Assert.assertThat(username.isDisplayed(), is(true));
        username.click();
        username.sendKeys(user);
        Assert.assertThat(password.isDisplayed(), is(true));
        password.click();
        password.sendKeys(pass);
        Assert.assertThat(loginButton.isDisplayed(), is(true));
        loginButton.click();
        Assert.assertThat(loginGreeting.isDisplayed(), is(true));
        Assert.assertEquals(greeting, loginGreeting.getText());
        return PageFactory.initElements(driver, AfterLoginPage.class);
    }

    public AfterLoginPage logout() {
        Assert.assertThat(logoutButton.isDisplayed(), is(true));
        logoutButton.click();
        return PageFactory.initElements(driver, AfterLoginPage.class);
    }

}
