package pages.callme;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class CallMePage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
	public WebElement app_BackArrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/filter_empty")
	public WebElement filterIcon_Element;
	
	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etFromDate")
	public WebElement fromDate_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etToDate")
	public WebElement toDate_Element;

	@AndroidFindBy(id = "android:id/date_picker_header_year")
	public WebElement year_Element;

	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"android:id/date_picker_year_picker\"]/android.widget.TextView")
	public List<WebElement> year_Elements;

	@AndroidFindBy(xpath = "//android.view.View[@resource-id=\"android:id/month_view\"]/android.view.View")
	public List<WebElement> date_Elements;

	@AndroidFindBy(id = "android:id/prev")
	public WebElement dateFilter_PrevBtn_Element;

	@AndroidFindBy(id = "android:id/next")
	public WebElement dateFilter_NextBtn_Element;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement datefilterOkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement filter_ApplyBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/add_fab")
	public WebElement callMeNow_Btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement reason_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/autoComplete_reason")
	public WebElement reason_DropDown_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_cancel")
	public WebElement reasonDialogBox_CancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_Ok")
	public WebElement reasonDialogBox_SubmitBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_err")
	public WebElement reasonError_Msg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCallID")
	public List<WebElement> requestNo_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valueCallType")
	public List<WebElement> callType_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valueNoOfAttempts")
	public List<WebElement> noOfAttempts_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valueStatus")
	public List<WebElement> callStatus_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_datevalue")
	public  List<WebElement> attempt_Date_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valueStatus")
	public  List<WebElement> attempt_Status_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/valueRemark")
	public  List<WebElement> attempt_Remark_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCallHistoryDate")
	public  List<WebElement> callHistoryDate_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement warning_TostMsg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/noResultText")
	public WebElement noResultAvailable_Element;

	

	

	

	

	

	public CallMePage(AndroidDriver driver) {
		super(driver);
	}


	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void clickOn_AppBackArrow() {
		clickElement(app_BackArrow_Element);
	}

	public void clickOn_FilterIcon() {
		clickElement(filterIcon_Element);
	}

	
	public void open_FromDate() {
		clickElement(fromDate_Element);
	}

	public void open_Todate() {
		clickElement(toDate_Element);
	}

	public void selectYear(String year) {
		clickElement(year_Element);
		for (WebElement year_Element : year_Elements) {
			String yearText = year_Element.getText();
			{
				if (yearText.equals(year)) {
					year_Element.click();
					break;
				}
			}
		}
	}

	public void selectDateFromText(String fullDateText) throws InterruptedException {
		// Example input: "01 January 2026"

		String[] parts = fullDateText.trim().split("\\s+");

		String day = parts[0].startsWith("0") ? parts[0].substring(1) : parts[0];
		String month = parts[1];
		String year = parts[2];

		select_Date(year, month, day);
	}

	public void select_Date(String year, String month, String day) throws InterruptedException {

		selectYear(year);

		boolean monthFound = false;
		boolean dateSelected = false;

		for (int i = 0; i < 12; i++) { // safety loop

			String headerText = date_Elements.get(0).getAttribute("content-desc");
			System.out.println("text : " + headerText);

			// Example headerText → "01 January 2025"
			if (headerText.contains(month) && headerText.contains(year)) {
				monthFound = true;

				for (WebElement dateElement : date_Elements) {

					String dateText = dateElement.getAttribute("content-desc").trim();
					// Example → "6 January 2025"

					if (dateText.contains(day)) {
						dateElement.click();
						dateSelected = true;
						clickElement(datefilterOkBtn_Element);
						break;
					}
				}
				break; // STOP scrolling after correct month
			}

			// Navigate month
			if (isElementPresent(dateFilter_PrevBtn_Element)) {
				clickElement(dateFilter_PrevBtn_Element);
			} else {
				throw new RuntimeException("Month navigation button not found");
			}

			Thread.sleep(300);
		}

		if (!monthFound) {
			throw new RuntimeException("Expected month not found: " + month + " " + year);
		}

		if (!dateSelected) {
			throw new RuntimeException("Date not selectable: " + day + " " + month + " " + year);
		}
	}

	private boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOn_FilterOkBtn() {
		clickElement(datefilterOkBtn_Element);
	}

	public void openFirstRecord() {
		clickElement(requestNo_Elements.get(0));
	}


	public String get_History_Date(int i) {
		WebElement callHistoryDate_Element = callHistoryDate_Elements.get(i);
		String fulldate = getText(callHistoryDate_Element);
		String[] parts = fulldate.split("\\|");
		String callDate = parts[0].trim();
		return callDate;
	}

	public boolean areCallDatesWithinRange(String fromDateStr, String toDateStr)
			throws InterruptedException {

		LocalDate fromDate = parseExcelDate(fromDateStr);
		LocalDate toDate = parseExcelDate(toDateStr);

		Set<String> verifiedDates = new HashSet<>();
		int maxScrolls = 15; // safety guard
		int scrollCount = 0;

		while (scrollCount < maxScrolls) {

			// Re-fetch elements every loop (very important after scroll)
			List<WebElement> callDateElements = callHistoryDate_Elements;

			boolean foundNewDate = false;

			for (int i = 0; i < callDateElements.size(); i++) {

				String uiDateText;
				try {
					uiDateText = get_History_Date(i).trim();
				} catch (Exception e) {
					continue; // skip stale / broken item
				}

				// Skip duplicates (happens after scroll)
				if (verifiedDates.contains(uiDateText)) {
					continue;
				}

				verifiedDates.add(uiDateText);
				foundNewDate = true;

				LocalDate callDate;
				try {
					callDate = parseExcelDate(uiDateText);
				} catch (Exception e) {
					throw new RuntimeException(
							"Unable to parse claim date from UI: " + uiDateText, e);
				}

				// FAIL FAST if out of range
				if (callDate.isBefore(fromDate) || callDate.isAfter(toDate)) {
					System.err.println(
							"Date out of range -> UI: " + uiDateText +
									" | Expected between: " + fromDate + " and " + toDate);
					return false;
				}
			}

			// If no new dates found, stop scrolling
			if (!foundNewDate) {
				break;
			}

			// Try to scroll
			boolean scrolled = scrollDownSafe();
			Thread.sleep(600);

			if (!scrolled) {
				break;
			}

			scrollCount++;
		}

		return true; // All visible dates are within range
	}

	public void clickOn_FilterApplyBtn() {
		clickElement(filter_ApplyBtn_Element);
	}

	public void clickOn_callMeNowBtn() {
		clickElement(callMeNow_Btn_Element);
	}

	public String get_ReasonDialogBox_Title() {
		return getText(reason_DialogBox_Title_Element);
	}

	public void clickOn_ReasonDropDownField() {
		clickElement(reason_DropDown_Element);
	}

	public void enter_ReasonDropDownField(String input) {
		sendText(reason_DropDown_Element,input);
	}

	
	
	public void selectReasonDropValue(int optionNumber) {

    clickOn_ReasonDropDownField();

    for (int i = 0; i < optionNumber; i++) {
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
    }

    driver.pressKey(new KeyEvent(AndroidKey.ENTER));
}


	public void clickOn_ReasonDropDown_CancelBtn() {
		clickElement(reasonDialogBox_CancelBtn_Element);
	}

	public void clickOn_ReasonDropDown_SubmitBtn() {
		clickIfPresent(reasonDialogBox_SubmitBtn_Element,0);
	}

	public String get_ReasonDialogBox_ErrorMsg() {
		return getText(reasonError_Msg_Element);
	}

	public String get_requestNo() {
		WebElement element = requestNo_Elements.get(0);
		return getText(element);
	}

	public String get_CallType() {
		WebElement element = callType_Elements.get(0);
		return getText(element);
	}

	public String get_NoOfAttempts() {
		WebElement element = noOfAttempts_Elements.get(0);
		return getText(element);
	}

	public String get_CallStatus() {
		WebElement element = callStatus_Elements.get(0);
		return getText(element);
	}

	public String get_Attempt1_Date() {
		WebElement element = attempt_Date_Elements.get(0);
		return getText(element);
	}

	public String get_Attempt2_Date() {
		WebElement element = attempt_Date_Elements.get(1);
		return getText(element);
	}

	public String get_Attempt1_Status() {
		WebElement element = attempt_Status_Elements.get(1);
		return getText(element);
	}

	public String get_Attempt2_Status() {
		WebElement element = attempt_Status_Elements.get(2);
		return getText(element);
	}

	public String get_Attempt1_Remark() {
		WebElement element = attempt_Remark_Elements.get(0);
		return getText(element);
	}

	public String get_Attempt2_Remark() {
		WebElement element = attempt_Remark_Elements.get(1);
		return getText(element);
	}

	public String get_Warning_ToastMsg() {
		return getText(warning_TostMsg_Element);
	}

	public String get_NoResultText() {
		return getText(noResultAvailable_Element);
	}
	


	 
	
}
