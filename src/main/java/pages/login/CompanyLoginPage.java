package pages.login;

import java.io.IOException;

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

    // Get error message
    public String getErrorMessage() {
       return getText(warning_Toast_Msg_Element);
    }

    public void hideKeyboardIfVisible() 
    {
    try {
        driver.hideKeyboard();
    } catch (Exception e) {
        // Keyboard was not open – ignore
    }
}

   



}

