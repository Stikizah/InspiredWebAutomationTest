package testCases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.OpenInNewTabPage;
import page.SearchPage;

public class TC03_OpenInNewTab extends Base {
    WebDriver driver;
    WebDriverWait w;

    public TC03_OpenInNewTab(){
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

    @Test(priority = 3)
    public void validateOpenInNewTabPopupAndClickGotIt() throws InterruptedException {
        OpenInNewTabPage openInNewTabPage= new OpenInNewTabPage(driver);

        searchProductAndClickSubmit();
        openInNewTabPage.ValidateOpenInNewTabPopupAndClickGotIt();
    }

    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
