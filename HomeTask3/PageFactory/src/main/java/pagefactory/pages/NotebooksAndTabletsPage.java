package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotebooksAndTabletsPage extends BasePage{

    @FindBy(xpath = "//div[@class='brand-box__title']//a[contains(@href,'noutbuki')]")
    private WebElement notebooksButton;

    public NotebooksAndTabletsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNotebooksButton() {
        notebooksButton.click();
    }
}
