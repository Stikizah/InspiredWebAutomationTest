package testCases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC05_AddProduct extends Base {
    WebDriver driver;
    WebDriverWait w;

    public TC05_AddProduct(){
        super();
    }
    @BeforeMethod
    public void navigateToUrl()
    {
        driver = initializeBrowserAndOpenURL(prop.getProperty("browser"));

    }
    @Test(priority = 1)
    public void validateThatYouAreOnTheUserLandingPage() throws InterruptedException {

        driver.findElement(By.xpath("//*[@alt='Takealot']")).isDisplayed();
    }

    @Test(priority = 2)
    public void searchProductAndClickSubmit() throws InterruptedException {

        driver.findElement(By.xpath("//*[@alt='Takealot']")).isDisplayed();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("wireless mouse");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    @Test(priority = 3)
    public void validateOpenInNewTabPopupAndClickGotIt() throws InterruptedException {
        w = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@alt='Takealot']")).isDisplayed();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("wireless mouse");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[text() = 'Open in new tab']")));

        driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[3]/div/div[2]//div/div/div[1]/div/button/div")).click();

        driver.findElement(By.xpath("//*[text() = 'Got it']")).click();
    }

    @Test(priority = 4)
    public void userSelectTheProduct() throws InterruptedException {

        w = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@alt='Takealot']")).isDisplayed();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("wireless mouse");

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[text() = 'Open in new tab']")));

        driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[3]/div/div[2]//div/div/div[1]/div/button/div")).click();

        driver.findElement(By.xpath("//*[text() = 'Got it']")).click();

        driver.findElement(By.xpath("//*[@id='42987747']")).click();

    }

    @Test(priority = 5)
    public void userAddToCartTheProduct() throws InterruptedException {

        w = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@alt='Takealot']")).isDisplayed();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("wireless mouse");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[text() = 'Open in new tab']")));

        driver.findElement(By.xpath("//*[@id=\"shopfront-app\"]/div[3]/div/div[2]//div/div/div[1]/div/button/div")).click();

        driver.findElement(By.xpath("//*[text() = 'Got it']")).click();

        driver.findElement(By.xpath("//*[@id='42987747']")).click();

        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id='shopfront-app']/div[3]//a[text()='Add to Cart']")));

        driver.findElement(By.xpath("//*[@id='shopfront-app']/div[3]//a[text()='Add to Cart']")).click();

    }

    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
