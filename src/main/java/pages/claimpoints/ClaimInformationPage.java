package pages.claimpoints;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class ClaimInformationPage  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_customer_name")
	public WebElement cust_Name_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_cust_mobileNo")
	public WebElement cust_MobileNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_site_address")
	public WebElement siteAddress_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_site_photo")
	public WebElement sitePhoto_Icon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_Invoice_No")
	public WebElement invNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_Invoice_Date")
	public WebElement invDate_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Invoice_photo")
	public WebElement invPhoto_Icon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_brand_Name")
	public WebElement added_BrandName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_Product_Name")
	public WebElement added_ProductName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/ProductImage")
	public WebElement productImage_Icon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvsubmit")
	public WebElement submitBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement alert_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_text")
	public WebElement alert_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_no")
	public WebElement alert_DialogBox_NoBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
	public WebElement alert_DialogBox_YesBtn_Element;

	

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	
	public ClaimInformationPage(AndroidDriver driver) {
		super(driver);
	}


public void enter_CustomerName(String name)
{
  sendText(cust_Name_Element, name);
}

public void enter_CustomerMobileNo(String mobileNo)
{
  sendText(cust_MobileNo_Element, mobileNo);
}

public void enter_SiteAddress(String address)
{
	scrollToId("com.prowess.apps.bandhan.world:id/tiet_site_address");
  sendText(siteAddress_Element, address);
}

public void clickOn_SitePhotoIcon()
	{
		 clickElement(sitePhoto_Icon_Element);
	}

	public String get_BrandName_Text()
	{
		return getTextAfterScroll(added_BrandName_Element,"com.prowess.apps.bandhan.world:id/tv_brand_Name");
	}

	public String get_ProductName_Text()
	{
		return getTextAfterScroll(added_ProductName_Element,"com.prowess.apps.bandhan.world:id/tv_Product_Name");
	}
	
	public void clickOn_ProductImageIcon()
	{
		 clickAfterScroll(productImage_Icon_Element,"com.prowess.apps.bandhan.world:id/ProductImage");
	}

	public boolean waitUntilToastDisappears() {

    try {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(
                AppiumBy.id("com.prowess.apps.bandhan.world:id/snackbar_text")));

    } catch (Exception e) {

        return false;
    }
}
	public void clickOn_CancelBtn() {
		waitUntilToastDisappears();
		clickElement(cancelBtn_Element);
	}

	public void clickOn_SubmitBtn() {
		clickElement(submitBtn_Element);
	}

	public String get_AlertDialogBoxTitle_Text() {
		return getText(alert_DialogBox_Title_Element);
	}

	public String get_AlertDialogBox_Text() {
		return getText(alert_DialogBox_Text_Element);
	}

	public void clickOn_Alert_DialogBox_NoBtn() {
		clickIfPresent(alert_DialogBox_NoBtn_Element,1);
	}

	public void clickOn_Alert_DialogBox_YesBtn() {
		clickIfPresent(alert_DialogBox_YesBtn_Element,1);
	}

	



	



}

