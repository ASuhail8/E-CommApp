package myApp.E_CommApp.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myApp.E_CommApp.abstractcomponenets.AbstractComponent;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = "[class*='cartWrap'] h3")
    List<WebElement> allProductsInCart;

    @FindBy(css = "[class='totalRow'] [class='btn btn-primary']")
    WebElement checkOutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyItemsInCart(String productName) {
        return allProductsInCart.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage clickOnCheckoutPage() {
        checkOutBtn.click();
        return new CheckoutPage(driver);
    }

}
