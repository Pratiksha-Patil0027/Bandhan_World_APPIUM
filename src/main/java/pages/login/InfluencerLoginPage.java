package pages.login;

import org.openqa.selenium.WebElement;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class InfluencerLoginPage extends BasePage {

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/user_mobile_no")
    public WebElement enter_MobileNo_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvGetOTP")
    public WebElement getOtp_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/otp_no")
    public WebElement enterOtp_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
    public WebElement otp_SubmitBtn_Element;

    
   
    // Constructor
    public InfluencerLoginPage(AndroidDriver driver) {
        super(driver);
    }



    public boolean verifyEnterMobileNoFieldDisplay()
    {
      return enter_MobileNo_Element.isDisplayed();
    } 
   
    public void enterMobileNumber(String mobileNUmber)
    {
        sendText(enter_MobileNo_Element,mobileNUmber);
    }

    public void clickOn_GetOtp_Btn()
    {clickElement(getOtp_Element);
    }

     public void enterOTP(String otp)
    {
        sendText(enterOtp_Element,otp);
    }

    public void clickOn_OtpSubmit_Btn()
    {
        clickElement(otp_SubmitBtn_Element);
    }


}

