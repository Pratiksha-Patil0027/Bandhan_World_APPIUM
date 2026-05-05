package pages.base;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
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
import io.appium.java_client.appmanagement.ApplicationState;
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


    public void clickUntilElementVisible(By clickLocator, WebElement nextScreenElement) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    int maxAttempts = 3;

    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
        try {
            // Wait for element to be clickable
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickLocator));

            element.click();
            System.out.println("Click attempt: " + attempt);

            //  Check if next screen element appears
            Thread.sleep(1000);
            if (isElementVisible(nextScreenElement, 5)) {
                System.out.println("Click successful, next element found");
                return; 
            }

        } catch (Exception e) {
            System.out.println("Click attempt failed: " + attempt);
        }
    }

    //  Final failure
    throw new RuntimeException("Failed to click element after " + maxAttempts +
            " attempts. Next element not visible: " + nextScreenElement);
}
    //  Click element with wait
  public void clickElement(WebElement element) {
    int attempts = 0;

    while (attempts < 3) {
        try {
            wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
            ));

            element.click();
            return;

        } catch (StaleElementReferenceException e) {
            System.out.println("Retrying click due to stale element...");

            attempts++;

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        } catch (WebDriverException e) {

            if (e.getMessage().contains("instrumentation process is not running")) {
                System.err.println("UiAutomator2 crashed. Killing driver...");
                driver.quit();
            }

            throw e;
        }
    }

    throw new RuntimeException("Click failed after retries");
}

public List<WebElement> getFreshElements(List<WebElement> elements) {
    try {
        elements.size(); // triggers re-evaluation in PageFactory
        return elements;
    } catch (Exception e) {
        return elements; // PageFactory will reload internally
    }
}

public void clickFromList(List<WebElement> elements, int index) {
    int attempts = 0;

    while (attempts < 3) {
        try {
            List<WebElement> freshList = getFreshElements(elements);

            if (freshList.size() > index) {
                WebElement element = freshList.get(index);

                wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(element)
                ));

                element.click();
                return;
            }

        } catch (StaleElementReferenceException e) {
            System.out.println("Retry list click due to stale...");
            attempts++;
        }
    }

    throw new RuntimeException("Unable to click element at index: " + index);
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
        if (element == null || !element.isDisplayed()) return false;

        Dimension size = element.getSize();
        if (size.height == 0 || size.width == 0) return false;

        return true;

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


    protected void clickProductByIndex(String resourceId, int productIndex) {

    int maxScroll = 8;
    int scrollCount = 0;

    while (scrollCount < maxScroll) {

        List<WebElement> products =
                driver.findElements(By.id(resourceId));

        if (products.size() > productIndex) {
            try {
                products.get(productIndex).click();
                return;
            } catch (Exception e) {
                // retry after small scroll
            }
        }

        scrollDownSmall();  // small swipe
        scrollCount++;
    }

    throw new RuntimeException(
            "Unable to click product index: " + productIndex);
}

public void smallWait() throws InterruptedException
{
    Thread.sleep(1000);
}
public void enterTextByResourceId(String resourceId, int index, String text) {

    int maxScroll = 6;
    int scrollCount = 0;

    while (scrollCount < maxScroll) {

        List<WebElement> elements = driver.findElements(By.id(resourceId));

        if (elements.size() > index) {

            WebElement element = elements.get(index);

            try {
                element.click();
                element.clear();
                element.sendKeys(text);
                return;
            } catch (Exception e) {
                // retry after scroll
            }
        }

        scrollDownSmall();
        scrollCount++;
    }

    throw new RuntimeException("Unable to enter text in index: " + index);
}


// public void scrollDownSmall() {

//     Dimension size = driver.manage().window().getSize();

//     int startX = size.width / 2;
//     int startY = (int) (size.height * 0.7);
//     int endY = (int) (size.height * 0.4);

//     new TouchAction((PerformsTouchActions) driver)
//             .press(PointOption.point(startX, startY))
//             .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//             .moveTo(PointOption.point(startX, endY))
//             .release()
//             .perform();
// }


public void scrollDownSmall() {

    Dimension size = driver.manage().window().getSize();

    int startX = size.width / 2;
    int startY = (int) (size.height * 0.7);
    int endY = (int) (size.height * 0.4);

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);

    swipe.addAction(finger.createPointerMove(Duration.ZERO,
            PointerInput.Origin.viewport(), startX, startY));

    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
            PointerInput.Origin.viewport(), startX, endY));

    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Arrays.asList(swipe));
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

    public WebElement waitForElementVisibility(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

        // Thread.sleep(500); // wait for dropdown to open
        // move focus from search field to list
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        // move to required item
        for (int i = 0; i <index; i++) {
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



public boolean scrollDownSafe() {
    try {
        AndroidDriver driver = (AndroidDriver) this.driver;

        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollForward()"
        ));
        return true;
    } catch (Exception e) {
        // Reached end of list OR no scrollable container
        return false;
    }
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

// public boolean clickIfPresent(WebElement element, int timeout) {
//     try {
//         new WebDriverWait(driver, Duration.ofSeconds(timeout))
//                 .until(ExpectedConditions.elementToBeClickable(element))
//                 .click();
//         return true;
//     } catch (TimeoutException e) {
//         return false;
//     }
// }


public boolean clickIfPresent(WebElement element, int timeout) {

    int attempts = 0;

    while (attempts < 3) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

            WebElement el = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
            ));

            el.click();
            return true;

        } catch (StaleElementReferenceException e) {
            System.out.println("Retrying click (stale)...");
            attempts++;

        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, retrying...");
            attempts++;

        } catch (TimeoutException e) {
            return false;
        }
    }

    return false;
}

