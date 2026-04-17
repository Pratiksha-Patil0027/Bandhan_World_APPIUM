package pages.querylist;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class QueryListPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/call_empty")
	public WebElement callIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvContactUsValue")
	public WebElement ContactUsValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvEmailValue")
	public WebElement emailValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTimeValue")
	public WebElement timeValue_Element;

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

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/noResultText")
	public WebElement noResultText_Element;
	
	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTicketNoValue")
	public List<WebElement> ticketNo_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/openBtn")
	public WebElement openTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/inProgressBtn")
	public WebElement inProgressTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/resolvedBtn")
	public WebElement resolvedBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/completedBtn")
	public WebElement completedBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/add_fab")
	public WebElement fabBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/queryTypeSpinnerText")
	public WebElement queryType_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/briefDescriptionText")
	public WebElement briefDescription_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/detailDescriptionText")
	public WebElement detailDescription_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement snackBarText_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/img")
	public WebElement imageIcon_Element;

	@AndroidFindBy(accessibility  = "Shutter")
	public WebElement cameraCapture_Element;

	@AndroidFindBy(accessibility  = "Done")
	public WebElement cameraCapture_DoneBtn;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement submitBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvQueryTypeValue")
	public WebElement queryTypeValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvBriefDescriptionValue")
	public WebElement briefDesValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDetailDescriptionValue")
	public WebElement detailsDesValue_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;


	public  QueryListPage(AndroidDriver driver) {
		super(driver);
	}

	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void clickOn_CallIcon()
	{
         clickElement(callIcon_Element);
	}
	
public String get_ContactUs_Value() {
		return getText(ContactUsValue_Element);
	}

	public String get_EmailValue() {
		return getText(emailValue_Element);
	}

	public String get_TimeValue() {
		return getText(timeValue_Element);
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

	public void clickOn_ApplyBtn() {
		clickElement(filter_ApplyBtn_Element);
	}
	
	public String get_NoResultText() {
		return getText(noResultText_Element);
	}
	

public String get_TicketNo() {
	WebElement ticketNo_Element = ticketNo_Elements.get(0);
		return getText(ticketNo_Element);
	}

	public void open_firstrecord() {
		WebElement ticketNo_Element = ticketNo_Elements.get(0);
		clickElement(ticketNo_Element);
	}

	public void clickOn_OpenTab() {
		clickElement(openTab_Element);
	}

	public void clickOn_InprogressTab() {
		clickElement(inProgressTab_Element);
	}

	public void clickOn_ResolvedTab() {
		clickElement(resolvedBtn_Element);
	}

	public void clickOn_CompletedTab() {
		clickElement(completedBtn_Element);
	}

	public void clickOn_FabBtn() {
		clickElement(fabBtn_Element);
	}

	public void clickOn_QueryType() {
		clickElement(queryType_Element);
	}

	public void clickOn_ResolvedBtn() {
		clickElement(resolvedBtn_Element);
	}
	
public void enter_BriefDesc(String text)
{
	sendText(briefDescription_Element, text );
}

public void enter_DetailDesc(String text)
{
	sendText(detailDescription_Element, text );
}

	public String get_SnackBar_Text() {
		return getText(snackBarText_Element);
	}

	 public void clickOn_ImageIcon() {
		clickElement(imageIcon_Element);
	}

	public void clickOn_CameraCaptureIcon() {
		clickIfPresent(cameraCapture_Element,5);
	}

	public void clickOn_CameraCapture_donebtn() {
		clickIfPresent(cameraCapture_DoneBtn,5);
	}

	

	public void clickOn_SubmitBtn() {
		clickElement(submitBtn_Element);
	}

	public String get_QueryTypeValue() {
		return getText(queryTypeValue_Element);
	}

	public String get_BriefDescValue() {
		return getText(briefDesValue_Element);
	}

	public String get_DetailDescValue() {
		return getText(detailsDesValue_Element);
	}

	public void clickOn_CancelBtn() {
		clickElement(cancelBtn_Element);
	}

	 

	
}