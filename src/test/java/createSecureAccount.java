import org.openqa.selenium.By;
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

public class createSecureAccount {

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
        String[] words = {"1","2","3", "4","5","6","7","8","9","10","11","12"};
        String[] boxes = {"3", "4", "8"};

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
        WebElement iAgreeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div/button[1]")));
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

        // Click on "Secure Account" button
        WebElement Secure = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[2]/button[2]")));
        Secure.click();

        // Click on "Reveal Phrase" button
        WebElement revealPhrase = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[6]/button")));
        revealPhrase.click();

        // Get the 12 secure words
        for (int i = 0; i < words.length; i++) {
            // Wait until the text box element is present
            WebElement secureBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[5]/div/div[" + words[i] +"]/div[2]")));

            // Get the text from the text box
            words[i] = secureBox.getText();

            // Print the text from the text box
            System.out.println(words[i]);
        }

        // Click on "Next" button
        WebElement nextSecureBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[6]/div/button")));
        nextSecureBox.click();


        WebElement inputSecureBox3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[4]/div/div[3]/div[2]/input")));
        // Get the text from the text box
        inputSecureBox3.sendKeys(words[2]);

        WebElement inputSecureBox4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[4]/div/div[4]/div[2]/input")));
        // Get the text from the text box
        inputSecureBox4.sendKeys(words[3]);

        WebElement inputSecureBox8 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[4]/div/div[8]/div[2]/input")));
        // Get the text from the text box
        inputSecureBox8.sendKeys(words[7]);

        // Click on "Confirm" button
        WebElement confirmSecureBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[2]/div/div/div/div[5]/button")));
        confirmSecureBox.click();

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
