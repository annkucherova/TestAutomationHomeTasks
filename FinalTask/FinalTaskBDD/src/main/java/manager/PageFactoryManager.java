package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public SavedItemsPage getSavedItemsPage() {
        return new SavedItemsPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public WomenTrainersPage getWomenTrainersPage() {
        return new WomenTrainersPage(driver);
    }

    public AuthorizationPage getAuthorizationPage() {
        return new AuthorizationPage(driver);
    }
}
