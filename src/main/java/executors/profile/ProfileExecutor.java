package executors.profile;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.claimpoints.CategoryPage;
import pages.claimpoints.DealerListPage;
import pages.claimpoints.DealerPage;
import pages.claimpoints.MyClaimsPage;
import pages.dashboard.DashboardPage;
import pages.login.ChooseLanguagePage;
import pages.login.CompanyLoginPage;
import pages.profile.ProfilePage;



public class ProfileExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private MyClaimsPage myClaimsPage;
    private DealerListPage dealerListPage;
    private DealerPage dealerPage;
  private CompanyLoginPage companyLoginPage;
  private CategoryPage categoryPage;
    private ProfilePage profilePage;
    private ChooseLanguagePage chooseLanguagePage;
    
    
    

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
            profilePage = new ProfilePage(driver);
             chooseLanguagePage =new ChooseLanguagePage(driver);
            
        }

        switch (step.toLowerCase()) {
            case "clickshowprofile":
                profilePage.clickOn_profileShow();
                return null;

            case "verifypagetitle":
                return profilePage.get_PageTitle(profilePage.profileLabel_Element);

            case "verifyisusernamedisplayonview":
                return profilePage.get_PageTitle(profilePage.name_Element);

            case "verifyisuseraddressdisplayonview":
                return profilePage.get_PageTitle(profilePage.address_Element);

            case "verifyisusernumberdisplayonview":
                return profilePage.get_PageTitle(profilePage.phone_Element);

            case "verifyinfuniqueiddisplayonview":
                return profilePage.get_PageTitle(profilePage.id_Element);

            case "verifyuseremaildisplayonview":
                return profilePage.get_PageTitle(profilePage.email_Element);

            case "verifyowngarrageondisplay":
                return profilePage.get_PageTitle(profilePage.ownGarage_Element);

            case "verifyfirmnameondisplay":
                return profilePage.get_PageTitle(profilePage.owngarage_text_Element);

            case "verifygarrageaddressondisplay" :
                return profilePage.get_PageTitle(profilePage.ownGarage_address_Element);

            case "verifypermanenetaddressondisplay" : 
                return profilePage.get_permanent_address_TextAfterScroll(profilePage.permanent_address_Element,
				"com.prowess.apps.bandhan.world:id/tvPermanentAddress");

            case "verifyaadharnumberondisplay" : 
                return profilePage.get_permanent_address_TextAfterScroll(profilePage.aadhar_number_Element,
				"com.prowess.apps.bandhan.world:id/tvAadhaarNumber");
            
            
            case "verifypannumberondisplay" :
                return profilePage.get_permanent_address_TextAfterScroll(profilePage.pan_number_Element,
				"com.prowess.apps.bandhan.world:id/tvPanNumber");

            case "verifydrivinglicensenumberondisplay" :
                return profilePage.get_permanent_address_TextAfterScroll(profilePage.drivingLicenseNumber_Element,
				"com.prowess.apps.bandhan.world:id/tvDrivingLicenseNumber");

            case "verifylanguageondisplay" :
                return profilePage.get_permanent_address_TextAfterScroll(profilePage.language_Element,
				"com.prowess.apps.bandhan.world:id/tvLanguage");

            case "verifyoptindateondisplay" :
                return profilePage.get_permanent_address_TextAfterScroll(profilePage.optindate_Element,
				"com.prowess.apps.bandhan.world:id/tvOPTInDate");

            case "verifyappversionondisplay" :
                return profilePage.get_permanent_address_TextAfterScroll(profilePage.appversion_Element,
				"com.prowess.apps.bandhan.world:id/tvAppVersion");

            case "verifymilestonepointsondisplay" :
                return profilePage.get_PageTitle(profilePage.milestoneCount_Element);

            case "verifybalancepointsondisplay" :
                return profilePage.get_PageTitle(profilePage.balanceCount_Element);

            case "verifylockedpointsondisplay" :
                return profilePage.get_PageTitle(profilePage.lockCount_Element);

            // case "verifyinfluencerimageondisplay":
            //     profilePage.isImageViewVisible();
            //     return null;

            case "verifymilestonehorizontalscroll":
                profilePage.milestoneHorizontalScroll();
                return null;           

            case "selectenglishlanguage":  
                chooseLanguagePage.select_English_language();
                return null ;

            case "clickonselectlanguagesubmitbtn":  
                chooseLanguagePage.clickOn_SelectLanguage_SubmitBtn();
                return null ;

            case "clickondeclarationnextbtn":  
                chooseLanguagePage.clickOn_DeclarationNextBtn_UntilExpectedVisible();
                return null ;     
                
            case "navigatebacktodashboardpage": 
                dashboardPage.navigateBackToHomeDashboard();
                return  null;

            case "clickonsignout":
                profilePage.clickOn_logoutBtn();
                return null;

            case "veriftysignoutlable":
                profilePage.get_PageTitle(profilePage.SIGNOUT_DIALOG_TITLE);
                return null;

            case "clickonnosignout":
                return profilePage.clickOn_logoutBtnNo();

            case "clickondeleteaccountbtn":
                profilePage.clickondeleteaccountbtn(profilePage.deleteAccountBtn_Element);
                return null;

            case "verifydeleteaccounttitle":
                return profilePage.get_PageTitle(profilePage.deleteAccount_header_Element);

            case "verifydeleteaccountmsg":
                return profilePage.get_PageTitle(profilePage.deleteAccount_text_Element);

            case "verifydeleteaccinfname":
                return profilePage.get_PageTitle(profilePage.deleteAccount_infname_Element);
            
            case "verifydeleteaccerrormsg":
                return profilePage.get_PageTitle(profilePage.deleteAccount_error_msg_Element);

            case "clickondeleteaccnobtn" :
                profilePage.clickondeleteaccountbtn(profilePage.deleteAccount_cancelBtn_Element);
                return null;
   
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }
}
