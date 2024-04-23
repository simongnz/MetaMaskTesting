import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class testHomePage {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.getDriver();
    }

    @Test
    public void testAllElementsDisplayed() {

        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement logo =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-testid='app-header-logo']")));
        Assert.assertTrue(logo.isDisplayed(), "MetaMask logo is not displayed.");

        WebElement networkDisplayButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-testid='network-display']")));
        Assert.assertTrue(networkDisplayButton.isDisplayed(), "Network display button is not displayed.");


        WebElement connectWalletButton = driver.findElement(By.cssSelector("button[data-testid='connect-wallet']"));
        Assert.assertTrue(connectWalletButton.isDisplayed(), "Connect wallet button is not displayed.");

        WebElement transactionHistory = driver.findElement(By.cssSelector("div[data-testid='transaction-history']"));
        Assert.assertTrue(transactionHistory.isDisplayed(), "Transaction history is not displayed.");

        WebElement balance = driver.findElement(By.cssSelector("div[data-testid='balance']"));
        Assert.assertTrue(balance.isDisplayed(), "Balance is not displayed.");

        WebElement sendButton = driver.findElement(By.cssSelector("button[data-testid='send']"));
        Assert.assertTrue(sendButton.isDisplayed(), "Send button is not displayed.");

        WebElement receiveButton = driver.findElement(By.cssSelector("button[data-testid='receive']"));
        Assert.assertTrue(receiveButton.isDisplayed(), "Receive button is not displayed.");

        WebElement addTokenButton = driver.findElement(By.cssSelector("button[data-testid='add-token']"));
        Assert.assertTrue(addTokenButton.isDisplayed(), "Add token button is not displayed.");

        WebElement settingsButton = driver.findElement(By.cssSelector("button[data-testid='settings']"));
        Assert.assertTrue(settingsButton.isDisplayed(), "Settings button is not displayed.");

        WebElement walletActivity = driver.findElement(By.cssSelector("div[data-testid='wallet-activity']"));
        Assert.assertTrue(walletActivity.isDisplayed(), "Wallet activity is not displayed.");

        WebElement tokensSection = driver.findElement(By.cssSelector("div[data-testid='tokens']"));
        Assert.assertTrue(tokensSection.isDisplayed(), "Tokens section is not displayed.");

        WebElement sendEtherButton = driver.findElement(By.cssSelector("button[data-testid='send-ether']"));
        Assert.assertTrue(sendEtherButton.isDisplayed(), "Send Ether button is not displayed.");

        WebElement requestEtherButton = driver.findElement(By.cssSelector("button[data-testid='request-ether']"));
        Assert.assertTrue(requestEtherButton.isDisplayed(), "Request Ether button is not displayed.");

        WebElement sendTokenButton = driver.findElement(By.cssSelector("button[data-testid='send-token']"));
        Assert.assertTrue(sendTokenButton.isDisplayed(), "Send Token button is not displayed.");

        WebElement requestTokenButton = driver.findElement(By.cssSelector("button[data-testid='request-token']"));
        Assert.assertTrue(requestTokenButton.isDisplayed(), "Request Token button is not displayed.");

        WebElement approveButton = driver.findElement(By.cssSelector("button[data-testid='approve']"));
        Assert.assertTrue(approveButton.isDisplayed(), "Approve button is not displayed.");

        WebElement rejectButton = driver.findElement(By.cssSelector("button[data-testid='reject']"));
        Assert.assertTrue(rejectButton.isDisplayed(), "Reject button is not displayed.");

        WebElement confirmButton = driver.findElement(By.cssSelector("button[data-testid='confirm']"));
        Assert.assertTrue(confirmButton.isDisplayed(), "Confirm button is not displayed.");

        WebElement cancelTransactionButton = driver.findElement(By.cssSelector("button[data-testid='cancel-transaction']"));
        Assert.assertTrue(cancelTransactionButton.isDisplayed(), "Cancel Transaction button is not displayed.");

        WebElement editButton = driver.findElement(By.cssSelector("button[data-testid='edit']"));
        Assert.assertTrue(editButton.isDisplayed(), "Edit button is not displayed.");

        WebElement deleteButton = driver.findElement(By.cssSelector("button[data-testid='delete']"));
        Assert.assertTrue(deleteButton.isDisplayed(), "Delete button is not displayed.");

        WebElement switchAccountsButton = driver.findElement(By.cssSelector("button[data-testid='switch-accounts']"));
        Assert.assertTrue(switchAccountsButton.isDisplayed(), "Switch Accounts button is not displayed.");

        WebElement addAccountButton = driver.findElement(By.cssSelector("button[data-testid='add-account']"));
        Assert.assertTrue(addAccountButton.isDisplayed(), "Add Account button is not displayed.");

        WebElement exportAccountButton = driver.findElement(By.cssSelector("button[data-testid='export-account']"));
        Assert.assertTrue(exportAccountButton.isDisplayed(), "Export Account button is not displayed.");

        WebElement importAccountButton = driver.findElement(By.cssSelector("button[data-testid='import-account']"));
        Assert.assertTrue(importAccountButton.isDisplayed(), "Import Account button is not displayed.");

        WebElement showAccountInformationButton = driver.findElement(By.cssSelector("button[data-testid='show-account-information']"));
        Assert.assertTrue(showAccountInformationButton.isDisplayed(), "Show Account Information button is not displayed.");

        WebElement hideAccountInformationButton = driver.findElement(By.cssSelector("button[data-testid='hide-account-information']"));
        Assert.assertTrue(hideAccountInformationButton.isDisplayed(), "Hide Account Information button is not displayed.");

        WebElement viewDetailsButton = driver.findElement(By.cssSelector("button[data-testid='view-details']"));
        Assert.assertTrue(viewDetailsButton.isDisplayed(), "View Details button is not displayed.");

        WebElement nextButton = driver.findElement(By.cssSelector("button[data-testid='next']"));
        Assert.assertTrue(nextButton.isDisplayed(), "Next button is not displayed.");

        WebElement backButton = driver.findElement(By.cssSelector("button[data-testid='back']"));
        Assert.assertTrue(backButton.isDisplayed(), "Back button is not displayed.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
    }
}
