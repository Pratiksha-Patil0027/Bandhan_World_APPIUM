package pages.claimpoints;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class DealerPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_dealerValue")
	public WebElement dealerName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_change")
	public WebElement change_Btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/date")
	public WebElement inv_Date_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/invoiceEditText")
	public WebElement inv_No_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Invoice_photo")
	public WebElement inv_PhotoIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvAttachlable")
	public WebElement attachDoc_lable_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cl_browse")
	public WebElement browseFile_Option_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cl_camera")
	public WebElement camera_Option_Element;

	@AndroidFindBy(id = "com.google.android.providers.media.module:id/icon_thumbnail")
	public List<WebElement> actualImage_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement warning_ToastMsg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvNext")
	public WebElement nextBtn_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	


	
	public DealerPage(AndroidDriver driver) {
		super(driver);
	}

	

	public String get_DealerName()
	{
		return getText(dealerName_Element);
	}

	public void clickOn_ChnageBtn()
	{
		 clickElement(change_Btn_Element);
	}

  public String get_PurchaseDate()
	{
		return getText(inv_Date_Element);
	}


	public void enter_InvNo(String invNo)
	{
		sendText(inv_No_Element, invNo);
	}

	public void clickOn_InvPhotoIcon()
	{
		 clickElement(inv_PhotoIcon_Element);
	}

public String get_AttachDocLable()
	{
		return getText(attachDoc_lable_Element);
	}


	public void clickOn_BrowseFileOption()
	{
		 clickElement(browseFile_Option_Element);
	}

	public String get_CameraOptionLable()
	{
		return getText(camera_Option_Element);
	}

	public String get_BrowseFileOptionLable()
	{
		return getText(browseFile_Option_Element);
	}

	public void clickOn_BrowseFileOption(int i)
	{
		WebElement image =actualImage_Elements.get(i);
		 clickElement(image);
	}

	public String get_WarningToastMsg()
	{
		return getText(warning_ToastMsg_Element);
	}


	public void clickOn_CancelBtn()
	{
		
		 clickElement(cancelBtn_Element);
	}

	public void clickOn_NextBtn()
	{
		
		 clickElement(nextBtn_Element);
	}



}
