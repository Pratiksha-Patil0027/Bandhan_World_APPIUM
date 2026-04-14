package pages.myheathbenefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class MyHeathBenefitsPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
	public WebElement backArrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_Teleconsulting_active")
	public WebElement teleconsultine_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_Group_Personal_Accidental_active")
	public WebElement groupPersonalAccidental_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_Hospicash_active")
	public WebElement hospicash_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_Group_Health_active")
	public WebElement groupHealth_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Teleconsulting_arrow")
	public WebElement teleconsulting_Arrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_GPA_arrow")
	public WebElement groupPersonalAccidental_Arrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Hospicash_arrow")
	public WebElement hospicash_Arrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_group_health_arrow")
	public WebElement groupHealth_Arrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_view")
	public List<WebElement> policyDetails_ViewIcon_Elements;

	
	By callIcon_Locator = By.xpath("//android.widget.FrameLayout[@resource-id=\"com.prowess.apps.bandhan.world:id/cv_call\"]/android.view.ViewGroup");
	

	By emailIcon_Locator = By.xpath("//android.widget.FrameLayout[@resource-id=\"com.prowess.apps.bandhan.world:id/cv_email\"]/android.view.ViewGroup");

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_out_email")
	public WebElement groupHealth_EmailIcon_Element;


	@AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_title")
	public WebElement welcomtomail_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_membership_number_value")
	public WebElement teleconsultingPage_MembershipNumber_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_Teleconsulting_active")
	public WebElement teleconsultingPage_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_wallet_amount_value")
	public WebElement teleconsultingPage_AmountValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_Book_Teleconsulting_Appointment")
	public WebElement teleconsultingPage_BookAppointment_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_video")
	public WebElement videoIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_document")
	public WebElement documentIcon_Element;

	@AndroidFindBy(id = "new UiSelector().text(\"Benefits Status\")")
	public WebElement teleconsultingPage_BookAppoitmentNavigate_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/exo_progress")
	public WebElement video_progess_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_policy_number_value")
	public WebElement policyNumber_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_policy_no_active")
	public WebElement policyNoACtive_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_insurance_cover_value")
	public WebElement insuranceCoverage_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_policy_provider_value")
	public WebElement policyProvider_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_title")
	public WebElement claimDetailsWindow_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/patientAutoComplete")
	public WebElement claimDetailsWindow_PatientnameElement;

	By claimDetails_PatientName_Locator = By.id("com.prowess.apps.bandhan.world:id/patientAutoComplete");

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_hospital_name")
	public WebElement claimDetailsWindow_HospitalName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_hospital_contact")
	public WebElement  claimDetailsWindow_Contact_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_admission_Date")
	public WebElement  claimDetailsWindow_Date_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_accident")
	public WebElement  claimDetailsWindow_Illeness_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cancel")
	public WebElement  claimDetailsWindow_CancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/save")
	public WebElement  claimDetailsWindow_SendMail_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_admission_time")
	public WebElement  claimDetailsWindow_AdmissionTime_Element;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement  timeWindow_OkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement  snackBarText_Element;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement  calendareOkBtn_Element;

	@AndroidFindBy(id = "com.android.chrome:id/title")
	public WebElement  cromeTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/memberName")
	public List<WebElement> coveredMembersName_Elements;


	
	public MyHeathBenefitsPage(AndroidDriver driver) {
		super(driver);
	}

	
	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void clickOn_BackArrow() {
		clickIfPresent(backArrow_Element, 0);
	}

	public void navigateBackToMyHealthPage() {

		int maxBackPress = 3; // safety limit

		while (!isElementVisible(teleconsulting_Arrow_Element) && maxBackPress-- > 0) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		}

		if (!isElementVisible(teleconsulting_Arrow_Element)) {
			throw new RuntimeException("Failed to navigate back to Home Dashboard");
		}
	}

	public void navigateBackToClaimDetailsWindow() {

		int maxBackPress = 3; // safety limit

		while (!isElementVisible(claimDetailsWindow_PatientnameElement) && maxBackPress-- > 0) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		}

		if (!isElementVisible(claimDetailsWindow_PatientnameElement)) {
			throw new RuntimeException("Failed to navigate back to Home Dashboard");
		}
	}

	 public  String get_Teleconsultine_Status()
    {
        return getText(teleconsultine_Status_Element);
    }

	 public  String get_GPA_Status()
    {
        return getText(groupPersonalAccidental_Status_Element);
    }

	 public  String get_Hospicash_Status()
    {
        return getText(hospicash_Status_Element);
    }

	 public  String get_GroupHealth_Status()
    {
        return getText(groupHealth_Status_Element);
    }

	public void clickOn_Teleconsulting_Arrow() {
		clickIfPresent(teleconsulting_Arrow_Element, 0);
	}

	public void clickOn_GPA_Arrow() {
		clickIfPresent(groupPersonalAccidental_Arrow_Element, 0);
	}

	public void clickOn_Hospicash_Arrow() {
		clickIfPresent(hospicash_Arrow_Element, 0);
	}

	public void clickOn_GroupHealth_Arrow() {
		clickIfPresent(groupHealth_Arrow_Element, 0);
	}

	public void clickOn_PolicyDetails_ViewIcon(int i) {
		clickIfPresent(policyDetails_ViewIcon_Elements.get(i), 0);
	}

	public void clickOn_EmailIcon() {
		clickIfPresent(emailIcon_Locator, 1);
	}

	public void clickOn_GroupHealth_EmailIcon() {
		scrollToId("com.prowess.apps.bandhan.world:id/iv_out_email");
		clickIfPresent(groupHealth_EmailIcon_Element, 0);
	}
	

	public  String get_Welcometomail()
    {
        return getText(welcomtomail_Element);
    }

 public  String get_TeleConsultPage_MembershipNo()
    {
        return getText(teleconsultingPage_MembershipNumber_Element);
    }

	public  String get_TeleConsultPage_Status()
    {
        return getText(teleconsultingPage_Status_Element);
    }

	public  String get_TeleConsultPage_AmountValue()
    {
        return getText(teleconsultingPage_AmountValue_Element);
    }

	 public void clickOn_BookAppointment() {
		clickIfPresent(teleconsultingPage_BookAppointment_Element, 0);
	}

	 public void clickOn_VideoIcon() {
		scrollToId("com.prowess.apps.bandhan.world:id/iv_video");
		clickIfPresent(videoIcon_Element, 0);
	}

	 public void clickOn_DocumentIcon() {
		clickIfPresent(documentIcon_Element, 0);
	}

	public boolean verify_bookAppointNavigate() throws InterruptedException
	{  Thread.sleep(2000);
		return isElementVisible(teleconsultingPage_BookAppoitmentNavigate_Element);
	}

	public boolean verify_VideoProgressBar_isDisplay()
	{
		return isElementVisible(video_progess_Element);
	}

	public  String get_PolicyNumber()
    {
        return getText(policyNumber_Element);
    }

	public  String get_PolicyNo_ActiveStatus()
    {
        return getText(policyNoACtive_Status_Element);
    }

	public  String get_InsuranceCoverage()
    {
        return getText(insuranceCoverage_Element);
    }

	public  String get_PolicyProvider()
    {
        return getText(policyProvider_Element);
    }

	public  String get_ClaimDetailsWin_Title()
    {
        return getText(claimDetailsWindow_Title_Element);
    }

	public  String get_ClaimDetailsWin_PatientName()
    {
        return getText(claimDetailsWindow_PatientnameElement);
    }

	public void clickOn_ClaimDetails_PatientName()
	{
          clickIfPresent(claimDetails_PatientName_Locator,1);
	}

	public  void enter_ClaimDetails_HospitalName(String input)
    {
        sendText(claimDetailsWindow_HospitalName_Element, input);
    }

	public  void enter_ClaimDetails_ContactNo(String input)
    {
        sendText(claimDetailsWindow_Contact_Element, input);
    }

    public void clickOn_ClaimDetails_DateField() {
		clickIfPresent(claimDetailsWindow_Date_Element, 0);
	}

	public  void enter_ClaimDetails_Illeness(String input)
    {
        sendText(claimDetailsWindow_Illeness_Element, input);
    }

	 public void clickOn_ClaimDetails_CancelBtn() {
		clickIfPresent(claimDetailsWindow_CancelBtn_Element, 0);
	}

	public void clickOn_ClaimDetails_SendMailBtn() throws InterruptedException {
		Thread.sleep(1000);
		clickIfPresent(claimDetailsWindow_SendMail_Element, 0);
	}

	public void clickOn_ClaimDetails_AdmissionTimeField() {
		clickIfPresent(claimDetailsWindow_AdmissionTime_Element, 0);
	}

	public void clickOn_ClaimDetails_TimeOkBtn() {
		clickIfPresent(timeWindow_OkBtn_Element, 0);
	}
	  
public  String get_SnackBar_Text()
    {
        return getText(snackBarText_Element);
    }
	  
	public void clickOn_Calender_OkBtn() {
		clickIfPresent(calendareOkBtn_Element, 0);
	}

	public  String get_CromeTitleText()
    {
        return getText(cromeTitle_Element);
    }
	  

	public String coveredmembersnames() {
		scrollToId("com.prowess.apps.bandhan.world:id/iv_video");
		List<String> values = getTextsFromElements(coveredMembersName_Elements);
		System.out.println("values" + values);
		return String.join(",", values);
	}


	
}