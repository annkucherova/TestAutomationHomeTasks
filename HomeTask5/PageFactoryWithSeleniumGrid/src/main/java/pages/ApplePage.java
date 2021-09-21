package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplePage extends BasePage{

    @FindBy(xpath = "//div[@class='sub-categories']//a[text()='iPhone  ']")
    private WebElement iphoneButton;

    @FindBy(xpath = "//h1[@class='cc']")
    private WebElement applePageElement;

    @FindBy(xpath = "//div[@class='sub-categories']//a[text()='MacBook   ']")
    private WebElement macBookButton;

    public ApplePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnIphoneButton() {
        iphoneButton.click();
    }

    public void clickOnMacBookButton() {
        macBookButton.click();
    }

    public WebElement getApplePageElement() {
        return applePageElement;
    }

}
