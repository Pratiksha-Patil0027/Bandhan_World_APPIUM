package pages.claimpoints;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class DealerListPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvtitle")
	public WebElement  headerTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_close")
	public WebElement crossIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etSearch")
	public WebElement searchField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_addProspectDealer")
	public WebElement mapNewDealerBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvName")
	public List<WebElement> dealerName_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dealerCheck")
	public List<WebElement> radioBtn_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_mobileNoValue")
	public List<WebElement> mobileNo_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_cityValue")
	public List<WebElement> cityName_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_instruction")
	public WebElement newDealerWindow_InstructionText_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cancel")
	public WebElement newDealer_CancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/addDealer")
	public WebElement newDealer_AddBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/no_data")
	public WebElement newDealer_NoDataFound_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/errAlreadyExist")
	public WebElement dealerAlreadyExist_Element;

	

	//  @AndroidFindBy(id = "")
	// public WebElement _Element;

	


	
	public DealerListPage(AndroidDriver driver) {
		super(driver);
	}


public String get_HeaderTitle()
{
	return getText(headerTitle_Element);
}

	 public void clickOn_CrossIcon ()
{
	clickElement(crossIcon_Element);
}


public void enter_TextInSerachField(String name)
{
  sendText(searchField_Element, name);
}
	

 public void clickOn_MapNewDealerBtn()
{
	clickElement(mapNewDealerBtn_Element);
}

public List<String> get_DealerNameList()
{
	return getTextsFromElements(dealerName_Elements);
}
	

public void clickOn_RadioBtn(int i)
{
	WebElement element = radioBtn_Elements.get(i);
	clickElement(element);
}


public List<String> get_MobileNumberList()
{
	return getTextsFromElements(mobileNo_Elements);
}
	

public String get_NewDealerWindow_InstructionText()
{
	return getText(newDealerWindow_InstructionText_Element);
}


public String get_NewDealerWindow_NoDatFoundText()
{
	return getText(newDealer_NoDataFound_Element);
}

public String get_NewDealerWindow_DealerAlredyExistText()
{
	return getText(dealerAlreadyExist_Element);
}
	

public void clickOn_NewDealerWindow_CancelBtn()
{
	clickElement(newDealer_CancelBtn_Element);
}

public void clickOn_NewDealerWindow_AddBtn()
{
	clickElement(newDealer_AddBtn_Element);
}
	

}
