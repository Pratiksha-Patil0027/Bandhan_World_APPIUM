package executors.digitalbussinesscard;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.digitalbussinesscard.SendDigitalCardPage;
import pages.login.CompanyLoginPage;
import pages.login.InfluencerLoginPage;
import pages.profile.ProfilePage;

public class SendBusinessCardExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
     private SendDigitalCardPage sendDigitalCardPage;
      private  InfluencerLoginPage influencerLoginPage;  
       private ProfilePage profilePage;
     
    
    
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
            sendDigitalCardPage = new SendDigitalCardPage(driver);
            influencerLoginPage= new InfluencerLoginPage(driver);
             profilePage = new ProfilePage(driver);
        
                
        }

       switch (step.toLowerCase()) {

              case "enter_loginmobilenumber":  
            influencerLoginPage.enterMobileNumber(data.get("INFLUENCER_MOBILENO"));
            return null ;

            case "clickongetotpbtn":  
            influencerLoginPage.clickOn_GetOtp_Btn();
            return null ;

             case "enterotp":  
            influencerLoginPage.enterOTP(data.get("OTP"));
            return null ;

            case "clickonotpsubmitbtn":  
            influencerLoginPage.clickOn_OtpSubmit_Btn();
            return null ;

            case "hidekeyboard":  
            companyLoginPage.hideKeyboardIfVisible();
            return null ;
                
                case "navigatebacktodashboardpage": 
                dashboardPage.navigateBackToHomeDashboard();
                 return  null;

            case "clickonskipbtnofinsurancewindow":
                dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
                return null;

                case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

                case "verify_warningtoastmsg":
                return sendDigitalCardPage.get_WarningMsg();

                case "clickon_sendbtn":
                sendDigitalCardPage.clickOn_SendBtn();
                return null;

                case "verify_sendbtnisenabled":
                return sendDigitalCardPage.verify_SendBtnIsEnabled();

                
                case "enter_mobileno":
                sendDigitalCardPage.enter_MobileNo(data.get("MOBILENO"));
                return null;

                case "verify_entermobilenofield_lablename":
                return sendDigitalCardPage.get_entermobile_lableName();

                 case "profile_clickon_showprofile":
                profilePage.clickOn_profileShow();
                return null;

                 case "clickon_signout":
                profilePage.clickOn_logoutBtn();
                return null;

                case "clickon_signout_yesbtn":
                profilePage.clickOn_logout_YesBtn();
                return null;

                







                 
		
		
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

    
}
