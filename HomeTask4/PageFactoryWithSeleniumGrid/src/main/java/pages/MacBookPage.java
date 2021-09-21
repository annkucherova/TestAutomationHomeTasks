package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends BasePage{

    @FindBy(xpath = "//div[@class='name']//a[contains(@href,'muhp2')]")
    private WebElement productNameOnMacBookPage;

    @FindBy(xpath = "//a[@data-product_id='25925']")
    private WebElement buyItemButton;

    @FindBy(xpath = "//div[@class='addcart-popup']")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//div[@class='name']//a[contains(@href,'muhp2')]")
    private WebElement productNameOnPopup;

    public MacBookPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfProductNameOnMacBookPage() {
        return productNameOnMacBookPage.getText();
    }

    public void clickOnBuyItemButton() {
        buyItemButton.click();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }

    public String getTextOfProductNameOnPopup() {
        return productNameOnPopup.getText();
    }

}
