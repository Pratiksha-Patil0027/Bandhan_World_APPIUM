package pages.dreamgift;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class DreamGiftPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/noResultText")
	public WebElement noResultAvailable_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/add_fab")
	public WebElement fab_Btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/searchview")
	public WebElement searchField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvGiftCodeValue")
	public List<WebElement> giftCode_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etGiftCode")
	public WebElement addGift_GiftCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etGiftName")
	public WebElement addGift_GiftName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etGiftDesc")
	public WebElement addGift_GiftDesc_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etTotalPoints")
	public WebElement addGift_TotalPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement addGift_SubmitBtn_Element;

   @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement alert_Dialog_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
	public WebElement alert_Dialog_YesBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDeleteIcon")
	public WebElement addedGift_DeleteIcon_Element;


	
	public  DreamGiftPage(AndroidDriver driver) {
		super(driver);
	}

	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public String get_NoResultAvailable_Text() {
		return getText(noResultAvailable_Text_Element);
	}

	public void clickOn_FabBtn()
	{
		clickElement(fab_Btn_Element);
	}
	
	
	public void enter_GiftCode(String input)
	{ 
      sendText(searchField_Element,input);
	}

	public String get_SnackBarText() throws InterruptedException {
     
    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");
return getText(snackbar);
    
}

public String get_GiftCode() throws InterruptedException {
	Thread.sleep(2000);
	WebElement giftCode_Element= giftCode_Elements.get(0);
		return getText(giftCode_Element);
	}

	public void clickOn_Gift()
	{
		WebElement giftCode_Element= giftCode_Elements.get(0);
		clickElement(giftCode_Element);
	}

	public String get_AddGift_GiftCode() {
		return getText(addGift_GiftCode_Element);
	}

	public String get_AddGift_GiftName() {
		return getText(addGift_GiftName_Element);
	}

	public String get_AddGift_GiftDesc() {
		return getText(addGift_GiftDesc_Element);
	}
	
	public String get_AddGift_TotalPoints() {
		return getText(addGift_TotalPoints_Element);
	}

	public void clickOn_SubmitBtn()
	{
		clickElement(addGift_SubmitBtn_Element);
	}

	public String get_AlertDialog_Title() {
		return getText(alert_Dialog_Title_Element);
	}

	public void clickOn_AlertDialog_YesBtn()
	{
		clickElement(alert_Dialog_YesBtn_Element);
	}

	public void clickOn_DeleteIcon()
	{
		clickElement(addedGift_DeleteIcon_Element);
	}
	
	
}