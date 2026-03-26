package pages.digitalbussinesscard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class BusinessCardPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/statusValue")
	public WebElement statusOnView_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnRejectBizCard")
	public WebElement rejectBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnApproveBizCard")
	public WebElement acceptBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement warning_ToastMsg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement proofReading_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_text")
	public WebElement proofReading_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_no")
	public WebElement proofReading_DialogBox_NoBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
	public WebElement proofReading_DialogBox_YesBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_StatusValue")
	public WebElement history_StatusValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/remark")
	public WebElement requestDetails_Remark_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
	public WebElement backArrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_requestNoValue")
	public WebElement requestNo_Element;

	public BusinessCardPage(AndroidDriver driver) {
		super(driver);
	}



	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public String get_Status_OnView() {
		return getText(statusOnView_Element);
	}

	public void clickOn_RejectBtn() {
		clickIfPresent(rejectBtn_Element, 0);
	}

	public void clickOn_AcceptBtn() {
		clickIfPresent(acceptBtn_Element, 0);
	}

	

	public String get_WarningToastMsg() {

    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");

    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    shortWait.pollingEvery(Duration.ofMillis(200)); // FAST polling

    try {
        WebElement element = shortWait.until(
                ExpectedConditions.presenceOfElementLocated(snackbar)
        );

        return element.getText().trim();

    } catch (Exception e) {
        throw new RuntimeException("Snackbar not found / disappeared too fast");
    }
}

	public String get_ProofReading_DialogBox_Title() {
		return getText(proofReading_DialogBox_Title_Element);
	}

	public String get_ProofReading_DialogBox_Text() {
		return getText(proofReading_DialogBox_Text_Element);
	}

	public void clickOn_ProofReading_DialogBox_NoBtn() {
		clickIfPresent(proofReading_DialogBox_NoBtn_Element, 0);
	}

	public void clickOn_ProofReading_DialogBox_YesBtn() {
		clickIfPresent(proofReading_DialogBox_YesBtn_Element, 0);
	}

	public String get_history_StatusValue() {
		return getText(history_StatusValue_Element);
	}

	public String get_RequestDetails_Remark() {
		return getText(requestDetails_Remark_Element);
	}

	public void clickOn_BackArrow() {
		clickIfPresent(backArrow_Element, 0);
	}

	public void openFirstRecord() {
		clickElement(requestNo_Element);
	}

	
}