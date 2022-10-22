package myApp.E_CommApp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myApp.E_CommApp.abstractcomponenets.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;

	@FindBy(css = ".hero-primary")
	WebElement confirmationmsg;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyConfirmationMsg() {
		return confirmationmsg.getText();
	}

	

}
