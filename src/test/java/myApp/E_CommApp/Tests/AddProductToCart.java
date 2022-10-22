package myApp.E_CommApp.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import myApp.E_CommApp.Pages.CartPage;
import myApp.E_CommApp.Pages.CheckoutPage;
import myApp.E_CommApp.Pages.ConfirmationPage;
import myApp.E_CommApp.Pages.OrdersPage;
import myApp.E_CommApp.Pages.ProductsPage;
import myApp.E_CommApp.TestComponents.BaseTest;
import myApp.E_CommApp.TestComponents.Retry;

public class AddProductToCart extends BaseTest {

    // String productName = "ADIDAS ORIGINAL";

    @Test(dataProvider = "getData", groups = "purchase", retryAnalyzer = Retry.class)
    public void addProductToCartTest(HashMap<String, String> map) {

        ProductsPage productsPage = landingPage.loginToApplication(map.get("email"), map.get("password"))
                .waitForProductsToLoad();

        productsPage = productsPage.addProductToCart(map.get("product"));
        CartPage cartPage = productsPage.clickOnCart();
        boolean flag = cartPage.verifyItemsInCart(map.get("product"));
        AssertJUnit.assertTrue(flag);

        CheckoutPage checkoutpage = cartPage.clickOnCheckoutPage();
        ConfirmationPage confirmationPage = checkoutpage.selectCountry("india").placeOrder();
        String msg = confirmationPage.verifyConfirmationMsg();
        AssertJUnit.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));

        confirmationPage.signOut();

    }

    @Test(dependsOnMethods = "addProductToCartTest", dataProvider = "getData", groups = "purchase", retryAnalyzer = Retry.class)
    public void orderHistoryTest(HashMap<String, String> map) {

        ProductsPage productsPage = landingPage.loginToApplication(map.get("email"), map.get("password"))
                .waitForProductsToLoad();

        OrdersPage ordersPage = productsPage.clickOnOrders();
        boolean flag = ordersPage.verifyProductPresent(map.get("product"));
        AssertJUnit.assertTrue(flag);

    }

    /*
     * Using Object[][]
     * 
     * @DataProvider
     * public Object[][] getData() {
     * 
     * return new Object[][] { { "abdullasuhail21@gmail.com", "Suhail@1",
     * "ZARA COAT 3" },
     * { "abdullasuhail21@gmail.com", "Suhail@1", "ADIDAS ORIGINAL" } };
     * }
     */

    // using HashMap / json

    @DataProvider
    public Object[][] getData() throws IOException {
        /*
         * HashMap<String, String> map1 = new HashMap<>();
         * map1.put("email", "abdullasuhail21@gmail.com");
         * map1.put("password", "Suhail@1");
         * map1.put("product", "ZARA COAT 3");
         * 
         * HashMap<String, String> map2 = new HashMap<>();
         * map2.put("email", "abdullasuhail21@gmail.com");
         * map2.put("password", "Suhail@1");
         * map2.put("product", "IPHONE 13 PRO");
         */

        List<HashMap<String, String>> data = readJsonData();

        return new Object[][] { { data.get(0) }, { data.get(1) } };
    }

}
