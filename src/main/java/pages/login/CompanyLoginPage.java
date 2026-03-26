package pages.login;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class CompanyLoginPage extends BasePage {
 

@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_title")
    public WebElement warningDialogBox_Element;

    @AndroidFindBy(id = "android:id/progress")
    public WebElement loaderIcon_Element ;


    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/edtCompanyName")
    public WebElement companyNameTextField_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnSubmitCompanyConfig")
    public WebElement submitButton_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
    public WebElement warning_Toast_Msg_Element;

   


    


   
    // Constructor
    public CompanyLoginPage(AndroidDriver driver) {
        super(driver);
    }


    
public void clickOn_WarningDialogBox_UntilExpectedVisible() {

    for (int i = 0; i < 7; i++) {
        try {
            if (warningDialogBox_Element.isDisplayed()) {
                clickElement(warningDialogBox_Element);
                Thread.sleep(500); // small pause to allow dialog to reappear if needed
            } else {
                break; // NOT visible → exit immediately
            }
         } catch (Exception e) {
            break;
        }
    }
}





public void pressDeviceBack() {
    if(isElementVisible(loaderIcon_Element))
    {
          driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    
}

public  void wifiOn() throws IOException {
        Runtime.getRuntime().exec("adb shell svc wifi enable");
    }

    // Enter company name
    public void enterCompanyName(String name) {
        pressDeviceBack();
        clickElement(companyNameTextField_Element); // Use BasePage wait method
        sendText(companyNameTextField_Element, name); // Use BasePage wait method
    }

    // Click Next button on Comany page
    
    public void clickOn_Submit_Button() {
        clickElement(submitButton_Element);
    }


    public String getErrorMessage() {

    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");

    long endTime = System.currentTimeMillis() + 5000;

    while (System.currentTimeMillis() < endTime) {
        try {
            List<WebElement> elements = driver.findElements(snackbar);

            if (!elements.isEmpty()) {
                String text = elements.get(0).getText();
                if (!text.isEmpty()) {
                    return text.trim();
                }
            }

        } catch (Exception ignored) {}

    }

    throw new RuntimeException("Snackbar message not captured");
}


   public void hideKeyboardIfVisible() {
    try {
        if (isKeyboardVisible()) {
            driver.hideKeyboard();
        }
    } catch (Exception e) {
        System.out.println("Keyboard not visible, skip hiding");
    }
}

public boolean isKeyboardVisible() {
    try {
        return driver.isKeyboardShown();
    } catch (Exception e) {
        return false;
    }
}

   



}

