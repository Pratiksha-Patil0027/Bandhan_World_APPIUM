package pages.reactpages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebSiteApprovalPage extends WebBasePage {

    private WebDriver driver;

    public WebSiteApprovalPage() {
        this.driver = WebBasePage.getDriver();

        if (this.driver == null) {
            throw new RuntimeException("WebDriver is null. Launch browser first.");
        }
    }

    public void open_WebSite(String inflAccountNo) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(
                By.xpath("//*[@id=\"cell-1-undefined\"]/a/span"));
        System.out.println("Elements found: " + elements.size());
        for (WebElement element : elements) {
            String text = element.getText().trim();
            System.out.println("text : " + text);
            if (text.equals(inflAccountNo)) {

                waitForClickable(element).click();
                System.out.println("Clicked account: " + inflAccountNo);
                return;
            }
        }

        throw new RuntimeException("Account not found: " + inflAccountNo);
    }

    public boolean verify_Website_IsCreated(String inflAccountNo) throws InterruptedException {
   Thread.sleep(2000);
    List<WebElement> elements = driver.findElements(
            By.xpath("//*[@id='cell-1-undefined']/a/span"));

    for (WebElement element : elements) {
        if (element.getText().trim().equals(inflAccountNo)) {
            return true;
        }
    }

    return false;
}


