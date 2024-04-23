import org.testng.TestListenerAdapter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot extends TestListenerAdapter {
    private WebDriver driver;

    public static void onTestFailure() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Cast WebDriver to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Take screenshot and save it to a file
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        // Specify the destination path for the screenshot
        String destinationPath = "/Users/simongonzalez/Downloads/newscreenshot.png";

        // Move the screenshot file to the specified location
        try {
            File des = new File(destinationPath);
            FileHandler.copy(src, des);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the browser after taking the screenshot
            driver.quit();
        }
    }
}
