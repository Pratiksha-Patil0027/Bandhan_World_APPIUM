package pages.redemptions;

import org.openqa.selenium.WebElement;

import core.GlobalStore;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class RedemptionSummaryPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalClaimText")
	public WebElement cartPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/deliveryAddressText")
	public WebElement deliveredAddress_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/deliveryMobileNoText")
	public WebElement deliveredMobileNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/pinCodeText")
	public WebElement pinCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/stateText")
	public WebElement state_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/districtText")
	public WebElement district_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cityText")
	public WebElement city_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/panText")
	public WebElement panNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/checkoutCartProductName")
	public WebElement productCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/checkoutProductDescription")
	public WebElement productDesc_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public WebElement productPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvQtyValue")
	public WebElement qty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cartCheckoutDelete")
	public WebElement deleteIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement checkoutBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/noCartItem")
	public WebElement cartIsEmpty_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement declaration_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_text")
	public WebElement declaration_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_no")
	public WebElement declaration_DialogBox_EditAddressBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
	public WebElement declaration_DialogBox_Accept_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"OTP Verification\")")
	public WebElement OTP_Verification_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/otp_no")
	public WebElement otpVerification_EnterOTP_Field_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_cancel")
	public WebElement otpVerification_CancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_ok")
	public WebElement otpVerification_VerifyBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_title")
	public WebElement warning_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_text")
	public WebElement warning_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_warning_ok")
	public WebElement warning_OkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_success_title")
	public WebElement success_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_text")
	public WebElement success_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_ok")
	public WebElement success_DialogBox_OkBtn_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	public RedemptionSummaryPage(AndroidDriver driver) {
		super(driver);
	}



public boolean isErrorDisplayed(String errorMessage) {

    long endTime = System.currentTimeMillis() + 5000;

    while (System.currentTimeMillis() < endTime) {
        try {
            if (driver.getPageSource().contains(errorMessage)) {
                return true;
            }
        } catch (Exception ignored) {}
    }

    return false;
}


	public String get_CartPoints() {
		return getText(cartPoints_Element);
	}

	public String verify_BalancePoints_Calculation()
	{ 
        String old_balpoints = GlobalStore.get("BALANCE_POINTS");
        String cartpoints_str = GlobalStore.get("CATALOGUE_CARTPOINTS");

         int oldbalpoints_int = Integer.parseInt(old_balpoints);
int cartpoints_int = (int) Double.parseDouble(cartpoints_str);
 int new_balpoints = (oldbalpoints_int + cartpoints_int);
 System.out.println("new_balpoints : " + new_balpoints);
//String cartPoints = String.format("%.1f", (double) new_balpoints);
String newPoints = String.valueOf(new_balpoints);
System.out.println("newPoints : " + newPoints);
      return newPoints;
	}

	public void enter_DeliveredAddress(String input) {
		sendText(deliveredAddress_Element, input);
	}


	public String get_DeliveredAddress() {
		return getText(deliveredAddress_Element);
	}

	public String get_DeliveredMobileNo() {
		return getText(deliveredMobileNo_Element);
	}

	public String get_Pincode() {
		return getText(pinCode_Element);
	}

	public String get_City() {
		return getText(city_Element);
	}

	public String get_State() {
		return getText(state_Element);
	}

	public String get_District() {
		return getText(district_Element);
	}

	public String get_PanNo() {
		return getText(panNo_Element);
	}

	public void enter_MobileNo(String input) {
		sendText(deliveredMobileNo_Element, input);
	}

	public void enter_PinCode(String input) {
		sendText(pinCode_Element, input);
	}

	public void clear_StateField () {
		state_Element.clear();
	}

	public void enter_District(String input) {
		sendText(district_Element, input);
	}

	public void clear_CityField () {
		city_Element.clear();
	}

	public void enter_PANno(String input) {
		sendText(panNo_Element, input);
	}

	public String get_ProductCode() {
		return getText(productCode_Element);
	}

	public String get_ProductDesc() {
		return getText(productDesc_Element);
	}

	public String get_ProductPoints() {
		return getText(productPoints_Element);
	}

	public String get_Qty() {
		return getText(qty_Element);
	}

	public void clickOn_DeleteIcon() {
		clickElement(deleteIcon_Element);
	}

	public void clickOn_CancelBtn() {
		clickElement(cancelBtn_Element);
	}

	public void clickOn_CheckoutBtn() {
		clickIfPresent(checkoutBtn_Element,5);
	}

	public String get_CartIsEmpty_Text() {
		return getText(cartIsEmpty_Text_Element);
	}

	public String get_Declaration_Title() {
		return getText(declaration_DialogBox_Title_Element);
	}

	public String get_Declaration_Text() {
		return getText(declaration_DialogBox_Text_Element);
	}

	public void clickOn_Declaration_EditAddressBtn() {
		clickElement(declaration_DialogBox_EditAddressBtn_Element);
	}

	public void clickOn_Declaration_AcceptBtn() {
		clickElement(declaration_DialogBox_Accept_Element);
	}

	public String get_OTPVerification_Title() {
		return getText(OTP_Verification_Title_Element);
	}

	public void enter_OTPVerification_OTP(String otp) {
		sendText(otpVerification_EnterOTP_Field_Element, otp);
	}

	public void clickOn_OTPVerification_CancelBtn() {
		clickElement(otpVerification_CancelBtn_Element);
	}

	public void clickOn_OTPVerification_VerifyBtn() {
		clickElement(otpVerification_VerifyBtn_Element);
	}

	public String get_Warning_DialogBox_Title() {
		return getText(warning_Title_Element);
	}

	public String get_Warning_DialogBox_Text() {
		return getText(warning_Text_Element);
	}

	public void clickOn_Warning_DialogBox_OkBtn() {
		clickElement(warning_OkBtn_Element);
	}

	public String get_Success_DialogBox_Title() {
		return getText(success_DialogBox_Title_Element);
	}

	public String get_Success_DialogBox_Text() {
		return getText(success_DialogBox_Text_Element);
	}

	public void clickOn_Success_DialogBox_OkBtn() {
		clickElement(success_DialogBox_OkBtn_Element);
	}

}
