package pages.mywebsite;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class MyWebSitePage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnCreate")
	public WebElement myWebsite_createNewBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnProceed")
	public WebElement websiteDemo_ProceedBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_do_later")
	public WebElement fillerInfo_DoitLaterBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_proceed")
	public WebElement fillerInfo_ProceedBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
	public WebElement backArrowBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement alert_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_text")
	public WebElement alert_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_no")
	public WebElement alert_DialogBox_NoBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
	public WebElement alert_DialogBox_YesBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valueRejectWebVersion")
	public WebElement myWebSite_WebVersion_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valueRejectStatus")
	public WebElement myWebSite_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnGoToDraft")
	public WebElement draftBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvbasicinfotitle")
	public WebElement personalInfo_Header_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etfullname")
	public WebElement personalInfo_fullName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etRoleInFirm")
	public WebElement personalInfo_RoleInFirm_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/experienceEditText")
	public WebElement personalInfo_WorkingProfession_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvbasicinfotitle")
	public WebElement MySite_PageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPersonalInfoTitle")
	public WebElement firmDetails_Header_Element;

	@AndroidFindBy(id = "android:id/numberpicker_input")
	public WebElement SelectYear_Year_Element;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement SelectYear_OkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etworkplace")
	public WebElement personalInfo_CityArea_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement listWindow_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/search_src_text")
	public WebElement listWindow_SearchFilter_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_count")
	public WebElement listWindow_Count_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_item_name")
	public List<WebElement> listWindow_DropValues_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_item_name")
	public WebElement listWindow_DropValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/list_empty1")
	public WebElement listWindow_EmptyList_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cancel")
	public WebElement listWindow_CancelButton_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/search_close_btn")
	public WebElement listWindow_CrossIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/done")
	public WebElement listWindow_SelectBtn_Element;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhan.world:id/serviceAreaChipView\"]/android.widget.Button")
	public List<WebElement> personalInfo_Selected_ServicesAreaList_Elements;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhan.world:id/serviceChipView\"]/android.widget.Button")
	public List<WebElement> aboutWork_selected_Services_Elements;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhan.world:id/capabilitiesChipView\"]/android.widget.Button")
	public List<WebElement> aboutWork_selected_Capabilities_Elements;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhan.world:id/valuesChipView\"]/android.widget.Button")
	public List<WebElement> aboutWork_selected_Values_Elements;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhan.world:id/whyUsChipView\"]/android.widget.Button")
	public List<WebElement> aboutWork_selected_WhyChooseValues_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/profileImage")
	public WebElement personalInfo_OwnerPhoto_ImageIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvAttachlable")
	public WebElement attachDoc_lable_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cl_browse")
	public WebElement browseFile_Option_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cl_camera")
	public WebElement camera_Option_Element;

	@AndroidFindBy(accessibility = "List view")
	public WebElement gallary_ListIcon_Element;

	
	@AndroidFindBy(id = "com.google.android.documentsui:id/icon_thumb")
	public List<WebElement> actualImage_Elements;

	@AndroidFindBy(id = "android:id/title")
	public List<WebElement> imageTitle_Elements;

	

	@AndroidFindBy(accessibility = "Crop")
	public WebElement camera_DoneBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement warning_ToastMsg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/yess")
	public WebElement firmDetails_FirmToggleBtn_Yes_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/no")
	public WebElement firmDetails_FirmToggleBtn_No_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etfirname")
	public WebElement firmDetails_FirmNameField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/teamSizeEditText")
	public WebElement firmDetails_TeamSizeField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/firmLogo")
	public WebElement firmDetails_FirmLogo_ImageIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/next")
	public WebElement nextButton_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvteamtitle")
	public WebElement ownersAndPart_Header_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/add_fab")
	public WebElement ownersAndPart_FabButton_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add Team\")")
	public WebElement ownersAndPart_AddTeamWindow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/nameEditText")
	public WebElement ownersAndPart_AddTeam_EnterNameField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/roleAutocomplete")
	public WebElement ownersAndPart_AddTeam_EnterPositionField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/yearOfExpEditText")
	public WebElement ownersAndPart_AddTeam_SelectWorkingSin_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/imageCapture")
	public WebElement ownersAndPart_AddTeam_OwnerPhotoIamgeIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/textinput_error")
	public WebElement ownersAndPart_AddTeam_EnterName_Error_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/textinput_error")
	public WebElement ownersAndPart_AddTeam_EnterPosition_Error_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/textinput_error")
	public WebElement ownersAndPart_AddTeam_SelectYear_Error_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cancel")
	public WebElement ownersAndPart_AddTeam_CancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/saveTeamData")
	public WebElement ownersAndPart_AddTeam_SaveBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_close")
	public WebElement ownersAndPart_AddTeam_CrossIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/teamMemberName")
	public WebElement ownersAndPart_MemberName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/positionValue")
	public WebElement ownersAndPart_PositionValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/workingSinceValue")
	public WebElement ownersAndPart_Experiance_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/headerAboutWork")
	public WebElement aboutWork_Header_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/aboutUsEditText")
	public WebElement aboutWork_TellUsField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/textinput_counter")
	public WebElement aboutWork_CharacterCounter_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/serviceEditText")
	public WebElement aboutWork_ServicesField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/capabilitiesEditText")
	public WebElement aboutWork_CapabilitiesField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valuesEditText")
	public WebElement aboutWork_ValuesField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/whyUsEditText")
	public WebElement aboutWork_WhyChooseUsField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvbrandmaterialtitle")
	public WebElement brandsMaterial_Header_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnIndustriesNBrand")
	public WebElement brandsMaterial_BrandInd_Btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTitle")
	public WebElement brandsMaterial_BrandInd_WindowTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/categoryAutoComplete")
	public WebElement brandsMaterial_BrandInd_IndustryDropField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/brandEditText")
	public WebElement brandsMaterial_BrandInd_BrandDropField_Element;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhan.world:id/chipGroup\"]/android.widget.Button")
	public List<WebElement> brandsMaterial_selected_BrandList_OnPreview_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/buttonOk")
	public WebElement brandsMaterial_BrandInd_OkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_category")
	public WebElement brandsMaterial_Category_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvbrandCount")
	public WebElement brandsMaterial_BrandCount_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/delete")
	public WebElement brandsMaterial_DeleteIcon_Element;

	@AndroidFindBy(xpath  = "//android.view.ViewGroup[@resource-id=\"com.prowess.apps.bandhan.world:id/chipGroup\"]/android.widget.Button")
	public List<WebElement> brandsMaterial_Brands_OnView_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProjectTitle")
	public WebElement project_Header_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/addProjects")
	public WebElement project_FabbButton_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_title")
	public WebElement project_ShoWorkWin_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_close")
	public WebElement project_ShoWorkWin_CrossIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/projectNameEditText")
	public WebElement project_ShoWorkWin_ProjectName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/styleAutoComplete")
	public WebElement project_ShoWorkWin_StyleField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/areaOfWorkEditText")
	public WebElement project_ShoWorkWin_AreaField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/budgetEditText")
	public WebElement project_ShoWorkWin_BudgetField_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/imageCapture")
	public WebElement project_ShoWorkWin_ProjectPhotos_ImageCapture_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/textinput_error")
	public WebElement project_ShoWorkWin_StyleError_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/errImage")
	public WebElement project_ShoWorkWin_ImageError_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/deleteImage")
	public List<WebElement> project_ShoWorkWin_DeleteIcon_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/alertTitle")
	public WebElement project_ShoWorkWin_DeletePopUp_Title_Element;

	@AndroidFindBy(id = "android:id/button2")
	public WebElement project_ShoWorkWin_DeletePopUp_NoBtn_Element;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement project_ShoWorkWin_DeletePopUp_YesBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/projectImage")
	public List<WebElement> project_showwork_addedimage_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cancel")
	public WebElement project_ShoWorkWin_CancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/saveProjectData")
	public WebElement project_ShoWorkWin_SaveBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/projectName")
	public List<WebElement> project_ProjectName_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/deleteProject")
	public List<WebElement> project_DeleteIcon_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/styleValue")
	public List<WebElement> project_Style_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/areaOfProjectValue")
	public List<WebElement> project_Area_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/budgetValue")
	public List<WebElement> project_Budget_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/next")
	public WebElement project_SubmitBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_success_title")
	public WebElement success_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_text")
	public WebElement success_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_ok")
	public WebElement success_DialogBox_OkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_title")
	public WebElement information_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_text")
	public WebElement information_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_ok")
	public WebElement information_DialogBox_OkBtn_Element;

	

	

	public MyWebSitePage(AndroidDriver driver) {
		super(driver);
	}

	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void clickOn_MyWebSite_CreateNewBtn() {
		clickIfPresent(myWebsite_createNewBtn_Element, 0);
	}

	public void clickOn_WebSiteDemo_ProceedBtn() {
		clickIfPresent(websiteDemo_ProceedBtn_Element, 0);
	}

	public void clickOn_FillerInfo_DoItLaterBtn() {
		clickIfPresent(fillerInfo_DoitLaterBtn_Element, 0);
	}

	public void clickOn_FillerInfo_ProceedBtn() {
		clickIfPresent(fillerInfo_ProceedBtn_Element, 0);
	}

	public void clickOn_BackArrrowBtn() {
		clickIfPresent(backArrowBtn_Element, 0);
	}

	public String get_Alert_DialogBox_Title() {
		return getText(alert_DialogBox_Title_Element);
	}

	public String get_Alert_DialogBox_Text() {
		return getText(alert_DialogBox_Text_Element);
	}

	public void clickOn_Alert_DialogBox_NoBtn() {
		clickIfPresent(alert_DialogBox_NoBtn_Element, 0);
	}

	public void clickOn_Alert_DialogBox_YesBtn() {
		clickIfPresent(alert_DialogBox_YesBtn_Element, 0);
	}

	public String get_MyWebSite_WebVersion_Text() {
		return getText(myWebSite_WebVersion_Element);
	}

	public String get_MyWebSite_WebVersion_Status() {
		return getText(myWebSite_Status_Element);
	}

	public String get_MyWebSite_DraftBtn_Text() {
		return getText(draftBtn_Element);
	}

	public boolean myWebSite_DraftBtn_isDisplay() {
		return isElementVisible(draftBtn_Element);
	}

	public void clickOn_MyWebSite_DraftBtn() {
		clickIfPresent(draftBtn_Element, 0);
	}

	public String get_PersonalInfo_HeaderName() {
		return getText(personalInfo_Header_Element);
	}

	public void personalInfo_Enter_FullName(String input) {
		String text = input;
		// Split by :
		String[] parts = text.split(":");
		// Get value part
		String fullName = parts[1].trim();
		sendText(personalInfo_fullName_Element, fullName);
	}

	public void personalInfo_ClickOn_RoleFirmDropField() {
		clickElement(personalInfo_RoleInFirm_Element);
	}

	public void personalInfo_Select_RoleFirmDropValue() throws InterruptedException  {
		Thread.sleep(1000);
		selectDropValues(142,1044);
	}

	public void personalInfo_ClickOn_WorkProfessionField() {
		clickElement(personalInfo_WorkingProfession_Element);
	}

	public String get_MySiteConfig_PageTitle() {
		return getText(MySite_PageTitle_Element);
	}

	public void clickOn_SelectYearValue() {
		clickElement(SelectYear_Year_Element);
	}

	public void clickOn_SelectYearOkBtn() {
		clickElement(SelectYear_OkBtn_Element);
	}

	public void personalInfo_ClickOn_CityArea() {
		clickElement(personalInfo_CityArea_Element);
	}

	public String get_ListWindow_Title() {
		return getText(listWindow_Title_Element);
	}

	public void enter_ListWindow_InSearchFilter(String input) {
		String text = input;
		// Split by :
		String[] parts = text.split(":");
		// Get value part
		String fullName = parts[1].trim();
		sendText(listWindow_SearchFilter_Element, fullName);
	}

	public String get_ListWindow_Count() {
		return getText(listWindow_Count_Element);
	}

	public List<String> get_ListWindow_Dropvalues() {
		return getTextsFromElements(listWindow_DropValues_Elements);
	}

	public String get_ListWindow_Dropvalue() {
		return getText(listWindow_DropValue_Element);
	}

	public String get_ListWindow_ListEmptyText() {
		return getText(listWindow_EmptyList_Element);
	}

	public String getToastMessage() {

    try {
        WebElement toast = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.Toast")));

        return toast.getText();

    } catch (Exception e) {
        return null;
    }
}

	public boolean verify_ToastMsg_InPageSource(String expectedMessage) {

		int attempts = 5;

		for (int i = 0; i < attempts; i++) {
			if (driver.getPageSource().contains(expectedMessage)) {
				return true;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException ignored) {
			}
		}

		return false;
	}

	public WebElement getElementByName(String elementName) {
		try {
			Field field = this.getClass().getDeclaredField(elementName);
			field.setAccessible(true);
			return (WebElement) field.get(this);
		} catch (Exception e) {
			throw new RuntimeException("Element not found: " + elementName, e);
		}
	}

	public void select_ListWindow_values(String inputText, String elementName) {

		String input = inputText;
		// Split by :
		String[] parts = input.split(":");
		// Get value part
		String dropOptions = parts[1].trim();
		if (dropOptions == null || dropOptions.isEmpty()) {
			throw new RuntimeException("currentPrograms list is empty!");
		}

		WebElement dropdownElement = getElementByName(elementName);
		// Split comma-separated brand names
		String[] Options = dropOptions.split(",");

		for (String Option : Options) {
			String trimmedOption = Option.trim();
			System.out.println("Trying to selected Option : " + trimmedOption);

			boolean found = false;
			int retryCount = 0;

			// Retry in case of stale or delayed rendering
			while (!found && retryCount < 3) {
				try {
					// Re-fetch element (avoid stale reference)
					List<WebElement> elements = driver.findElements(
							AppiumBy.androidUIAutomator(
									"new UiSelector().text(\"" + trimmedOption + "\")"));

					if (!elements.isEmpty()) {
						WebElement element = elements.get(0);
						clickElement(element);
						System.out.println(" Selected Program: " + trimmedOption);
						found = true;
						retryCount=2;
					} else {
						System.out.println(" Program not found in visible list: " + trimmedOption);
					}
				} catch (StaleElementReferenceException e) {
					System.out.println(" Retrying due to stale element for program: " + trimmedOption);
				} catch (Exception e) {
					System.out.println(" Exception selecting program " + trimmedOption + ": " + e.getMessage());
				}
				retryCount++;

				if (retryCount>=3) {
					break;	
				}
				
			}

			if (!found) {
				System.out.println(" Failed to select program after retries: " + trimmedOption);
			}

			// Optional: re-open dropdown for next selection if it closes automatically
			try {
				
				if (Options.length > 1 && !Option.equals(Options[Options.length - 1])) {
					if(dropdownElement.isDisplayed())
					{
                   dropdownElement.click();
					//Thread.sleep(1000);
					}
					
				}
			} catch (Exception ignored) {
			
			}
		}
	}

	

	public void select_ListWindow_DropValue(String dropValues) {
		clickElementFromListByText(listWindow_DropValues_Elements, dropValues);
	}

	public void clickOn_ListWindow_CancelButton() {
		clickElement(listWindow_CancelButton_Element);
	}

	public void clickOn_ListWindow_CrossButton() {
		clickElement(listWindow_CrossIcon_Element);
	}

	public void clickOn_ListWindow_SelectButton() {
		clickElement(listWindow_SelectBtn_Element);
	}

	public String personalInfo_get_SelectedServiceArea_Values_OnView() {
		List<String> values = getTextsFromElements(personalInfo_Selected_ServicesAreaList_Elements);
		System.out.println("values" + values);
		return String.join(",", values);

	}

	public void personalInfo_clickOn_OwnerPhoto_ImageIcon() {
		clickElement(personalInfo_OwnerPhoto_ImageIcon_Element);
	}

	public String get_AttachDocLable() {
		return getText(attachDoc_lable_Element);
	}

	public void clickOn_BrowseFileOption() {
		clickElement(browseFile_Option_Element);
	}

	public void clickOn_CameraCaptureOption() {
		clickElement(camera_Option_Element);
	}

	public void clickOn_Gallary_ListIcon() {
		clickElement(gallary_ListIcon_Element);
	}

	
	public void select_GallaryImage(int i) {
		waitForListToLoad(actualImage_Elements);
		WebElement image = actualImage_Elements.get(i);
		clickElement(image);
	}

	public void selectGalleryImageByName(String imageName) {
    waitForListToLoad(imageTitle_Elements);

    for (WebElement image : imageTitle_Elements) {
        String desc = image.getText(); // or "text"

        if (desc != null && desc.contains(imageName)) {
            clickElement(image);
            break;
        }
    }
}

	public void clickOn_GallaryDoneButton() {
		clickElement(camera_DoneBtn_Element);
	}


	public String get_WarningToastMsg() {

    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");

    long endTime = System.currentTimeMillis() + 5000;

    while (System.currentTimeMillis() < endTime) {
        try {
            List<WebElement> elements = driver.findElements(snackbar);

            if (!elements.isEmpty()) {
                String text = elements.get(0).getText();
                if (!text.isEmpty()) {
                    return text.trim();
                }
            }

        } catch (Exception ignored) {}

    }

    throw new RuntimeException("Snackbar message not captured");
}

	public void waitForToastToDisappear() {
    wait.until(ExpectedConditions.invisibilityOf(warning_ToastMsg_Element));
}
	public void firmDetails_clickOn_FirmToggleBtn_Yes() {
		clickElement(firmDetails_FirmToggleBtn_Yes_Element);
	}

	public void firmDetails_clickOn_FirmToggleBtn_No() {
		clickElement(firmDetails_FirmToggleBtn_No_Element);
	}

	public String get_FirmDetails_Header() {
		return getText(firmDetails_Header_Element);
	}

	public void firmDetails_Enter_FirmName(String input) {
		String text = input;
		// Split by :
		String[] parts = text.split(":");
		// Get value part
		String splitText = parts[1].trim();
		sendText(firmDetails_FirmNameField_Element, splitText);
	}

	public boolean firmDetails_FirmNameField_isDisplay() {
		return isElementVisible(firmDetails_FirmNameField_Element);
	}

	public void firmDetails_Enter_TeamSize(String input) {
		String text = input;
		// Split by :
		String[] parts = text.split(":");
		// Get value part
		String splitText = parts[1].trim();
		sendText(firmDetails_TeamSizeField_Element, splitText);
	}

	public boolean firmDetails_FirmLogo_isDisplay() {
		return isElementVisible(firmDetails_FirmLogo_ImageIcon_Element);
	}

	public void firmDetails_clickOn_FirmLogo_ImageIcon() {
		clickElement(firmDetails_FirmLogo_ImageIcon_Element);
	}

	public void clickOn_NextButton() throws InterruptedException {
		Thread.sleep(1000);
		clickIfPresent(nextButton_Element,5);
	}

	public String get_OwnersAndPart_Header() {
		return getText(ownersAndPart_Header_Element);
	}

	public void OwnersAndPart_clickOn_FabBtn() {
		clickElement(ownersAndPart_FabButton_Element);
	}

	public String OwnersAndPart_get_AddTeamWindow_Title() {
		return getText(ownersAndPart_AddTeamWindow_Element);
	}

	public void ownersAndPart_Enter_Name(String input) {
		String text = input;
		// Split by :
		String[] parts = text.split(":");
		// Get value part
		String fullName = parts[1].trim();
		sendText(ownersAndPart_AddTeam_EnterNameField_Element, fullName);
	}

	public String OwnersAndPart_get_EnterNameFieldText() {
		return getText(ownersAndPart_AddTeam_EnterNameField_Element);
	}

	public void OwnersAndPart_clickOn_EnterPosition() {
		clickElement(ownersAndPart_AddTeam_EnterPositionField_Element);
	}

	public String OwnersAndPart_get_EnterPositionFieldText() {
		return getText(ownersAndPart_AddTeam_EnterPositionField_Element);
	}

	public void OwnersAndPart_Select_PositionDropOption() throws InterruptedException {
		Thread.sleep(1000);
		 selectDropValues(124,692);
	}

	public void OwnersAndPart_clickOn_WorkingSince() {
		clickElement(ownersAndPart_AddTeam_SelectWorkingSin_Element);
	}

	public String OwnersAndPart_get_WorkingSinceFieldText() {
		return getText(ownersAndPart_AddTeam_SelectWorkingSin_Element);
	}

	public void OwnersAndPart_clickOn_OwnerPhoto() {
		clickElement(ownersAndPart_AddTeam_OwnerPhotoIamgeIcon_Element);
	}

	public String OwnersAndPart_get_EnterNameError() {
		return getText(ownersAndPart_AddTeam_EnterName_Error_Element);
	}

	public String OwnersAndPart_get_EnterPositionError() {
		return getText(ownersAndPart_AddTeam_EnterPosition_Error_Element);
	}

	public String OwnersAndPart_get_SelectYearError() {
		return getText(ownersAndPart_AddTeam_SelectYear_Error_Element);
	}

	public void OwnersAndPart_clickOn_CancelBtn() {
		clickIfPresent(ownersAndPart_AddTeam_CancelBtn_Element,0);
	}

	public void OwnersAndPart_clickOn_SaveBtn() {
		clickElement(ownersAndPart_AddTeam_SaveBtn_Element);
	}

	public void OwnersAndPart_clickOn_CrossIcon() {
		clickElement(ownersAndPart_AddTeam_CrossIcon_Element);
	}

	public String OwnersAndPart_get_AddedMemberName() {
		return getText(ownersAndPart_MemberName_Element);
	}

	public boolean OwnersAndPart_AddedMember_isDisplay() {
		return isElementVisible(ownersAndPart_MemberName_Element);
	}

	public String OwnersAndPart_get_AddedPosition() {
		return getText(ownersAndPart_PositionValue_Element);
	}

	public String OwnersAndPart_get_AddedExperiance() {
		return getText(ownersAndPart_Experiance_Element);
	}

	public String get_AboutWork_Header() {
		return getText(aboutWork_Header_Element);
	}

	public void aboutWork_Enter_TellUs(String input) {
		sendText(aboutWork_TellUsField_Element, input);
	}

	public String aboutWork_get_CharacterCounter() {
		return getText(aboutWork_CharacterCounter_Element);
	}

	public String aboutWork_get_EnteredTellUsText() {
		return getText(aboutWork_TellUsField_Element);
	}

	public void aboutWork_clickOn_ServicesField() {
		clickElement(aboutWork_ServicesField_Element);
	}

	public String aboutwork_get_SelectedService_Values() {
		List<String> values = getTextsFromElements(aboutWork_selected_Services_Elements);
		System.out.println("values" + values);
		return String.join(",", values);
	}

	public void aboutWork_clickOn_CapabilitiesField() {
		clickElement(aboutWork_CapabilitiesField_Element);
	}

	public String aboutwork_get_SelectedCapabilities_Values() {
		List<String> values = getTextsFromElements(aboutWork_selected_Capabilities_Elements);
		System.out.println("values" + values);
		return String.join(",", values);
	}

	public void aboutWork_clickOn_ValuesField() {
		clickElement(aboutWork_ValuesField_Element);
	}

	public String aboutwork_get_SelectedValuesField_Values() {
		List<String> values = getTextsFromElements(aboutWork_selected_Values_Elements);
		System.out.println("values" + values);
		return String.join(",", values);
	}

	public void aboutWork_clickOn_WhyChooseUsField() {

		clickAfterScroll(aboutWork_WhyChooseUsField_Element,"com.prowess.apps.bandhan.world:id/whyUsEditText");
	}

	public String aboutwork_get_SelectedWhyChooseUs_Values() {
		scrollDownSafe();
		List<String> values = getTextsFromElements(aboutWork_selected_WhyChooseValues_Elements);
		System.out.println("values" + values);
		return String.join(",", values);
	}

	public String get_BrandsAndMaterials_Header() {
		return getText(brandsMaterial_Header_Element);
	}

	public void brandsAndMaterials_clickOn_BrandInd_Btn() {
		clickElement(brandsMaterial_BrandInd_Btn_Element);
	}

	public String brandsAndMat_get_BrandInd_WindowTitle() {
		return getText(brandsMaterial_BrandInd_WindowTitle_Element);
	}

	public void brandsAndMat_clickOn_BrandIndWindow_IndustryDropField() {
		clickElement(brandsMaterial_BrandInd_IndustryDropField_Element);
	}

	public String brandsAndMat_get_IndustryText() {
		return getText(brandsMaterial_BrandInd_IndustryDropField_Element);
	}

	public void brandsAndMat__Select_IndDropValue() {
		
		selectDropValueByAndroidKey(1);
	}

	public void brandsAndMat_clickOn_BrandIndWindow_BrandsDropField() throws InterruptedException {
		Thread.sleep(1000);
		clickElement(brandsMaterial_BrandInd_BrandDropField_Element);
	}

	public String brandsAndMats_get_SelectedBrands_OnPreview() {
		List<String> values = getTextsFromElements(brandsMaterial_selected_BrandList_OnPreview_Elements);
		System.out.println("values" + values);
		return String.join(",", values);
	}

	public void brandsAndMat_clickOn_BrandIndWindow_OkBtn() throws InterruptedException {
		Thread.sleep(1000);
		clickElement(brandsMaterial_BrandInd_OkBtn_Element);
	}

	public String brandsAndMat_get_AddedCategoryName() {
		return getText(brandsMaterial_Category_Element);
	}
	
	
	public boolean brandsAndMat_Category_isDisplay() {
		return isElementVisible(brandsMaterial_Category_Element);
	}

	public String brandsAndMat_get_AddedBrandCount() {
		return getText(brandsMaterial_BrandCount_Element);
	}

	public void brandsAndMat_clickOn_DeleteBtn() {
		clickElement(brandsMaterial_DeleteIcon_Element);
	}

	public String brandsAndMats_get_SelectedBrands_OnView() {
		List<String> values = getTextsFromElements(brandsMaterial_Brands_OnView_Elements);
		System.out.println("values" + values);
		return String.join(",", values);
	}

	public String project_get_ProjectHeader() {
		return getText(project_Header_Element);
	}

	public void project_clickOn_fabbBtn() {
		clickElement(project_FabbButton_Element);
	}

	public String project_ShowWork_get_Title() {
		return getText(project_ShoWorkWin_Title_Element);
	}

	public void project_ShowWork_ClickOn_CrossIcon() {
		clickElement(project_ShoWorkWin_CrossIcon_Element);
	}

	public void project_ShowWork_enter_ProjectName(String input) {
		sendText(project_ShoWorkWin_ProjectName_Element, input);
	}

