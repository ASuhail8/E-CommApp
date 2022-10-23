package myApp.E_CommApp.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import myApp.E_CommApp.Pages.LandingPage;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;
    String browser = null;

    public WebDriver intializeDriver() throws IOException {

        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : getProperty("browser");

         ChromeOptions options = new ChromeOptions();
        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;

    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = intializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/java/myApp/E_CommApp/TestComponents/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public List<HashMap<String, String>> readJsonData() throws IOException {

        String jsonContent = FileUtils
                .readFileToString(new File(System.getProperty("user.dir") + "/src/test/java/resources/purchase.json"),
                        StandardCharsets.UTF_8);
        ObjectMapper objMapper = new ObjectMapper();
        List<HashMap<String, String>> data = objMapper.readValue(jsonContent,
                new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }

    public String getScreenshot(String testName, WebDriver driver) throws IOException {

        TakesScreenshot t = (TakesScreenshot) driver;
        File src = t.getScreenshotAs(OutputType.FILE);
        File path = new File(System.getProperty("user.dir") + "/reports/" + testName + ".png");
        FileUtils.copyFile(src, path);
        return System.getProperty("user.dir") + "/reports/" + testName + ".png";

    }
}
