package executors.catalogue;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.catalogue.CataloguePage;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;
import pages.login.InfluencerLoginPage;
import pages.profile.ProfilePage;

public class CatalogueExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
     private  InfluencerLoginPage influencerLoginPage;  
       private ProfilePage profilePage;
    private CataloguePage cataloguePage;

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
            influencerLoginPage= new InfluencerLoginPage(driver);
             profilePage = new ProfilePage(driver);
            cataloguePage = new CataloguePage(driver);

        }

        switch (step.toLowerCase()) {

             case "profile_clickon_showprofile":
                profilePage.clickOn_profileShow();
                return null;

                 case "clickon_signout":
                profilePage.clickOn_logoutBtn();
                return null;

                case "clickon_signout_yesbtn":
                profilePage.clickOn_logout_YesBtn();
                return null;

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
                return null;

            case "navigatebacktodashboardpage":
                dashboardPage.navigateBackToHomeDashboard();
                return null;

            case "clickonskipbtnofinsurancewindow":
                dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
                return null;

            case "open_cataloguemenu":
                dashboardPage.clickOn_Catalogue_Menu();
                return null;

            case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

            case "verify_pagetitle":
                return cataloguePage.get_PageTitle();

      case "enter_productname":
                cataloguePage.enter_ProductName(data.get("PRODUCT_CODE"));
                return null;

                 case "verify_snackbartext":
                return cataloguePage.get_SnackBarText();

                case "verify_productcode":
                return cataloguePage.get_ProductCode();

                
                case "clickon_pcc_category":
                cataloguePage.clickOn_PCC_Category();
                return null;

                

            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

}
