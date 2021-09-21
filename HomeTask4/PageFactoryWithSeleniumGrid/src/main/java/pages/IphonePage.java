package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IphonePage extends BasePage{

    @FindBy(id = "v-111484294244072")
    private WebElement iphoneSE2020FilterID;

    @FindBy(xpath = "//div[@class='buttons']//button[contains(@onclick,'se-2020')]")
    private WebElement showFilterButton;

    @FindBy(id = "ocf-result")
    private WebElement filterPopup;

    @FindBy(xpath = "//div[@id='content']//div[@class='name']")
    private List<WebElement> filterResultsList;

    public IphonePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnIphoneSE2020Filter() {
        iphoneSE2020FilterID.click();
    }

    public void clickOnShowFilterButton() {
        showFilterButton.click();
    }

    public WebElement getFilterPopup() {
        return filterPopup;
    }

    public List<WebElement> getFilterResultsList() {
        return filterResultsList;
    }


}
