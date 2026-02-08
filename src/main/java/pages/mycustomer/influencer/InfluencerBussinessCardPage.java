package pages.mycustomer.influencer;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class InfluencerBussinessCardPage extends BasePage {

    

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btn_createBizCard")
     public WebElement create_Bizcard_Btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tiet_Name")
    public WebElement nameField_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tiet_FirmName")
    public WebElement firmName_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tiet_mobileno")
    public WebElement mobileNumber_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tiet_email")
    public WebElement emailId_Element;

     @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/tiet_Address1\")")
    public WebElement address1_Element;
    

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tiet_Address2")
    public WebElement address2_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tiet_Address3")
    public WebElement address3_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/btnsubmit")
    public WebElement submitBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tvCardStatusValue")
    public WebElement card_StatusOnView_Element;

      @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tv_requestNoValue")
    public WebElement card_RequestNumber_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tv_StatusValue")
    public WebElement card_Status_FromList_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/remark")
    public WebElement requestHistory_Details_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_alert_title")
    public WebElement confirm_DialogBox_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_yes")
    public WebElement confirm_DialogBox_YesBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_no")
    public WebElement confirm_DialogBox_NoBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_universal_success_title")
    public WebElement success_Popup_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_universal_info_ok")
    public WebElement success_Popup_OkBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_universal_info_text")
    public WebElement successDilaog_GeneratedText_Element;

    //   @AndroidFindBy(id = "")
    // public WebElement _Element;

    //   @AndroidFindBy(id = "")
    // public WebElement _Element;



    public InfluencerBussinessCardPage(AndroidDriver driver) {
        super(driver);
    }

    

    public  void clickOn_CreateBizCard_Btn()
    {
        clickElement(create_Bizcard_Btn_Element);
    }

    public  String get_CreateBizCard_Text()
    {
        return getText(create_Bizcard_Btn_Element);
    }
     
  public String get_InflName()
  {
    return getText(nameField_Element).replaceAll("\\s+", " ");
     
    
  }

  public void enter_InflName(String inflName)
  {
     sendText(nameField_Element,inflName);
  }

   public void enter_FirmName(String firmName)
  {
     sendText(firmName_Element,firmName);
  }
   
   public String get_MobileNo()
  {
    return getText(mobileNumber_Element);
  }

  public void enter_EmailId(String id)
  {
     sendText(emailId_Element,id);
  }

   public void enter_Address1(String address1)
  {
     sendText(address1_Element,address1);
  }

   public void enter_Address2(String address2)
  {
     sendText(address2_Element,address2);
  }

   public void enter_Address3(String address3)
  {
     scrollToId("com.prowess.apps.bandhansfa:id/tiet_Address3");
     sendText(address3_Element,address3);
  }
  
  public void clickOn_SubmitBtn()
  {
     clickElement(submitBtn_Element);
  }
  
   public String get_Confirm_DialogBox_Title_Text()
  {
    return getText(confirm_DialogBox_Element);
  }

  public void clickOn_Confirm_DialogBox_YesBtn()
  {
    try{
     clickElement(confirm_DialogBox_YesBtn_Element);
    }catch(Exception e)
    {

    }
  }

  public void clickOn_Confirm_DialogBox_NoBtn()
  {
     clickElement(confirm_DialogBox_NoBtn_Element);
  }
  
  public String get_SuccessDiaogBox_Text()
  {
    return getText(success_Popup_Element);
  }

   public String get_RequestId_OfBizCard_Text()
  {
 String fullText= successDilaog_GeneratedText_Element.getText();
        String[] part =fullText.split("\\:");
                String requestId = part[0].trim().replaceAll("\\s+", " ");
                return requestId;
  }

  public void clickOn_Success_DialogBox_OkBtn()
  {
     clickElement(success_Popup_OkBtn_Element);
  }
  
  public String get_CardStatusOnView_Text()
  {
    return getText(card_StatusOnView_Element);
  }

  public String get_CardStatusOnList_Text()
  {
    return getText(card_Status_FromList_Element);
  }

  public String get_card_RequestNumber_Text()
  {
    return getText(card_RequestNumber_Element);
  }

  public void clickOn_Generated_CardRecord()
  {
     clickElement(card_RequestNumber_Element);
  }
  

   public String get_Address1_ErrorMsg() throws InterruptedException
  {
    Thread.sleep(3000);
    return address1_Element.getAttribute("error");
  }

  public String get_requestHistory_Text()
  {
    return getText(requestHistory_Details_Element);
  
  }
}
