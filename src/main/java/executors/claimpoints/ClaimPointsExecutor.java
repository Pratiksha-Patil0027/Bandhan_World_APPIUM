package executors.claimpoints;

import java.util.List;
import java.util.Map;

import core.GlobalStore;
import core.KeywordExecutor;
import core.VerifyResult;
import io.appium.java_client.android.AndroidDriver;
import pages.claimpoints.CategoryPage;
import pages.claimpoints.DealerListPage;
import pages.claimpoints.DealerPage;
import pages.claimpoints.MyClaimsPage;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;



public class ClaimPointsExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private MyClaimsPage myClaimsPage;
    private DealerListPage dealerListPage;
    private DealerPage dealerPage;
  private CompanyLoginPage companyLoginPage;
  private CategoryPage categoryPage;
     
    
    
    

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

            dashboardPage = new DashboardPage(driver);
            myClaimsPage = new MyClaimsPage(driver);
             dealerListPage = new DealerListPage(driver);
             dealerPage = new DealerPage(driver);
              companyLoginPage = new CompanyLoginPage(driver);
               categoryPage = new CategoryPage(driver);
              
             
            
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

            case "openclaimpointsmenu":
                dashboardPage.clickOn_ClaimPoints_Menu();
                return null;

            case "verifypagetitle":
                return myClaimsPage.get_PageTitle();

            case "myclaims_clickonlisticon":
                myClaimsPage.clickOn_ClaimListIcon();
                return null;

            case "verifyisinvoicenodisplayonview":
                return myClaimsPage.verify_InvoiceNoisDiaplay();

            case "myclaims_clickongridicon":
                myClaimsPage.clickOn_ClaimGridIcon();
                return null;

            case "myclaims_enterfromdate":
                myClaimsPage.open_FromDate();
                
                myClaimsPage.selectDateFromText(data.get("FROM_DATE"));
                return null;

            case "myclaims_entertodate":
                myClaimsPage.open_Todate();
                myClaimsPage.selectDateFromText(data.get("TO_DATE"));
                return null;

            case "verifydatanotavailabletext":
                return myClaimsPage.get_NoDataAvailable_Text();

            case "verifyareclaimdateswithinrange":
                return myClaimsPage.areClaimDatesWithinRange(data.get("FROM_DATE"), data.get("TO_DATE"));

            case "myclaims_openfirstclaimrecord":
                myClaimsPage.openClaim(0);
                return null;

                 case "verifyclaimstatusonclaimdetails":
              return  myClaimsPage.get_ClaimDetails_ClaimStatus();
               
                case "clickoncancelbtnofclaimdetails":
                myClaimsPage.clickOn_ClaimDetails_CancelBtn();
                return null;

                case "clickonapprovetab":
                myClaimsPage.clickOn_ApprovedTab();
                return null;

                 case "clickonrejectedtab":
                myClaimsPage.clickOn_RejectedTab();
                return null;

                case "clickonpendingtab":
                myClaimsPage.clickOn_PendingTab();
                return null;

                case "myclaim_getclaimid":
                String claimId=myClaimsPage.get_ClaimIdFromView(0).trim();
                GlobalStore.put("MYCLIAMS_CLAIMID", claimId);
                return claimId;

                 case "myclaim_getdealername":
                 String dealerName=myClaimsPage.get_DealerNameFromView(0).trim();
                GlobalStore.put("MYCLIAMS_DEALERNAME", dealerName);
                return dealerName;

                case "myclaim_getproductdesc":
                String productDesc=myClaimsPage.get_ProductDescFromView(0).trim();
                GlobalStore.put("MYCLIAMS_PRODUCTDESC", productDesc);
                return productDesc;

                case "myclaim_invoiceno":
                String invNo = myClaimsPage.get_InvNoFromView(0).trim();
                GlobalStore.put("MYCLIAMS_INVNO", invNo);
                return invNo;

                case "myclaim_getclaimqty":
                String claimQty=myClaimsPage.get_ClaimQtyFromView(0).trim();
                GlobalStore.put("MYCLIAMS_CLAIMQTY", claimQty);
                return claimQty;

                case "myclaim_getclaimpoints":
                String claimPoints=myClaimsPage.get_ClaimPointFromView(0).trim();
                GlobalStore.put("MYCLIAMS_CLAIMPOINTS", claimPoints);
                return claimPoints;

                case "verifyclaimid_onclaimdetails":
               return myClaimsPage.get_ClaimDetails_ClaimId().trim();

                case "verifydealername_onclaimdetails":
               return myClaimsPage.get_ClaimDetails_DealerName().trim();

                case "verifyproductdesc_onclaimdetails":
               return myClaimsPage.get_ClaimDetails_ProductDesc().trim();

                case "verifyinvno_onclaimdetails":
               return myClaimsPage.get_ClaimDetails_InvNo().trim();

                case "verifyclaimqty_onclaimdetails":
               return myClaimsPage.get_ClaimDetails_ClaimQty().trim();

                case "verifyclaimpoints_onclaimdetails":
               return myClaimsPage.get_ClaimDetails_ClaimPoints().trim();

               case "claimdetails_clickondownloadpdf":
                myClaimsPage.clickOn_DownloadPdf();
                return null;

                 case "claimdetails_clickoncancelbtn":
                myClaimsPage.clickOn_ClaimDetails_CancelBtn();
                return null;

                 case "verifyclaimdetailstoastmsg":
               return myClaimsPage.get_ClaimDetails_ToastMsg();

               case "myclaims_clickonfabbutton":
                myClaimsPage.clickOn_FabBtn();
                return null;

                 case "verifydealerlistheadertitle":
               return dealerListPage.get_HeaderTitle();

               case "verifydealerlistwindowdisplay":
               return dealerListPage.get_HeaderTitle();

               
                case "dealerlist_clickoncrossicon":
                dealerListPage.clickOn_CrossIcon();
                return null;

                case "verify_dealerlist_mapnewdealerbtnisdisplay":
               return dealerListPage.verifyMapNewDealerBtnisdisplay();
                 
               case "dealer_clickonnextbutton":
                dealerPage.clickOn_NextBtn();
                return null;

                case "dealer_clickonchangebtn":
                dealerPage.clickOn_ChnageBtn();
                return null;

                case "dealerlist_enterdealername":
                dealerListPage.enter_TextInSerachField(data.get("DEALER_NAME"));
                return null;

                case "verify_dealerlist_isdisplay":
               return  dealerListPage.verify_DealerListisDisplay();
                 

                 case "verify_dealerlist_name": 
                String expected = data.get("DEALER_NAME");
                List<String> actualdealername = dealerListPage. get_DealerNameList();
                System.out.println("actualdealername : " + actualdealername);
                return new VerifyResult(expected, actualdealername);

                case "verify_dealerlist_mobileno": 
                String expectedmobile = data.get("DEALER_NAME");
                List<String> actualmobileno= dealerListPage. get_MobileNumberList();
                System.out.println("actualdealername : " + actualmobileno);
                return new VerifyResult(expectedmobile, actualmobileno);

               case "dealerlist_clickonradiobutton":
                dealerListPage.clickOn_RadioBtn(0);
                return null;

                 case "dealerlist_getdealername":
                    String list_dealerName =dealerListPage.get_DealerNameFromList(0);
                    GlobalStore.put("DEALERLIST_DEALERNAME", list_dealerName);
                    
                return list_dealerName ;

                case "verify_dealer_selectedealername":
                return dealerPage.get_DealerName();

                 case "dealerlist_clickonmapnewdealerbtn":
                 dealerListPage.clickOn_MapNewDealerBtn();
                 return null;
                 
                 case "verify_dealerlist_newdealer_nodatafounde":
                 return dealerListPage.get_NewDealerWindow_NoDatFoundText();

                 
                 case "verify_dealerlist_newdealer_alredyexist":
                 return dealerListPage.get_NewDealerWindow_DealerAlredyExistText();

                 case "verify_dealerlist_radiobtnisdisplay":
                 return dealerListPage.verify_RadioBtnisDisplay();

                  case "verify_dealer_changebtnisdisplay":
                 return dealerPage.get_ChangeBtnDisplay();
                 
                  case "dealerlist_clickoncancelbtn":
                 dealerListPage.clickOn_NewDealerWindow_CancelBtn();
                 return null;

                 case "dealerlist_selectnewdealer":
                String newDealer= dealerListPage.selectFirstVisibleRadioAndGetDealer();
                GlobalStore.put("DEALERLIST_NEWDEALER", newDealer);
                 return newDealer;
                 
                 case "dealerlist_clickonaddbtn":
                 dealerListPage.clickOn_NewDealerWindow_AddBtn();
                 return null;

                 case "verify_dealerlist_adddeddealerisdisplay":
                return dealerListPage.isAddedDealerDisplayed(GlobalStore.get("DEALERLIST_NEWDEALER"));

                case "verify_warningmsg":
                return dealerPage.get_WarningToastMsg();
                  
                case "dealer_clickoncancelbtn":
                 dealerPage.clickOn_CancelBtn();
                 return null;
                
                case "dealer_enterinvno": 
                dealerPage.enter_InvNo(data.get("INV_NO")+System.currentTimeMillis());
                 return  null;

                  case "dealer_clickonimagecaptureicon":
                 dealerPage.clickOn_InvPhotoIcon();
                 return null;

                  case "verifyattachdocwindowdisplay":
                return dealerPage.get_AttachDocLable();

                case "verifyattachmentoptiondisplay":
                return dealerPage.verify_BrowseFile_Option_isDisplay() && dealerPage.verify_CaptureCamera_Option_isDisplay() ;
                 
                case "clickonbrowsefileoption":
                 dealerPage.clickOn_BrowseFileOption();
                 return null;

                 case "selectimageclickonbrowsefileoption":
                 dealerPage.clickOn_BrowseFileOption(0);
                 return null;
               
                 case "clickonbackarrow":
                 categoryPage.clickOn_BackArrow();
                 return null;

                 case "category_selectcategory":
                 categoryPage.selectCategoryByHorizontalScroll(data.get("CATEGORY_NAME"));
                 return null;
                 
             

                 
                

   
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }
}
