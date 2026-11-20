package executors.querylist;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;
import pages.querylist.QueryListPage;

public class QueryListExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
    private QueryListPage queryListPage;

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
            queryListPage = new QueryListPage(driver);

        }

        switch (step.toLowerCase()) {

             case "terminateapp":
                Thread.sleep(3000);
               driver.terminateApp("com.prowess.apps.bandhan.world");
                return null;

                  case "relaunchapp":
                    Thread.sleep(2000);
               driver.activateApp("com.prowess.apps.bandhan.world");
                return null;

            case "hidekeyboard":
                companyLoginPage.hideKeyboardIfVisible();
                return null;

            case "navigatebacktodashboardpage":
                dashboardPage.navigateBackToHomeDashboard();
                return null;

            case "clickonskipbtnofinsurancewindow":
                dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
                return null;

            case "open_querylist_menu":
                dashboardPage.clickOn_QueryList_Menu();
                return null;

            case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

            case "verify_pagetitle":
               return queryListPage.get_PageTitle();

                 case "clickon_callicon":
                queryListPage.clickOn_CallIcon();
                return null;

                 case "verify_contsctus_value":
               return queryListPage.get_ContactUs_Value();

                 case "verify_emailvalue":
               return queryListPage.get_EmailValue();

                 case "verify_timevalue":
               return queryListPage.get_TimeValue();

                 case "clickon_filericon":
                queryListPage.clickOn_FilterIcon();
                return null;

                case "clickon_filerokbtn":
                queryListPage.clickOn_FilterOkBtn();
                return null;
                
                  case "enterfromdate":
                queryListPage.open_FromDate(); 
                queryListPage.selectDateFromText(data.get("FROM_DATE"));
                return null;

            case "entertodate":
                queryListPage.open_Todate();
                queryListPage.selectDateFromText(data.get("TO_DATE"));
                return null;


                case "clickon_filterapplybtn":
                queryListPage.clickOn_ApplyBtn();
                return null;

                 case "verify_noresulttext":
               return queryListPage.get_NoResultText();
                
                case "verify_ticketno":
               return queryListPage.get_TicketNo();

               case "open_firstrecord":
                queryListPage.open_firstrecord();
                return null;

                case "clickon_opentab":
                queryListPage.clickOn_OpenTab();
                return null;

                case "clickon_inprogresstab":
                queryListPage.clickOn_InprogressTab();
                return null;

                case "clickon_resolvedtab":
                queryListPage.clickOn_ResolvedTab();
                return null;

                case "clickon_completedtab":
                queryListPage.clickOn_CompletedTab();
                return null;

                case "clickon_fabbtn":
                queryListPage.clickOn_FabBtn();
                return null;

                 case "clickon_querytype":
                queryListPage.clickOn_QueryType();
                return null;

                  case "select_querytype_dropvalue":
                    Thread.sleep(1000);
                queryListPage.selectDropValues(165, 664);
                return null;

                 case "clickon_resolvedbtn":
                queryListPage.clickOn_ResolvedBtn();
                return null;

                 case "enter_briefdesc":
                queryListPage.enter_BriefDesc(data.get("BRIEF_DESC"));
                return null;

                 case "enter_detailsdesc":
                queryListPage.enter_DetailDesc(data.get("DETAIL_DESC"));
                return null;
                
                 case "verify_snackbar":
               return queryListPage.get_SnackBar_Text();

                 case "clickon_imageicon":
                queryListPage.clickOn_ImageIcon();
                return null;

                case "clickon_cameracaptureicon":
                queryListPage.clickOn_CameraCaptureIcon();
                return null;

                case "clickon_cameracapturedonebtn":
                queryListPage.clickOn_CameraCapture_donebtn();
                return null;

                  case "clickon_submitbtn":
                queryListPage.clickOn_SubmitBtn();
                return null;

                 case "verify_querytypevalue":
                    Thread.sleep(2000);
               return queryListPage.get_QueryTypeValue();

                case "verify_getbrief":
               return queryListPage.get_BriefDescValue();

                case "verify_detailsdesc":
               return queryListPage.get_DetailDescValue();

                 case "clickon_cancelbtn":
                queryListPage.clickOn_CancelBtn();
                return null;

		
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
}

}
