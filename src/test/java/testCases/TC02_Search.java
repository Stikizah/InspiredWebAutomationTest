package testCases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

public class TC02_Search extends Base {
    WebDriver driver;

    public TC02_Search(){
        super();
    }

    @BeforeMethod
    public void navigateToUrl()
    {
        driver = initializeBrowserAndOpenURL(prop.getProperty("browser"));

    }
    @Test(priority = 1)
    public void validateThatYouAreOnTheUserLandingPage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.VerifyUserList();
    }

    @Test(priority = 2)
    public void searchProductAndClickSubmit() throws InterruptedException {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.SearchProductAndClickSubmit();;

    }

    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
