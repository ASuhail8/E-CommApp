package myApp.E_CommApp.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myApp.E_CommApp.abstractcomponenets.AbstractComponent;

public class OrdersPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> allProducts;

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductPresent(String productName) {
        boolean match = allProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }

}
