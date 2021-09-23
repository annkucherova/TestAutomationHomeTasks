package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;

    HomePage homePage;
    SearchResultsPage searchResultsPage;
    SavedItemsPage savedItemsPage;
    ProductPage productPage;
    WomenTrainersPage womenTrainersPage;
    AuthorizationPage authorizationPage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void searchByKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickOnSearchButton();
    }

    @Then("User check that search results contain expected keyword {string}")
    public void checkThatSearchResultsContainExpectedKeyword(final String expectedKeyword) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement webElement : searchResultsPage.getSearchResultsList()) {
            assertTrue(webElement.getText().contains(expectedKeyword));
        }
    }

    @Then("User checks that search page contains message {string}")
    public void checkThatSearchPageContainsDidNotFindMessage(final String expectedMessage) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.getSearchResultMessage().contains(expectedMessage));
    }

    @And("User clicks on 'Trainers' button")
    public void clickOnTrainersButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.moveToWomenShoesButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getWomenShoesList());
        homePage.clickOnWomenTrainersButton();
    }

    @When("User adds item to wish list by click on heart icon")
    public void addItemToWishList() {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        womenTrainersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        womenTrainersPage.clickOnTrainersItemSaveButton();
    }

    @And("User clicks on 'Saved Items' icon")
    public void clickOnSavedItemsIcon() {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        womenTrainersPage.clickOnSavedItemsButton();
    }

    @Then("User checks that wish list has correct amount of items {string}")
    public void checkWishListAmountOfItems(final String expectedAmount) {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedItemsPage.getSavedItemsAmountField());
        assertEquals(savedItemsPage.getSavedItemsAmount(), expectedAmount);
    }

    @And("User deletes item from wish list")
    public void checkDeletingItemFromWishList() {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedItemsPage.getSavedItemsAmountField());
        savedItemsPage.clickOnDeleteItemButton();
    }

    @Then("User checks that wish list has message {string}")
    public void checkWishListMessage(final String expectedMessage) {
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
        savedItemsPage.implicitWait(DEFAULT_TIMEOUT);
        assertEquals(savedItemsPage.getNoItemsMessage(), expectedMessage);
    }

    @And("User clicks on product")
    public void clickOnProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickOnProductButton();
    }

    @When("User clicks on Add to bag button")
    public void clickOnAddToBagButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickOnAddToCartButton();
    }

    @Then("User checks warning message {string}")
    public void checkWarningMessage(final String expectedMessage) {
        productPage = pageFactoryManager.getProductPage();
        assertEquals(productPage.getWarningMessage(), expectedMessage);
    }

    @When("User selects size of product")
    public void selectSizeOfProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickOnSizeSelector();
        productPage.clickOnSizeButton();
    }

    @Then("User check that Cart Icon has correct amount of Products {string}")
    public void checkProductAmountInCart(final String amountOfProductsInCart) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartPopup());
        assertEquals(productPage.getAmountOfProductsInCart(), amountOfProductsInCart);
    }

    @When("User clicks on 'Brand' filter button")
    public void clickOnBrandFilterButton() {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        womenTrainersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        womenTrainersPage.clickOnBrandFilterSelectButton();
    }

    @And("User checks search brand field visibility")
    public void checkSearchBrandFieldVisibility() {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        assertTrue(womenTrainersPage.isBrandFilterSearchFieldVisible());
    }

    @And("User enters brand keyword {string}")
    public void enterBrandKeyword(final String keyword) {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        womenTrainersPage.enterTextToBrandFilterSearchField(keyword);
    }

    @And("User clicks on brand button")
    public void clickOnBrandButton() {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        womenTrainersPage.clickOnBrandFilterNikeButton();
        womenTrainersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that every product contains word {string}")
    public void checkThatEveryProductContainsExpectedWord(final String expectedWord) {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        for (WebElement webElement : womenTrainersPage.getFilteredProductsList()) {
            assertTrue(webElement.getText().contains(expectedWord));
        }
    }

    @And("User moves cursor on My account Icon")
    public void moveCursorOnMyAccountIcon() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.moveToMyAccountIcon();
    }

    @And("User clicks on My account button")
    public void clicksOnMyAccountButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountDropdown());
        homePage.clickOnMyAccountButton();
    }

    @And("User checks that username field is visible")
    public void checkUsernameFieldVisibility() {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(authorizationPage.isUsernameFieldVisible());
    }

    @And("User checks that password field is visible")
    public void checkPasswordFieldVisibility() {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        assertTrue(authorizationPage.isPasswordFieldVisible());
    }

    @When("User clicks on Username field")
    public void clickOnUsernameField() {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.clickOnUsernameField();
    }

    @And("User enters email address {string}")
    public void enterEmailAddress(final String email) {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.enterTextToUsernameField(email);
    }

    @And("User clicks on Password field")
    public void clickOnPasswordField() {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.clickOnPasswordField();
    }

    @Then("User checks that appears message")
    public void checkEmailErrorMessageAppearing() {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        assertTrue(authorizationPage.isEmailErrorPopupAppears());
    }

    @And("User checks email warning message {string}")
    public void checkEmailErrorWarningMessage(final String warning) {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        assertEquals(authorizationPage.getEmailErrorPopup().getText(), warning);
    }

    @And("User enters password {string}")
    public void userEntersPasswordPassword(final String password) {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.enterTextToPasswordField(password);
    }

    @And("User clicks on Sign In Button")
    public void clickOnSignInButton() {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.clickOnSignInButton();
    }

    @Then("User checks that appears warning message")
    public void checkWarningMessageVisibility() {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(authorizationPage.isErrorMessageContainerAppears());
    }

    @And("User check that message contains warning {string}")
    public void checkMessageContainsWarning(final String warning) {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        assertTrue(authorizationPage.getErrorMessage().getText().contains(warning));
    }


    @Then("User checks that product name on its page the same as on Search results page")
    public void compareProductNamesOnDifferentPages() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        productPage = pageFactoryManager.getProductPage();
        assertEquals(getsProductName(), productPage.getProductName());
    }

    @When("User gets product name")
    public WebElement getsProductName() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        return searchResultsPage.getProductName();
    }

    @When("User clicks on Sale filter button")
    public void clickOnSaleFilterButton() {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        womenTrainersPage.clickOnSaleFilterSelectButton();
    }

    @And("User clicks on Sale button")
    public void clickOnSaleButton() {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        womenTrainersPage.clickOnSaleFilterButton();
        womenTrainersPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that every product contains discount {string}")
    public void checkProductsContainDiscount(final String discount) {
        womenTrainersPage = pageFactoryManager.getWomenTrainersPage();
        for (WebElement webElement : womenTrainersPage.getDiscountList()) {
            assertTrue(webElement.getText().contains(discount));
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
