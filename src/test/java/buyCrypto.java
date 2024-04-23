import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class buyCrypto {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        driver = WebDriverManager.getDriver();
    }

    @Test
    public void testMetaMaskAccountCreation() throws InterruptedException, IOException {

        // Navigate to MetaMask website
        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on "Buy" button
        WebElement buy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[3]/div/div/div/div[2]/div/div/div/div[1]/button[1]")));
        buy.click();

        // Get the current window handle (assuming you're on the parent window)
        String parentWindowHandle = driver.getWindowHandle();

        // Perform action that opens a new tab, for example, clicking a link that opens in a new tab

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                parentWindowHandle = driver.getWindowHandle();
                break;
            }
        }


        // Click on "Get Started" button
        WebElement buyGetStarted = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onramp-page\"]/div/div/button")));
        buyGetStarted.click();

        // Select "United States of America" button
        WebElement usa =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onramp-page\"]/div/div/div/div[2]/ul[1]/li[5]/button")));
        usa.click();

        // Enter State on input
        WebElement stateSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"selected-region\"]")));
        stateSearch.sendKeys("Florida");

        // Click on "Florida" button
        WebElement florida = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onramp-page\"]/div/div/div/div[2]/ul/li/button")));
        florida.click();

        // Click on "Debit or Credit" button
        WebElement creditCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onramp-page\"]/div/div/div/ul/li[1]/div")));
        creditCard.click();

        // Click on "Continue" button
        WebElement creditCardContinue = driver.findElement(By.xpath("//*[@id=\"onramp-page\"]/div/div/div/div/button"));
        creditCardContinue.click();

        // Click on area for amount desire to purchase and input $5
        WebElement moneyDesired = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"build-quote-page\"]/div/div[2]/input")));
        moneyDesired.clear();
        moneyDesired.sendKeys("5");

        String originalWindowHandle = driver.getWindowHandle();

        // Click on "Connect Metamask" button
        WebElement connectMetamask = driver.findElement(By.xpath("//*[@id=\"build-quote-page\"]/div/div[6]/button"));
        connectMetamask.click();


        Thread.sleep(10000);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#");
                driver.navigate().refresh();
                break;
            }
        }



        // Click on "Next" button
        WebElement nextConnectMetamask =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[1]/div/div[3]/div[2]/footer/button[2]")));
        nextConnectMetamask.click();

        // Click on "Connect" button
        WebElement ConnectMetamask = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-content\"]/div/div[1]/div/div[3]/div[2]/footer/button[2]")));
        ConnectMetamask.click();

        driver.switchTo().window(originalWindowHandle);

        Thread.sleep(15000);

        // Click on "Stripe" button
        WebElement stripe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onramp-page\"]/div/div/div[2]/div/ul/li[2]/div")));
        stripe.click();

        // Click on "Continue with Stripe" button
        WebElement stripeContinue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onramp-page\"]/div/div/div[2]/div/ul/li[2]/div/button")));
        stripeContinue.click();

        Thread.sleep(15000);

        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src= screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("/Users/simongonzalez/Downloads/metabuy.png");
        FileHandler.copy(src,des);
    }



    @AfterClass
    public void tearDown() {
        // Close WebDriver
    }
}
