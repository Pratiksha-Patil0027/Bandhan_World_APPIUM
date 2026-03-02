package pages.claimpoints;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class ClaimDetailsPage  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dealerNameText")
	public WebElement added_DealerName_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/invoiceText")
	public WebElement added_ClaimInvNo_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dateText")
	public WebElement added_ClaimInvDate_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/total")
	public WebElement added_ClaimTotalPoints_OnHeader_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/claimIdText")
	public WebElement added_ClaimIdText_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/productCode")
	public WebElement added_ProductCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/downLoadPDF")
	public WebElement pdfIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/qtyText")
	public WebElement added_ClaimQty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/PointText")
	public WebElement added_ClaimPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalPointText")
	public WebElement added_ClaimTotalPoints_Element;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text=\"PDF download started.\"]")
	public WebElement pdfDownloadStartedText_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement close_Btn_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;
	


	
	public ClaimDetailsPage(AndroidDriver driver) {
		super(driver);
	}

	


}

