package executors.digitalbussinesscard;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.digitalbussinesscard.BusinessCardPage;
import pages.login.CompanyLoginPage;

public class DigitalBusinessCardExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;   
    private BusinessCardPage businessCardPage;
    
    
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
            businessCardPage = new BusinessCardPage(driver);
        
                
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

            case "open_businesscardmenu":
                dashboardPage.clickOn_BusinessCard_Menu();
                return null;

                case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();


            case "verifypagetitle":
                return businessCardPage.get_PageTitle(); 

                 case "verify_businesscard_statusonview":
                return businessCardPage.get_Status_OnView();
                
                case "clickon_rejectbtn":
                 businessCardPage.clickOn_RejectBtn();
                 return null;

                 case "clickon_acceptbtn":
                 businessCardPage.clickOn_AcceptBtn();
                 return null;

                 case "verify_warningtoastmsg":
                return businessCardPage.get_WarningToastMsg(); 

                 case "verify_proofreading_dialogboxtitle":
                return businessCardPage.get_ProofReading_DialogBox_Title(); 

                case "verify_proofreading_dialogboxtext":
                return businessCardPage. get_ProofReading_DialogBox_Text(); 

                 case "clickon_proofreading_dialogbox_nobtn":
                 businessCardPage.clickOn_ProofReading_DialogBox_NoBtn();
                 return null;

                  case "clickon_proofreading_dialogbox_yesbtn":
                 businessCardPage.clickOn_ProofReading_DialogBox_YesBtn();
                 return null;

                  case "verify_history_statusvalue":
                return businessCardPage. get_history_StatusValue(); 

                 case "verify_requestdetails_remark":
                return businessCardPage. get_RequestDetails_Remark(); 
              
                case "clickon_backarrow":
                 businessCardPage.clickOn_BackArrow();
                 return null;

                 case "openhistoryfirstrecord":
                 businessCardPage.openFirstRecord();
                 return null;

                 
		
		
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

    
}
