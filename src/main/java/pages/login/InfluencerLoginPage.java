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

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
    public WebElement warningText_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/otp_no")
    public WebElement enterOtp_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
    public WebElement otp_SubmitBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/buttonAccept")
    public WebElement eulaPage_IAgreeBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/resendOtp")
    public WebElement resendOtpBtn_Element;

    
   
   
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

    public boolean verifyEnterOtpFieldDisplay()
    {
      return enterOtp_Element.isDisplayed();
    } 
   

     public void enterOTP(String otp)
    {
        sendText(enterOtp_Element,otp);
    }

    public void clickOn_OtpSubmit_Btn()
    {
        clickElement(otp_SubmitBtn_Element);
    }

    public void clickOn_ResendOtp_Btn()
    {
        clickElement(resendOtpBtn_Element);
    }

    
     public void clickOn_Eula_IAgree_Btn()
    {
      try {
        clickIfPresent(eulaPage_IAgreeBtn_Element, 2);
           
        } catch (Exception e) {
            
            System.out.println("Eula page not available");
        }
        
    }


    public String get_warningTextMsg()
    {
       return getText(warningText_Element);
    }

    
}

