package TestComponents;

import alexacademy.tests.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public  WebDriver driver;
    public LandingPage landingPage;
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/GlobalData.properties");
        prop.load(fis);

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser"):prop.getProperty("browser");

        //prop.getProperty("browser");

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

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"/src/test/java/screenshots" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return file.toString();
    }


    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //Read a json file to string
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});

        return data;
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
}
