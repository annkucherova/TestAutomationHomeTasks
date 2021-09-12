package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotebooksPage extends BasePage{

    @FindBy(xpath = "//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'JYU4035CN')]")
    private WebElement buyButton;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'main-btn--orange')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//i[@class='icon icon-cart-new']")
    private WebElement cartIconButton;

    @FindBy(xpath = "//div[@class='item']//i[contains(@class,'js-btn-close')]")
    private WebElement deleteItemButton;

    @FindBy(xpath = "//div[@id='js_cart']//p[@class='text-center']//b")
    private WebElement cartTextMessage;

    public NotebooksPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBuyButton() {
        buyButton.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickOnCartIconButton() {
        cartIconButton.click();
    }

    public void clickOnDeleteItemButton() {
        deleteItemButton.click();
    }

    public String getCartTextMessage() {
        return cartTextMessage.getText();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }
}
