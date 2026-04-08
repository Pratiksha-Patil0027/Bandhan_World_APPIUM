package executors.dreamgift;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.dreamgift.DreamGiftPage;
import pages.login.CompanyLoginPage;
import pages.myheathbenefits.MyHeathBenefitsPage;

public class DreamGiftExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
    private DreamGiftPage dreamGiftPage;

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
            dreamGiftPage = new DreamGiftPage(driver);

        }

        switch (step.toLowerCase()) {

            case "hidekeyboard":
                companyLoginPage.hideKeyboardIfVisible();
                return null;

            case "navigatebacktodashboardpage":
                dashboardPage.navigateBackToHomeDashboard();
                return null;

            case "clickonskipbtnofinsurancewindow":
                dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
                return null;

            case "open_dreamgift_menu":
                dashboardPage.clickOn_DreamGift_Menu();
                return null;

            case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

            case "verify_pagetitle":
               return dreamGiftPage.get_PageTitle();

                case "verify_nodataavailable_text":
               return dreamGiftPage.get_NoResultAvailable_Text();


            case "clickon_fabbtn":
                dreamGiftPage.clickOn_FabBtn();
                return null;

                 case "enter_searchdata":
                dreamGiftPage.enter_GiftCode(data.get("INPUT_DATA"));
                return null;

                case "verify_snackbar_text":
               return dreamGiftPage.get_SnackBarText();

                case "verify_giftcodeinlist":
               return dreamGiftPage.get_GiftCode();

                 case "clickon_gift":
                dreamGiftPage.clickOn_Gift();
                return null;
               

                case "verify_addgift_giftcode":
               return dreamGiftPage.get_AddGift_GiftCode();

                case "verify_addgift_giftname":
               return dreamGiftPage.get_AddGift_GiftName();

                case "verify_addgift_giftdesc":
               return dreamGiftPage.get_AddGift_GiftDesc();

               case "verify_addgift_gifttotalpoints":
               return dreamGiftPage.get_AddGift_TotalPoints();

               case "clickon_submitbtn":
                dreamGiftPage.clickOn_SubmitBtn();
                return null;

               case "verify_alertdialog_title":
               return dreamGiftPage.get_AlertDialog_Title();

                case "clickon_alertdialog_yesbtn":
                dreamGiftPage.clickOn_AlertDialog_YesBtn();
                return null;

                 case "clickon_deleteicon":
                dreamGiftPage.clickOn_DeleteIcon();
                return null;

	
            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

}
