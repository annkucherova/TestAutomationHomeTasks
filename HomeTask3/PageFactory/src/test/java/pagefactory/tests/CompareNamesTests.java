package pagefactory.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareNamesTests extends BaseTest {

    @Test(priority = 1)
    public void checkItemNameOnAsusItemPageAndOnPopUp() {
        getHomePage().clickOnAsusButton();
        getAsusPage().waitForPageLoadComplete(30);
        getAsusPage().clickOnAsusNotebookItemButton();
        getAsusNotebookPage().waitForPageLoadComplete(30);
        getAsusNotebookPage().getTextOfNotebookNameOnItsPage();
        getAsusNotebookPage().clickOnBuyInOneClickButton();
        getAsusNotebookPage().waitVisibilityOfElement(30, getAsusNotebookPage().getBuyInOneClickPopup());
        getAsusNotebookPage().getTextOfNotebookNameOnPopup();
        assertEquals(getAsusNotebookPage().getTextOfNotebookNameOnItsPage(),
                getAsusNotebookPage().getTextOfNotebookNameOnPopup());

    }
}
