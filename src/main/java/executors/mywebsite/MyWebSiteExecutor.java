package executors.mywebsite;

import java.util.Map;

import core.GlobalStore;
import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;
import pages.mywebsite.MyWebSitePage;

public class MyWebSiteExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
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
            myWebSitePage = new MyWebSitePage(driver);

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

            case "open_mywebsitemenu":
                dashboardPage.clickOn_MyWebSite_Menu();
                return null;

            case "verify_navigatetodashboard":
                return dashboardPage.claimPointsMenuIsDisplay();

            case "verify_pagetitle":
                return myWebSitePage.get_PageTitle();

            case "mywebsite_clickon_createbtn":
                myWebSitePage.clickOn_MyWebSite_CreateNewBtn();
                return null;

            case "mywebdemo_clickon_proceedbtn":
                myWebSitePage.clickOn_WebSiteDemo_ProceedBtn();
                return null;

            case "fillerinfo_clickon_doitlaterbtn":
                myWebSitePage.clickOn_FillerInfo_DoItLaterBtn();
                return null;

            case "fillerinfo_clickon_proceedbtn":
                myWebSitePage.clickOn_FillerInfo_ProceedBtn();
                return null;

            case "clickon_backarrowbtn":
                myWebSitePage.clickOn_BackArrrowBtn();
                return null;

            case "verify_alert_dialog_title":
                return myWebSitePage.get_Alert_DialogBox_Title();

            case "verify_alert_dialog_text":
                return myWebSitePage.get_Alert_DialogBox_Text();

            case "clickon_alert_dialog_nobtn":
                myWebSitePage.clickOn_Alert_DialogBox_NoBtn();
                return null;

            case "clickon_alert_dialog_yesbtn":
                myWebSitePage.clickOn_Alert_DialogBox_YesBtn();
                return null;

            case "verify_mywebsite_webversion":
                return myWebSitePage.get_MyWebSite_WebVersion_Text();

            case "verify_mywebsite_webversion_status":
                return myWebSitePage.get_MyWebSite_WebVersion_Status();

            case "verify_mywebsite_draftbtntext":
                return myWebSitePage.get_MyWebSite_DraftBtn_Text();

            case "verify_isdraftbtn_display":
                return myWebSitePage.myWebSite_DraftBtn_isDisplay();

            case "clickon_mywebsite_draftbtn":
                myWebSitePage.clickOn_MyWebSite_DraftBtn();
                return null;

            case "verify_personalinfo_header":
                return myWebSitePage.get_PersonalInfo_HeaderName();

            case "personalinfo_enter_fullname":
                myWebSitePage.personalInfo_Enter_FullName(data.get("INPUT_DATA"));
                return null;

            case "personalinfo_clickon_rolefirmdropfield":
                myWebSitePage.personalInfo_ClickOn_RoleFirmDropField();
                return null;

            case "personalinfo_select_rolefirmdropvalue":
                myWebSitePage.personalInfo_Select_RoleFirmDropValue();
                return null;

            case "personalinfo_clickon_workprofessionfield":
                myWebSitePage.personalInfo_ClickOn_WorkProfessionField();
                return null;

            case "verify_mysiteconfig_pagetitle":
                return myWebSitePage.get_MySiteConfig_PageTitle();

            case "clickon_selectyearvalue":
                myWebSitePage.clickOn_SelectYearValue();
                return null;

            case "clickon_selectyearokbtn":
                myWebSitePage.clickOn_SelectYearOkBtn();
                return null;

            case "personalinfo_clickon_cityarea":
                myWebSitePage.personalInfo_ClickOn_CityArea();
                return null;

            case "verify_listwindow_title":
                return myWebSitePage.get_ListWindow_Title();

            case "listwindow_enter_searchdata":
                myWebSitePage.enter_ListWindow_InSearchFilter(data.get("INPUT_DATA"));
                return null;

            case "verify_listwindow_count":
                return myWebSitePage.get_ListWindow_Count();

            case "verify_listwindow_dropvalues":
                return myWebSitePage.get_ListWindow_Dropvalues();

            case "verify_listwindow_dropvalue":
                return myWebSitePage.get_ListWindow_Dropvalue();

            case "verify_listwindow_listemptytext":
                return myWebSitePage.get_ListWindow_ListEmptyText();

            case "verify_listwindow_errortoastmsg":
                return myWebSitePage.verify_ToastMsg_InPageSource(data.get("ERROR_MSG"));

            case "verify_listwindow_errortoastmsgs":
                return myWebSitePage.getToastMessage();

            case "select_listwindow_dropoption":
                myWebSitePage.select_ListWindow_values(data.get("INPUT_DATA"), data.get("ELEMENT_NAME"));
                return null;

            case "select_listwindow_dropvalues":
                myWebSitePage.select_ListWindow_DropValue(data.get("INPUT_DATA"));
                return null;

            case "clickon_listwindow_cancelbtn":
                myWebSitePage.clickOn_ListWindow_CancelButton();
                return null;

            case "clickon_listwindow_crossbtn":
                myWebSitePage.clickOn_ListWindow_CrossButton();
                return null;

            case "clickon_listwindow_selectbtn":
                myWebSitePage.clickOn_ListWindow_SelectButton();
                return null;

            case "verify_personalinfo_selectedserviceareavalues_onview":
                return myWebSitePage.personalInfo_get_SelectedServiceArea_Values_OnView();

            case "personalinfo_clickon_ownerphoto":
                myWebSitePage.personalInfo_clickOn_OwnerPhoto_ImageIcon();
                return null;

            case "verify_attachdoclabel":
                return myWebSitePage.get_AttachDocLable();

            case "clickon_browsefileoption":
                myWebSitePage.clickOn_BrowseFileOption();
                return null;

            case "clickon_cameracaptureoption":
                myWebSitePage.clickOn_CameraCaptureOption();
                return null;

            case "select_gallaryimage":
                myWebSitePage.select_GallaryImage(0);
                return null;

            case "clickon_gallarydonebtn":
                myWebSitePage.clickOn_GallaryDoneButton();
                return null;

            case "verify_warningtoastmsg":
                return myWebSitePage.get_WarningToastMsg();

            case "wait_untiletoastmsg_disapears":
                myWebSitePage.waitForToastToDisappear();
                return null;

            case "firmdetails_clickon_toggleyesbtn":
                myWebSitePage.firmDetails_clickOn_FirmToggleBtn_Yes();
                return null;

            case "firmdetails_clickon_togglenobtn":
                myWebSitePage.firmDetails_clickOn_FirmToggleBtn_No();
                return null;

            case "verify_firmdetails_header":
                return myWebSitePage.get_FirmDetails_Header();

            case "firmdetails_enter_firmname":
                myWebSitePage.firmDetails_Enter_FirmName(data.get("INPUT_DATA"));
                return null;

            case "verify_firmdetails_firmnamefield_isdisplay":
                return myWebSitePage.firmDetails_FirmNameField_isDisplay();

            case "firmdetails_enter_teamsize":
                myWebSitePage.firmDetails_Enter_TeamSize(data.get("INPUT_DATA"));
                return null;

            case "verify_firmdetails_firmlogo_isdisplay":
                return myWebSitePage.firmDetails_FirmLogo_isDisplay();

            case "firmdetails_clickon_firmlogoimage":
                myWebSitePage.firmDetails_clickOn_FirmLogo_ImageIcon();
                return null;

            case "clickon_nextbtn":
                myWebSitePage.clickOn_NextButton();
                return null;

            case "verify_owners_header":
                return myWebSitePage.get_OwnersAndPart_Header();

            case "owners_clickon_fabbtn":
                myWebSitePage.OwnersAndPart_clickOn_FabBtn();
                return null;

            case "verify_owners_addteamwindow_title":
                return myWebSitePage.OwnersAndPart_get_AddTeamWindow_Title();

            case "owners_enter_name":
                myWebSitePage.ownersAndPart_Enter_Name(data.get("INPUT_DATA"));
                return null;

            case "owners_clickon_enterposition":
                myWebSitePage.OwnersAndPart_clickOn_EnterPosition();
                return null;

            case "owners_select_positiondropoption":
                myWebSitePage.OwnersAndPart_Select_PositionDropOption();
                return null;

            case "smallwait":
                myWebSitePage.smallWait();
                return null;

            case "owners_clickon_workingsince":
                myWebSitePage.OwnersAndPart_clickOn_WorkingSince();
                return null;

            case "owners_clickon_ownerphotoimage":
                myWebSitePage.OwnersAndPart_clickOn_OwnerPhoto();
                return null;

            case "verify_owners_enternamefielderror":
                return myWebSitePage.OwnersAndPart_get_EnterNameError();

            case "verify_owners_enterpositionfielderror":
                return myWebSitePage.OwnersAndPart_get_EnterPositionError();

            case "verify_owners_selectyearfielderror":
                return myWebSitePage.OwnersAndPart_get_SelectYearError();

            case "owners_clickon_cancelbtn":
                myWebSitePage.OwnersAndPart_clickOn_CancelBtn();
                return null;

            case "owners_get_enternamefieldtext":
                String name = myWebSitePage.OwnersAndPart_get_EnterNameFieldText();
                GlobalStore.put("OWNERS_MEMBERNAME", name);
                return name;

            case "owners_get_enterpositionfieldtext":
                String position = myWebSitePage.OwnersAndPart_get_EnterPositionFieldText();
                GlobalStore.put("OWNERS_POSITION", position);
                return position;

            case "owners_get_experiancefieldtext":
                String experiance = myWebSitePage.OwnersAndPart_get_WorkingSinceFieldText();
                GlobalStore.put("OWNERS_EXPERIANCE", experiance);
                return experiance;

            case "owners_clickon_savebtn":
                myWebSitePage.OwnersAndPart_clickOn_SaveBtn();
                return null;

            case "owners_clickon_crossicon":
                myWebSitePage.OwnersAndPart_clickOn_CrossIcon();
                return null;

            case "verify_owners_addedmember_isdisplay":
                return myWebSitePage.OwnersAndPart_AddedMember_isDisplay();

            case "verify_owners_addedmembername":
                return myWebSitePage.OwnersAndPart_get_AddedMemberName();

            case "verify_owners_addedposition":
                return myWebSitePage.OwnersAndPart_get_AddedPosition();

            case "verify_owners_addedexperiance":
                return myWebSitePage.OwnersAndPart_get_AddedExperiance();

            case "verify_aboutwork_header":
                return myWebSitePage.get_AboutWork_Header();

            case "aboutwork_enter_tellustext":
                myWebSitePage.aboutWork_Enter_TellUs(data.get("INPUT_DATA"));
                return null;

            case "verify_aboutwork_charactercount":
                return myWebSitePage.aboutWork_get_CharacterCounter();

            case "verify_aboutwork_enteredtellustext":
                return myWebSitePage.aboutWork_get_EnteredTellUsText();

            case "aboutwork_clickon_servicesfield":
                myWebSitePage.aboutWork_clickOn_ServicesField();
                return null;

            case "verify_aboutwork_selected_servicesvalues":
                return myWebSitePage.aboutwork_get_SelectedService_Values();

            case "aboutwork_clickon_capabilitiesfield":
                myWebSitePage.aboutWork_clickOn_CapabilitiesField();
                return null;

            case "verify_aboutwork_selected_capabilitiesvalues":
                return myWebSitePage.aboutwork_get_SelectedCapabilities_Values();

            case "aboutwork_clickon_valuesfield":
                myWebSitePage.aboutWork_clickOn_ValuesField();
                return null;

            case "verify_aboutwork_selected_valuesfieldvalue":
                return myWebSitePage.aboutwork_get_SelectedValuesField_Values();

            case "aboutwork_clickon_whychooseusfield":
                myWebSitePage.aboutWork_clickOn_WhyChooseUsField();
                return null;

            case "verify_aboutwork_selected_whychooseusvalues":
                return myWebSitePage.aboutwork_get_SelectedWhyChooseUs_Values();

            case "verify_brandmaterial_header":
                return myWebSitePage.get_BrandsAndMaterials_Header();

            case "brandmaterial_clickon_brandindustrybtn":
                myWebSitePage.brandsAndMaterials_clickOn_BrandInd_Btn();
                return null;

            case "verify_brandmaterial_brandindwindowtitle":
                return myWebSitePage.brandsAndMat_get_BrandInd_WindowTitle();

            case "brandmaterial_clickon_brandwindow_industrydropfield":
                myWebSitePage.brandsAndMat_clickOn_BrandIndWindow_IndustryDropField();
                return null;

            case "brandmaterial_get_selectedindustryvalue":
                String industry = myWebSitePage.brandsAndMat_get_IndustryText();
                GlobalStore.put("INDUSTRY_NAME", industry);
                return industry;

            case "brandmaterial_select_brandwindow_industrydropvalue":
                Thread.sleep(1000);
                myWebSitePage.selectDropValues(270, 1232);
                return null;

            case "brandmaterial_clickon_brandwindow_branddropfield":
                myWebSitePage.brandsAndMat_clickOn_BrandIndWindow_BrandsDropField();
                return null;

            case "verify_brandmaterial_selected_brandsonpreview":
                return myWebSitePage.brandsAndMats_get_SelectedBrands_OnPreview();

            case "brandmaterial_clickon_brandwindow_okbtn":
                myWebSitePage.brandsAndMat_clickOn_BrandIndWindow_OkBtn();
                return null;

            case "verify_brandmaterial_addedcategoryname":
                return myWebSitePage.brandsAndMat_get_AddedCategoryName();

            case "verify_brandmaterial_addedcategory_isdisplay":
                return myWebSitePage.brandsAndMat_Category_isDisplay();

            case "verify_brandmaterial_addedbrandcount":
                return myWebSitePage.brandsAndMat_get_AddedBrandCount();

            case "brandmaterial_clickon_deletebtn":
                myWebSitePage.brandsAndMat_clickOn_DeleteBtn();
                return null;

            case "verify_brandmaterial_selected_brandsonview":
                return myWebSitePage.brandsAndMats_get_SelectedBrands_OnView();

            case "verify_project_header":
                return myWebSitePage.project_get_ProjectHeader();

            case "project_clickon_fabbtn":
                myWebSitePage.project_clickOn_fabbBtn();
                return null;

            case "verify_project_showworkwin_title":
                return myWebSitePage.project_ShowWork_get_Title();

            case "project_clickon_showworkwin_crossicon":
                myWebSitePage.project_ShowWork_ClickOn_CrossIcon();
                return null;

            case "project_enter_showworkwin_projectname":
                myWebSitePage.project_ShowWork_enter_ProjectName(data.get("PROJECT_NAME"));
                return null;

            case "project_showworkwin_get_projectname":
                String projectName = myWebSitePage.get_Project_ShowWork_ProjectName();
                GlobalStore.put("PROJECT_NAME", projectName);
                return projectName;

            case "project_showworkwin_get_projectstyle":
                String projectStyle = myWebSitePage.get_Project_ShowWork_ProjectStyle();
                GlobalStore.put("PROJECT_STYLE", projectStyle);
                return projectStyle;

            case "project_showworkwin_get_projectarea":
                String projectArea = myWebSitePage.project_ShowWork_get_AreaValue();
                GlobalStore.put("PROJECT_AREA", projectArea);
                return projectArea;

            case "project_showworkwin_get_projectbudget":
                String projectBudget = myWebSitePage.project_ShowWork_get_BudgetValue();
                GlobalStore.put("PROJECT_BUDGET", projectBudget);
                return projectBudget;

            case "project_clickon_showworwin_stylefield":
                myWebSitePage.project_ShowWork_ClickOn_StyleField();
                return null;

            case "project_select_showworwin_styledropvalue":
                Thread.sleep(1000);
                myWebSitePage.selectDropValues(206,944);
                return null;

            case "project_enter_showworwin_area":
                myWebSitePage.project_ShowWork_enter_Area(data.get("PROJECT_AREA"));
                return null;

            case "verify_project_showworkwin_areatext":
                return myWebSitePage.project_ShowWork_get_AreaValue();

            case "project_enter_showworwin_budget":
                myWebSitePage.project_ShowWork_enter_Budget(data.get("PROJECT_BUDGET"));
                return null;

            case "verify_project_showworkwin_budgettext":
                return myWebSitePage.project_ShowWork_get_BudgetValue();

            case "project_clickon_showworwin_projectphotoicon":
                myWebSitePage.project_ShowWork_ClickOn_ProjectPhotosIcon();
                return null;

                 case "project_clickon_showworwin_projectphotoiconafterselectimage":
                myWebSitePage.project_ShowWork_ClickOn_ProjectPhotosIconafterselectimage();
                return null;

                

            case "project_addprojectphotos":
                try{
                for (int i = 0; i < 5; i++) {
                    myWebSitePage.project_ShowWork_ClickOn_ProjectPhotosIcon();
                    myWebSitePage.clickOn_BrowseFileOption();
                    myWebSitePage.select_GallaryImage(2);
                    myWebSitePage.clickOn_GallaryDoneButton();
                }}catch(Exception e)
                {
                      System.out.println(e.getMessage());
                }
                return null;

            case "project_add_projects":
                for (int i = 0; i <3; i++) {
                    myWebSitePage.project_clickOn_fabbBtn();
                    myWebSitePage
                            .project_ShowWork_enter_ProjectName(data.get("PROJECT_NAME") + System.currentTimeMillis());
                    companyLoginPage.hideKeyboardIfVisible();
                    myWebSitePage.project_ShowWork_ClickOn_StyleField();
                    myWebSitePage.selectDropValueByAndroidKey(1);
                    myWebSitePage.project_ShowWork_enter_Area(data.get("PROJECT_AREA"));
                    companyLoginPage.hideKeyboardIfVisible();
                    myWebSitePage.project_ShowWork_enter_Budget(data.get("PROJECT_BUDGET"));
                    companyLoginPage.hideKeyboardIfVisible();
                    for (int count = 0; count <3; count++) {
                         Thread.sleep(1000);
                         myWebSitePage.project_ShoWorkWin_ProjectPhotos_ImageCapture_Element.click();
                        myWebSitePage.project_ShowWork_ClickOn_ProjectPhotosIcon();
                        myWebSitePage.clickOn_BrowseFileOption();
                        myWebSitePage.select_GallaryImage(0);
                        myWebSitePage.clickOn_GallaryDoneButton();
                        Thread.sleep(1000);
                    }
                    myWebSitePage.project_ShowWork_ClickOn_SaveBtn();
                }
                return null;

            case "verify_project_showworwin_stylefielderror":
                return myWebSitePage.project_ShowWork_get_StyleError();

            case "verify_project_showworwin_imageserror":
                return myWebSitePage.project_ShowWork_get_ImageError();

            case "verify_project_showworwin_imageicon_isclickable":
                return myWebSitePage.project_ShowWork_Verify_ProjectImageIcon_isClickable();

            case "project_clickon_showworwin_deletebtn":
                myWebSitePage.project_ShowWork_ClickOn_DeleteIcon();
                return null;

            case "verify_project_showworwin_deletepopuptitle":
                return myWebSitePage.project_ShowWork_get_DeletePopup_Title();

            case "verify_project_showworwin_imagescount":
                return myWebSitePage.project_ShowWork_Get_CountOfAddedImages();

            case "project_clickon_showworwin_nobtn":
                myWebSitePage.project_ShowWork_ClickOn_NoBtn();
                return null;

            case "project_clickon_showworwin_deletepopup_yesbtn":
                myWebSitePage.project_ShowWork_ClickOn_YesBtn();
                return null;

            case "project_clickon_showworwin_cancelbtn":
                myWebSitePage.project_ShowWork_ClickOn_cancelBtn();
                return null;

            case "project_clickon_showworwin_savebtn":
                myWebSitePage.project_ShowWork_ClickOn_SaveBtn();
                return null;

            case "verify_project_addedproject_isdisplayed":
                return myWebSitePage.verify_AddedProject_isDisplayed();

            case "verify_project_addedprojectname":
                return myWebSitePage.project_get_AddedProjectName();

            case "project_clickon_deleteicon":
                myWebSitePage.project_ClickOn_DeleteIcon();
                return null;

            case "verify_project_addedstylename":
                return myWebSitePage.project_get_AddedStyleName();

            case "verify_project_addedareaname":
                return myWebSitePage.project_get_AddedAreaName();

            case "verify_project_addedbudgetvalue":
                return myWebSitePage.project_get_AddedBudgetValue();

            case "project_clickon_submitbtn":
                myWebSitePage.project_ClickOn_SubmitBtn();
                return null;

            case "verify_successdialogbox_title":
                return myWebSitePage.get_SuccessDialogBox_Title();

            case "verify_successdialogbox_text":
                return myWebSitePage.get_SuccessDialogBox_Text();

            case "clickon_successdialogbox_okbtn":
                myWebSitePage.clickOn_SuccessDialogBox_Okbtn();
                return null;

            case "verify_infodialogbox_title":
                return myWebSitePage.getget_InfoDialogBox_Title_();

            case "verify_infodialogbox_text":
                return myWebSitePage.get_InfoDialogBox_Text();

            case "clickon_infodialogbox_okbtn":
                myWebSitePage.clickOn_InfoDilaogBox_Okbtn();
                return null;

            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }

}
