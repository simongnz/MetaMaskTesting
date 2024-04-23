import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class createAccount {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        ChromeOptions options = new ChromeOptions();

        // Add the Metamask Extension
        options.addExtensions(new File("/Users/simongonzalez/Downloads/MetaMask 11.14.0.0.crx"));

        // Initialize ChromeDriver with ChromeOptions
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testMetaMaskAccountCreation() throws InterruptedException {
        // Navigate to MetaMask website

        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Agree to terms of service check box
        WebElement agreeCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onboarding__terms-checkbox\"]")));
        agreeCheckbox.click();


        // Click on "Create a Wallet" button
        WebElement createWalletButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/ul/li[2]/button")));
        createWalletButton.click();

        // Click on "I agree" button
        WebElement iAgreeButton =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div/button[1]")));
        iAgreeButton.click();

        // Enter password
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/div[1]/label/input")));
        passwordField.sendKeys("MetaMaskTest123");

        // Confirm password
        WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/div[2]/label/input")));
        confirmPasswordField.sendKeys("MetaMaskTest123");

        // Click on "I understand" Checkbox
        WebElement iUnderstand = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/div[3]/label/input"));
        iUnderstand.click();

        // Click on "Create" button
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/button"));
        createButton.click();

        // Click on "Remind me later" button
        WebElement remindLater = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button[1]")));
        remindLater.click();

        // Click on "I understand" checkbox
        WebElement iUnderstandLater = driver.findElement(By.xpath("//*[@id=\"popover-content\"]/div/div/section/div[1]/div/div/label/input"));
        iUnderstandLater.click();

        // Click on "Skip" button
        WebElement skipLater = driver.findElement(By.xpath("//*[@id=\"popover-content\"]/div/div/section/div[2]/div/button[2]"));
        skipLater.click();

        // Click on "Got It" button
        WebElement gotIt = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button"));
        gotIt.click();

        // Click on "Next" button
        WebElement gotItNext= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button"));
        gotItNext.click();

        // Click on "Done" button
        WebElement gotItDone= driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button"));
        gotItDone.click();

        By buttonLocator = By.xpath("//*[@id=\"popover-content\"]/div/div/section/div[2]/div/div[1]/button");
        // Click on "Got it" four  buttons
        while (driver.findElements(buttonLocator).size() > 0) {
            // Find and click the button
            WebElement button = driver.findElement(buttonLocator);
            button.click();

            // Add some delay to observe changes or allow page update
            try {
                Thread.sleep(2000); // Adjust the delay as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }


    @AfterClass
    public void tearDown() {
        // Close WebDriver
        driver.quit();
    }
}
