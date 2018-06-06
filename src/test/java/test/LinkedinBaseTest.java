package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LinkedinLoginPage;

/**
 * Base Test Object class
 */
public class  LinkedinBaseTest {
    WebDriver webDriver;
    LinkedinLoginPage linkedinLoginPage;

    /**
     * Method to be executed before each test - opens browser and landing url
     * @param browserType - browser test to be executed in, open Test suits *xml documents to parametrize a value. Default value is placed in Optional annotation
     * @param envURL - url localization test to be executed in, open Test suits *xml documents to parametrize a value. Default value is placed in Optional annotation
     */
    @Parameters({"browserType", "envURL"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType,
                           @Optional("https://ua.linkedin.com/") String envURL) {

        switch (browserType.toLowerCase()){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            default :
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
        }

        webDriver.navigate().to(envURL);
        linkedinLoginPage = new LinkedinLoginPage(webDriver);
    }

    /**
     * Method to be executed after each test - closes browser
     */
    @AfterMethod
    public void after() {

        webDriver.close();
    }
}
