package myApp.E_CommApp.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myApp.E_CommApp.abstractcomponenets.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(css = "[class*='ta-item']")
	List<WebElement> listOfCountries;

	@FindBy(css = "[class*='action__submit']")
	WebElement placeOrderBtn;

	By countryList = By.cssSelector("[class='ta-results list-group ng-star-inserted']");

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CheckoutPage enterCountryToSelect(String country) {
		this.country.sendKeys(country);
		waitForTheElementToAppear(countryList);
		return this;
	}

	public CheckoutPage selectCountry(String countryName) {
		enterCountryToSelect(countryName);
		listOfCountries.stream().filter(country -> country.getText().equalsIgnoreCase("india")).findFirst().orElse(null)
				.click();
		return this;
	}

	public ConfirmationPage placeOrder() {
		placeOrderBtn.click();
		return new ConfirmationPage(driver);
	}

}
