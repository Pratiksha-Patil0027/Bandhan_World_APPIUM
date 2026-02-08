package executors.claimpoints;

import java.util.Map;

import core.GlobalStore;
import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.claimpoints.DealerListPage;
import pages.claimpoints.MyClaimsPage;
import pages.dashboard.DashboardPage;

public class ClaimPointsExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private MyClaimsPage myClaimsPage;
    private DealerListPage dealerListPage;
    

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
            
        }

        switch (step.toLowerCase()) {

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
                 

                case "navigatebacktodashboardpage": 
                dashboardPage.navigateBackToHomeDashboard();
                 return  null;
                


            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }
}
