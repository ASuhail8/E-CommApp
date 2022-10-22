package myApp.E_CommApp.abstractcomponenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import myApp.E_CommApp.Pages.CartPage;
import myApp.E_CommApp.Pages.OrdersPage;

public class AbstractComponent {

    WebDriver driver;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cart;

    @FindBy(css = "[routerlink*='orders']")
    WebElement orders;

    @FindBy(xpath = "(//button[@class='btn btn-custom'])[4]")
    WebElement signOutBtn;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void waitForTheElementToAppear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForTheElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTheElementToDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public CartPage clickOnCart() {
        cart.click();
        return new CartPage(driver);
    }

    public OrdersPage clickOnOrders() {
        waitForTheElementToAppear(orders);
        orders.click();
        return new OrdersPage(driver);
    }

    public void signOut() {
        signOutBtn.click();
    }

}
