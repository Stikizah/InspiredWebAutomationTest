package page;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewProductPage extends Base {
    public WebDriver driver;
    WebDriverWait w;

    @FindBy(xpath = "//*[@class='button checkout-now dark']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id='shopfront-app']/div[3]//a[text()='Add to Cart']")
    private WebElement AddToTart;

    @FindBy(xpath = "//*[@class='cart-content-module_title_24yoi']")
    private WebElement ViewToTart;

    //*[@class="cart-content-module_title_24yoi"]
    @FindBy(xpath = "//*[@id='42987747']")
    private WebElement selectProduct;
    public ViewProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void userSelectTheProduct() throws InterruptedException {
        selectProduct.click();
    }

    public void UserAddToCartTheProduct() throws InterruptedException {
        addToCart();
        ClickcheckoutButton();
        ViewAddedProduct();
        viewCart();
    }
    public void addToCart() throws InterruptedException {
        Thread.sleep(1000);
        AddToTart.click();
    }

    public void ClickcheckoutButton() throws InterruptedException {
        Thread.sleep(1000);
        checkoutButton.click();
    }

    public void ViewAddedProduct() throws InterruptedException {
        viewCart();
    }
    public void viewCart() throws InterruptedException {
        Thread.sleep(1000);
        ViewToTart.isDisplayed();
    }

}
