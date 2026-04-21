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
	try {
		clickElement(crossIcon_Element);
	} catch (Exception e) {
		System.out.println("Cross icon not available");
	}
	
}


public void enter_TextInSerachField(String name)
{
  sendText(searchField_Element, name);
}
	

 public void clickOn_MapNewDealerBtn()
{
	clickElement(mapNewDealerBtn_Element);
}


public boolean verifyMapNewDealerBtnisdisplay()
{
	return isElementVisible(mapNewDealerBtn_Element);
}

public List<String> get_DealerNameList()
{
	return getTextsFromElements(dealerName_Elements);
}


public boolean isAddedDealerDisplayed(String expectedDealerName) throws InterruptedException {

    int maxScrolls = 5;

    for (int i = 0; i < maxScrolls; i++) {

        List<String> dealerList = get_DealerNameList();
Thread.sleep(1000);
        if (dealerList != null && !dealerList.isEmpty()) {
            for (String dealer : dealerList) {
				System.out.println("expectedDealerName : "+ expectedDealerName);
				System.out.println("actualDealerName : "+ dealer);
                if (dealer.equalsIgnoreCase(expectedDealerName)) {
                    return true; //  dealer found
                }
            }
        }

        // Scroll down if not found
        scrollDownSafe();
    }

    return false; //  not found after scrolling
}


public String get_DealerNameFromList(int i)
{
	waitForListToLoad(dealerName_Elements);
	WebElement element = dealerName_Elements.get(i);
	return getText(element);
}

public boolean verify_DealerListisDisplay() {
    if (dealerName_Elements == null || dealerName_Elements.isEmpty()) {
        return false;
    }
    return isElementVisible(dealerName_Elements.get(0));
}

public boolean verify_RadioBtnisDisplay() {
    if (radioBtn_Elements == null || radioBtn_Elements.isEmpty()) {
        return false;
    }
    return isElementVisible(radioBtn_Elements.get(0));
}

	

public void clickOn_RadioBtn(int i)
{
	waitForListToLoad(radioBtn_Elements);
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
	
public String selectFirstVisibleRadioAndGetDealer() {

    int maxScrolls = 5;   // safety to avoid infinite loop

    for (int scrollCount = 0; scrollCount < maxScrolls; scrollCount++) {

        int size = Math.min(radioBtn_Elements.size(), dealerName_Elements.size());

        for (int i = 0; i < size; i++) {

            try {
                WebElement radio = radioBtn_Elements.get(i);

                if (isElementVisible(radio)) {
                    radio.click(); //  click radio

                    // get dealer name from same row
                  return getText(dealerName_Elements.get(i));
                }

            } catch (Exception e) {
                // ignore & continue
            }
        }

        // none visible → scroll and retry
        scrollDownSafe();
    }

    return null; // nothing found
}



}
