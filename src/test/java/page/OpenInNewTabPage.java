package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenInNewTabPage extends Base {

    public WebDriver driver;
    WebDriverWait w;

    @FindBy(xpath = "//*[text() = 'Open in new tab']")
    private WebElement closeTeb;

    @FindBy(xpath = "//*[@id='shopfront-app']/div[3]/div/div[2]//div/div/div[1]/div/button/div")
    private WebElement clickTeb;

    @FindBy(xpath = "//*[text() = 'Got it']")
    private WebElement clickGotIt;
    public OpenInNewTabPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void ValidateOpenInNewTabPopupAndClickGotIt() throws InterruptedException {
        WaitUntilOpenDisplayed();
        ClickTab();
        ClickGotIt();
    }
    public void WaitUntilOpenDisplayed() throws InterruptedException {
        Thread.sleep(1000);
    }
    public void ClickTab() {
        clickTeb.click();
    }

    public void ClickGotIt()
    {
        clickGotIt.click();
    }
}
