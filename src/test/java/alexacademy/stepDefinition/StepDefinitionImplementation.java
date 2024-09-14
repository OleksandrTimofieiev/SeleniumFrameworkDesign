package alexacademy.stepDefinition;

import TestComponents.BaseTest;
import alexacademy.tests.CheckOutPage;
import alexacademy.tests.LandingPage;
import alexacademy.tests.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImplementation extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public CheckOutPage checkOutPage;

    @Given("I landed on Ecommerce Page")
    public void i_landed_on_ecommerce_page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String userName, String password) {
        productCatalogue = landingPage.loginApp(userName, password);
    }

    @When("^I add a product (.+) to Cart$")
    public void i_add_a_product_zara_coat_from_a_cart_and_submit_the_order(String productName) {
        productCatalogue.getProductByName(productName);
    }

    @When("^Checkout (.+) and submit the order to the country (.+)$")
    public void checkout_zara_coat_and_submit_the_order(String name, String country) {
        productCatalogue.checkOutPage();
        CheckOutPage checkOutPage = productCatalogue.checkOutButton();
        checkOutPage.selectCountry(country);
//        String confirmationPage = checkOutPage.placeAnOrderAndVerify();
        checkOutPage.placeAnOrderAndVerify();
    }

    @Then("{string} is displayed")
    public void message_is_displayed_on_confrimation_page(String confirmationPage) {
        Assert.assertTrue(confirmationPage.equalsIgnoreCase("Thankyou for the order."));
    }

    @Then("{string} message is displayed")
    public void message_is_displayed(String strArg1) {
        Assert.assertEquals(strArg1, landingPage.getErrorMessage());
    }

}
