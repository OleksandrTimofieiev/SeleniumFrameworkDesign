package alexacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;
    CheckOutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type=\"email\"]")
    WebElement login2;

    @FindBy(css = "input[placeholder=\"Select Country\"]")
    WebElement selectCountry;

    @FindBy(css = "section[class=\"ta-results list-group ng-star-inserted\"]")
    WebElement options;

    @FindBy(xpath = "(//button[contains(@class, 'ta-item')])[2]")
    WebElement ourCountry;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
    WebElement placeAnOrder;

    @FindBy(css = "h1[class=\"hero-primary\"]")
    WebElement banner;

    By newPage = By.cssSelector("h1[class='hero-primary']");

    public void selectCountry(String countyName) {
        Actions a = new Actions(driver);
        waitForAnElementToAppear(selectCountry);
        a.sendKeys(selectCountry, countyName).build().perform();
        waitForAnElementToAppear(options);
        ourCountry.click();
    }

    public String placeAnOrderAndVerify() {
        placeAnOrder.click();
        waitForAnElementToAppear(newPage);
//        Assert.assertTrue(banner.getText().equalsIgnoreCase("Thank you for the order."));
        return banner.getText();
    }

}
