package executors.login;

import java.io.IOException;
import java.util.Map;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.login.ChooseLanguagePage;
import pages.login.CompanyLoginPage;
import pages.login.InfluencerLoginPage;
import core.KeywordExecutor;


public class CompanyLoginExecutor implements KeywordExecutor {

    private CompanyLoginPage page;
    private ChooseLanguagePage chooseLanguagePage;
   private  InfluencerLoginPage influencerLoginPage;
   private DashboardPage dashboardPage;
 
    @Override
public Object execute(
        String step,
        Map<String, String> data,
        AndroidDriver driver) throws InterruptedException {

    if (driver == null) {
        throw new IllegalStateException(
            "AndroidDriver is NULL. Appium session not initialized."
        );
    }

    if (page == null) {
        page = new CompanyLoginPage(driver);
        chooseLanguagePage =new ChooseLanguagePage(driver);
        influencerLoginPage= new InfluencerLoginPage(driver);
        dashboardPage= new DashboardPage(driver);
    }

        switch (step.toLowerCase()) {


            case "clickonwarningdialogbox":
                page.clickOn_WarningDialogBox_UntilExpectedVisible();
                return null;

                 case "pressdeviceback":
                page.pressDeviceBack();
                return null;

                
                case "connectwifi":
                try {
                    page.wifiOn();
                    Thread.sleep(2000);
                } catch (IOException e) {
                
                    e.printStackTrace();
                }
                return null;
     
            case "entercompanyname":
                page.enterCompanyName(data.get("COMPANY_NAME"));
                return null;

            case "clicksubmitbutton":
                page.clickOn_Submit_Button();
                return null;
   
            case "verifycompanyerrormessage":
                return page.getErrorMessage();

            case "hidekeyboard":  
            page.hideKeyboardIfVisible();
            return null ;

             case "verifychooselanguagepagedisplay":  
           return chooseLanguagePage.verifyChooseLanguagePageisdisplay();
             
            case "selectenglishlanguage":  
            chooseLanguagePage.select_English_language();
            return null ;

             case "clickonselectlanguagesubmitbtn":  
            chooseLanguagePage.clickOn_SelectLanguage_SubmitBtn();
            return null ;

            case "clickondeclarationnextbtn":  
            chooseLanguagePage.clickOn_DeclarationNextBtn_UntilExpectedVisible();
            return null ;

             case "entermobilenumber":  
            influencerLoginPage.enterMobileNumber(data.get("MOBILE_NUMBER"));
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

             case "clickonskipbtnofinsueancewindow":  
            dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
            return null ;



 case "refreshloginpage":
    AndroidDriver androidDriver = (AndroidDriver) driver;

   if (androidDriver.queryAppState("com.prowess.apps.bandhan.world").name()
        .equals("NOT_RUNNING")) {

            ((AndroidDriver) driver).activateApp("com.prowess.apps.bandhan.world");
    
}


    return null;

          
    
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }
}
