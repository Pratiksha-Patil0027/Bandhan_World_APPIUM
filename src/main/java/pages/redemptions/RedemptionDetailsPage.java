package pages.redemptions;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class RedemptionDetailsPage  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDeliveryAddressValue")
	public WebElement deliveredAddress_Element;
	
	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDeliveryMobileNoValue")
	public WebElement deliveredMobileNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPinCodeValue")
	public WebElement pinCodeValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCityValue")
	public WebElement cityValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvStateValue")
	public WebElement stateValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDistrictValue")
	public WebElement districtValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRedemptionNo")
	public WebElement redemptionNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDateLabel")
	public WebElement redemptionDate_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvredemProductName")
	public WebElement productName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvredemProductDesc")
	public WebElement productDesc_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvQtyValue")
	public WebElement productQty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public WebElement productPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSValue")
	public WebElement TDSPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTotalRedeemPointsValue")
	public WebElement TotalRedeemPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSLabel")
	public WebElement TDSPercentage_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/rewardPdfDownload")
	public WebElement downloadPDF_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;

	@AndroidFindBy(id = "//android.widget.Toast[@text=\"PDF download started.\"]")
	public WebElement downloadStartedMsg_Element;

	
	
	public RedemptionDetailsPage(AndroidDriver driver) {
		super(driver);
	}


public String get_DeliveredAddress()
	{
    return  getText(deliveredAddress_Element);
	}

	public String get_DeliveredMobileNo()
	{
     return getText(deliveredMobileNo_Element);
	}

	public String get_PinCodeValue()
	{
     return getText(pinCodeValue_Element);
	}

	public String get_CityValue()
	{
     return getText(cityValue_Element);
	}

	public String get_StateValue()
	{
     return getText(stateValue_Element);
	}

	public String get_DistrictValue()
	{
     return getText(districtValue_Element);
	}

	public String get_RedemptionNo()
	{
     return getText(redemptionNo_Element);
	}

	public String get_RedemptionDate()
	{
     return getText(redemptionDate_Element);
	}

	public String get_ProductName()
	{
     return getText(productName_Element);
	}

	public String get_ProductDesc()
	{
     return getText(productDesc_Element);
	}

	public String get_ProductQty()
	{
     return getText(productQty_Element);
	}

	public String get_ProductPoints()
	{
     return getText(productPoints_Element);
	}

	public String get_TDSPoints()
	{
     return getText(TDSPoints_Element);
	}

	public String get_TotalRedeemPoints()
	{
     return getText(TotalRedeemPoints_Element);
	}

	public String get_TDSPercentage()
	{
     return getText(TDSPercentage_Element);
	}

	public String get_DownloadStartedText()
	{
     return getText(downloadStartedMsg_Element);
	}

	public void clickOn_DownloadPdf()
	{
     clickElement(downloadPDF_Element);
	}

	public void clickOn_CancelBtn()
	{
     clickElement(cancelBtn_Element);
	}


    
}
	
	



