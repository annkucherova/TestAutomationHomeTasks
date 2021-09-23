package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenTrainersPage extends BasePage {

    @FindBy(xpath = "//article[@id='product-200348041']//button[@data-auto-id='saveForLater']")
    private WebElement trainersItemSaveButton;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement savedItemsButton;

    @FindBy(xpath = "//div[@class='_2pwX7b9'][text()='Brand']")
    private WebElement brandFilterSelectButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement brandFilterSearchField;

    @FindBy(xpath = "//div[@class='kx2nDmW'][text()='Nike']")
    private WebElement brandFilterNikeButton;

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']")
    private List<WebElement> filteredProductsList;

    @FindBy(xpath = "//div[@class='_2pwX7b9'][text()='Sale / New Season']")
    private WebElement saleFilterSelectButton;

    @FindBy(xpath = "//div[@class='kx2nDmW'][text()='Sale']")
    private WebElement saleFilterButton;

    @FindBy(xpath = "//div[@class='_1MVUcS8']")
    private List<WebElement> discountList;

    public WomenTrainersPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTrainersItemSaveButton() {
        trainersItemSaveButton.click();
    }

    public void clickOnSavedItemsButton() {
        savedItemsButton.click();
    }

    public void clickOnBrandFilterSelectButton() {
        brandFilterSelectButton.click();
    }

    public void clickOnSaleFilterSelectButton() {
        saleFilterSelectButton.click();
    }

    public boolean isBrandFilterSearchFieldVisible() {
        return brandFilterSearchField.isDisplayed();
    }

    public void enterTextToBrandFilterSearchField(final String keyword) {
        brandFilterSearchField.clear();
        brandFilterSearchField.sendKeys(keyword);
    }

    public void clickOnBrandFilterNikeButton() {
        brandFilterNikeButton.click();
    }

    public void clickOnSaleFilterButton() {
        saleFilterButton.click();
    }

    public List<WebElement> getFilteredProductsList() {
        return filteredProductsList;
    }

    public List<WebElement> getDiscountList() {
        return discountList;
    }

}
