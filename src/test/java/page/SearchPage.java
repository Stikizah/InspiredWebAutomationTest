package page;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Base {

    public WebDriver driver;

    @FindBy(xpath = "//*[@name='search']")
    private WebElement txtSearch;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement btnSearch;
    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void SearchProductAndClickSubmit()
    {
        EnterProduct();
        clickSearchButton();

    }
    public void EnterProduct()
    {
        txtSearch.sendKeys(prop.getProperty("productItem"));
    }

    public void clickSearchButton()
    {
        btnSearch.click();
    }
}
