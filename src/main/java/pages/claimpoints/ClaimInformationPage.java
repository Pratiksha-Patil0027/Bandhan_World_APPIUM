package pages.claimpoints;

import org.openqa.selenium.WebElement;

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

	@AndroidFindBy(id = "")
	public WebElement _Element;

	
	public ClaimInformationPage(AndroidDriver driver) {
		super(driver);
	}

	


}

