package pages.mycustomer.influencer;

import java.util.List;

import org.openqa.selenium.WebElement;

import core.GlobalStore;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class InfluencerListPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Influencer\")")
    public WebElement influencer_Tile_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/my_cust_searchfield")
    public WebElement Search_Input_Field_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/textinput_placeholder\").instance(0)")
    public WebElement market_Route_Dropdown_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/spinner_marketcity")
    public WebElement market_Route_SearchField_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Task\")")
    public WebElement task_Dropdown_Element;

    @AndroidFindBy(id = " com.prowess.apps.bandhansfa:id/spinner_task")
    public WebElement selected_TaskDrop_Txt_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/img_mycust_clearfilter")
    public WebElement go_Button_Element;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.prowess.apps.bandhansfa:id/influencerDataList\"]/android.view.ViewGroup/android.widget.ImageView")
    public List<WebElement> kyc_Status_Txt_Elements;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.prowess.apps.bandhansfa:id/cd\"]/android.view.ViewGroup/android.widget.TextView[1]")
    public List<WebElement> influencerName_Txt_Elements;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.prowess.apps.bandhansfa:id/cd\"]/android.view.ViewGroup/android.widget.TextView[2]")
    public List<WebElement> mobileNumber_Txt_Elements;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.prowess.apps.bandhansfa:id/cd\"]/android.view.ViewGroup/android.widget.TextView[4]")
    public List<WebElement> marketRoute_Txt_Elements;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhansfa:id/ll_itembeat_add_outlet\"]")
    public List<WebElement> startMeet_Icon_Elements;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.prowess.apps.bandhansfa:id/historyimg\"]")
    public List<WebElement> call_Icon_Elements;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.prowess.apps.bandhansfa:id/callimg\"]")
    public List<WebElement> information_Icon_Elements;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.prowess.apps.bandhansfa:id/locimg\"]")
    public List<WebElement> go_Icon_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btn_skip")
    public WebElement startMeet_SkipBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btn_cancel_catpure_remark")
    public WebElement startMeet_CancelBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btn_save_capture_remark")
    public WebElement startMeet_SubmitBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/clDialogTitle")
    public WebElement startMeet_Dialog_Tilte_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/ivCloseDialog")
    public WebElement startMeet_CrossIcon_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/txtEdit_Remark")
    public WebElement startMeet_EnterTextField_Element;

      @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tvNoItem")
     public WebElement no_Infl_Available_Element;

      @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
      public WebElement permission_Allow_Btn_Element;

    //  @AndroidFindBy(id = "")
    //  public WebElement _Element;

    //  @AndroidFindBy(id = "")
    //  public WebElement _Element;



    public InfluencerListPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOn_InfluencerTile() {
        clickElement(influencer_Tile_Element);
    }

    public void clickOn_MarketRoute_Drop() {
        try{
        clickElement(market_Route_Dropdown_Element);
        } catch (Exception e) {
             throw e;
        }
    }

    public void clickOn_Go_Button() {
        try{
        clickElement(go_Button_Element);
        } catch (Exception e) {
             throw e;
        }
    }

    public void enter_TextIn_MarketRoute_Drop(String market) {
        sendText(market_Route_SearchField_Element, market);
    }

    public void clickOn_MarketRoute_Filter() {
        try{
        clickElement(market_Route_SearchField_Element);
        } catch (Exception e) {
             throw e;
        }
    }

    public void select_MarketRoute_DropValue(String market, int x, int y) throws Exception {
        try {
            // clickOn_MarketRoute_Drop();
            // Thread.sleep(1000);
            enter_TextIn_MarketRoute_Drop(market);
            clickOn_MarketRoute_Filter();
            Thread.sleep(1000);
            selectDropValues(x, y);
                

        } catch (Exception e) {
            throw e;
        }
    }

   
    public String getText_SelectedMarketRouteDropdown() {
        return getText(market_Route_SearchField_Element);
    }

    public List<String> getMarketRouteTextFromList() throws InterruptedException {
        Thread.sleep(2000);
        return getTextsFromElements(marketRoute_Txt_Elements);
    }

    public List<String> getInfluencerNameTextFromList() throws InterruptedException {
        Thread.sleep(2000);
        return getTextsFromElements(influencerName_Txt_Elements);
    }

 public String get_InflNameFromList(int index) {
    waitForListToLoad(influencerName_Txt_Elements);
        String fullName= influencerName_Txt_Elements.get(index).getText();
        String[] part =fullName.split("\\|");
                String inflNameFromList = part[0].trim().replaceAll("\\s+", " ");
                return inflNameFromList;
    }

    public String get_InflAccountNoFromList(int index) {
        waitForListToLoad(influencerName_Txt_Elements);
        String fullName= influencerName_Txt_Elements.get(index).getText();
        String[] part =fullName.split("\\|");
                String inflAccountFromList = part[1].trim().replaceAll("\\s+", " ");
                return inflAccountFromList;
    }

     public String get_InflMobileNoFromList(int index) {
        waitForListToLoad(mobileNumber_Txt_Elements);
        return mobileNumber_Txt_Elements.get(index).getText();
    }

    public void select_Task_DropValue( int x, int y) throws Exception {
        try {
          clickElement(task_Dropdown_Element);
            Thread.sleep(2000);
            selectDropValues(x, y);

    //    By dropdown = AppiumBy.accessibilityId("spinner_task");

 
    // driver.findElement(dropdown).click();
    // Thread.sleep(1000);
 
    //selectFromPopupByText("KYC Pending");

        } catch (Exception e) {
            throw e;
        }
    }


    public String getText_SelectedTaskDropdown() {
        return getText(selected_TaskDrop_Txt_Element);
    }

    public void clickOn_FirstRecord_StartMeet_Icon() {
        clickElement(startMeet_Icon_Elements.get(0));
    }

     public void clickOn_StartMeet_Icon(int index) {
        clickElement(startMeet_Icon_Elements.get(index));
    }

    public boolean startMeet_Icon_isDisplayed() {
        return startMeet_Icon_Elements.get(0).isDisplayed();
    }

    public void clickOn_StartMeet_SkipBtn() {
       try{
             clickElement(startMeet_SkipBtn_Element);
        }catch(Exception e)
        {
           clickOn_StartMeet_CrossIcon();
           throw e;
        
    }

    } 
    public void clickOn_StartMeet_CrossIcon() {
             clickElement(startMeet_CrossIcon_Element);        
    } 

    public String get_No_Infl_Available_Text() {
        return getText(no_Infl_Available_Element);
    }

     public boolean no_Infl_Available_Text_isDiaplay() {
        return no_Infl_Available_Element.isDisplayed();
    }
    
    public void enterInfluencerName(String inflName)
    {
        sendText(Search_Input_Field_Element,inflName);
    }

    public void clearSearchField()
{
        Search_Input_Field_Element.clear();   
} 
    