public boolean clickIfPresent(By by, int timeout) {
    int attempts = 0;

    while (attempts < 3) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout))
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



public LocalDate parseExcelDate(String dateText) {

    dateText = dateText.trim();

    // Remove time part if present
    if (dateText.contains("|")) {
        dateText = dateText.split("\\|")[0].trim();
    }
    // Handle format like: 16-Mar-2026 10:03:44 AM
else if (dateText.matches("\\d{2}-[A-Za-z]{3}-\\d{4}.*")) {
    dateText = dateText.split(" ")[0].trim();
}

    List<DateTimeFormatter> formatters = List.of(
        DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH),
        DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH),
        DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH),
        DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
    );

    for (DateTimeFormatter formatter : formatters) {
        try {
            return LocalDate.parse(dateText, formatter);
        } catch (Exception ignored) {}
    }

    throw new RuntimeException("Unsupported date format: " + dateText);
}

public void swipeLeft() {

  

    Dimension size = driver.manage().window().getSize();

    int startX = (int) (size.width * 0.8);
    int endX   = (int) (size.width * 0.2);
    int y      = (int) (size.height * 0.3);

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);

    swipe.addAction(finger.createPointerMove(
            Duration.ZERO,
            PointerInput.Origin.viewport(),
            startX, y));

    swipe.addAction(finger.createPointerDown(
            PointerInput.MouseButton.LEFT.asArg()));

    swipe.addAction(finger.createPointerMove(
            Duration.ofMillis(400),
            PointerInput.Origin.viewport(),
            endX, y));

    swipe.addAction(finger.createPointerUp(
            PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(swipe));
}

public void swipeLeftOnElement(By element) {

    WebElement container = driver.findElement(element);
    Rectangle rect = container.getRect();

    int startX = rect.getX() + (int) (rect.getWidth() * 0.85);
    int endX   = rect.getX() + (int) (rect.getWidth() * 0.15);
    int y      = rect.getY() + rect.getHeight() / 2;

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence swipe = new Sequence(finger, 1);

    swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, y));
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(swipe));
}

public String get_text_after_scroll(String resourceId) {
    try {
        // 1. Scroll using the ID string
        scrollToId(resourceId);
        
        // 2. Locate the element immediately after scrolling
        WebElement el = driver.findElement(By.id(resourceId));
        
        return el.getText().trim();
    } catch (Exception e) {
        // 3. Fallback: Reset to top and try one more time
        scrollToTop();
        scrollToId(resourceId);
        return driver.findElement(By.id(resourceId)).getText().trim();
    }
}


public boolean verify_FieldsDisplayed_WithScroll(String fields) {

    if (fields == null || fields.trim().isEmpty()) {
        throw new RuntimeException("Field list is empty!");
    }

    String[] fieldArray = fields.split(",");

    for (String field : fieldArray) {

        String fieldName = field.trim();
        System.out.println("Verifying field: " + fieldName);

        try {

            WebElement element = driver.findElement(
                AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                    + ".scrollIntoView(new UiSelector().textContains(\""
                    + fieldName + "\"))"
                )
            );

            if (element.isDisplayed()) {
                System.out.println(fieldName + " is displayed");
            } else {
                System.out.println(fieldName + " is NOT displayed");
                return false;
            }

        } catch (Exception e) {
            System.out.println(fieldName + " NOT found even after scroll");
            return false;
        }
    }

    return true;
}


public String removeDecimal(String value) {
    return String.valueOf((int) Double.parseDouble(value));
}

public void ensureAppRunning() {
    if (driver.queryAppState("com.prowess.apps.bandhan.world")
        != ApplicationState.RUNNING_IN_FOREGROUND) {

        System.out.println("App crashed. Restarting...");

        driver.activateApp("com.prowess.apps.bandhan.world");
    }
}

public void waitForListToLoad(List<WebElement> elements) {
    new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(driver -> {
            try {
                return elements.size() > 0 && elements.get(0).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        });
}

public void waitForListToLoad(By locator) {
    new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(driver -> {
            try {
                List<WebElement> elements = driver.findElements(locator);
                return elements.size() > 0 && elements.get(0).isDisplayed();
            } catch (Exception e) {
                return false;
            }
        });
}



public void relaunchAppIfClosed(String appActivity) {
    try {
        String currentPackage = driver.getCurrentPackage();

        if (currentPackage == null || !currentPackage.contains("com.prowess.apps.bandhan.world")) {
            System.out.println("App is not in foreground. Relaunching...");

            driver.activateApp(appActivity);
            // OR
            // driver.launchApp();

            Thread.sleep(3000); // wait for app to load
        }

    } catch (Exception e) {
        System.out.println("App might be closed. Launching again...");
        driver.activateApp("com.prowess.apps.bandhan.world");
    }
}


   public static  String getTodayDate()
   {
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String todayDate = LocalDate.now().format(formatter);

        System.out.println(todayDate);
        return todayDate;
   }

}



