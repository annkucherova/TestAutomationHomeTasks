package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'noutbuki-i-aksessuaryi')]")
    private WebElement notebooksAndTabletsButton;

    @FindBy(xpath = "//button[contains(@class,'search-btn')]//i[@class='icon icon-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@href='/brand-asus']")
    private WebElement asusButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAsusButton() {
        asusButton.click();
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnProductCatalogButton() {
        productCatalogButton.click();
    }

    public void clickOnNotebooksAndTabletsButton() {
        notebooksAndTabletsButton.click();
    }

}
