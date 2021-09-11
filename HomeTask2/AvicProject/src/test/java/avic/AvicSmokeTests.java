package avic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AvicSmokeTests {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("iPhone 11");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        assertTrue(driver.getCurrentUrl().contains("query=iPhone"));
    }

    @Test(priority = 2)
    public void checkElementAmountOnSearchPage() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("iPhone 11");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='prod-cart__descr']"));
        assertEquals(elementList.size(), 12);
    }

    //    ---HOME TASK TESTS---
    @Test(priority = 3)
    public void checkItemNameOnAsusItemPageAndOnPopUp() {
        driver.findElement(By.xpath("//a[@href='/brand-asus']")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//div[contains(@data-ecomm,'90NB0U11-M05340')]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String itemNameOnItemPage =
                driver.findElement(By.xpath("//h1[@class='page-title']")).getText();
        driver.findElement(By.xpath("//a[contains(@class,'btn--middle')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_oneclickModal")));
        String itemNameOnPopUp =
                driver.findElement(By.xpath("//div[@id='js_oneclickModal']//div[@class='name']")).getText();
        assertEquals(itemNameOnItemPage, itemNameOnPopUp);
    }

    @Test(priority = 4)
    public void checkDidntFindSearchMessage() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("spoon", Keys.ENTER);
        driver.findElement(By.xpath("//button[contains(@class,'search-btn')]//i[@class='icon icon-search']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String resultMessage = driver.findElement(By.xpath("//p[@class='col-xs-12']")).getText();
        assertEquals(resultMessage, "Ничего не найдено");
    }

    @Test(priority = 5)
    public void checkThatCartIsEmptyAfterDeletingItem() {
        driver.findElement(By.xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(By.xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'noutbuki-i-aksessuaryi')]")).click();
        driver.findElement(By.xpath("//div[@class='brand-box__title']//a[contains(@href,'noutbuki')]")).click();
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'JYU4035CN')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(By.xpath("//div[@class='btns-cart-holder']//a[contains(@class,'main-btn--orange')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'header-bottom__cart')]//i[@class='icon icon-cart-new']")).click();
        driver.findElement(By.xpath("//div[@class='item']//i[contains(@class,'js-btn-close')]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(By.xpath("//div[contains(@class,'header-bottom__cart')]//i[@class='icon icon-cart-new']")).click();
        String actualCartStatus = driver.findElement(By.xpath("//div[@id='js_cart']//p[@class='text-center']//b")).getText();
        assertEquals(actualCartStatus, "Корзина пустая!");
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
