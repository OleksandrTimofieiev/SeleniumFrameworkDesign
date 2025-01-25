package alexacademy.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//Here we store our methods and locators related to finding a product and going to a CheckOut page
public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/descendant::div/child::div[@class='card-body']")
    List<WebElement> names;
    By products = By.xpath("//body/descendant::div/child::div[@class='card-body']");

    By addedToCart2 = By.xpath("//div[@id=\"toast-container\"]/child::div");

    @FindBy(xpath = "//button[@routerlink=\"/dashboard/cart\"]") //button[contains(text(), "Cart")]
    WebElement cartButton2;

    @FindBy(css = ".totalRow button")
    WebElement checkOut2;

    public List<WebElement> getProductList() {
        waitForAnElementToAppear(products);
        return names;
    }

    public void getProductByName(String productName) {
        try {
            getProductList().stream().filter(n -> n.getText().contains(productName))
                    .forEach(n -> n.findElement(By.className("w-10")).click());
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }

    public CheckOutPage checkOutPage() {
        waitForAnElementToDisappear(addedToCart2);
        waitForAnElementToBeClickable(cartButton2);
        cartButton2.click();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        return checkOutPage;
    }

    public CheckOutPage checkOutButton() {
        waitForAnElementToAppear(checkOut2);
        checkOut2.click();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        return checkOutPage;
    }
}
