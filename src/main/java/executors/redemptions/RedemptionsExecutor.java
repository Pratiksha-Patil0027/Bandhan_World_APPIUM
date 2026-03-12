package executors.redemptions;

import java.util.Map;

import core.GlobalStore;
import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.claimpoints.CardDetailsPage;
import pages.claimpoints.ClaimDetailsPage;
import pages.claimpoints.ClaimInformationPage;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;
import pages.redemptions.RedemptionCartPage;
import pages.redemptions.RedemptionHistoryPage;
import pages.redemptions.RedemptionSummaryPage;
import pages.redemptions.RewardCataloguePage;

public class RedemptionsExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private RedemptionHistoryPage redemptionHistoryPage;
    private CompanyLoginPage companyLoginPage;
    private RewardCataloguePage rewardCataloguePage;
    private CardDetailsPage cardDetailsPage;
    private ClaimInformationPage claimInformationPage;
    private ClaimDetailsPage claimDetailsPage;
     private RedemptionCartPage redemptionCartPage;
     private RedemptionSummaryPage redemptionSummaryPage;

     
    
    
    
    
    @Override
    public Object execute(
            String step,
            Map<String, String> data,
            AndroidDriver driver) throws InterruptedException {

        if (driver == null) {
            throw new IllegalStateException(
                    "AndroidDriver is NULL. Appium session not initialized.");
        }

        if (dashboardPage == null) {

            companyLoginPage = new CompanyLoginPage(driver);
            dashboardPage = new DashboardPage(driver);
            redemptionHistoryPage = new RedemptionHistoryPage(driver);
            rewardCataloguePage = new RewardCataloguePage(driver);
            redemptionCartPage = new RedemptionCartPage(driver);
            redemptionSummaryPage = new RedemptionSummaryPage(driver);
                
        }

        switch (step.toLowerCase()) {

            case "hidekeyboard":  
            companyLoginPage.hideKeyboardIfVisible();
            return null ;
                
                case "navigatebacktodashboardpage": 
                dashboardPage.navigateBackToHomeDashboard();
                 return  null;

            case "clickonskipbtnofinsurancewindow":
                dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
                return null;

            case "openredemptionsmenu":
                dashboardPage.clickOn_Redemptions_Menu();
                return null;

                case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

            case "verifypagetitle":
                return redemptionHistoryPage.get_PageTitle(); 
                
                case "dashboard_get_balancepoints":
                    String balancePoints = dashboardPage.get_MyBalancePoints();
                    GlobalStore.put("BALANCE_POINTS", balancePoints);
                return balancePoints;

                case "dashboard_get_newbalancepoints":
                    String newbalancePoints = dashboardPage.get_MyBalancePoints();
                    GlobalStore.put("NEW_BALANCE_POINTS", newbalancePoints);
                return newbalancePoints;


            case "redhistory_enterfromdate":
                redemptionHistoryPage.open_FromDate(); 
                redemptionHistoryPage.selectDateFromText(data.get("FROM_DATE"));
                return null;

            case "redhistory_entertodate":
                redemptionHistoryPage.open_Todate();
                redemptionHistoryPage.selectDateFromText(data.get("TO_DATE"));
                return null;

                 case "verify_areredemptionsdates_withinrange":
                return redemptionHistoryPage.areRedemptionsDatesWithinRange(data.get("FROM_DATE"), data.get("TO_DATE"));

                case "redhistory_openfirstrecord":
                redemptionHistoryPage.openFirstRecord();
                return null;

            case "verify_recordsnotavailable_text":
                return redemptionHistoryPage.get_NoRecordsAvailable_Text();

                case "clickon_approvetab":
                redemptionHistoryPage.clickOn_ApprovedTab();
                return null;

                 case "clickon_rejectedtab":
                redemptionHistoryPage.clickOn_RejectedTab();
                return null;

                case "clickon_pendingtab":
                redemptionHistoryPage.clickOn_PendingTab();
                return null;

                 case "clickon_deliveredtab":
                redemptionHistoryPage.clickOn_DeliveredTab();
                return null;

                 case "verify_redhistory_redemptionno_present":
               return redemptionHistoryPage.isRedemptionNoPresent();

                case "verify_redhistory_generated_date":
               return GlobalStore.get("ROW_DATE_TIME");

                case "verify_redhistory_generated_productcode":
               return GlobalStore.get("ROW_PRODUCTNAME");

                case "verify_redhistory_generated_productdesc":
               return GlobalStore.get("ROW_PRODUCTDESC");

                case "verify_redhistory_generated_qty":
               return GlobalStore.get("ROW_QTY");

                case "verify_redhistory_generated_totalpoints":
               return GlobalStore.get("ROW_POINTS");

               case "verify_redhistory_generated_tdspoints":
               return GlobalStore.get("ROW_TDS");

                case "verify_redhistory_generated_totalredeempoints":
               return GlobalStore.get("ROW_TOTAL_REDEEM_POINTS");


                case "redhistory_get_redemptionno":
                String redemptionno = redemptionHistoryPage.get_History_RedemptionNo(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_REDEMPTIONNO", redemptionno);
                return redemptionno;
 

                 case "redhistory_get_redemptiondate":
                 String date = redemptionHistoryPage.get_History_RedemptionDate(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_REDEMPTIONDATE", date);
                return date;

                case "redhistory_get_rewardproductcode":
                String productcode=redemptionHistoryPage.get_History_ProductCode(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_PRODUCTCODE", productcode);
                return productcode;

                case "redhistory_get_rewardproductdesc":
                String productdesc = redemptionHistoryPage.get_History_ProductDesc(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_PRODUCTDESC", productdesc);
                return productdesc;

                case "redhistory_get_qty":
                String qty = redemptionHistoryPage.get_History_ProductQty(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_QTY", qty);
                return qty;

                case "redhistory_get_totalpoints":
                String totalpoints=redemptionHistoryPage.get_History_TotalPoints(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_TOTALPOINTS", totalpoints);
                return totalpoints;

                 case "redhistory_get_tdspoints":
                String TDSpoints = redemptionHistoryPage.get_History_TDSPoints(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_TDSPOINTS", TDSpoints);
                return TDSpoints;

                 case "redhistory_get_totalredeempoints":
                String totalRedeemPoints = redemptionHistoryPage.get_History_TotalRedeemPoints(0).trim();
                GlobalStore.put("REDEMPTIONHISTORY_TOTALREDEEMPOINTS", totalRedeemPoints);
                return totalRedeemPoints;

                case "verify_viewhistory_redemptionno":
               return redemptionHistoryPage.get_ViewHistory_RedemptionNo().trim();

                case "verify_viewhistory_redemptiondate":
               return redemptionHistoryPage.get_ViewHistory_RedemptionDate().trim();

                case "verify_viewhistory_totalredeempoints":
               return redemptionHistoryPage.get_ViewHistory_TotalRedeemPoints().trim();

                case "verify_viewhistory_totalredeempoints_calculation":
               return redemptionHistoryPage.verify_ViewHistory_TotalRedeemPoints_Calculation();

                case "verify_viewhistory_tdspoints":
               return redemptionHistoryPage.get_ViewHistory_TDSPoints().trim();

                case "verify_viewhistory_points":
               return redemptionHistoryPage.get_ViewHistory_Points().trim();

                case "verify_viewhistory_qty":
               return redemptionHistoryPage.get_ViewHistory_Qty().trim();

                case "verify_viewhistory_rewardproductcode":
               return redemptionHistoryPage.get_ViewHistory_ProductCode().trim();

                case "verify_viewhistory_rewardproductdesc":
               return redemptionHistoryPage.get_ViewHistory_ProductDesc().trim();

                case "verify_viewhistory_redemptionstatus":
              return  redemptionHistoryPage.get_ViewHistory_RedemptionStatus();

              case "verify_viewhistory_dispatchhistorydisplay":
              return  redemptionHistoryPage.get_ViewHistory_DispatchHistoryIsDisplay();


               case "viewhistory_clickon_downloadpdf":
                redemptionHistoryPage.clickOn_ViewHistory_DownloadPdf();
                return null;

                 case "clickon_viewhistory_cancelbtn":
                redemptionHistoryPage.clickOn_ViewHistory_CancelBtn();
                return null;

                case "verify_viewhistory_pdfdownloadstratedtext":
                  return redemptionHistoryPage.verify_PDFDownload_ToastMsg("PDF download started.");


               case "redhistory_clickon_fabbutton":
                redemptionHistoryPage.clickOn_FabBtn();
                return null;
                
                case "verify_warningtoastmsg":
                return rewardCataloguePage.get_WarningToastMsg();
  
                 case "clickon_backarrow":
                 rewardCataloguePage.clickOn_BackArrow();
                 return null;

                 case "catalogue_enter_searchdata":
                 rewardCataloguePage.enter_SearchData(data.get("SEARCH_DATA"));
                 return null;

                  case "catalogue_clickon_keyboardsearchicon":
                 rewardCataloguePage.clickOn_Keyboard_Searchicon();
                 return null;

                
                   case "catalogue_clear_searchfield":
                 rewardCataloguePage.clear_InputSearchField();
                 return null;

                  case "verify_catalogue_norecordsavailabletext":
                return rewardCataloguePage.get_NoRecordsAvailable_Text();
                 

                  case "catalogue_clickon_eligiblecheckbox":
                 rewardCataloguePage.clickOn_Eligible_Checkbox();
                 return null;

                 case "verify_catalogue_productvisibility_eligiblechecked":
                    
                return rewardCataloguePage.verifyProductVisibility(true);

                 case "verify_catalogue_productvisibility_eligibleunchecked":
                return rewardCataloguePage.verifyProductVisibility(false);

                 
                  case "catalogue_clickon_updownarrow":
                 rewardCataloguePage.clickOn_upDown_Arrow();
                 return null;

                 case "verify_catalogue_productafter_sorting":
                return rewardCataloguePage.verifyNextProductGreaterThanFirst();

                 case "catalogue_get_cartpoints":
                    String cartPoints = rewardCataloguePage.get_CartPoints_Text();
                    GlobalStore.put("CATALOGUE_CARTPOINTS", cartPoints);
                return cartPoints;

                case "verify_catalogue_cartpoints_calculation":
                return rewardCataloguePage.verify_CartPoints_Calculation();

                 case "verify_catalogue_balancepoints_calculation":
                return rewardCataloguePage.verify_Balancepoints_Calculation();

                case "verify_catalogue_productcode_inlist":
                 return rewardCataloguePage.get_RewardProductCode(0);

                 case "catalogue_get_rewardproductcode":
                String cat_productcode = rewardCataloguePage.get_RewardProductCode(0).trim();
                GlobalStore.put("CATALOGUE_PRODUCTCODE", cat_productcode);
                return cat_productcode;

                case "catalogue_get_rewardproductdesc":
                String cat_productdesc = rewardCataloguePage.get_RewardProductDesc(0).trim();
                GlobalStore.put("CATALOGUE_PRODUCTDESC", cat_productdesc);
                return cat_productdesc;

                case "catalogue_get_rewardproductpoints":
                String cat_productpoints = rewardCataloguePage.get_RewardProductPoints(0).trim();
                GlobalStore.put("CATALOGUE_POINTS", cat_productpoints);
                return cat_productpoints;

                 case "catalogue_get_rewardproductqty":
                String cat_Qty = rewardCataloguePage.get_RewardProductQty(0).trim();
                GlobalStore.put("CATALOGUE_QTY", cat_Qty);
                return cat_Qty;

                
                case "verify_catalogue_qty":
                return rewardCataloguePage.get_RewardProductQty(0);

                case "catalogue_clickon_qtyminusbtn":
                 rewardCataloguePage.clickOn_QtyMinus_Btn(0);
                 return null;

                 case "catalogue_clickon_qtyplusbtn":
                 rewardCataloguePage.clickOn_QtyPlus_Btn(0);
                 return null;

                  case "catalogue_enter_qty":
                 rewardCataloguePage.enter_Qty(0,data.get("QTY"));
                 return null;

                  case "verify_catalogue_iscarticondisplay":
                return rewardCataloguePage.isCartIconDisplay();

                 
                 case "catalogue_clickon_viewdetails":
                 rewardCataloguePage.clickOn_ViewDetails_Btn(0);
                 return null;

                 case "verify_catalogue_viewdetails_productcode":
               // return rewardCataloguePage.get_ViewDetails_ProductCode().equals(GlobalStore.get("CATALOGUE_PRODUCTCODE"));
               return rewardCataloguePage.get_ViewDetails_ProductCode();

                case "verify_catalogue_viewdetails_productdesc":
                //return rewardCataloguePage.get_ViewDetails_ProductDesc().equals(GlobalStore.get("CATALOGUE_PRODUCTDESC"));
                return rewardCataloguePage.get_ViewDetails_ProductDesc();

                case "verify_catalogue_viewdetails_productpoints":
               // return rewardCataloguePage.get_ViewDetails_ProductPoints().equals(GlobalStore.get("CATALOGUE_POINTS"));
               return rewardCataloguePage.get_ViewDetails_ProductPoints();

                 case "catalogue_clickon_viewdetails_crossicon":
                 rewardCataloguePage.clickOn_ViewDetails_CrossIcon();
                 return null;

                 case "verify_catalogue_tdspercentage":
                return rewardCataloguePage.get_TDSPercentage();

                 case "catalogue_get_tdspercentage":
                    String cat_TDSper = rewardCataloguePage.get_TDSPercentage().trim();
                GlobalStore.put("CATALOGUE_TDSPERCENTAGE", cat_TDSper);
                return cat_TDSper;

                case "catalogue_get_tdspoints":
                     String cat_TDSpoints = rewardCataloguePage.get_TDSPoints().trim();
                GlobalStore.put("CATALOGIE_TDSPOINTS", cat_TDSpoints);
                return cat_TDSpoints;

                case "verify_catalogue_tdspoints_calculation":
                return rewardCataloguePage. verify_TDSPoints_Calculation(data.get("TDS%"));
               
                 case "catalogue_clickon_submitbtn":
                 rewardCataloguePage.clickOn_SubmitBtn();
                 return null;

                  case "catalogue_clickon_filtericon":
                 rewardCataloguePage.clickOn_FilterIcon();
                 return null;

                 case "verify_catalogue_filter_filterwindowopen":
                return rewardCataloguePage.verify_Catagories_filterwindow_open();

                 
                 case "verify_catalogue_filter_availablebalance":
                return rewardCataloguePage.verify_Filter_AvailableBalance();

                case "catalogue_filter_get_minpoints":
                return rewardCataloguePage.get_Filter_MinPoints();

                case "catalogue_filter_get_maxpoints":
                return rewardCataloguePage.get_Filter_MaxPoints();

                 case "verify_catalogue_filter_maxpoints_eligiblechecked":
                return rewardCataloguePage.verify_filterMaxPoints(true);

                 case "verify_catalogue_filter_maxpoints_eligibleunchecked":
                return rewardCataloguePage.verify_filterMaxPoints(false);

                 case "catalogue_filter_clickon_eligiblecheckbox":
                 rewardCataloguePage.clickOn_Filter_EligibleCheckbox();
                 return null;
                
                  case "verify_catalogue_filter_eligiblegift_checkedattributevalue":
                return rewardCataloguePage.get_EligibleGift_CheckedAttributeValue();

                case "verify_catalogue_filter_categories":
                 return rewardCataloguePage.verify_CategoriesDisplayed_WithScroll(data.get("CATEGORIES_NAME"));

                
                 case "catalogue_filter_clickon_allcheckbox":
                 rewardCataloguePage.clickOn_Filter_AllCheckbox();
                 return null;

                  case "catalogue_filter_clickon_specific_categorycheckbox":
                 rewardCataloguePage.clickOn_Filter_Specific_Category_Checkbox(2);
                 return null;

                  case "catalogue_filter_clickon_refreshicon":
                 rewardCataloguePage.clickOn_Filter_RefreshIcon();
                 return null;

                  case "verify_catalogue_filter_errormsg":
                return rewardCataloguePage.get_Filter_ErrorMsg();

                 case "catalogue_filter_clickon_cancelbtn":
                 rewardCataloguePage.clickOn_filter_CancelBtn();
                 return null;

                  case "catalogue_filter_clickon_applybtn":
                 rewardCataloguePage.clickOn_filter_ApplyBtn();
                 return null;
	
                 case "verify_redemptioncart_cartpoints":
                    return redemptionCartPage.get_CartPoints();
               
                 case "redemptioncart_get_cartpoints":
                    String cartpoints = redemptionCartPage.get_CartPoints().trim();
                GlobalStore.put("REDEMPTIONCART_CARTPOINTS", cartpoints);
                 return cartpoints; 

                case "verify_redemptioncart_productcode":
                return redemptionCartPage.get_ProductCode();

                case "verify_redemptioncart_productdesc":
                return redemptionCartPage.get_ProductDesc();

                case "verify_redemptioncart_productpoints":
                return redemptionCartPage.get_ProductPoints();

                case "redemptioncart_clickon_minusbtn":
                 redemptionCartPage.clickOn_MinusBtn();
                 return null;

                 case "redemptioncart_clickon_plusbtn":
                 redemptionCartPage.clickOn_PlusBtn();
                 return null;

                  case "verify_redemptioncart_addqty":
                 return redemptionCartPage.verify_AdditionQty_Increased_By_One();

                 case "verify_redemptioncart_minusqty":
                 return redemptionCartPage.verify_AdditionQty_decreased_By_One();

                  case "verify_redemptioncart_productqty":
                return redemptionCartPage.get_QtyText();

                 case "redemptioncart_clickon_deletebtn":
                 redemptionCartPage.clickOn_DeleteIcon();
                 return null;

                 case "verify_redemptioncart_tdspoints":
                return redemptionCartPage.get_TDSPoints();

                case "redemptioncart_get_tdspoints":
               String tdspoints = redemptionCartPage.get_TDSPoints().trim();
                GlobalStore.put("REDEMPTIONCART_TDSPOINTS", tdspoints);
                 return tdspoints;

                case "verify_redemptioncart_tdspercentage":
                return redemptionCartPage.get_TDSPerscentage();

                 case "verify_redemptioncart_cartpointscalculation":
                return redemptionCartPage.verify_CartPoints_Calculation();

                case "verify_redemptioncart_tsdpointscalculation":
                return redemptionCartPage.verify_TDSPoints_Calculation(data.get("TDS%"));
                
                 case "redemptioncart_clickon_cancelbtn":
                 redemptionCartPage.clickOn_CancelBtn();
                 return null;

                 case "redemptioncart_clickon_checkoutbtn":
                 redemptionCartPage.clickOn_CheckoutBtn();
                 return null;

                 case "verify_redemptioncart_cartisemptytext":
                return redemptionCartPage.get_CartIsEmpty_Text();

                case "verify_redemptioncart_warningtoastmsg":
                return redemptionCartPage.get_WarningToastMsg();

                 case "verify_summary_cartpoints":
                return redemptionSummaryPage.get_CartPoints();

                 case "summary_enter_deliveredaddress":
                 redemptionSummaryPage.enter_DeliveredAddress();
                 return null;

                  case "verify_summary_deliveredmobileno":
                return redemptionSummaryPage.get_DeliveredMobileNo();

                case "summary_enter_pincode":
                 redemptionSummaryPage.enter_PinCode();
                 return null;

                 case "verify_summary_state":
                return redemptionSummaryPage. get_State();

                case "summary_enter_district":
                 redemptionSummaryPage.enter_District();
                 return null;

                 case "verify_summary_city":
                return redemptionSummaryPage. get_City();

                case "summary_enter_panno":
                 redemptionSummaryPage.enter_PANno();
                 return null;

                  case "verify_summary_productcode":
                return redemptionSummaryPage. get_ProductCode();

                 case "verify_summary_productdesc":
                return redemptionSummaryPage. get_ProductDesc();

                 case "verify_summary_productpoints":
                return redemptionSummaryPage. get_ProductPoints();

                case "verify_summary_productqty":
                return redemptionSummaryPage. get_Qty();

                 case "summary_clickon_deleteicon":
                 redemptionSummaryPage.clickOn_DeleteIcon();
                 return null;

                  case "summary_clickon_cancelbtn":
                 redemptionSummaryPage.clickOn_CancelBtn();
                 return null;

                  case "summary_clickon_checkout":
                 redemptionSummaryPage.clickOn_CheckoutBtn();
                 return null;

                 case "verify_summary_cartisemptytext":
                return redemptionSummaryPage. get_CartIsEmpty_Text();

                case "verify_summary_declarationtitle":
                return redemptionSummaryPage. get_Declaration_Title();

                case "verify_summary_declarationtext":
                return redemptionSummaryPage. get_Declaration_Text();

                 case "summary_clickon_declaration_editaddressbtn":
                 redemptionSummaryPage.clickOn_Declaration_EditAddressBtn();
                 return null;

                 case "summary_clickon_declaration_acceptbtn":
                 redemptionSummaryPage.clickOn_Declaration_AcceptBtn();
                 return null;

                  case "verify_summary_otpverfy_title":
                return redemptionSummaryPage. get_OTPVerification_Title();

                 case "summary_enter_otpverfy_otp":
                 redemptionSummaryPage.enter_OTPVerification_OTP(data.get("OTP"));
                 return null;

                 case "summary_clickon_otpverfy_cancelbtn":
                 redemptionSummaryPage.clickOn_OTPVerification_CancelBtn();
                 return null;

                 case "summary_clickon_otpverfy_verifybtn":
                 redemptionSummaryPage.clickOn_OTPVerification_VerifyBtn();
                 return null;

                 case "verify_summary_warning_title":
                return redemptionSummaryPage. get_Warning_DialogBox_Title();

                case "verify_summary_warning_text":
                return redemptionSummaryPage. get_Warning_DialogBox_Text();

                 case "summary_clickon_warning_okbtn":
                 redemptionSummaryPage.clickOn_Warning_DialogBox_OkBtn();
                 return null;

                  case "verify_summary_success_title":
                return redemptionSummaryPage. get_Success_DialogBox_Title();

                case "verify_summary_successy_text":
                return redemptionSummaryPage. get_Success_DialogBox_Text();

                 case "summary_clickon_success_okbtn":
                 redemptionSummaryPage.clickOn_Success_DialogBox_OkBtn();
                 return null;
		

                  

   
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

    
}
