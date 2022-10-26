package stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myApp.E_CommApp.Pages.CartPage;
import myApp.E_CommApp.Pages.CheckoutPage;
import myApp.E_CommApp.Pages.ConfirmationPage;
import myApp.E_CommApp.Pages.LandingPage;
import myApp.E_CommApp.Pages.ProductsPage;
import myApp.E_CommApp.TestComponents.BaseTest;

public class StepDefinition extends BaseTest {

    public LandingPage landingpage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckoutPage checkoutpage;
    public ConfirmationPage confirmationPage;

    @Given("I am on landing page")
    public void i_am_on_landing_page() throws IOException {

        landingpage = launchApplication();

    }

    @Given("^I login to the application using (.+) and (.+)$")
    public void i_login_to_the_application_using_and(String username, String password) {

        productsPage = landingPage.loginToApplication(username, password);
    }

    @When("^I add (.+) to cart and click on cart$")
    public void i_add_to_cart_and_click_on_cart(String productname) {

        productsPage = productsPage.addProductToCart(productname);
        cartPage = productsPage.clickOnCart();

    }

    @Then("^I click on checkoutpage and verify \"([^\"]*)\" is displayed$")
    public void i_click_on_checkoutpage_and_verify_something_is_displayed(String message) {

        checkoutpage = cartPage.clickOnCheckoutPage();
        confirmationPage = checkoutpage.selectCountry("india").placeOrder();
        String msg = confirmationPage.verifyConfirmationMsg();
        Assert.assertTrue(msg.equalsIgnoreCase(message));
        driver.close();

    }

    @And("^verify if (.+) is present in cart$")
    public void verify_if_is_present_in_cart(String productname) {

        boolean flag = cartPage.verifyItemsInCart(productname);
        Assert.assertTrue(flag);

    }

    @Then("^I verify \"([^\"]*)\" is displayed$")
    public void i_verify_something_is_displayed(String errorMessag) {
        String errorMsg = landingPage.verifyErrorMsg();
        Assert.assertEquals(errorMsg, errorMessag);
        driver.close();

    }

}
