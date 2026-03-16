package pages.redemptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import core.GlobalStore;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class RedemptionHistoryPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
	public WebElement app_BackArrow_Element;

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

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/pendingBtn")
	public WebElement pendingTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/approvedBtn")
	public WebElement approvedTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/rejectedBtn")
	public WebElement rejectedTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/deliveredBtn")
	public WebElement deliveredTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/noRecords")
	public WebElement noRecords_Available_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/add_fab")
	public WebElement fab_Btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRedemptionNo")
	public List<WebElement> history_RedemptionNo_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRedemptionNo")
	public WebElement history_RedemptionNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDateLabel")
	public List<WebElement> history_RedemptionDate_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProduct")
	public List<WebElement> history_ProductCode_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProductDesc")
	public List<WebElement> history_ProductDesc_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvQtyValue")
	public List<WebElement> history_Qty_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public List<WebElement> history_TotalPoints_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSLabel")
	public List<WebElement> history_TDSPercentage_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSValue")
	public List<WebElement> history_TDSPoints_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTotalRedeemPointsValue")
	public List<WebElement> history_TotalRedeemPoints_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRedemptionNo")
	public WebElement viewHistory_RedemptionNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDateLabel")
	public WebElement viewHistory_RedemptionDate_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTotalPointsValue")
	public WebElement viewHistory_TotalRedeemPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSValue")
	public WebElement viewHistory_TDSPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public WebElement viewHistory_Points_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvQtyValue")
	public WebElement viewHistory_Qty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProductValue")
	public WebElement viewHistory_ProductCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDescriptionValue")
	public WebElement viewHistory_ProductDesc_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvStatusValue")
	public WebElement viewHistory_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/pdfText")
	public WebElement viewHistory_DownloadPDF_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement viewHistory_CancelBtn_Element;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text=\"PDF download started.\"]")
	public WebElement viewHistory_PDFDownloadStarted_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDispatchHistory")
	public WebElement viewHistory_DispatchHistoryLable_Element;

	

	public RedemptionHistoryPage(AndroidDriver driver) {
		super(driver);
	}

	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void clickOn_AppBackArrow() {
		clickElement(app_BackArrow_Element);
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

	public void clickOn_PendingTab() {
		clickElement(pendingTab_Element);
	}

	public void clickOn_ApprovedTab() {
		clickElement(approvedTab_Element);
	}

	public void clickOn_RejectedTab() {
		clickElement(rejectedTab_Element);
	}

	public void clickOn_DeliveredTab() {
		clickElement(deliveredTab_Element);
	}

	public String get_NoRecordsAvailable_Text() {
		return getText(noRecords_Available_Element);
	}

	public void clickOn_FabBtn() {
		clickIfPresent(fab_Btn_Element,0);
	}

	public String get_History_RedemptionNo(int i) {
		WebElement claimId = history_RedemptionNo_Elements.get(i);
		return getText(claimId);
	}

	




   public boolean isRedemptionNoPresent() {

    String redemptionNo = GlobalStore.get("GENERATED_REDEMPTIONNO").trim();

	// String redemptionNo = "ILP2603000038";
    System.out.println("GENERATED_REDEMPTIONNO : " + redemptionNo);
	

    int maxScroll = 5;

    for (int i = 0; i < maxScroll; i++) {

        List<WebElement> redemptions = driver.findElements(
                By.id("com.prowess.apps.bandhan.world:id/tvRedemptionNo"));

				 System.out.println("Step 111");

        for (WebElement redemption : redemptions) {

			 System.out.println("Step 222");

            if (redemption.getText().trim().equalsIgnoreCase(redemptionNo)) {

				 System.out.println("Step 333");

               WebElement row = driver.findElement(By.xpath(
"//android.widget.TextView[@resource-id='com.prowess.apps.bandhan.world:id/tvRedemptionNo' and normalize-space(@text)='" 
+ redemptionNo +
"']/ancestor::android.view.ViewGroup[@resource-id='com.prowess.apps.bandhan.world:id/item_stripe_bar']/parent::android.view.ViewGroup"));


               String date = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvDateLabel")).getText();

			   String uiDate = date.split("\\|")[0].trim();   // 15 Mar 2026

DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

LocalDate splitdate = LocalDate.parse(uiDate, inputFormat);
String formattedDate = splitdate.format(outputFormat);

System.out.println(formattedDate);  
                String productName = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvProduct")).getText();
                System.out.println("Step 2");

                String productDesc = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvProductDesc")).getText();
                System.out.println("Step 3");

                String qty = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvQtyValue")).getText();
                System.out.println("Step 4");

                String points = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvPointsValue")).getText();
                System.out.println("Step 5");

                String tds = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvTDSValue")).getText();
				String formatted_tds = String.format("%.1f", Double.parseDouble(tds));
                System.out.println("formatted_tds : "+ formatted_tds);

                String totalRedeemPoints = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvTotalRedeemPointsValue")).getText();
				removeDecimal(totalRedeemPoints);
				 System.out.println("totalRedeemPoints :" + removeDecimal(totalRedeemPoints));

				   
				  GlobalStore.put("ROW_DATE_TIME", formattedDate);
                GlobalStore.put("ROW_PRODUCTNAME", productName);
                GlobalStore.put("ROW_PRODUCTDESC", productDesc);
                GlobalStore.put("ROW_QTY", qty);
                GlobalStore.put("ROW_POINTS", points);
                GlobalStore.put("ROW_TDS", formatted_tds);
                GlobalStore.put("ROW_TOTAL_REDEEM_POINTS", removeDecimal(totalRedeemPoints));

                return true;
            }
        }

        scrollDownSafe();
    }

    return false;
}


	public void openRedemption(int i) {
		WebElement redemption = history_RedemptionNo_Elements.get(i);
		clickIfPresent(redemption, 2);
	}

	private By locator = By.id("com.prowess.apps.bandhan.world:id/tvRedemptionNo");

	public void openFirstRecord() {
		int retry = 0;

		while (retry < 3) {
			try {
				List<WebElement> claims = driver.findElements(locator);

				if (claims.isEmpty()) {
					throw new RuntimeException("No Redemptions records found");
				}

				claims.get(0).click();
				return; // success

			} catch (StaleElementReferenceException e) {
				retry++;
				System.out.println("Retrying due to stale element...");
				// sleep(500);
			}
		}

		throw new RuntimeException("Unable to open first claim record due to stale elements");
	}

	public String get_History_RedemptionDate(int i) {
		WebElement redemptionDateElement = history_RedemptionDate_Elements.get(i);
		String fulldate = getText(redemptionDateElement);
		String[] parts = fulldate.split("\\|");
		String redemptionDate = parts[0].trim();
		return redemptionDate;
	}

	public boolean areRedemptionsDatesWithinRange(String fromDateStr, String toDateStr)
			throws InterruptedException {

		LocalDate fromDate = parseExcelDate(fromDateStr);
		LocalDate toDate = parseExcelDate(toDateStr);

		Set<String> verifiedDates = new HashSet<>();
		int maxScrolls = 15; // safety guard
		int scrollCount = 0;

		while (scrollCount < maxScrolls) {

			// Re-fetch elements every loop (very important after scroll)
			List<WebElement> redemptionDateElements = history_RedemptionDate_Elements;

			boolean foundNewDate = false;

			for (int i = 0; i < redemptionDateElements.size(); i++) {

				String uiDateText;
				try {
					uiDateText = get_History_RedemptionDate(i).trim();
				} catch (Exception e) {
					continue; // skip stale / broken item
				}

				// Skip duplicates (happens after scroll)
				if (verifiedDates.contains(uiDateText)) {
					continue;
				}

				verifiedDates.add(uiDateText);
				foundNewDate = true;

				LocalDate redemptionDate;
				try {
					redemptionDate = parseExcelDate(uiDateText);
				} catch (Exception e) {
					throw new RuntimeException(
							"Unable to parse claim date from UI: " + uiDateText, e);
				}

				// FAIL FAST if out of range
				if (redemptionDate.isBefore(fromDate) || redemptionDate.isAfter(toDate)) {
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

	public String get_History_ProductCode(int i) {
		WebElement produtDesc = history_ProductCode_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_History_ProductDesc(int i) {
		WebElement produtDesc = history_ProductDesc_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_History_ProductQty(int i) {
		WebElement produtDesc = history_Qty_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_History_TotalPoints(int i) {
		WebElement produtDesc = history_TotalPoints_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_History_TDSPercentage(int i) {
		WebElement produtDesc = history_TDSPercentage_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_History_TDSPoints(int i) {
		WebElement produtDesc = history_TDSPoints_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_History_TotalRedeemPoints(int i) {
		WebElement produtDesc = history_TotalRedeemPoints_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_ViewHistory_RedemptionNo() {
		return getText(viewHistory_RedemptionNo_Element);
	}

	public String get_ViewHistory_RedemptionDate() {
		return getText(viewHistory_RedemptionDate_Element);
	}

	public boolean verify_ViewHistory_TotalRedeemPoints_Calculation() {
		String points = get_ViewHistory_Points();
		String qty = get_ViewHistory_Qty();
		String tdsPoints = get_ViewHistory_TDSPoints();
int points_int = Integer.parseInt(points);
int qty_int = Integer.parseInt(qty);
int tdspoints_int = (int) Double.parseDouble(tdsPoints);
 int totalRedeemPoints_int = (points_int * qty_int) + tdspoints_int;
 System.out.println("totalRedeemPoints_int : " + totalRedeemPoints_int);
String totalRedeemPoints = String.format("%.2f", (double) totalRedeemPoints_int);
System.out.println("totalRedeemPoints : " + totalRedeemPoints);
      return totalRedeemPoints.equals(get_ViewHistory_TotalRedeemPoints());
	}

	public String get_ViewHistory_TotalRedeemPoints() {
		return getText(viewHistory_TotalRedeemPoints_Element);
	}

	public String get_ViewHistory_TDSPoints() {
		return getText(viewHistory_TDSPoints_Element);
	}

	public String get_ViewHistory_Points() {
		return getText(viewHistory_Points_Element);
	}

	public String get_ViewHistory_Qty() {
		return getText(viewHistory_Qty_Element);
	}

	public String get_ViewHistory_ProductCode() {
		return getText(viewHistory_ProductCode_Element);
	}

	public String get_ViewHistory_ProductDesc() {
		return getText(viewHistory_ProductDesc_Element);
	}

	public String get_ViewHistory_RedemptionStatus() {
		return getText(viewHistory_Status_Element);
	}

	public boolean get_ViewHistory_DispatchHistoryIsDisplay() {
	   return isElementPresent(viewHistory_DispatchHistoryLable_Element);
	}

	

	public String get_ViewHistory_ToastMsg() {
		return getText(viewHistory_PDFDownloadStarted_Text_Element);

	}

	public boolean verify_PDFDownload_ToastMsg(String expectedMessage) {

    int attempts = 5;

    for (int i = 0; i < attempts; i++) {
        if (driver.getPageSource().contains(expectedMessage)) {
            return true;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
    }

    return false;
}

	public void clickOn_ViewHistory_DownloadPdf() {
		clickElement(viewHistory_DownloadPDF_Element);
	}

	public void clickOn_ViewHistory_CancelBtn() {
		clickIfPresent(viewHistory_CancelBtn_Element, 0);
	}

}
