package alexacademy.tests;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidation extends BaseTest {


    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void loginErrorValidation() {
        landingPage.loginApp("test1000332@gmail.com", "M267");
        Assert.assertEquals("Incorrect email o password.", landingPage.getErrorMessage());
    }

    @Test
    public void productErrorValidation() throws IOException {
        ProductCatalogue productCatalogue = landingPage.loginApp("test1000332@gmail.com", "M267280m");

        productCatalogue.getProductByName("ZARA COAT 3");

        productCatalogue.checkOutPage();
//        productCatalogue.checkOutButton();
//
//        CheckOutPage checkOutPage = new CheckOutPage(driver);
//        checkOutPage.selectCountry("ind");
//
//        String verifyConfirmation = checkOutPage.placeAnOrderAndVerify();
    }
//
//        Assert.assertTrue(verifyConfirmation.equalsIgnoreCase("Thankyou for the order."));

}