public void clickOn_Permission_Allow_Btn()
{
    try {
        
        if(permission_Allow_Btn_Element.isDisplayed())
        {
            clickElement(permission_Allow_Btn_Element);
        }
    } catch (Exception e) {
        
    }
}

public InfluencerInformationPage clickOn_Information_Icon(int index) {
waitForListToLoad(information_Icon_Elements);
    WebElement element = information_Icon_Elements.get(index);
    element.click();

    return new InfluencerInformationPage(driver);
}


  public void openKYCPendingInfluencer() {

    boolean found = false;
    int maxScrolls = 5;   // avoid infinite scroll
    int scrollCount = 0;

    while (!found && scrollCount < maxScrolls) {

        waitForListToLoad();

        List<WebElement> statusList = kyc_Status_Txt_Elements;

        for (int i = 0; i < statusList.size(); i++) {

            WebElement statusElement = statusList.get(i);

            String statusText =
                    statusElement.getAttribute("content-desc") != null
                            ? statusElement.getAttribute("content-desc").trim()
                            : "";

                            
                           // System.out.println("statusText : "+statusText);
                            

            if (statusText.equalsIgnoreCase("KYC Both Pending")) {

                get_InflNameFromList(i);
                 // store inflNameFromList in global store
                GlobalStore.put("INFL_NAME_FROM_LIST",  get_InflNameFromList(i));
                get_InflAccountNoFromList(i);
                  GlobalStore.put("INFL_ACCOUNTNO_FROM_LIST",   get_InflAccountNoFromList(i));
                clickOn_StartMeet_Icon(i);

                found = true;
                break;
            }
        }

        if (!found) {
            scrollDownSafe();
            scrollCount++;
        }
    }

    if (!found) {
        throw new RuntimeException("KYC Both Pending influencer not found after scrolling");
    }
}




}
