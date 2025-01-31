package testComponents;

import dataAndComponents.data.DataReader;
import dataAndComponents.tests.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

//It sets browser configuration details and global properties
public class BaseTest extends DataReader {
    public  WebDriver driver;
    public LandingPage landingPage;
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/GlobalData.properties");
        prop.load(fis);

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser"):prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    //Allows us to take a screenshot and save it
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"/src/test/java/screenshots/test" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return file.toString();
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);

        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        //We are getting the data from the 'PurchaseOrder' JSON file
        String path = System.getProperty("user.dir")+"/src/test/java/dataAndComponents/data/PurchaseOrder.json";
        List<HashMap<String, String>> data = getJsonDataToMap(path);

        return new Object[][] {{data.get(0)},{data.get(1)}};

        //An alternative option how we can get that data without the JSON file

//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("email", "test1000332@gmail.com");
//        map.put("password", "M267280m");
//        map.put("product", "IPHONE 13 PRO");
//
//        HashMap<String, String> map2 = new HashMap<String, String>();
//        map2.put("email", "test1000332@gmail.com");
//        map2.put("password", "M267280m");
//        map2.put("product", "ADIDAS ORIGINAL");
//
//        return new Object[][] {{map},{map2}};
    }
}
