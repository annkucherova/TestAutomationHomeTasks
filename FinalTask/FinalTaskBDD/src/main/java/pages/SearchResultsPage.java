package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//section[contains(@class,'background')]//h2[@class='grid-text__title ']")
    private WebElement searchResultMessage;

    @FindBy(xpath = "//div[@data-auto-id='productList']")
    private WebElement searchResultsListContainer;

    @FindBy(xpath = "//a[@class='_3TqU78D']")
    private List<WebElement> searchResultsList;

    @FindBy(xpath = "//a[contains(@aria-label,'cali sport in white')]")
    private WebElement productButton;

    @FindBy(xpath = "//a[contains(@href,'cali-sport-in-white')]//div//p")
    private WebElement productName;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsList;
    }

    public String getSearchResultMessage() {
        return searchResultMessage.getText();
    }

    public void clickOnProductButton() {
        productButton.click();
    }

    public WebElement getProductName() {
        return productName;
    }

}
