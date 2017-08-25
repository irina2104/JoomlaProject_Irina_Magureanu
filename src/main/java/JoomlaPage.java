import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoomlaPage {
    public WebDriver driver;

    public JoomlaPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#filter-search")
    private WebElement searchBox;

    @FindBy(xpath = ".//*[@id='adminForm']/fieldset/div[1]/button[1]")
    private WebElement searchButton;

    public void searchTag(String text) {
        searchBox.click();
        searchBox.sendKeys(text);
        searchButton.click();
    }
}