public String get_Project_ShowWork_ProjectName() {
		return getText(project_ShoWorkWin_ProjectName_Element);
	}

	public void project_ShowWork_ClickOn_StyleField() {
		clickElement(project_ShoWorkWin_StyleField_Element);
	}

	public String get_Project_ShowWork_ProjectStyle() {
		return getText(project_ShoWorkWin_StyleField_Element);
	}

	public void project_ShowWork_enter_Area(String input) {
		sendText(project_ShoWorkWin_AreaField_Element, input);
	}

	public String project_ShowWork_get_AreaValue() {
		return getText(project_ShoWorkWin_AreaField_Element);
	}

	public void project_ShowWork_enter_Budget(String input) {
		sendText(project_ShoWorkWin_BudgetField_Element, input);
	}

	public String project_ShowWork_get_BudgetValue() {
		return getText(project_ShoWorkWin_BudgetField_Element);
	}

	public void project_ShowWork_ClickOn_ProjectPhotosIcon() {
		try {
				clickIfPresent(project_ShoWorkWin_ProjectPhotos_ImageCapture_Element,0);
		} catch (Exception e) {
			
		}
	
	}

	public void project_ShowWork_ClickOn_ProjectPhotosIconafterselectimage() {
		try {
			project_ShoWorkWin_ProjectPhotos_ImageCapture_Element.click();
		} catch (Exception e) {
			System.out.println("Element disable");
		}
			
		
	}

	public String project_ShowWork_Verify_ProjectImageIcon_isClickable() {
		return project_ShoWorkWin_ProjectPhotos_ImageCapture_Element.getAttribute("clickable");
	}

	public String project_ShowWork_get_StyleError() {
		return getText(project_ShoWorkWin_StyleError_Element);
	}

	public String project_ShowWork_get_ImageError() {
		return getText(project_ShoWorkWin_ImageError_Element);
	}

	public void project_ShowWork_ClickOn_DeleteIcon() {
		WebElement element = project_ShoWorkWin_DeleteIcon_Elements.get(0);
		clickElement(element);
	}

	public String project_ShowWork_get_DeletePopup_Title() {
		return getText(project_ShoWorkWin_DeletePopUp_Title_Element);
	}

	public void project_ShowWork_ClickOn_NoBtn() {
		clickElement(project_ShoWorkWin_DeletePopUp_NoBtn_Element);
	}

	public void project_ShowWork_ClickOn_YesBtn() {
		clickElement(project_ShoWorkWin_DeletePopUp_YesBtn_Element);
	}

	public int project_ShowWork_Get_CountOfAddedImages() {
		return project_showwork_addedimage_Elements.size();
	}
	

	public void project_ShowWork_ClickOn_cancelBtn() {
		clickElement(project_ShoWorkWin_CancelBtn_Element);
	}

	public void project_ShowWork_ClickOn_SaveBtn() {
		clickElement(project_ShoWorkWin_SaveBtn_Element);
	}

	public String project_get_AddedProjectName() {
		WebElement element = project_ProjectName_Elements.get(0);
		return getText(element);
	}

	public boolean verify_AddedProject_isDisplayed() {

    if (project_ProjectName_Elements != null && !project_ProjectName_Elements.isEmpty()) {
        return isElementVisible(project_ProjectName_Elements.get(0));
    }

    return false;
}

	public void project_ClickOn_DeleteIcon() {
		WebElement element = project_DeleteIcon_Elements.get(0);
		clickElement(element);
	}

	public String project_get_AddedStyleName() {
		WebElement element = project_Style_Elements.get(0);
		return getText(element);
	}

	public String project_get_AddedAreaName() {
    if (project_Area_Elements == null || project_Area_Elements.isEmpty()) {
        return "";
    }
    String text = getText(project_Area_Elements.get(0)); // "5600 sq ft"
    return text.replaceAll("[^0-9]", ""); // → "5600"
}

	public String project_get_AddedBudgetValue() {
    if (project_Budget_Elements == null || project_Budget_Elements.isEmpty()) {
        return "";
    }

    String text = getText(project_Budget_Elements.get(0)); // "8 lac"
    return text.replaceAll("[^0-9]", ""); // → "8"
}
	public void project_ClickOn_SubmitBtn() {
		clickElement(project_SubmitBtn_Element);
	}

	public String get_SuccessDialogBox_Title() {
		return getText(success_DialogBox_Title_Element);
	}

	public String get_SuccessDialogBox_Text() {
		return getText(success_DialogBox_Text_Element);
	}

	public void clickOn_SuccessDialogBox_Okbtn() {
		clickElement(success_DialogBox_OkBtn_Element);
	}

	public String getget_InfoDialogBox_Title_() {
		return getText(information_DialogBox_Title_Element);
	}

	public String get_InfoDialogBox_Text() {
		return getText(information_DialogBox_Text_Element);
	}

	public void clickOn_InfoDilaogBox_Okbtn() {
		clickElement(information_DialogBox_OkBtn_Element);
	}

	public void addProjectPhotos() {
		
		
	}



}