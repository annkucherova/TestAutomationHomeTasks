package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='catalog']")
    private WebElement catalog;

    @FindBy(xpath = "//a[@data-item='i1']")
    private WebElement appleButton;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class,'btn-default')]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAppleButtonInCatalog() {
        Actions action = new Actions(driver);
        action.moveToElement(catalog).moveToElement(appleButton).click().build().perform();
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

}
