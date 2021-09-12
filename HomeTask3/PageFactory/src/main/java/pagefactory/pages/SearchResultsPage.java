package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//p[@class='col-xs-12']")
    private WebElement resultMessage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfResultMessage() {
        return resultMessage.getText();
    }
}