public boolean waitForWebsiteCreation(String websiteName) throws InterruptedException {

    for (int i = 1; i <= 20; i++) {

        driver.navigate().refresh();

        if (verify_Website_IsCreated(websiteName)) {
            return true;
        }

        Thread.sleep(30000);
    }

    return false;
}

    public void clickOn_startButton() {

        scrollToElementAndClick(
                By.cssSelector("button[class='me-2 btn btn-primary']"));
    }

    public String get_ContentName() {
       try{
        By contentLocator = By.xpath(
                "//*[@id='layout-wrapper']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div[1]/div");

        WebElement element = driver.findElement(contentLocator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);

        return element.getText().trim();
       }catch(Exception e)
       {
          System.out.println("Unable to get content name");
        //e.printStackTrace();

        return "";
       }
    }

    public void clickOn_ApproveButton() {
        scrollToElementAndClick(By.cssSelector("button[class='btn btn-success']"));
    }

    public void clickOn_RejectButton() {
        scrollToElementAndClick(By.cssSelector("button[class='btn btn-danger']"));
    }

    public void clickOn_Accept_CheckBox() {
        clickIfPresent(By.id("finalCheck"), 2);
    }

    public void clickOn_Accept_SubmitBtn() {
        clickIfPresent(By.cssSelector("button[type='submit']"), 2);
    }

    public void clickOn_SuccessWindow_OkBtn() {
        clickIfPresent(By.cssSelector("button[class='swal2-confirm swal2-styled']"), 2);
    }

    public void clickOn_NextRecordBtn() {

        By nextBtn = By.cssSelector("button.btn-primary.btn.btn-primary");

        WebElement element = driver.findElement(nextBtn);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public void enter_RejectionRemark(String remark) {
        sendText(driver.findElement(By.id("Remark")), remark);
    }

    public void enter_ExpectedRemark(String remark) {
        sendText(driver.findElement(By.id("ExpectedRemark")), remark);
    }

    public void clickOn_Submit_FinalApproval_Btn() {
        clickIfPresent(By.cssSelector("button[class='mt-5 btn btn-primary ']"), 2);
    }

    public void clickOn_ThankYou_OkBtn() {
        clickIfPresent(By.cssSelector("button[class='swal2-confirm swal2-styled']"), 2);
    }

    public void clickOn_ProjectImages_ApproveBtn() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By approveBtnLocator = By.xpath(
                "//*[@id='layout-wrapper']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div[3]/div/div/div/button[1]");

        while (true) {

            List<WebElement> buttons = driver.findElements(approveBtnLocator);

            System.out.println("Approve buttons found: " + buttons.size());

            if (buttons.isEmpty()) {
                System.out.println("All project images approved.");
                break;
            }

            try {

                // Always take first available button after page refresh
                WebElement button = buttons.get(0);

                // Scroll to button
                js.executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        button);

                Thread.sleep(1000);

                // Wait until clickable
                wait.until(ExpectedConditions.elementToBeClickable(button));

                try {
                    button.click();
                } catch (Exception e) {

                    System.out.println("Normal click failed. Trying JS click.");

                    js.executeScript("arguments[0].click();", button);
                }

                // Approval flow
                clickOn_Accept_CheckBox();

                Thread.sleep(500);

                clickOn_Accept_SubmitBtn();

                Thread.sleep(500);

                clickOn_SuccessWindow_OkBtn();

                // Wait for page refresh/update
                Thread.sleep(3000);

                // Small scroll down so next row becomes visible
                js.executeScript("window.scrollBy(0,300);");

                Thread.sleep(1000);

            } catch (Exception e) {

                System.out.println("Error while approving image: " + e.getMessage());

                // Scroll slightly and continue with next iteration
                js.executeScript("window.scrollBy(0,500);");

                Thread.sleep(1000);
            }
        }
    }

    public void processAllContents(List<String> rejectContents) throws InterruptedException {
try{
        while (true) {

            clickNextButtonIfPresent();
            String contentName = get_ContentName().trim();

            System.out.println("Processing Content : " + contentName);

            if (rejectContents.contains(contentName)) {

                System.out.println("Rejecting : " + contentName);

                clickOn_RejectButton();
                enter_RejectionRemark("Content rejected as per test scenario.");
                enter_ExpectedRemark("Please upload valid content.");

            } else {

                System.out.println("Approving : " + contentName);

                clickOn_ApproveButton();
                clickOn_Accept_CheckBox();
            }

            clickOn_Accept_SubmitBtn();
            clickOn_SuccessWindow_OkBtn();

            Thread.sleep(2000);

            // Keep going until no Next button exists
            boolean movedToNext = clickNextButtonIfPresent();

            if (!movedToNext) {
                System.out.println("All records processed.");
                break;
            }

            Thread.sleep(3000); // wait for next record to load

        }

    }catch(Exception e){
        System.out.println("Unable to get content name");
        //e.printStackTrace();
    }
    }


    public void appproveAllWebsites() throws InterruptedException {

    while (true) {

        try {

            // Approve current record if Approve button is present
            if (isElementPresent(By.xpath("//button[contains(text(),'Approve')]"))) {

                clickOn_ApproveButton();
                clickOn_Accept_CheckBox();
                clickOn_Accept_SubmitBtn();
                Thread.sleep(1000);
                clickOn_SuccessWindow_OkBtn();
                

                System.out.println("Record approved.");
                Thread.sleep(2000);
            }

            // Move to next record
            if (!clickNextButtonIfPresent()) {
                System.out.println("All records processed.");
                break;
            }

            System.out.println("Moved to next record.");
            Thread.sleep(3000);

        } catch (Exception e) {

           // System.out.println("Error while processing record: " + e.getMessage());

            // Try moving to next record even if current record fails
            if (!clickNextButtonIfPresent()) {
                System.out.println("No more records found.");
                break;
            }

            Thread.sleep(3000);
        }
    }
}





public boolean clickNextButtonIfPresent() {

    try {

        WebElement nextBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(text(),'Next')]")));

        // Scroll button into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", nextBtn);

        Thread.sleep(1000);

        // Wait until clickable
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(nextBtn));

        try {
            nextBtn.click();
        } catch (ElementClickInterceptedException e) {

            System.out.println("Normal click failed. Trying JS click...");

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", nextBtn);
        }

        System.out.println("Next button clicked.");
        return true;

    } catch (TimeoutException e) {

        System.out.println("No Next button found.");
        return false;

    } catch (Exception e) {

        System.out.println("Unable to click Next button: " + e.getMessage());
        return false;
    }
}

public boolean isElementPresent(By locator) {
    try {
        return driver.findElements(locator).size() > 0;
    } catch (Exception e) {
        return false;
    }
}
}