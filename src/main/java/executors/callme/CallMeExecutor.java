package executors.callme;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.callme.CallMePage;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;

public class CallMeExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CallMePage callMePage;
    private CompanyLoginPage companyLoginPage;   
    
    
    
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
            callMePage = new CallMePage(driver);
        
                
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

            case "open_callmemenu":
                dashboardPage.clickOn_CallMe_Menu();
                return null;

                case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();


            case "verifypagetitle":
                return callMePage.get_PageTitle(); 
              

                 case "callhistory_clickon_filtericon":
                callMePage.clickOn_FilterIcon(); 
                return null;
                

            case "callhistory_enterfromdate":
                callMePage.open_FromDate(); 
                callMePage.selectDateFromText(data.get("FROM_DATE"));
                return null;

            case "callhistory_entertodate":
                callMePage.open_Todate();
                callMePage.selectDateFromText(data.get("TO_DATE"));
                return null;

                 case "verify_callhistory_arecalldates_withinrange":
                return callMePage.areCallDatesWithinRange(data.get("FROM_DATE"), data.get("TO_DATE"));

                case "callhistory_openfirstrecord":
                callMePage.openFirstRecord();
                return null;

                case "callhistory_clickon_filterapplybtn":
                callMePage.clickOn_FilterApplyBtn();
                return null;

                case "callhistory_clickon_callmenowbtn":
                callMePage.clickOn_callMeNowBtn();
                return null;

                 case "verify_callhistory_reasontitle":
                return callMePage.get_ReasonDialogBox_Title();

                case "callhistory_clickon_reasondropdownfield":
                callMePage.clickOn_ReasonDropDownField();
                return null;

                 case "callhistory_enter_reason":
                callMePage.enter_ReasonDropDownField("Need");
                return null;

                //  case "callhistory_select_reason":
                // callMePage.select_ReasonDropValue();
                // return null; 
                

                 case "callhistory_select_dmiwebsite":
                callMePage.selectReasonDropValue(1);
                return null;

                case "callhistory_select_healthbenefits":
                callMePage.clickOn_ReasonDropDown_SubmitBtn();
                return null;


                case "callhistory_clickon_reasoncancelbtn":
                callMePage.clickOn_ReasonDropDown_CancelBtn();
                return null;

                case "callhistory_clickon_clickonreasonsubmitbtn":
                callMePage.clickOn_ReasonDropDown_SubmitBtn();
                return null;

                case "verify_reasondialog_errormsg":
                return callMePage.get_ReasonDialogBox_ErrorMsg();

                case "verify_callhistory_requestno":
                return callMePage.get_requestNo();

                case "verify_callhistory_calltype":
                return callMePage.get_CallType();

                case "verify_callhistory_noofattempts":
                return callMePage.get_NoOfAttempts();

                case "verify_callhistory_callstatus":
                return callMePage.get_CallStatus();

                case "verify_callhistory_attempt1date":
                return callMePage.get_Attempt1_Date();

                case "verify_callhistory_attempt2date":
                return callMePage.get_Attempt2_Date();

                case "verify_callhistory_attempt1status":
                return callMePage.get_Attempt1_Status();

                case "verify_callhistory_attempt2status":
                return callMePage.get_Attempt2_Status();

                case "verify_callhistory_attempt1remark":
                return callMePage.get_Attempt1_Remark();

                case "verify_callhistory_attempt2remark":
                return callMePage.get_Attempt2_Remark();

                case "verify_callhistory_warningtoastmsg":
                return callMePage.get_Warning_ToastMsg();

                case "verify_callhistory_noresultavailable":
                return callMePage.get_NoResultText();
                
            
   
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

    
}
