package pages.reactpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebBasePage { 

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public static void launchBrowser() {

        if (webDriver == null) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();

            wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        }
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void openWebsite(String url) {
        if (webDriver == null) {
            throw new RuntimeException("Browser not initialized. Call launchBrowser first.");
        }
        webDriver.get(url);
    }

    public static void quitBrowser() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public static WebElement waitForVisible(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static WebElement waitForClickable(By locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public static WebElement waitForClickable(WebElement locator) {
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public boolean clickIfPresent(By by, int timeout) {
    int attempts = 0;

    while (attempts < 3) {
        try {
            WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.elementToBeClickable(by));

            element.click();
            return true;

        } catch (Exception e) {
            attempts++;
            try {
                Thread.sleep(500); // small wait before retry
            } catch (InterruptedException ignored) {}
        }
    }
    return false;
}


public void scrollToElementAndClick(WebElement element) {

    ((JavascriptExecutor) webDriver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            element);

    try {
        Thread.sleep(500); // optional
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    waitForClickable(element).click();
}

public void scrollToElementAndClick(By locator) {

    WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator));

    ((JavascriptExecutor) webDriver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            element);

    try {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    } catch (Exception e) {

        System.out.println("Normal click failed. Trying JS click.");

        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].click();",
                element);
    }
}

 //  Send text with wait
   public void sendText(WebElement element, String text) {
    int attempts = 0;

    while (attempts < 3) {
        try {
            wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOf(element)
            ));
            element.clear();
            element.sendKeys(text);
            return;

        } catch (StaleElementReferenceException e) {
            attempts++;
        }
    }

    throw new RuntimeException("SendKeys failed due to stale element");
}

//  Get text with wait
   public String getText(WebElement element) {
    int attempts = 0;

    while (attempts < 3) {
        try {
            return wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOf(element)
            )).getText();

        } catch (StaleElementReferenceException e) {
            attempts++;
        }
    }

    throw new RuntimeException("GetText failed due to stale element");
}

    public String getText(By locatoBy) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locatoBy));
        return element.getText();
    }
}