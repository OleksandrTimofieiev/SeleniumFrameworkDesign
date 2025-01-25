package alexacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static alexacademy.tests.StandAloneTest.productName;

//Here we store our methods and locators related to finding a product in 'orders' page
public class OrderPage extends AbstractComponent {
    WebDriver driver;
    OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr/td/following-sibling::td[contains(text()," + productName + ")]")
    List<WebElement> names;

    @FindBy(xpath = "//tr/td/following-sibling::td[contains(text()," + productName + ")]")
    WebElement name;


    public Boolean getProductByName(String product) {
        waitForAnElementToAppear(name);
        Boolean match = names.stream().anyMatch(n -> n.getText().contains(product));
        return match;
    }
}
