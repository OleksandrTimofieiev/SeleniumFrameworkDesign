package alexacademy.tests;

import TestComponents.BaseTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class StandAloneTest extends BaseTest {

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

    @Test(dependsOnMethods = {"submitOrder"})
//    @Test
    public void orderHistory() {
        ProductCatalogue productCatalogue = landingPage.loginApp("test1000332@gmail.com", "M267280m");
        OrderPage orderPage = productCatalogue.goToOrderPage();
        System.out.println(orderPage.getProductByName());
    }

    //Extent reports -

    @DataProvider
    public Object[][] getData() throws IOException {

//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("email", "test1000332@gmail.com");
//        map.put("password", "M267280m");
//        map.put("product", "ZARA COAT 3");
//
//        HashMap<String, String> map2 = new HashMap<String, String>();
//        map2.put("email", "test1000332@gmail.com");
//        map2.put("password", "M267280m");
//        map2.put("product", "ADIDAS ORIGINAL");


        String path = System.getProperty("user.dir")+"/src/test/java/data/PurchaseOrder.json";
        List<HashMap<String, String>> data = getJsonDataToMap(path);
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}
