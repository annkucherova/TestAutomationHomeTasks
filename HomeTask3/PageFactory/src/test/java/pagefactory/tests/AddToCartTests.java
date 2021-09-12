package pagefactory.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTest {

    private static final String EXPECTED_CART_MESSAGE = "Корзина пустая!";

    @Test(priority = 1)
    public void checkThatCartIsEmptyAfterDeletingItem() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnNotebooksAndTabletsButton();
        getNotebooksAndTabletsPage().clickOnNotebooksButton();
        getNotebooksPage().waitForPageLoadComplete(30);
        getNotebooksPage().clickOnBuyButton();
        getNotebooksPage().waitVisibilityOfElement(30, getNotebooksPage().getAddToCartPopup());
        getNotebooksPage().clickOnContinueShoppingButton();
        getNotebooksPage().clickOnCartIconButton();
        getNotebooksPage().clickOnDeleteItemButton();
        getNotebooksPage().waitInvisibilityOfElement(30, getNotebooksPage().getAddToCartPopup());
        getNotebooksPage().clickOnCartIconButton();
        getNotebooksPage().getCartTextMessage();
        assertEquals(getNotebooksPage().getCartTextMessage(), EXPECTED_CART_MESSAGE);
    }

}
