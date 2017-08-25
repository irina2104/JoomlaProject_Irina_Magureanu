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

    @FindBy(xpath = ".//*[@id='element-box']")
    private WebElement loginPopUp;

    @FindBy(xpath = ".//*[@id='mod-login-username']")
    private WebElement usernameField;

    @FindBy(xpath = ".//*[@id='mod-login-password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='form-login']/fieldset/div[4]/div/div/button")
    private WebElement loginButton;

    @FindBy(xpath = ".//*[@id='content']/div/div/div[2]/div[2]/div[1]/div")
    private WebElement messagesNotif;

    @FindBy(xpath = ".//*[@id='content']/div/div/div[2]/div[2]/div[1]/div/p[3]/a")
    private WebElement readButton;

    @FindBy(xpath = ".//*[@id='system-message-container']/div")
    private WebElement notification;

    @FindBy(xpath = "http://localhost/joomla/administrator/index.php")
    private WebElement onceButton;


    public void login(String user, String pass) {
        Assert.assertThat(usernameField.isDisplayed(), is(true));
        usernameField.click();
        usernameField.sendKeys(user);
        Assert.assertThat(passwordField.isDisplayed(), is(true));
        passwordField.click();
        passwordField.sendKeys(pass);
        Assert.assertThat(loginButton.isDisplayed(), is(true));
        loginButton.click();
        if (messagesNotif.isDisplayed()) readButton.click();
       // if (notification.isDisplayed()) onceButton.click();

    }
}
