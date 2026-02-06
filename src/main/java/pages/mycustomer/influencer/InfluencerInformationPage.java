package pages.mycustomer.influencer;

import org.openqa.selenium.WebElement;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class InfluencerInformationPage extends BasePage {

	public InfluencerListPage influencerListPage;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Influencer\")")
	public WebElement influencer_Tile_Element;

	
	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/my_cust_searchfield")
	public WebElement influencer_Search_FilterField_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhansfa:id/callimg\").instance(0)")
	public WebElement inflList_FristRecord_InformationIcon_Element;

    @AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infNameValue")
	public WebElement inflName_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infMobileValue")
	public WebElement mobileNo_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infMobile2Value")
	public WebElement secondary_MobileNo_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infEmailValue")
	public WebElement emailId_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infGenderValue")
	public WebElement gender_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infSpouseDOBValue")
	public WebElement spouse_DOB_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infAnniversaryValue")
	public WebElement anniversary_Date_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infLanguageValue")
	public WebElement language_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infTypeValue")
	public WebElement inflType_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infIndustryBrandValue")
	public WebElement industryBrand_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infAvgSiteValue")
	public WebElement avgSite_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infAddressValue")
	public WebElement address_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infLandmarkValue")
	public WebElement landmark_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infDealerValue")
	public WebElement outlet_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infMarketCityValue")
	public WebElement marketRoute_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infCurrentProgramValue")
	public WebElement currentProgram_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infEstablishmentValue")
	public WebElement ownFirm_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infFirmValue")
	public WebElement firmName_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infFirmAddressValue")
	public WebElement firmAddress_Element;
	
	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infGSTValue")
	public WebElement gstValue_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infShopDocIDValue")
	public WebElement shopDocId_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/infEdit")
	public WebElement inflEdit_Element;
	
	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/edt_fname")
	public WebElement edit_InflName_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/edt_influencer_dob")
	public WebElement edit_Infl_DOB_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/spnLanguage")
	public WebElement edit_Language_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/spinnerInfType")
	public WebElement edit_InflType_DropDown_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/btnIndustriesNBrand")
	public WebElement edit_IndustryBrand_Btn_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/categoryAutoComplete")
	public WebElement edit_Industry_Dropown_Field_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/brandEditText")
	public WebElement edit_Brand_Dropdown_Field_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/buttonOk")
	public WebElement IndsBrand_AddButton_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/done")
	public WebElement IndsBrand_SelectButton_Element;
	
	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/edt_avg_site")
	public WebElement edit_AvgSite_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/edt_landmark")
	public WebElement edit_Landmark_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/tiet_MarketCity")
	public WebElement edit_SelectMarketRoute_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/districtAutoComplete")
	public WebElement edit_Market_District_Drop_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/subDistrictAutoComplete")
	public WebElement edit_Market_SubDistrict_Drop_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/cityAutoComplete")
	public WebElement edit_Market_City_Drop_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/marketCityAutoComplete")
	public WebElement edit_MarketRoute_Drop_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/btnSetMarketCity")
	public WebElement edit_Set_MarketRoute_Button_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/GST_yes")
	public WebElement edit_GST_Yes_ToggleBtn_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/et_gst_validation")
	public WebElement edit_GST_Input_Field_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/gst_validatebtn")
	public WebElement edit_GST_ValidateBtn_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/dialog_universal_info_ok")
	public WebElement edit_GST_SuccessDialog_OKBtn_Element;

	

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/shopDcoYes")
	public WebElement edit_Firm_AddssProof_YesToggle_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/shopDocIDEditText")
	public WebElement edit_ShopId_InputField_Element;

	@AndroidFindBy(id= "com.prowess.apps.bandhansfa:id/ivShopDocPhoto")
	public WebElement edit_Shop_ImageIcon_Element;

	@AndroidFindBy(accessibility = "Shutter")
	public WebElement edit_camera_CaptureIcon_Element;

	@AndroidFindBy(accessibility = "Done")
	public WebElement edit_camera_capture_DoneButton_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/updateData")
	public WebElement edit_Update_btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/button_yes")
	public WebElement edit_Conf_Dialog_YesBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/dialog_universal_info_ok")
	public WebElement edit_UpdateSuccess_Dialog_OkBtn_Element;

	
	@AndroidFindBy(id = "com.prowess.apps.bandhansfa:id/tvHeading2")
	public WebElement header_Element;

	


	public InfluencerInformationPage(AndroidDriver driver) {
		super(driver);
		
	}
  
	


	public void clickOn_Influencer_Tile() {
		clickElement(influencer_Tile_Element);
	}
	
	public void enter_SearchData(String influencerName) {
		sendText(influencer_Search_FilterField_Element, influencerName);
	}

	public void clickOn_InflList_FristRecord_InformationIcon() {
		clickElement(inflList_FristRecord_InformationIcon_Element);
	}



	
     public String get_InfluencerName(){
		 return getTextAfterScroll(
            inflName_Element,
            "com.prowess.apps.bandhansfa:id/infNameValue"
        );
	}

	public String get_Mobile(){
		return getTextAfterScroll(
            mobileNo_Element,
            "com.prowess.apps.bandhansfa:id/infMobileValue"
        );	
	}

	public String get_Secondarymobile(){
		return getTextAfterScroll(
            secondary_MobileNo_Element,
            "com.prowess.apps.bandhansfa:id/infMobile2Value"
        );		
	}

	public String get_EmailId(){
		return getTextAfterScroll(
            emailId_Element,
            "com.prowess.apps.bandhansfa:id/infEmailValue"
        );		
	}

	public String get_Gender(){
		return getTextAfterScroll(
           gender_Element ,
            "com.prowess.apps.bandhansfa:id/infGenderValue"
        );		
	}

	public String get_Spouse_DOB(){
		return getTextAfterScroll(
            spouse_DOB_Element,
            "com.prowess.apps.bandhansfa:id/infSpouseDOBValue"
        );	
	}

	public String get_Anniversary_Date(){
		return getTextAfterScroll(
           anniversary_Date_Element ,
            "com.prowess.apps.bandhansfa:id/infAnniversaryValue"
        );	
	}

	public String get_Language(){
		return getTextAfterScroll(
           language_Element ,
            "com.prowess.apps.bandhansfa:id/infLanguageValue"
        );	
	}

	public String get_InflType(){
		return getTextAfterScroll(
           inflType_Element ,
            "com.prowess.apps.bandhansfa:id/infTypeValue"
        );	
	}

	public String get_IndustryBrand(){
		return getTextAfterScroll(
           industryBrand_Element ,
            "com.prowess.apps.bandhansfa:id/infIndustryBrandValue"
        );	
	}

	public String get_AvgSite(){
		return getTextAfterScroll(
            avgSite_Element,
            "com.prowess.apps.bandhansfa:id/infAvgSiteValue"
        );	
	}

	public String get_Address(){
		return getTextAfterScroll(
            address_Element,
            "com.prowess.apps.bandhansfa:id/infAddressValue"
        );	
	}

	public String get_Landmark(){
		return getTextAfterScroll(
           landmark_Element ,
            "com.prowess.apps.bandhansfa:id/infLandmarkValue"
        );	
	}

	public String get_Outlet(){
		return getTextAfterScroll(
           outlet_Element ,
            "com.prowess.apps.bandhansfa:id/infDealerValue"
        );	
	}

	public String get_MarketRoute(){
		return getTextAfterScroll(
            marketRoute_Element,
            "com.prowess.apps.bandhansfa:id/infMarketCityValue"
        );	
	}

	public String get_CurrentProgram(){
		return getTextAfterScroll(
           currentProgram_Element ,
            "com.prowess.apps.bandhansfa:id/infCurrentProgramValue"
        );	
	}

	public String get_OwnFirm(){
		return getTextAfterScroll(
            ownFirm_Element,
            "com.prowess.apps.bandhansfa:id/infEstablishmentValue"
        );	
	}

	public String get_FirmName(){
		return getTextAfterScroll(
            firmName_Element,
            "com.prowess.apps.bandhansfa:id/infFirmValue"
        );	
	}

	public String get_FirmAddress(){
		return getTextAfterScroll(
            firmAddress_Element,
            "com.prowess.apps.bandhansfa:id/infFirmAddressValue"
        );	
	}

	public String get_GstValue(){
		return getTextAfterScroll(
           gstValue_Element ,
            "com.prowess.apps.bandhansfa:id/infGSTValue"
        );	
	}

	public String get_ShopDocId(){
		return getTextAfterScroll(
           shopDocId_Element ,
            "com.prowess.apps.bandhansfa:id/infShopDocIDValue"
        );	
	}

	public void clickOn_inflEdit_Button() {
		 clickAfterScroll(
            inflEdit_Element,
            "com.prowess.apps.bandhansfa:id/infEdit"
        );
	}
	
	public void enter_InflName(String inflName) {
		sendText(edit_InflName_Element,inflName );
	}

	public void enter_InflDOB(String inflDOB) {
		scrollToId("com.prowess.apps.bandhansfa:id/edt_influencer_dob");
		sendText(edit_Infl_DOB_Element,inflDOB );
	}

	public void clearLanguageDropdown()
{
	scrollToId("com.prowess.apps.bandhansfa:id/spnLanguage");
	edit_Language_Element.clear();
}

	public void clickOn_Language_DropDown() {
		clickAfterScroll(
            edit_Language_Element,
            "com.prowess.apps.bandhansfa:id/spnLanguage"
        );
		
	}



	public void clickOn_InflType_DropDown() {
		clickAfterScroll(
            edit_InflType_DropDown_Element,
            "com.prowess.apps.bandhansfa:id/spinnerInfType"
        );
		
	}

	public void clickOn_IndustryBrand_Btn() {
		clickAfterScroll(
            edit_IndustryBrand_Btn_Element,
            "com.prowess.apps.bandhansfa:id/btnIndustriesNBrand"
        );
		
	}

	public void clickOn_Industry_DropDown() {
		
           clickElement(edit_Industry_Dropown_Field_Element);
           
		
	}

	public void clickOn_Brand_DropDown() {
		clickElement(edit_Brand_Dropdown_Field_Element);
	}

	public void clickOn_IndsBrand_AddBtn() {
		clickElement(IndsBrand_AddButton_Element);
	}

	public void clickOn_IndsBrand_SelectBtn() {
		clickElement(IndsBrand_SelectButton_Element);
	}


	public void enter_AvgSite(String avgSite ) {
		scrollToId("com.prowess.apps.bandhansfa:id/edt_avg_site");
		sendText(edit_AvgSite_Element, avgSite);
	}

	public void enter_Landmark(String landmark ) {
		scrollToId("com.prowess.apps.bandhansfa:id/edt_landmark");
		sendText(edit_Landmark_Element, landmark);
	}

	
	public void clickOn_SelectMarketRoute_Field() {
		clickElement(edit_SelectMarketRoute_Element);
	}

	public void clickOn_Market_Dist_DropDown() {
		clickElement(edit_Market_District_Drop_Element);
	}

	public void enter_MarketRoute_District(String district ) {
		sendText(edit_Market_District_Drop_Element, district);
	}

	public void clickOn_Market_SubDist_DropDown() {
		clickElement(edit_Market_SubDistrict_Drop_Element);
	}

	public void enter_MarketRoute_SubDistrict(String subDistrict ) {
		sendText(edit_Market_SubDistrict_Drop_Element, subDistrict);
	}

	public void clickOn_Market_City_DropDown() {
		clickElement(edit_Market_City_Drop_Element);
	}

	public void enter_MarketRoute_City(String city ) {
		sendText(edit_Market_City_Drop_Element, city);
	}

	public void clickOn_MarketRoute_Drpdown() {
		clickElement(edit_MarketRoute_Drop_Element);
	}

	public void enter_MarketRoute(String marketRoute ) {
		sendText(edit_MarketRoute_Drop_Element, marketRoute);
	}

	public void clickOn_Set_MarketRouteBtn() {
		clickElement(edit_Set_MarketRoute_Button_Element);
	}

	public void clickOn_GST_Yes_ToggleBtn() {
		clickAfterScroll(
            edit_GST_Yes_ToggleBtn_Element,
            "com.prowess.apps.bandhansfa:id/GST_yes"
        );
	}

	public void clickOn_GST_Field() {
		clickElement(edit_GST_Input_Field_Element);
	}

	public void enter_GST_No(String GST ) {
		scrollToId("com.prowess.apps.bandhansfa:id/et_gst_validation");
		sendText(edit_GST_Input_Field_Element, GST);
	}

	public void clickOn_GST_ValidateBtn() {
		clickElement(edit_GST_ValidateBtn_Element);
	}

	public void clickOn_GST_SuccessDialog_OKBtn() {
		clickElement(edit_GST_SuccessDialog_OKBtn_Element);
	}

	
	public void clickOn_Frim_Address_YesToggleBtn() {
		clickAfterScroll(
            edit_Firm_AddssProof_YesToggle_Element,
            "com.prowess.apps.bandhansfa:id/shopDcoYes"
        );
		
	}
	
	public void enter_ShopId(String shopId ) {
		scrollToId("com.prowess.apps.bandhansfa:id/shopDocIDEditText");
		sendText(edit_ShopId_InputField_Element, shopId);
	}
	
public void clickOn_Shop_ImageIcon() {
		clickElement(edit_Shop_ImageIcon_Element);
	}

	public void clickOn_Camera_CaptureIcon() {
		clickElement(edit_camera_CaptureIcon_Element);
	}

	public void clickOn_Camera_Capture_DoneButton() {
		clickElement(edit_camera_capture_DoneButton_Element);
	}

	public void clickOn_UpdateBtn() {
		clickAfterScroll(
            edit_Update_btn_Element,
            "com.prowess.apps.bandhansfa:id/updateData"
        );
		
	}

	public void clickOn_Conf_Dialog_YesBtn() {
		clickElement(edit_Conf_Dialog_YesBtn_Element);
        
		
	}

	public void clickOn_UpdateSuss_Dialog_OkBtn() {
		clickElement(edit_UpdateSuccess_Dialog_OkBtn_Element);
        
		
	}
	
	

	public String get_HeaderName(){
		
        return getText(header_Element);
	}

public void verifyKycDetails() {

    int count = 10;
	boolean isKycPending=false;

    for (int i = 0; i < count; i++) {

		  influencerListPage.clickOn_Information_Icon(i);


        if (isKycPending) {

                  

        
            break;
        }
    }
}



}
