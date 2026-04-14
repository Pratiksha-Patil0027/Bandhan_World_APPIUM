package executors.myhealthbenefits;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;
import pages.login.InfluencerLoginPage;
import pages.myheathbenefits.MyHeathBenefitsPage;
import pages.profile.ProfilePage;

public class MyHealthBenefitsExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
    private MyHeathBenefitsPage myHeathBenefitsPage;
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
            myHeathBenefitsPage = new MyHeathBenefitsPage(driver);
              influencerLoginPage= new InfluencerLoginPage(driver);
             profilePage = new ProfilePage(driver);

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

            case "open_myhealthbenefitsmenu":
                dashboardPage.clickOn_MyHealthBenefits_Menu();
                return null;

            case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

            case "verify_pagetitle":
               return myHeathBenefitsPage.get_PageTitle();

                case "clickon_backarrow":
                myHeathBenefitsPage.clickOn_BackArrow();
                return null;

                 case "navigatebackto_myhealthpage":
                myHeathBenefitsPage.navigateBackToMyHealthPage();
                return null;

                 case "navigatebackto_claimdetailswindow":
                myHeathBenefitsPage.navigateBackToClaimDetailsWindow();
                return null;

                 case "verify_teleconsultine_status":
               return myHeathBenefitsPage.get_Teleconsultine_Status();

                case "verify_gpa_status":
               return myHeathBenefitsPage.get_GPA_Status();

                case "verify_hospicash_status":
               return myHeathBenefitsPage.get_Hospicash_Status();

               case "verify_grouphealth_status":
               return myHeathBenefitsPage.get_GroupHealth_Status();

                case "clickon_teleconsulting_arrow":
                myHeathBenefitsPage.clickOn_Teleconsulting_Arrow();
                return null;

                case "clickon_gpa_arrow":
                myHeathBenefitsPage.clickOn_GPA_Arrow();
                return null;

                 case "clickon_grouphealth_arrow":
                myHeathBenefitsPage.clickOn_GroupHealth_Arrow();
                return null;

                 case "clickon_hospicash_arrow":
                myHeathBenefitsPage.clickOn_Hospicash_Arrow();
                return null;

                 case "clickon_opddetails_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(0);
                return null;

                 case "clickon_grouphealthdetails_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(1);
                return null;

                  case "clickon_policydocument_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(0);
                return null;

                  case "clickon_docforclaimsubmission_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(1);
                return null;

                 case "clickon_networkhospital_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(1);
                return null;

                 case "clickon_healthcard_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(2);
                return null;

                 case "clickon_checklist_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(3);
                return null;

                 case "clickon_claimform_viewicon":
                myHeathBenefitsPage.clickOn_PolicyDetails_ViewIcon(4);
                return null;

                case "clickon_mailicon":
                myHeathBenefitsPage.clickOn_EmailIcon();
                return null;

                  case "clickon_grouphealth_mailicon":
                myHeathBenefitsPage.clickOn_GroupHealth_EmailIcon();
                return null;

                

                 case "verify_welcometomail_text":
               return myHeathBenefitsPage.get_Welcometomail();
      
                case "verify_teleconsultpage_membershipno":
               return myHeathBenefitsPage.get_TeleConsultPage_MembershipNo();

               case "verify_teleconsultpage_status":
               return myHeathBenefitsPage.get_TeleConsultPage_Status();

               case "verify_teleconsultpage_amountvalue":
               return myHeathBenefitsPage.get_TeleConsultPage_AmountValue();

                case "clickon_bookappointment":
                myHeathBenefitsPage.clickOn_BookAppointment();
                return null;

                 case "clickon_videoicon":
                myHeathBenefitsPage.clickOn_VideoIcon();
                return null;

                 case "clickon_documenticon":
                myHeathBenefitsPage.clickOn_DocumentIcon();
                return null;

                 case "verify_bookappointnavigation":
               return myHeathBenefitsPage.verify_bookAppointNavigate();

                case "verify_videoprogressbar_isdisplay":
               return myHeathBenefitsPage.verify_VideoProgressBar_isDisplay();

               case "verify_policynumber":
               return myHeathBenefitsPage.get_PolicyNumber();

                case "verify_policynumber_activestatus":
               return myHeathBenefitsPage.get_PolicyNo_ActiveStatus();

                case "verify_insurancecoverage":
               return myHeathBenefitsPage.get_InsuranceCoverage();

                case "verify_policyprovider":
               return myHeathBenefitsPage.get_PolicyProvider();

                case "verify_claimdetails_title":
               return myHeathBenefitsPage.get_ClaimDetailsWin_Title();

                case "verify_claimdetails_patientname":
               return myHeathBenefitsPage.get_ClaimDetailsWin_PatientName();

               case "enter_claimdetails_hospitalname":
                myHeathBenefitsPage.enter_ClaimDetails_HospitalName(data.get("HOSPITALNAME"));
                return null;

                  case "clickon_claimdetails_patientnamedropdown":
                myHeathBenefitsPage.clickOn_ClaimDetails_PatientName();
                return null;

                  case "select_claimdetails_patientnamedropdown":
                    Thread.sleep(1000);
                myHeathBenefitsPage.selectDropValues(190, 564);
                return null;

                 case "enter_claimdetails_contactno":
                myHeathBenefitsPage.enter_ClaimDetails_ContactNo(data.get("CONTACTNUMBER"));
                return null;

                 case "enter_claimdetails_illeness":
                myHeathBenefitsPage.enter_ClaimDetails_Illeness(data.get("NATURE_ILLENESS"));
                return null;

                 case "clickon_claimdetails_datefield":
                myHeathBenefitsPage.clickOn_ClaimDetails_DateField();
                return null;

                 case "clickon_claimdetails_cancelbtn":
                myHeathBenefitsPage.clickOn_ClaimDetails_CancelBtn();
                return null;

                 case "clickon_claimdetails_sendmailbtn":
                myHeathBenefitsPage.clickOn_ClaimDetails_SendMailBtn();
                return null;

                 case "clickon_claimdetails_admissiontimefield":
                myHeathBenefitsPage.clickOn_ClaimDetails_AdmissionTimeField();
                return null;

                 case "clickon_claimdetails_timeokbtn":
                myHeathBenefitsPage.clickOn_ClaimDetails_TimeOkBtn();
                return null;

                
                 case "clickon_calenderokbtn":
                myHeathBenefitsPage.clickOn_Calender_OkBtn();
                return null;

                 case "verify_chrometitle":
               return myHeathBenefitsPage.get_CromeTitleText();

                case "verify_coveredmembersnames":
               return myHeathBenefitsPage.coveredmembersnames();

                  case "verify_snackbartext":
               return myHeathBenefitsPage.get_SnackBar_Text();
		

            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

}
