package testComponents;

import pageObjects.modules.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public String pageURL;
    String browserName;
    public String USERNAME;
    public String PASSWORD;

    public WebDriver initializeTheBrowser() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//configs//config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException exception caught in initialize method: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException exception caught in initialize method: " + e.getMessage());
        }

        //TODO - To get BaseTest input form Terminal or config.properties File
        browserName = System.getProperty("web_browser") != null ? System.getProperty("web_browser") : properties.getProperty("web_browser");

        //TODO - To get url input form Terminal or Config.properties File
        //pageURL = System.getProperty("webpageURL") != null ? System.getProperty("webpageURL") : properties.getProperty("webpageURL");
        pageURL = "C:\\Users\\KC - Reddy\\Documents\\AutomationTestProject\\TestPages\\QE-index.html";

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome BaseTest is Selected " + driver);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firefox BaseTest is Selected " + driver);
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Edge BaseTest is Selected " + driver);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    //TODO - Initializing the BaseTest
    @BeforeMethod(alwaysRun = true)
    public LandingPage setLaunchBrowser() {
        driver = initializeTheBrowser();
        driver.get(pageURL);
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    //TODO - Closing the BaseTest
    @AfterMethod(alwaysRun = true)
    public void setShutdown() {
        driver.quit();
    }

}
