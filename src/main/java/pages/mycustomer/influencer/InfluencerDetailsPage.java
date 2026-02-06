package pages.mycustomer.influencer;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class InfluencerDetailsPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/tv_skip_btn\")")
    public WebElement insuranceDialog_SkipBtn_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/tv_submit\")")
    public WebElement insuranceDilog_ProceedBtn_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Business Card\")")
    public WebElement bussinessCardMenu_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"KYC\")")
    public WebElement kycMenu_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Website\")")
    public WebElement websiteMenu_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Family Details\")")
    public WebElement familyDetailsMenu_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/ivMenuIcon\").instance(4)")
    public WebElement updown_ArrowIcon_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"End Meet\")")
    public WebElement endMeetMenu_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/dialog_alert_title\")")
    public WebElement endMeet_AlretDialogTitle_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_alert_text")
    public WebElement endMeet_AlretDialogText_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_no")
    public WebElement endMeet_No_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_yes")
    public WebElement endMeet_Yes_Btn_Element;

    
    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_yes")
    public WebElement endMeet_Ok_Btn_Element;

    

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/ivBackbtn")
     public WebElement backBtn_Arrow_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/constraintBanner")
    public WebElement insuranceBanner_Image_Element;

    public InfluencerDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOn_InsuranceDialog_SkipBtn() {
        try {
            if (insuranceDialog_SkipBtn_Element.isDisplayed())
                clickElement(insuranceDialog_SkipBtn_Element);
        } catch (Exception e) {

        }

    }

    public void clickOn_InsuranceDialog_ProceedBtn() {
        try {
            clickElement(insuranceDilog_ProceedBtn_Element);
        } catch (Exception e) {
            throw e;
        }

    }

     public void clickOn_BusiessCard_Menu() {

            clickElement(bussinessCardMenu_Element);    
    }

     public void clickOn_KYC_Menu() {

            clickElement(kycMenu_Element);    
    }


     public void clickOn_Website_Menu() {

            clickElement(websiteMenu_Element);    
    }

     public void clickOn_FamilyDetails_Menu() {

            clickElement(familyDetailsMenu_Element);    
    }

     public void clickOn_UpDown_Arrow_() {

            clickElement(updown_ArrowIcon_Element);    
    }

     public void clickOn_EndMeet_Menu() {
        try
        {
            if(endMeetMenu_Element.isDisplayed())
            {
                 clickElement(endMeetMenu_Element);
            }
        }catch(Exception e)
        {
            clickOn_UpDown_Arrow_();
             clickElement(endMeetMenu_Element);

        }
               
    }


    public void endMeet()
    {
        clickOn_EndMeet_Menu();
        clickOn_EndMeetDialog_YesBtn();
        clickOn_EndMeet_OkBtn();
    }


    public String getText_EndMeet_AlertDialog_Title() {
        return getText(endMeet_AlretDialogTitle_Element);
    }

     public String getText_EndMeet_AlertDialog_Text() {
        return getText(endMeet_AlretDialogText_Element);
    }

 public void clickOn_EndMeetDialog_NoBtn() {
            clickElement(endMeet_No_Btn_Element);    
    }

    public void clickOn_EndMeetDialog_YesBtn() {
            clickElement(endMeet_Yes_Btn_Element);    
    }

    public void clickOn_EndMeet_OkBtn() {
            clickElement(endMeet_Ok_Btn_Element);    
    }
     

    public void clickOn_BackBtn_Arrow() {
            clickElement(backBtn_Arrow_Element);    
    }

    public boolean insuranceBanner_Image_isDisplay()
    {
   return insuranceBanner_Image_Element.isDisplayed();
    }
    
    
     
    
}
