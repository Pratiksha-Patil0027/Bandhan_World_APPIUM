package executors.claimpoints;

import java.util.List;
import java.util.Map;

import core.GlobalStore;
import core.KeywordExecutor;
import core.VerifyResult;
import io.appium.java_client.android.AndroidDriver;
import pages.claimpoints.CardDetailsPage;
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
    private CardDetailsPage cardDetailsPage;
    

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
               cardDetailsPage = new CardDetailsPage(driver);
              
             
            
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

                  case "category_selectbrand":
                 categoryPage.selectBrandByHorizontalScroll(data.get("BRAND_NAME"));
                 return null;

                  case "category_enterproductname_insearchfield":
                 categoryPage.enter_searchData_InSearchField(data.get("PRODUCT_NAME"));
                 return null;

                 case "verify_category_get_qtywarningtoastmsg":
                 return categoryPage.verify_Qty_WarningToastMsg("Quantity should be greater than 0");

                 case "category_enterqty":    
                GlobalStore.put("PRODUCT_QTY", data.get("QTY"));
                 categoryPage.enter_QtyInputField(0,data.get("QTY"));
                 return null;

                 case "category_enter_secondqty":
                    int qty = Integer.parseInt(data.get("QTY"));
                   qty = qty + 4;
                  categoryPage.enter_QtyInputField(0, String.valueOf(qty));
                 return null;

                  case "category_selectuom":
                 categoryPage.select_UOM(0,data.get("UOM"));
                 return null;

                 case "category_get_points_fieldvalue":
                 return categoryPage.getPointsFieldValue(0);

                  case "category_get_totalpoints_fieldvalue":
                  String product_totalPoints=categoryPage.get_TotalPointsField_value(0).trim();
                GlobalStore.put("PRODUCT_TOTAL_POINTS", product_totalPoints);
                return product_totalPoints;
                  

                 
                  case "verify_category_totalpoints_fieldvalue":
                  String product_expected_totalpoints = categoryPage.verify_TotalPointsField_value(0,data.get("QTY"));
                  GlobalStore.put("PRODUCT_EXPECTED_TOTAL_POINTS", product_expected_totalpoints);
                return product_expected_totalpoints;
                  

                 case "category_clickon_addtocart_btn":
                 categoryPage.clickOn_AddToCartBtn(0);
                 return null;

                 case "category_clickon_carticon":
                 categoryPage.clickOn_CartIcon();
                 return null;

                   case "category_clickon_refreshbtn":
                 categoryPage.clickOn_RefreshBtn();
                 return null;

                  case "verify_category_cartandrefrshicon_isdisplay":
                return  categoryPage.verify_CartIconAndRefreshIcon_isDisplayed();
                 
                 case "verify_category_brandscontainer_isdisplayed":
                 return categoryPage.isBrandListPresent();

                 case "verify_category_get_warningtoastmsg":
                return  categoryPage.get_WarningToastMsg();

                case "verify_category_productsinlist_isdisplayed":
                 return categoryPage.verify_ProductsInList_isDisplayed();

                  case "verify_category_productcode_inlist":
                 return categoryPage.get_ProductCode_InList(0);

                 case "category_productcode_inlist":
                    String product_code = categoryPage.get_ProductCode_InList(0);
                  GlobalStore.put("CATEGORY_PRODUCTCODE", product_code);
                 return product_code;

                 case "category_productdesc_inlist":
                    String product_desc= categoryPage.get_ProductDescription_InList(0);
                  GlobalStore.put("CATEGORY_PRODUCTDESC", product_desc);
                 return product_desc;
                
                  case "category_productuom_inlist":
                    String productUom_Text= categoryPage.get_ProductUom_Text(0);
                  GlobalStore.put("CATEGORY_PRODUCTUOM", productUom_Text);
                 return productUom_Text;

                  case "category_productpoints_inlist":
                    String pointsFieldValue_FullText= categoryPage.getPointsFieldValue_FullText(0);
                  GlobalStore.put("CATEGORY_PRODUCT_POINTS", pointsFieldValue_FullText);
                 return pointsFieldValue_FullText;

                 
                   case "category_clear_searchfield":
                 categoryPage.clear_InputSearchField();
                 return null;

                 case "category_enter_productremark":
                 categoryPage.enter_ProductRemark(0,data.get("PRODUCT_REMARK")+System.currentTimeMillis());
                 return null;

                 case "verify_category_tonne_uom":
                 return categoryPage.get_TonneUom_Text();

                 case "category_addproductsincart":
                  categoryPage.addProductsToCart(data.get("PRODUCT_NAME"));
                  return null;
                 
                  case "verify_cartdetails_totalclaimpoints":
                 return cardDetailsPage.get_TotalClaimPoints_value();

                  case "verify_cartdetails_added_categoryname":
                 return cardDetailsPage.get_AddedCategoryName(0);

                 case "verify_cartdetails_productcount":
                 return cardDetailsPage.get_ProductCount(0);

                 case "cartdetails_clickon_updownarrow":
                  cardDetailsPage.clickOn_UpDownArrowIcon(0);
                  return null;
                 
                  case "verify_cartdetails_productcode":
                 return cardDetailsPage.get_ProductCode();

                 
                  case "verify_cartdetails_productdescription":
                 return cardDetailsPage.get_ProductDescription();

                 case "cartdetails_clickon_deleteicon":
                  cardDetailsPage.clickOn_DeleteIcon();
                  return null;

                  case "cartdetails_clickon_plusicon":
                  cardDetailsPage.clickOn_PlusIcon();
                  return null;

                  case "cartdetails_clickon_minusicon":
                  cardDetailsPage.clickOn_MinusIcon();
                  return null;
                 
                  case "verify_cartdetails_qty":
                 return cardDetailsPage.get_QtyText();

                  case "verify_cartdetails_addqty":
                 return cardDetailsPage.verify_AdditionQty_Increased_By_One();

                 case "verify_cartdetails_minusqty":
                 return cardDetailsPage.verify_AdditionQty_decreased_By_One();

                 case "verify_cartdetails_uom":
                 return cardDetailsPage.get_UOMText();

                 case "cartdetails_get_points":
                 return cardDetailsPage.get_PointsText();

                 case "verify_cartdetails_totalpoints":
                 return cardDetailsPage.get_TotalPointsText();
                
                 case "cartdetails_get_additionoftotalpoints":
                    String text= cardDetailsPage.get_AdditionOfTotalPoints();
                  GlobalStore.put("CARDDETAILS_ADDITIONTOTALPOINTS", text);
                 return text;

                  case "cartdetails_clickon_cancelbtn":
                  cardDetailsPage.clickOn_CancelBtn();
                  return null;

                   case "cartdetails_clickon_submitbtn":
                  cardDetailsPage.clickOn_SubmitBtn();
                  return null;

                  case "cartdetails_clickon_alertbox_nobtn":
                  cardDetailsPage.clickOn_Alert_DialogBox_NoBtn();
                  return null;

                  case "cartdetails_clickon_alertbox_yesbtn":
                  cardDetailsPage.clickOn_Alert_DialogBox_YesBtn();
                  return null;

                  case "verify_cartdetails_alertbox_title":
                 return cardDetailsPage.get_AlertDialogBoxTitle_Text();

                 case "cartdetails_get_alertbox_text":
                 return cardDetailsPage.get_AlertDialogBox_Text();

                  case "verify_cartdetails_nodatafoundtext":
                 return cardDetailsPage.get_NoDataFound_Text();

                 case "verify_cartdetails_submitbtn_isenabled":
                 return cardDetailsPage.verify_submitbtn_isEnable();
                  
                 
 
   
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }
}
