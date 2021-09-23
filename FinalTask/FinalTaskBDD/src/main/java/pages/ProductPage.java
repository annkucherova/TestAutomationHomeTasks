package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement warningMessage;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizeSelector;

    @FindBy(xpath = "//option[text()='EU 37']")
    private WebElement sizeButton;

    @FindBy(xpath = "//div[@id='minibag-dropdown']")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//div[@class='product-hero']//h1")
    private WebElement productName;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }

    public void clickOnSizeSelector() {
        sizeSelector.click();
    }

    public void clickOnSizeButton() {
        sizeButton.click();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }

    public String getAmountOfProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public WebElement getProductName() {
        return productName;
    }
}
