package myApp.E_CommApp.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myApp.E_CommApp.abstractcomponenets.AbstractComponent;

public class ProductsPage extends AbstractComponent {

	WebDriver driver;

	By products = By.xpath("//div[contains(@class,'col-lg-4')]");

	@FindBy(xpath = "//div[contains(@class,'col-lg-4')]")
	List<WebElement> allProducts;

	By addToCart = By.cssSelector("button[class*='btn w-10 rounded']");
	By toastMsg = By.cssSelector("#toast-container");
	By animating = By.cssSelector(".ng-animating");

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public ProductsPage waitForProductsToLoad() {
		waitForTheElementToAppear(products);
		return this;
	}

	public WebElement getProduct(String productName) {

		WebElement prod = allProducts.stream()
				.filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prod;

	}

	public ProductsPage addProductToCart(String productName) {
		getProduct(productName).findElement(addToCart).click();
		waitForTheElementToAppear(toastMsg);
		waitForTheElementToDisappear(animating);
		return this;
	}

}
