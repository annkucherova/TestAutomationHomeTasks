package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@data-id='0edf7894-4f2f-42fb-896d-3e91a01704b1']//span[text()='Shoes']")
    private WebElement shoesButton;

    @FindBy(xpath = "//div[@class='_8EFahPg']//div[@class='_2yreb5T _36PJqEn']")
    private WebElement womenShoesList;

    @FindBy(xpath = "//div[@class='_2yreb5T _36PJqEn']//a[text()='Trainers']")
    private WebElement womenTrainersButton;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement myAccountIcon;

    @FindBy(xpath = "//div[@data-testid='myaccount-dropdown']")
    private WebElement myAccountDropdown;

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void moveToWomenShoesButton() {
        Actions action = new Actions(driver);
        action.moveToElement(shoesButton).build().perform();
    }

    public WebElement getWomenShoesList() {
        return womenShoesList;
    }

    public void clickOnWomenTrainersButton() {
        Actions action = new Actions(driver);
        action.moveToElement(shoesButton).moveToElement(womenTrainersButton).click().build().perform();
    }

    public void moveToMyAccountIcon() {
        Actions action = new Actions(driver);
        action.moveToElement(myAccountIcon).build().perform();
    }

    public WebElement getMyAccountDropdown() {
        return myAccountDropdown;
    }

    public void clickOnMyAccountButton() {
        Actions action = new Actions(driver);
        action.moveToElement(myAccountIcon).moveToElement(myAccountButton).click().build().perform();
    }


}
