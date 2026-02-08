package pages.mycustomer.influencer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class InfluencerKYCPage extends BasePage {

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tvHeading2")
    public WebElement Header_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tv_PanStatus")
    public WebElement PanStatus_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/tv_AadhaarStatus\")")
    public WebElement AadharStatus_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tv_AadhaarKYCDate")
    public WebElement AadharDate_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tv_panKYCDate")
    public WebElement PanDate_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_pan_History")
    public WebElement PanHistory_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btnPan")
    public WebElement PanScan_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_aadhar_History")
    public WebElement AadharHistory_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btnAadhar")
    public WebElement AadharScan_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_panPhoto")
    public WebElement pancard_Capture_Icon_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btnsubmit")
    public WebElement pancard_SubmitBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tvAttachlable")
    public WebElement attachDocument_Label_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/cl_browse")
    public WebElement browseFile_Option_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/cl_camera")
    public WebElement capturePhoto_Option_Element;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]/android.view.View")
    public List<WebElement> vivo_browse_Actual_Image_Elements;

    @AndroidFindBy(xpath = "//android.widget.GridView[@resource-id=\"com.google.android.providers.media.module:id/picker_tab_recyclerview\"]/android.widget.FrameLayout")
    public List<WebElement> samsung_browse_Actual_Image_Elements;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(1)")
    public WebElement browse_Collection_Option_Element;

    @AndroidFindBy(uiAutomator = " new UiSelector().text(\"Albums\")")
    public WebElement browse_Albums_Option_Element;

    @AndroidFindBy(uiAutomator  = "new UiSelector().resourceId(\"com.google.android.providers.media.module:id/icon_thumbnail\").instance(0)")
    public WebElement browse_Favourites_Folder_Element;

    @AndroidFindBy(accessibility = "Crop")
    public WebElement browse_CropIcon_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_panPhoto")
    public WebElement uploaded_PAN_Image_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/infoMessage")
    public WebElement pancard_VerificationInfo_Text_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_panEdit")
    public WebElement pancard_EditBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_alert_title")
    public WebElement exit_Title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_no")
    public WebElement exit_No_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_yes")
    public WebElement exit_Yes_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_alert_title")
    public WebElement confirm_Title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_no")
    public WebElement confirm_No_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_yes")
    public WebElement confirm_Yes_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_universal_success_title")
    public WebElement panKyc_Success_Window_Title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_universal_info_text")
    public WebElement panKyc_Success_Window_InfoText_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_universal_info_ok")
    public WebElement panKyc_Success_Window_OkBtn_Element;


    
    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tv_StatusValue")
    public WebElement kyc_History_Status_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tv_RemarkValue")
    public WebElement kyc_History_Remark_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/is_full_aadhar")
    public WebElement fullAadhar_Checkbox_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/titleMsgFront")
    public WebElement fullAadhar_Scan_Title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_aadhar_font_Photo")
    public WebElement fullAadhar_ImageScanIcon_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/titleMsgFront")
    public WebElement fronSideAadhar_Scan_Title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/titleMsgBack")
    public WebElement backSideAadhar_Scan_Title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_aadhar_font_Photo")
    public WebElement frontAadhar_ImageScanIcon_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_adhar_back_Photo")
    public WebElement backAadhar_ImageScanIcon_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/snackbar_text")
    public WebElement error_ToastMsg_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_aadhaarFrontEdit")
    public WebElement aadharFront_EditBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/iv_aadhaarBackEdit")
    public WebElement aadharBack_EditBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/infoMessageFront")
    public WebElement frontAadhar_VerificationInfo_Text_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/infoMessageBack")
    public WebElement backAadhar_VerificationInfo_Text_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/validateAadhaar")
    public WebElement aadhar_Validate_Btn_Element;

    // @AndroidFindBy(id = "")
    // public WebElement _Element;

    // @AndroidFindBy(id = "")
    // public WebElement _Element;

    public InfluencerKYCPage(AndroidDriver driver) {
        super(driver);
    }

    public String get_Header_Text() {
        return getText(Header_Element);
    }

    public String get_InflNameOnHeader() {
        String fullName = Header_Element.getText();
        String[] part = fullName.split("\\|");
        String inflName = part[1].trim().replaceAll("\\s+", " ");
        return inflName;
    }

    public String get_InflAccountOnHeader() {
        String fullName = Header_Element.getText();
        String[] part = fullName.split("\\|");
        String[] account = part[0].split("\\-");
        String inflAccount = account[1].trim().replaceAll("\\s+", " ");
        return inflAccount;
    }

    public String get_PANStatus_Text() {
        return getText(PanStatus_Element);
    }

    public String get_AadharStatus_Text() {
        return getText(AadharStatus_Element);
    }

    public void clickOn_PanHistory_Btn() {
        clickElement(PanHistory_Btn_Element);
    }

    public void clickOn_PanScan_Btn() {
        clickElement(PanScan_Btn_Element);

    }

     public boolean verify_PanScan_Btn_isDisplayed() {
        return isElementVisible(PanScan_Btn_Element,1);

    }

    public void clickOn_AadarHistory_Btn() {
        clickElement(AadharHistory_Btn_Element);
    }

    public void clickOn_AadharScan_Btn() {
        clickElement(AadharScan_Btn_Element);
    }

    public void clickOn_PanCard_Capture_Icon() {
        clickIfPresent(pancard_Capture_Icon_Element, 2);
      
    }

    public void clickOn_PanCard_Submit_Btn() {
         clickIfPresent(pancard_SubmitBtn_Element, 2);
}


   public boolean verify_SubmitBtn_isDisplay() {
     return isElementVisible(pancard_SubmitBtn_Element, 2);
   
}


    public String get_AttachDocument_Label_Text() {
        return getText(attachDocument_Label_Element);
    }

    public void clickOn_BrowseFile_Option() {
        clickIfPresent(pancard_Capture_Icon_Element, 2);
         clickIfPresent(browseFile_Option_Element, 2);
    }

    public void clickOn_CapturePhoto_Option() {
        clickIfPresent(pancard_Capture_Icon_Element, 2);
         clickIfPresent(capturePhoto_Option_Element, 2);
    }

    public boolean verify_BrowseFile_Option_isDisplay() {

         clickIfPresent(pancard_Capture_Icon_Element, 2);
        return isElementVisible(browseFile_Option_Element, 2);
       
    }

    public boolean verify_CaptureCamera_Option_isDisplay() {

        clickIfPresent(pancard_Capture_Icon_Element, 2);
        return isElementVisible(capturePhoto_Option_Element, 2);
        
    }

    public void clickOn_Browse_Collections_Option() {
        clickElement(browse_Collection_Option_Element);
    }

    public void clickOn_Browse_Albums_Option() {
        clickElement(browse_Albums_Option_Element);
    }

    public void clickOn_Browse_Favourite_Folder() {
        clickElement(browse_Favourites_Folder_Element);
    }

    public void selectvivoBrowseImageByIndex(int index) {
        WebElement imageElement = vivo_browse_Actual_Image_Elements.get(index);
        clickElement(imageElement);
    }

    // public void selectsamsungBrowseImageByIndex(int index)
    // {
    // WebElement imageElement= samsung_browse_Actual_Image_Elements.get(index);
    // clickElement(imageElement);
    // }

    public void selectSamsungBrowseImageByIndex(int index) {

        int maxScrolls = 5;

        for (int attempt = 0; attempt < maxScrolls; attempt++) {

            List<WebElement> images = samsung_browse_Actual_Image_Elements;

            if (index < images.size()) {
                WebElement image = images.get(index);

                if (isElementVisible(image,1)) {
                    clickElement(image);
                    return;
                }
            }

            // Image not visible yet → scroll gallery
            scrollDownSafe();
            waitForListToLoad();
        }

        throw new NoSuchElementException(
                "Image at index " + index + " not found after scrolling gallery");
    }

    public void clickOn_Browse_Done_Icon() {
        clickElement(browse_CropIcon_Element);
    }


   public String get_PanCard_VerificationInfo_Text() {
    String initialText = pancard_VerificationInfo_Text_Element.getText().trim();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    return wait.until(d -> {
        String current = pancard_VerificationInfo_Text_Element.getText().trim();
        return (!current.isEmpty() && !current.equals(initialText)) ? current : null;
    });
}


    public void clickOn_PanCard_EditBtn() {
      clickIfPresent(pancard_EditBtn_Element,2);
    }

    public String get_ExitTitle_Text() {
        return getText(exit_Title_Element);
    }

    public void clickOn_Exit_NoBtn() {
        clickElement(exit_No_Btn_Element);
    }

    public void clickOn_Exit_YesBtn() {
        clickElement(exit_Yes_Btn_Element);
    }

    public String get_Confirm_Title_Text() {
        return getText(confirm_Title_Element);
    }

    public void clickOn_Confirm_NoBtn() {
        clickElement(confirm_No_Btn_Element);
    }

    public void clickOn_Confirm_YesBtn() {
        clickElement(confirm_Yes_Btn_Element);
    }


    public String get_PanKyc_SucccessWindow_Title_Text() {
        return getText(panKyc_Success_Window_Title_Element);
    }

    public String get_PanKyc_SucccessWindow_Info_Text() {
        return getText(panKyc_Success_Window_InfoText_Element);
    }

    public void clickOnPanKyc_SucccessWindow_OkBtn() {
        clickIfPresent(panKyc_Success_Window_OkBtn_Element,2);
       
    }

    public String get_Kyc_History_Status_Text() {
        return getText(kyc_History_Status_Element);
    }

    public String get_Kyc_History_Remark_Text() {
        return getText(kyc_History_Remark_Element);
    }

    public void clickOn_FullAadhar_Checkbox() {
        clickElement(fullAadhar_Checkbox_Element);
    }

    public String get_FullAadhar_Scan_TitleText() {
        return getText(fullAadhar_Scan_Title_Element);
    }

    public void clickOn_FullAadhar_ScanImageIcon() {
        clickElement(fullAadhar_ImageScanIcon_Element);
    }

    public String get_FrontAadhar_Scan_TitleText() {
        return getText(fronSideAadhar_Scan_Title_Element);
    }

    public String get_BackAadhar_Scan_TitleText() {
        return getText(backSideAadhar_Scan_Title_Element);
    }

    public void clickOn_FrontAadhar_ScanImageIcon() {
        clickElement(frontAadhar_ImageScanIcon_Element);
    }

    public void clickOn_BackAadhar_ScanImageIcon() {
        clickElement(backAadhar_ImageScanIcon_Element);
    }

    public String get_Error_Toast_Text() {
        return getText(error_ToastMsg_Element);
    }

    public void clickOn_AadharFront_EditBtn() {
        clickElement(aadharFront_EditBtn_Element);
    }

    public void clickOn_AadharBack_EditBtn() {
        clickElement(aadharBack_EditBtn_Element);
    }

    public String get_FrontAadhar_VerificationInfo_Text() {
        return getText(frontAadhar_VerificationInfo_Text_Element);
    }

    public String get_BackAadhar_VerificationInfo_Text() {
        return getText(backAadhar_VerificationInfo_Text_Element);
    }

    public void clickOn_Aadhar_ValidateBtn() {
        clickElement(aadhar_Validate_Btn_Element);
    }

    public boolean verify_Aadhar_ValidateBtn_Display() {
        return isElementVisible(aadhar_Validate_Btn_Element,1);
    }

    public boolean verifyAnyKYCStatusPending() {

        return get_AadharStatus_Text().equalsIgnoreCase("Pending")
                || get_PANStatus_Text().equalsIgnoreCase("Pending");
    }

}
