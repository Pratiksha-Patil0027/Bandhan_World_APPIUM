package pages.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

    protected AndroidDriver driver;   // Use raw AndroidDriver (no generics)
    protected WebDriverWait wait;
   
    protected boolean isPageScrolledDown = false;


    //  Constructor
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    //  Click element with wait
   public void clickElement(WebElement element) {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    } catch (WebDriverException e) {

        if (e.getMessage().contains("instrumentation process is not running")) {
            System.err.println("UiAutomator2 crashed. Killing driver...");
            driver.quit();
        }

        throw e;
    }
}


    //  Send text with wait
    public void sendText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    //  Get text with wait
    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    //  Wait for visibility
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //  Wait for invisibility
    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //  Wait for visibility by locator
    public void waitForVisibilityOfLocated(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Wait for invisibility by locator
    public void waitForInvisibilityOfLocated(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //  Click from list by exact text match
    public void clickElementFromListByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().trim().equalsIgnoreCase(text.trim())) {
                clickElement(element);
                return;
            }
        }
        throw new RuntimeException("No element with text '" + text + "' found.");
    }

    //  Click from list by partial text match
    public void clickElementFromListByPartialText(List<WebElement> elements, String partialText) {
        for (WebElement element : elements) {
            if (element.getText().contains(partialText)) {
                clickElement(element);
                return;
            }
        }
        throw new RuntimeException("No element containing text '" + partialText + "' found.");
    }


    //Get mUltiple values in list by Webelemnt
    public List<String> getTextsFromElements(List<WebElement> elements) {
    List<String> texts = new ArrayList<>();
    for (WebElement element : elements) {
        texts.add(element.getText().trim());
    }
    return texts;
}

public static boolean isElementVisible(WebElement element) {
    try {
        return element != null && element.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}




    //  Window Handling (for hybrid apps or webviews)
    public void switchToMainWindow() {
        Set<String> windows = driver.getWindowHandles();
        if (!windows.isEmpty()) {
            driver.switchTo().window(windows.iterator().next());
        } else {
            throw new RuntimeException("No window found to switch.");
        }
    }

    public void switchToChildWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        if (windows.size() < 2) {
            throw new RuntimeException("Less than two windows open.");
        }
        it.next(); // Skip main
        driver.switchTo().window(it.next());
    }

    public void switchToWindowByIndex(int index) {
        Set<String> windows = driver.getWindowHandles();
        if (index < 0 || index >= windows.size()) {
            throw new IllegalArgumentException("Invalid window index: " + index);
        }
        Iterator<String> it = windows.iterator();
        for (int i = 0; i <= index; i++) {
            String windowHandle = it.next();
            if (i == index) {
                driver.switchTo().window(windowHandle);
            }
        }
    }





    protected void scrollToId(String resourceId) {
        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
              + ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\"))"
            )
        );
    }



protected void scrollToTop() {
    driver.findElement(
        AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))"
          + ".scrollToBeginning(5)"
        )
    );
}




protected void clickAfterScroll(WebElement element, String resourceId) {

    Exception lastException = null;

    // -------- PASS 1: Continue from current position --------
    try {
        if (!isPageScrolledDown) {
            scrollToId(resourceId);      // first time scroll
            isPageScrolledDown = true;
        } else {
            scrollToId(resourceId);      // continues from current scroll
        }
        clickElement(element);
        return;
    } catch (Exception e) {
        lastException = e;
    }

    // -------- PASS 2: Reset ONLY if not found anywhere --------
    try {
        scrollToTop();
        isPageScrolledDown = false;

        scrollToId(resourceId);
        isPageScrolledDown = true;

        clickElement(element);
        return;
    } catch (Exception e) {
        lastException = e;
    }

    throw new RuntimeException(
        "Click failed after continue-scroll + top-reset for resourceId: " + resourceId,
        lastException
    );
}




protected String getTextAfterScroll(WebElement element, String resourceId) {

    Exception lastException = null;

    // -------- PASS 1: Continue scrolling --------
    try {
        if (!isPageScrolledDown) {
            scrollToId(resourceId);
            isPageScrolledDown = true;
        } else {
            scrollToId(resourceId);
        }
        return getText(element).trim();
    } catch (Exception e) {
        lastException = e;
    }

    // -------- PASS 2: Reset only if truly needed --------
    try {
        scrollToTop();
        isPageScrolledDown = false;

        scrollToId(resourceId);
        isPageScrolledDown = true;

        return getText(element).trim();
    } catch (Exception e) {
        lastException = e;
    }

    throw new RuntimeException(
        "Unable to get text after continue-scroll + top-reset for resourceId: " + resourceId,
        lastException
    );
}


