import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
            ChromeOptions options = new ChromeOptions();

            // Add the Metamask Extension
            options.addExtensions(new File("/Users/simongonzalez/Downloads/MetaMask 11.14.0.0.crx"));

            // Initialize ChromeDriver with ChromeOptions
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver instance
        }
    }
}
