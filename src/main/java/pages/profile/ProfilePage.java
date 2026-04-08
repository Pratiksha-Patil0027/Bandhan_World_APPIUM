package pages.profile;

import java.util.Base64;
import java.util.NoSuchElementException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class ProfilePage extends BasePage {

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/showProfile")
    public WebElement profileShow_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/profileLabel")
    public WebElement profileLabel_Element;

    // @AndroidFindBy(uiAutomator  = "new UiSelector().text(\"English\")")
    // public WebElement english_Language_Element;

     @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/ivLogoutUser")
    public WebElement signoutBtn_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/ivProfileClose")
    public WebElement profileCloseBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_profile")
    public WebElement profile_image_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/tvName")
    public WebElement name_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/tvAddress")
    public WebElement address_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPhone")
    public WebElement phone_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvEmail")
    public WebElement email_Element;



    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/rv_milestone_profile")
    public WebElement milestone_list_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/tvMilestoneCount")
    public WebElement milestoneCount_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvBalanceCount")
    public WebElement balanceCount_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/tvLockCount")
    public WebElement lockCount_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/tvId")
    public WebElement id_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvLinkLegalDocument")
    public WebElement linkLegalDocumentBtn_Element;


    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvWebLink")
    public WebElement webLink_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDeleteAccount")
    public WebElement deleteAccountBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvOwnGarage")
    public WebElement ownGarage_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvGarageName")
    public WebElement owngarage_text_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvGarageAddress")
    public WebElement ownGarage_address_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPermanentAddress")
    public WebElement permanent_address_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvAadhaarNumber")
    public WebElement aadhar_number_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPanNumber")
    public WebElement pan_number_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDrivingLicenseNumber")
    public WebElement drivingLicenseNumber_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvLanguage")
    public WebElement language_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvOPTInDate")
    public WebElement optindate_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvAppVersion")
    public WebElement appversion_Element;

     @AndroidFindBy(id = "android:id/button1")
    public WebElement singout_YesBtn_Element;
   


    public AppiumBy SIGNOUT_DIALOG_TITLE = (AppiumBy) AppiumBy.id("android:id/alertTitle");
    public AppiumBy SIGNOUT_DIALOG_MESSAGE = (AppiumBy) AppiumBy.id("android:id/message");
    public AppiumBy SIGNOUT_BUTTON_POSITIVE = (AppiumBy) AppiumBy.id("android:id/button1");
    public AppiumBy SIGNOUT_BUTTON_NEGATIVE = (AppiumBy) AppiumBy.id("android:id/button2");

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/alertTitle")
    public WebElement logout_title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/profileLabel")
    public WebElement deleteAccount_header_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvName")
    public WebElement deleteAccount_infname_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDeleteMsg")
    public WebElement deleteAccount_text_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvErrorMsg")
    public WebElement deleteAccount_error_msg_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
    public WebElement deleteAccount_cancelBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
    public WebElement deleteAccount_submitBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCaptcha")
    public WebElement deleteAccount_captcha_text_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etEnterCaptcha")
    public WebElement deleteAccount_enter_captcha_text_Element;


    public ProfilePage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOn_profileShow() {
		try {
			clickIfPresent(profileShow_Element, 0);
		} catch (Exception e) {
			System.out.println("Profile dialog not shown");
		}
	}

    public String get_PageTitle(WebElement webElement) {
		return getText(webElement);
	}

    public String get_PageTitle(AppiumBy appiumby){
        return getText(appiumby);
    }

    public String verify_UserNameDisplay() {
		return getText(profileLabel_Element);
	}

    public boolean verify_PhoneNumberDisplay() throws InterruptedException {
         Thread.sleep(4000);
		return isElementVisible(phone_Element);
	}

    public boolean verify_InfluencerUniqueIdDisplay() throws InterruptedException {
         Thread.sleep(4000);
		return isElementVisible(id_Element);
	}

    public void clickOn_logoutBtn() {
		try {
			clickIfPresent(signoutBtn_Element, 0);
		} catch (Exception e) {
			System.out.println("Profile dialog not shown");
		}
	}

    public void clickOn_logout_YesBtn() {
		clickIfPresent(singout_YesBtn_Element,0);
	}

    

    public boolean clickOn_logoutBtnNo() {
		try {
			clickIfPresent(SIGNOUT_BUTTON_NEGATIVE, 0);
            return true;
		} catch (Exception e) {
            System.out.println("Profile dialog not shown");
            return false;
		}
	}

    public void clickondeleteaccountbtn(WebElement webElement) {
		try {
			clickIfPresent(webElement, 0);
		} catch (Exception e) {
			System.out.println("Profile dialog not shown");
		}
	}


    public void milestoneHorizontalScroll() {

        int maxSwipes = 5; // safety limit

        for (int swipe = 0; swipe < maxSwipes; swipe++) {
            swipeLeft();
        }
    }


    public boolean doesImageViewDifferFromPlaceholder(AppiumBy locator, String baselineImageBase64) {
        try {
            WebElement imageView = driver.findElement(locator);
            
            // Get screenshot of just the element
            byte[] elementScreenshot = imageView.getScreenshotAs(OutputType.BYTES);
            String currentImageBase64 = Base64.getEncoder().encodeToString(elementScreenshot);

            // You can use Appium's verifyVisual (if using Appium 2.0+ visual plugin)
            // or a standard Java image comparison library like AWT/OpenCV.
            // For simplicity, we compare strings (exact match check):
            return !currentImageBase64.equals(baselineImageBase64);
            
        } catch (Exception e) {
            System.err.println("Error during image comparison: " + e.getMessage());
            return false;
        }
    }

    public boolean isImageViewVisible() {
        return profile_image_Element.isDisplayed() && profile_image_Element.getSize().getWidth() > 0;
    }

    public String get_permanent_address_TextAfterScroll(WebElement element, String resourceId) {
        return get_text_after_scroll(resourceId);
    }

    public String get_Infl_State()
    {
        return getText(address_Element);
    }

    public String get_Infl_Mobileno()
    {
        return getText(phone_Element);
    }

    public void clickOn_Profile_CloseBtn()
    {
        clickIfPresent(profileCloseBtn_Element,0);
    }
    
    public boolean pointsVisibilityCheck(WebElement webElement) {
        if (getText(webElement).isBlank() || getText(webElement).isEmpty()) {
            return false;
        }
		return true;
	}

}
