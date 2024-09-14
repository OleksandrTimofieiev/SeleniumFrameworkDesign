package alexacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type=\"email\"]")
    WebElement login2;

    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement password2;

    @FindBy(xpath = "//input[@name=\"login\"]")
    WebElement loginButton2;

    @FindBy(xpath = "//div[@role=\"alert\"]")
    WebElement errorMessage;

    public ProductCatalogue loginApp(String email, String password) {
        login2.sendKeys(email);
        password2.sendKeys(password);
        loginButton2.submit();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public String getErrorMessage() {
        waitForAnElementToAppear(errorMessage);
        String response = errorMessage.getText();
        return response;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
