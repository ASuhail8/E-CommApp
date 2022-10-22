package myApp.E_CommApp.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import myApp.E_CommApp.Pages.CartPage;
import myApp.E_CommApp.Pages.ProductsPage;
import myApp.E_CommApp.TestComponents.BaseTest;
import myApp.E_CommApp.TestComponents.Retry;

public class InvalidLogin extends BaseTest {

    @Test(groups = "errorhandling", retryAnalyzer = Retry.class)
    public void invalidLoginTest() {

        landingPage.loginToApplication("abdullasuhail@gmail.com", "Suhail"); // wrong password
        String errorMsg = landingPage.verifyErrorMsg();
        Assert.assertEquals(errorMsg, "Incorrect email password.");

    }

    @Test(retryAnalyzer = Retry.class)
    public void errorValidationOnProductsTest() {

        String productName = "ADIDAS ORIGINAL";

        ProductsPage productsPage = landingPage.loginToApplication("abdullasuhail21@gmail.com", "Suhail@1")
                .waitForProductsToLoad();

        productsPage = productsPage.addProductToCart(productName);
        CartPage cartPage = productsPage.clickOnCart();
        boolean flag = cartPage.verifyItemsInCart(productName + "as");
        Assert.assertFalse(flag);
    }

}
