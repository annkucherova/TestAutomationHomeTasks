package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsusNotebookPage extends BasePage{

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement notebookNameOnItsPage;

    @FindBy(xpath = "//a[contains(@class,'btn--middle')]")
    private WebElement buyInOneClickButton;

    @FindBy(id = "js_oneclickModal")
    private WebElement buyInOneClickPopup;

    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement notebookNameOnPopup;

    public AsusNotebookPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfNotebookNameOnItsPage() {
        return notebookNameOnItsPage.getText();
    }

    public void clickOnBuyInOneClickButton() {
        buyInOneClickButton.click();
    }

    public String getTextOfNotebookNameOnPopup() {
        return notebookNameOnPopup.getText();
    }

    public WebElement getBuyInOneClickPopup() {
        return buyInOneClickPopup;
    }
}
