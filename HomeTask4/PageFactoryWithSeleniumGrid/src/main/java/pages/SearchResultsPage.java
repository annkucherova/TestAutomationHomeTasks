package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//div[@id='content']//p")
    private WebElement resultMessage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfResultMessage() {
        return resultMessage.getText();
    }

}
