package alexacademy.tests;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidation extends BaseTest  {
    //Negative 'login page' test case
    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void loginErrorValidation() {
        landingPage.loginApp("test1000332@gmail.com", "M267");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }
    //Negative 'cart' test case
    @Test
    public void productErrorValidation() throws IOException {
        ProductCatalogue productCatalogue = landingPage.loginApp("test1000332@gmail.com", "M267280m");
        productCatalogue.getProductByName("ZARA"); //IPHONE 13 PRO
        productCatalogue.checkOutPage();
        BaseTest bt = new BaseTest();
        bt.getScreenshot("productErrorValidation", driver);
        Assert.assertEquals("No Product in Your Cart", landingPage.getErrorMessage());
    }
}
