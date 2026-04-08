package pages.insurancekyc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class KYCDetailsPage extends BasePage {


	By insuranceDialog_ProceedBtn_Locator = By.id("com.prowess.apps.bandhan.world:id/tv_submit");
	
	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_title")
	public WebElement insuranceDialog_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_title")
	public WebElement universal_WarningDialog_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_ok")
	public WebElement universal_WarningDialog_OkBtn_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").instance(2)")
	public WebElement universal_WarningDialog_PermissionOption_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Location\")")
	public WebElement universal_WarningDialog_Location_Element;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/allow_foreground_only_radio_button")
	public WebElement universal_WarningDialog_AllowOnly_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/nomineeNameEditText")
	public WebElement nominee_EnterName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/nomineeGenderAutoComplete")
	public WebElement gender_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/nomineeDOBEditText")
	public WebElement DOB_Element;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement calender_OkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/AadharNoEditText")
	public WebElement aadharNumber_Field_Element;
	
	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Aadhar_front_photo")
	public WebElement aadharPhoto_Front_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Aadhar_back_photo")
	public WebElement aadharPhoto_Back_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Supporting_doc")
	public WebElement documentPhoto_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement snackBar_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_pan_photo")
	public WebElement personalPage_PanPhoto_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/maritalStatusAutoComplete")
	public WebElement personalPage_MaritalStatus_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnsubmit")
	public WebElement submitBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/noChildrenEditText")
	public WebElement noOfChildren_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement dialogAlert_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
	public WebElement dialogAlert_YesBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_success_title")
	public WebElement success_Window_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_ok")
	public WebElement success_Window_OkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/hasVehicleYes")
	public WebElement vehicle_ToggleBtn_YES_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/hasVehicleNo")
	public WebElement vehicle_ToggleBtn_NO_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/vehicleTypeAutoComplete")
	public WebElement vehicle_VehicleTypes_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/vehicleNumberEditText")
	public WebElement vehicle_VehicleNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/makeEditText")
	public WebElement vehicle_ManufacturedBy_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/modelEditText")
	public WebElement vehicle_Model_Element;

	
	public KYCDetailsPage(AndroidDriver driver) {
		super(driver);
	}

	
	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void clickOn_ProceedBtn() {
		clickIfPresent(insuranceDialog_ProceedBtn_Locator, 1);
	}

	public String get_InsuranceDialog_Text() {
		return getText(insuranceDialog_Text_Element);
	}

public void universal_WarningDialogBox_isDisplay()
{
   try {
	     if(universal_WarningDialog_Element.isDisplayed())
		 {
			clickElement(universal_WarningDialog_OkBtn_Element);
			clickElement(universal_WarningDialog_PermissionOption_Element);
			clickElement(universal_WarningDialog_Location_Element);
			clickElement(universal_WarningDialog_AllowOnly_Element);
		 }

   } catch (Exception e) {
	
   }
}


public void navigateBackToPersonalDetailsPage() {

		int maxBackPress = 5; // safety limit

		while (!isElementVisible(nominee_EnterName_Element) && maxBackPress-- > 0) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		}

		if (!isElementVisible(nominee_EnterName_Element)) {
			throw new RuntimeException("Failed to navigate back to Home Dashboard");
		}
	}

	public void enter_NomineeName(String input)
	{
		sendText(nominee_EnterName_Element, input);
	}

	public void clickOn_GenderField() {
		clickIfPresent(gender_Element, 1);
	}

	public void clickOn_DOBField() {
		clickIfPresent(DOB_Element, 1);
	}

	public void clickOn_CalenderOkBtn() {
		clickIfPresent(calender_OkBtn_Element, 1);
	}
	
public void enter_AadharNumber(String input)
	{
		sendText(aadharNumber_Field_Element, input);
	}

   public void clickOn_AadharPhoto_Front() {
		clickIfPresent(aadharPhoto_Front_Element, 1);
	}
	 
	  public void clickOn_AadharPhoto_Back() {
		clickIfPresent(aadharPhoto_Back_Element, 1);
	}

	public void clickOn_DocumentPhoto() {
		clickIfPresent(documentPhoto_Element, 1);
	}
	
	 public String get_SnackBar_Text() {
		return getText(snackBar_Text_Element);
	}

	public void waitForSnackbarToDisappear() {
    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");

    new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.invisibilityOfElementLocated(snackbar));
}

	public void clickOn_PanPhoto() {
		clickAfterScroll(personalPage_PanPhoto_Element,"com.prowess.apps.bandhan.world:id/iv_pan_photo" );
		//clickIfPresent(personalPage_PanPhoto_Element, 1);
	}
	 
	public void clickOn_MaritalStatusField() {
		clickIfPresent(personalPage_MaritalStatus_Element, 1);
	}

	public void clickOn_SubmitBtn() {
		clickIfPresent(submitBtn_Element, 1);
	}

	public void clickOn_NoOfChildrenField() {
		clickIfPresent(noOfChildren_Element, 1);
	}

	public boolean verify_NoOfChildrenField_isDisplay()
	{ 
		scrollDownSmall();
		return isElementVisible(noOfChildren_Element);
	}
	 
     public void enter_noofChildren(String input)
	{
		 scrollToId("com.prowess.apps.bandhan.world:id/noChildrenEditText");
		sendText(noOfChildren_Element, input);
	}

	 public String get_DialogAlreat_TitleText(){
		return getText(dialogAlert_Title_Element);
	}
	
	public void clickOn_DialogAlert_YesBtn() {
		clickIfPresent(dialogAlert_YesBtn_Element, 1);
	}

	public String get_Success_TitleText(){
		return getText(success_Window_Element);
	}

	public void clickOn_SuccessDialog_OkBtn() {
		clickIfPresent(success_Window_OkBtn_Element, 1);
	}

	public void clickOn_Vehicle_ToggleYesBtn() {
		clickIfPresent(vehicle_ToggleBtn_YES_Element, 1);
	}

	public void clickOn_Vehicle_ToggleNoBtn() {
		clickIfPresent(vehicle_ToggleBtn_NO_Element, 1);
	}
	 
	public void clickOn_Vehicle_TypesDropField() {
		clickIfPresent(vehicle_VehicleTypes_Element, 1);
	}

	public boolean verify_vehicleTypesField_isDisplay()
	{
      return isElementVisible(vehicle_VehicleTypes_Element);
	}

	public void enter_VehicleNumber(String input)
	{
		sendText(vehicle_VehicleNo_Element, input);
	}

	public void enter_Vehicle_Manufactured(String input)
	{
		sendText(vehicle_ManufacturedBy_Element, input);
	}

	public void enter_VehicleModel(String input)
	{
		sendText(vehicle_Model_Element, input);
	}
	
	
}