protected void resetScrollState() {
    isPageScrolledDown = false;
}
    

public void clickByDPAD(){
    driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER)); // gives focus
                                driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN)); // focuses list
                                driver.pressKey(new KeyEvent(AndroidKey.ENTER)); // select

}

public void selectDropValues(int x, int y) throws InterruptedException {
    
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(tap));
    }














    //  Wait for element visible (WebElement)
    public WebElement waitForVisible(WebElement element, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    //  Wait for element clickable (WebElement)
    public WebElement waitForClickable(WebElement element, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    //  SAME LOCATOR SCREEN CHANGE FIX
    public void waitUntilElementRefreshed(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    //  HEADER TEXT CHANGE FIX
    public void waitForTextToBePresent(WebElement element, String expectedText, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    //  Wait until element has ANY text (best for headers)
    public String waitUntilTextIsNotEmpty(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(driver -> {
            String text = element.getText();
            return (text != null && !text.trim().isEmpty()) ? text : null;
        });
    }

    public boolean isElementVisible(WebElement element, int timeoutSeconds) {
    try {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOf(element));
        return true;
    } catch (TimeoutException e) {
        return false;
    }
}


public void selectDropValueByAndroidKey(int index) {

    
    try {
        // move focus from search field to list
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        // move to required item
        for (int i = 0; i < index; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        }

        // select
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

    } catch (Exception e) {
        throw new AssertionError("Failed to select dropdown value using Android keys", e);
    }
}


public void tapDropdownItemByPosition(int itemIndex) {

    Dimension size = driver.manage().window().getSize();

    int x = size.width / 2;
    int startY = (int) (size.height * 0.25);
    int rowHeight = (int) (size.height * 0.08);
    int y = startY + (itemIndex * rowHeight);

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence tap = new Sequence(finger, 1);

    tap.addAction(finger.createPointerMove(Duration.ZERO,
            PointerInput.Origin.viewport(), x, y));
    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(List.of(tap));
}



public void scrollDownSafe() {

    Dimension size = driver.manage().window().getSize();

    int startX = size.width / 2;
    int startY = (int) (size.height * 0.75);
    int endY   = (int) (size.height * 0.30);

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);

    swipe.addAction(finger.createPointerMove(Duration.ZERO,
            PointerInput.Origin.viewport(), startX, startY));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
            PointerInput.Origin.viewport(), startX, endY));
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(List.of(swipe));
}


public void waitForListToLoad() {
    try {
        Thread.sleep(700);
    } catch (InterruptedException ignored) {}
}

protected void selectFromPopupByText(String expectedText) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    //  Wait until popup is visible (at least one option)
    wait.until(d ->
            d.findElements(AppiumBy.className("android.widget.TextView")).size() > 0 ||
            d.findElements(AppiumBy.className("android.widget.CheckedTextView")).size() > 0
    );

    // Collect all possible option views
    List<WebElement> options = new ArrayList<>();
    options.addAll(driver.findElements(AppiumBy.className("android.widget.TextView")));
    options.addAll(driver.findElements(AppiumBy.className("android.widget.CheckedTextView")));

    //  Debug (KEEP THIS during stabilization)
    for (WebElement opt : options) {
        System.out.println("POPUP OPTION: [" + opt.getText() + "]");
    }

    //  Match text safely
    for (WebElement option : options) {
        String actual = option.getText().replace("\n", " ").trim();

        if (actual.toLowerCase().contains(expectedText.toLowerCase())) {
            option.click();
            return;
        }
    }

    //  SCROLL & RETRY (Android spinner may be scrollable)
    try {
        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + expectedText + "\"))"
            )
        ).click();
        return;
    } catch (Exception ignored) {}

    throw new NoSuchElementException(
            "Popup option not found even after scroll: " + expectedText
    );
}

protected void waitForUiIdle() {
    try {
        Thread.sleep(1200);
    } catch (InterruptedException ignored) {}
}


public void pressDeviceBack() {
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
}

public boolean clickIfPresent(WebElement element, int timeout) {
    try {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
        return true;
    } catch (TimeoutException e) {
        return false;
    }
}



}



