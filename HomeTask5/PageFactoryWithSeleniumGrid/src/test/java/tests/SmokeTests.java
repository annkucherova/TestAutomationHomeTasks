package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {

    private static final String FILTER_KEYWORD = "iPhone SE 2020";
    private static final String SEARCH_KEYWORD = "spoon";
    private static final String EXPECTED_RESULT_MESSAGE = "Нет товаров, которые соответствуют критериям поиска.";

    @Test
    public void checkFilter() {
        getHomePage().clickOnAppleButtonInCatalog();
        getApplePage().implicitWait(30);
        getApplePage().clickOnIphoneButton();
        getIphonePage().waitPageLoadToComplete(30);
        getIphonePage().clickOnIphoneSE2020Filter();
        getIphonePage().waitVisibilityOfElement(30, getIphonePage().getFilterPopup());
        getIphonePage().clickOnShowFilterButton();
        for (WebElement webElement : getIphonePage().getFilterResultsList()) {
            assertTrue(webElement.getText().contains(FILTER_KEYWORD));
        }
    }

    @Test
    public void checkDidnotFindSearchMessage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(30);
        assertEquals(getSearchResultsPage().getTextOfResultMessage(), EXPECTED_RESULT_MESSAGE);
    }

    @Test
    public void checkProductNames() {
        getHomePage().clickOnAppleButtonInCatalog();
        getApplePage().implicitWait(30);
        getApplePage().clickOnMacBookButton();
        getMacBookPage().waitPageLoadToComplete(30);
        getMacBookPage().clickOnBuyItemButton();
        getMacBookPage().waitVisibilityOfElement(30, getMacBookPage().getAddToCartPopup());
        assertEquals(getMacBookPage().getTextOfProductNameOnMacBookPage(),
                getMacBookPage().getTextOfProductNameOnPopup());

    }

}
