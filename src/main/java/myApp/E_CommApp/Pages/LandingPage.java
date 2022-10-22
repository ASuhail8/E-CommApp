package myApp.E_CommApp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myApp.E_CommApp.abstractcomponenets.AbstractComponent;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(id = "userEmail")
    WebElement username;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
    WebElement errorMsg;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LandingPage goTo() {
        driver.get("https://rahulshettyacademy.com/client");
        return this;
    }

    public ProductsPage loginToApplication(String email, String pwd) {
        username.sendKeys(email);
        password.sendKeys(pwd);
        loginBtn.click();
        return new ProductsPage(driver);
    }

    public String verifyErrorMsg() {
        waitForTheElementToAppear(errorMsg);
        return errorMsg.getText();
    }

}
