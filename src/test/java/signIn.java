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

public class signIn {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        driver = WebDriverManager.getDriver();
    }

    @Test
    public void testMetaMaskAccountCreation() throws InterruptedException {
        String[] words = {"alarm", "twelve", "stem", "loan", "glare", "perfect", "artwork", "garden", "release", "affair", "calm", "book"};
        // Navigate to MetaMask website

        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Agree to terms of service check box
        WebElement agreeCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onboarding__terms-checkbox\"]")));
        agreeCheckbox.click();


        // Click on "Import Wallet" button
        WebElement importWallet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/ul/li[3]/button")));
        importWallet.click();

        // Click on "I agree" button
        WebElement iAgreeButton =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div/button[1]")));
        iAgreeButton.click();

        for (int i = 0; i < words.length; i++) {
            // Wait until the text box element is present
            WebElement inputSecureBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"import-srp__srp-word-" + i +"\"]")));

            // Get the text from the text box
            inputSecureBox.sendKeys(words[i]);

            // Print the text from the text box
            System.out.println(words[i]);
        }

        // Click on "Confirm phrase" Checkbox
        WebElement confirmPhrase = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[4]/div/button")));
        confirmPhrase.click();

        // Enter new password
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/div[1]/label/input")));
        passwordField.sendKeys("123MetaMaskTest");

        // Confirm new password
        WebElement confirmPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/div[2]/label/input")));
        confirmPasswordField.sendKeys("123MetaMaskTest");

        // Click on "I understand" Checkbox
        WebElement iUnderstand = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/div[3]/label/input"));
        iUnderstand.click();

        // Click on "Import wallet" button
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/form/button"));
        createButton.click();

        Thread.sleep(5000);

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
    }
}
