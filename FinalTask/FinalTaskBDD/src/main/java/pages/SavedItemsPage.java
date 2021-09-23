package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedItemsPage extends BasePage {

    @FindBy(xpath = "//header[@class='itemsHeader_saaZS']")
    private WebElement savedItemsAmountField;

    @FindBy(xpath = "//div[@class='itemCount_3vWat']")
    private WebElement savedItemsAmount;

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private WebElement deleteItemButton;

    @FindBy(xpath = "//h2[contains(@class,'noItemsPrompt')]")
    private WebElement noItemsMessage;

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSavedItemsAmountField() {
        return savedItemsAmountField;
    }

    public String getSavedItemsAmount() {
        return savedItemsAmount.getText();
    }

    public void clickOnDeleteItemButton() {
        deleteItemButton.click();
    }

    public String getNoItemsMessage() {
        return noItemsMessage.getText();
    }

}
