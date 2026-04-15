package executors.insurancekyc;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.insurancekyc.KYCDetailsPage;
import pages.login.CompanyLoginPage;
import pages.login.InfluencerLoginPage;
import pages.mywebsite.MyWebSitePage;
import pages.profile.ProfilePage;

public class InsuranceKYCExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
    private KYCDetailsPage kYCDetailsPage;
      private  InfluencerLoginPage influencerLoginPage;  
       private ProfilePage profilePage;
        private MyWebSitePage myWebSitePage;

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
            kYCDetailsPage = new KYCDetailsPage(driver);
            influencerLoginPage= new InfluencerLoginPage(driver);
             profilePage = new ProfilePage(driver);
              myWebSitePage = new MyWebSitePage(driver);

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

            
             case "clickonskipbtnofinsurancewindow":
                dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
                return null;

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

            case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

            case "verify_pagetitle":
               return kYCDetailsPage.get_PageTitle();

               case "clickon_proceedbtn":
                kYCDetailsPage.clickOn_ProceedBtn();
                return null;

                case "verify_insurancedialog_text":
               return kYCDetailsPage.get_InsuranceDialog_Text();
               
               case "click_ifwarningdisplay":
                kYCDetailsPage.universal_WarningDialogBox_isDisplay();
                return null;

                 case "navigatebacktopersonaldetailspage":
                kYCDetailsPage.navigateBackToPersonalDetailsPage();
                return null;
		
                 case "enter_nomineename":
                kYCDetailsPage.enter_NomineeName(data.get("NOMINEE_NAME"));
                return null;

                  case "clickon_genderfield":
                kYCDetailsPage.clickOn_GenderField();
                return null;

                 case "select_generdropvalue":
                    Thread.sleep(1000);
                kYCDetailsPage.selectDropValues(105,870);
                return null;

                 case "select_spousegenerdropvalue":
                    Thread.sleep(1000);
                kYCDetailsPage.selectDropValues(105,994);
                return null;

                 case "clickon_dobfield":
                kYCDetailsPage.clickOn_DOBField();
                return null;

                  case "clickon_calenderokbtn":
                kYCDetailsPage.clickOn_CalenderOkBtn();
                return null;

                 case "enter_aadharnumber":
                kYCDetailsPage.enter_AadharNumber(data.get("AADHAR_NUMBER"));
                return null;

                 case "clickon_aadharphoto_front":
                kYCDetailsPage.clickOn_AadharPhoto_Front();
                return null;

                case "clickon_browsefileoption":
                myWebSitePage.clickOn_BrowseFileOption();
                return null;

                 case "clickon_gallarylisticon":
                myWebSitePage.clickOn_Gallary_ListIcon();
                return null;


            case "select_aadhar_frontimage":
                myWebSitePage.selectGalleryImageByName("shared image.jpg");
                return null;

                 case "select_aadhar_backimage":
                myWebSitePage.selectGalleryImageByName("shared image-3.jpg");
                return null;

                case "select_pan_image":
                myWebSitePage.selectGalleryImageByName("shared image-2.jpg");
                return null;

            case "clickon_gallarydonebtn":
                myWebSitePage.clickOn_GallaryDoneButton();
                return null;

                  case "clickon_aadharphoto_back":
                kYCDetailsPage.clickOn_AadharPhoto_Back();
                return null;

                case "clickon_documentphoto":
                kYCDetailsPage.clickOn_DocumentPhoto();
                return null;

                case "verify_snackbartext":
               return kYCDetailsPage.get_SnackBar_Text();

                case "waitforsnackbardisappear":
                 kYCDetailsPage.waitForSnackbarToDisappear();
                 return null;

                case "clickon_panphoto":
                kYCDetailsPage.clickOn_PanPhoto();
                return null;

                 case "clickon_maritalstatusfield":
                kYCDetailsPage.clickOn_MaritalStatusField();
                return null;

                 case "clickon_submitbtn":
                kYCDetailsPage.clickOn_SubmitBtn();
                return null;

                 case "clickon_noofchildrenfield":
                kYCDetailsPage.clickOn_NoOfChildrenField();
                return null;

                 case "select_maritalstatus_dropvalue":
                    Thread.sleep(1000);
                kYCDetailsPage.selectDropValues(131, 1596);
                return null;

                  case "verify_noofchildrenfield_isdisplay":
               return kYCDetailsPage.verify_NoOfChildrenField_isDisplay();

                 case "enter_noofchildren":
                kYCDetailsPage.enter_noofChildren("1");
                return null;
               
            case "verify_dialogalert_title":
               return kYCDetailsPage.get_DialogAlreat_TitleText();

                 case "clickon_dialogalert_yesbtn":
                kYCDetailsPage.clickOn_DialogAlert_YesBtn();
                return null;

            case "verify_successdialog_title":
               return kYCDetailsPage.get_Success_TitleText();

                case "clickon_successdialog_okbtn":
                kYCDetailsPage.clickOn_SuccessDialog_OkBtn();
                return null;

                 case "clickon_vehicle_toggle_yesbtn":
                kYCDetailsPage.clickOn_Vehicle_ToggleYesBtn();
                return null;

                 case "clickon_vehicle_toggle_nobtn":
                kYCDetailsPage.clickOn_Vehicle_ToggleNoBtn();
                return null;
                
            case "verify_vehicletypesfield_isdisplay":
               return kYCDetailsPage.verify_vehicleTypesField_isDisplay();

                 case "clickon_vehicle_typesdrop_field":
                kYCDetailsPage.clickOn_Vehicle_TypesDropField();
                return null;

                  case "select_vehicle_typesdropvalue":
                    Thread.sleep(1000);
                kYCDetailsPage.selectDropValues(165, 798);
                return null;

                 case "enter_vehiclenumber":
                kYCDetailsPage.enter_VehicleNumber(data.get("VEHICLE_NUMBER"));
                return null;

                 case "enter_vehicle_manufactureby":
                kYCDetailsPage.enter_Vehicle_Manufactured(data.get("VEHICLE_MANUFACTURED"));
                return null;

                 case "enter_vehiclemodel":
                kYCDetailsPage.enter_VehicleModel(data.get("VEHICLE_MODEL"));
                return null;


            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

}
