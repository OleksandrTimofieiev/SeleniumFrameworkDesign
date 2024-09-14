package alexacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    WebDriver driver;
    OrderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr/td/following-sibling::td[contains(text(), 'ZARA')]")
    List<WebElement> names;

    @FindBy(xpath = "//tr/td/following-sibling::td[contains(text(), 'ZARA')]")
    WebElement name;

    public Boolean getProductByName() {
        waitForAnElementToAppear(name);
        Boolean match = names.stream().anyMatch(n -> n.getText().equalsIgnoreCase("ZARA COAT 3"));
        return match;
    }



}
