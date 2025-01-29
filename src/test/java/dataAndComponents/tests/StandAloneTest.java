package dataAndComponents.tests;

import testComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class StandAloneTest extends BaseTest {
    //Positive 'submit order' test case
    @Test(dataProvider = "getData", groups = "Purchase")
    public void submitOrder(HashMap<String, String> input) {

        ProductCatalogue productCatalogue = landingPage.loginApp(input.get("email"), input.get("password"));

        productCatalogue.getProductByName(input.get("product"));

        productCatalogue.checkOutPage();
        productCatalogue.checkOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.selectCountry("ind");

        String verifyConfirmation = checkOutPage.placeAnOrderAndVerify();

        Assert.assertTrue(verifyConfirmation.equalsIgnoreCase("Thankyou for the order."));
    }

    //Positive 'order history' test case
    public static final String productName = "Refrigerator";
    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistory() {
        ProductCatalogue productCatalogue = landingPage.loginApp("test1000332@gmail.com", "M267280m");
        OrderPage orderPage = productCatalogue.goToOrderPage();
        Assert.assertTrue(orderPage.getProductByName(productName));
    }
}
