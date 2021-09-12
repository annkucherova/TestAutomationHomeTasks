package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsusPage extends BasePage{

    @FindBy(xpath = "//div[contains(@data-ecomm,'90NB0U11-M05340')]")
    private WebElement asusNotebookItemButton;

    public AsusPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAsusNotebookItemButton() {
        asusNotebookItemButton.click();
    }
}
