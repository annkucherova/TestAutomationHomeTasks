package pagefactory.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchTests extends BaseTest{

    private static final String SEARCH_KEYWORD = "spoon";
    private static final String EXPECTED_RESULT_MESSAGE = "Ничего не найдено";

    @Test(priority = 1)
    public void checkDidntFindSearchMessage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(30);
        assertEquals(getSearchResultsPage().getTextOfResultMessage(), EXPECTED_RESULT_MESSAGE);
    }
}
