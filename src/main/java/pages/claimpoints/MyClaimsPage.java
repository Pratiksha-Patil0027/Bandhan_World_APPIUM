package pages.claimpoints;

import java.time.LocalDate;
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

public class MyClaimsPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
	public WebElement pageTitle_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/gridIcon")
	public WebElement claimGridIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/listIcon")
	public WebElement claimListIcon_Element;

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
	public WebElement filterOkBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/pendingBtn")
	public WebElement pendingTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/approvedBtn")
	public WebElement approvedTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/rejectedBtn")
	public WebElement rejectedTab_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/no_data")
	public WebElement noData_Available_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/add_fab")
	public WebElement fab_Btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvClaimId")
	public List<WebElement> claimId_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvLabel")
	public List<WebElement> claimDate_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRetailerDealerValue")
	public List<WebElement> dealerName_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDescValue")
	public List<WebElement> productDesc_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvInvoiceNoValue")
	public List<WebElement> invoice_No_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvInvoiceNoValue")
	public WebElement invoice_No_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvClaimQtyValue")
	public List<WebElement> claimQty_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvClaimPointsValue")
	public List<WebElement> claim_Points_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRedemptionNo")
	public WebElement claimDetails_ClaimId_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDateLabel")
	public WebElement claimDetails_AddDate_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRetailerDealerNameValue")
	public WebElement claimDetails_DealerName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDescValue")
	public WebElement claimDetails_ProductDesc_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvInvoiceNoValue")
	public WebElement claimDetails_InvNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvInvoiceNoValue")
	public WebElement claimDetails_InvDate_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvClaimQtyValue")
	public WebElement claimDetails_ClaimQty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvClaimPointsValue")
	public WebElement claimDetails_ClaimPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvApproveQtyValue")
	public WebElement claimDetails_ApprovedQty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvApprovedPointsValue")
	public WebElement claimDetails_ApprovedPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvStatusValue")
	public WebElement claimDetails_Status_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCusomerNameValue")
	public WebElement claimDetails_CustName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCusomerMobNoValue")
	public WebElement claimDetails_CustMobile_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSiteAddressValue")
	public WebElement claimDetails_SiteAddress_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/pdfText")
	public WebElement claimDetails_DownloadPDF_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement claimDetails_CancelBtn_Element;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text=\"PDF download started.\"]")
	public WebElement claimDetails_PDFDownloadStarted_Text_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	public MyClaimsPage(AndroidDriver driver) {
		super(driver);
	}

	public String get_PageTitle() {
		return getText(pageTitle_Element);
	}

	public void clickOn_ClaimGridIcon() {
		clickElement(claimGridIcon_Element);
	}

	public void clickOn_ClaimListIcon() {
		clickElement(claimListIcon_Element);
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

    for (int i = 0; i < 12; i++) {   // safety loop

        String headerText = date_Elements.get(0).getAttribute("content-desc");
        System.out.println("text : " + headerText);

        // Example headerText → "01 January 2025"
        if (headerText.contains(month) && headerText.contains(year)) {
            monthFound = true;

            for (WebElement dateElement : date_Elements) {

                String dateText = dateElement.getAttribute("content-desc").trim();
                // Example → "6 January 2025"

               
                if (dateText.contains(day ))
                       {
                    dateElement.click();
                    dateSelected = true;
					clickElement(filterOkBtn_Element);
                    break;
                }
            }
            break; //  STOP scrolling after correct month
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
		clickElement(filterOkBtn_Element);
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

	public String get_NoDataAvailable_Text() {
		return getText(noData_Available_Element);
	}

	public void clickOn_FabBtn() {
		clickElement(fab_Btn_Element);
	}

	public String get_ClaimIdFromView(int i) {
		waitForListToLoad(claimId_Elements);
		WebElement claimId = claimId_Elements.get(i);
		return getText(claimId);
	}


	public boolean isClaimIdPresent() {

    String claimId = GlobalStore.get("GENERATED_CLAIMID");
	 //String claimId = "C2618004-1";
	

    int maxScroll = 5;

    for (int i = 0; i < maxScroll; i++) {

        List<WebElement> claims = driver.findElements(
                By.id("com.prowess.apps.bandhan.world:id/tvClaimId"));

        for (WebElement claim : claims) {

            if (claim.getText().trim().equalsIgnoreCase(claimId)) {

                WebElement row = driver.findElement(By.xpath(
                        "//android.widget.TextView[@resource-id='com.prowess.apps.bandhan.world:id/tvClaimId' and @text='" 
                        + claimId +
                        "']/ancestor::android.view.ViewGroup[@resource-id='com.prowess.apps.bandhan.world:id/clgrid']"));

                String dealerName = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvRetailerDealerValue")).getText();
                String invNo = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvInvoiceNoValue")).getText();
                String productDesc = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvDescValue")).getText().replaceAll("\\s*-\\s*$", "").trim();
                String claimQty = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvClaimQtyValue")).getText();
                String claimPoints = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvClaimPointsValue")).getText();
                String invDate = row.findElement(By.id("com.prowess.apps.bandhan.world:id/tvLabel")).getText();

                GlobalStore.put("ROW_DEALERNAME", dealerName);
                GlobalStore.put("ROW_INVNO", invNo);
                GlobalStore.put("ROW_PRODUCTDESC", productDesc);
                GlobalStore.put("ROW_CLAIMQTY", claimQty.replace(".000",""));
                GlobalStore.put("ROW_CLAIMPOINTS", claimPoints.split("\\.")[0]);
                GlobalStore.put("ROW_INVDATE", invDate);

                return true;
            }
        }

        scrollDownSafe();
    }

    return false;
}



public String normalizeBagText(String text) {

    if (text == null || text.isEmpty()) return text;

    String[] parts = text.trim().split(" ");

    try {
        double num = Double.parseDouble(parts[0]);
        String normalized = String.valueOf(num);

        if (parts.length > 1) {
            return normalized + " " + parts[1];
        }

        return normalized;

    } catch (Exception e) {
        return text;
    }
}




	public void openClaim(int i) {
		waitForListToLoad(claimId_Elements);
		WebElement claimId = claimId_Elements.get(i);
		clickIfPresent(claimId,2);
	}


	private By claimIdLocator = By.id("com.prowess.apps.bandhan.world:id/tvClaimId");

	public void openFirstClaimRecord() {	
    int retry = 0;

    while (retry < 3) {
        try {
            List<WebElement> claims =
                    driver.findElements(claimIdLocator);

            if (claims.isEmpty()) {
                throw new RuntimeException("No claim records found");
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



	public String get_ClaimDateFromView(int i) {
		waitForListToLoad(claimDate_Elements);
		WebElement claimDateElement = claimDate_Elements.get(i);
		String fulldate = getText(claimDateElement);
		String[] parts = fulldate.split("\\|");
		String claimDate = parts[0].trim();
		return claimDate;
	}

	public boolean areClaimDatesWithinRange(String fromDateStr, String toDateStr)
        throws InterruptedException {

    LocalDate fromDate = parseExcelDate(fromDateStr);
    LocalDate toDate   = parseExcelDate(toDateStr);

    Set<String> verifiedDates = new HashSet<>();
    int maxScrolls = 15;                 // safety guard
    int scrollCount = 0;

    while (scrollCount < maxScrolls) {

        // Re-fetch elements every loop (very important after scroll)
        List<WebElement> claimDateElements = claimDate_Elements;

        boolean foundNewDate = false;

        for (int i = 0; i < claimDateElements.size(); i++) {

            String uiDateText;
            try {
                uiDateText = get_ClaimDateFromView(i).trim();
            } catch (Exception e) {
                continue; // skip stale / broken item
            }

            // Skip duplicates (happens after scroll)
            if (verifiedDates.contains(uiDateText)) {
                continue;
            }

            verifiedDates.add(uiDateText);
            foundNewDate = true;

            LocalDate claimDate;
            try {
                claimDate = parseExcelDate(uiDateText);
            } catch (Exception e) {
                throw new RuntimeException(
                        "Unable to parse claim date from UI: " + uiDateText, e
                );
            }

            //  FAIL FAST if out of range
            if (claimDate.isBefore(fromDate) || claimDate.isAfter(toDate)) {
                System.err.println(
                        "Date out of range -> UI: " + uiDateText +
                        " | Expected between: " + fromDate + " and " + toDate
                );
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

    return true; //  All visible dates are within range
}


	public String get_DealerNameFromView(int i) {
		waitForListToLoad(dealerName_Elements);
		WebElement dealerName = dealerName_Elements.get(i);
		return getText(dealerName);
	}

	public String get_ProductDescFromView(int i) {
		waitForListToLoad(productDesc_Elements);
		WebElement produtDesc = productDesc_Elements.get(i);
		return getText(produtDesc);
	}

	public String get_InvNoFromView(int i) {
		waitForListToLoad(invoice_No_Elements);
		WebElement invNo = invoice_No_Elements.get(i);
		return getText(invNo);
	}

	public boolean verify_InvoiceNoisDiaplay() throws InterruptedException {
         Thread.sleep(4000);
		return isElementVisible(invoice_No_Element);
	}

	public String get_ClaimQtyFromView(int i) {
		waitForListToLoad(claimQty_Elements);
		WebElement claimQty = claimQty_Elements.get(i);
		String fullText = getText(claimQty);
		// String[] parts = fullText.split("\\ ");
		// String qty = parts[0];
		return fullText;

	}

	public String get_ClaimPointFromView(int i) {
		waitForListToLoad(claim_Points_Elements);
		WebElement claimPoint = claim_Points_Elements.get(i);
		return getText(claimPoint);
	}

	public String get_ClaimDetails_ClaimId() {
		return getText(claimDetails_ClaimId_Element);
	}

	public String get_ClaimDetails_AddDate() {
		return getText(claimDetails_AddDate_Element);
	}

	public String get_ClaimDetails_DealerName() {
		return getText(claimDetails_DealerName_Element);
	}

	public String get_ClaimDetails_ProductDesc() {
		return getText(claimDetails_ProductDesc_Element);
	}

	public String get_ClaimDetails_InvNo() {
		return getText(claimDetails_InvNo_Element);
	}

	public String get_ClaimDetails_InvDate() {
		return getText(claimDetails_InvDate_Element);
	}

	public String get_ClaimDetails_ClaimQty() {
		return getText(claimDetails_ClaimQty_Element);
	}

	public String get_ClaimDetails_ClaimPoints() {
		return getText(claimDetails_ClaimPoints_Element);
	}

	public String get_ClaimDetails_ApprovedQty() {

		return getTextAfterScroll(claimDetails_ApprovedQty_Element,
				"com.prowess.apps.bandhan.world:id/tvApproveQtyValue");
	}

	public String get_ClaimDetails_ApprovedPoints() {
		return getTextAfterScroll(claimDetails_ApprovedPoints_Element,
				"com.prowess.apps.bandhan.world:id/tvApprovedPointsValue");
	}

	public String get_ClaimDetails_ClaimStatus() {
		return getTextAfterScroll(claimDetails_Status_Element, "com.prowess.apps.bandhan.world:id/tvStatusValue");
	}

	public String get_ClaimDetails_CustName() {
		return getTextAfterScroll(claimDetails_CustName_Element,
				"com.prowess.apps.bandhan.world:id/tvCusomerNameValue");
	}

	public String get_ClaimDetails_CustMobileNo() {
		return getTextAfterScroll(claimDetails_CustMobile_Element,
				"com.prowess.apps.bandhan.world:id/tvCusomerMobNoValue");

	}

	public String get_ClaimDetails_CustSiteAddress() {
		return getTextAfterScroll(claimDetails_SiteAddress_Element,
				"com.prowess.apps.bandhan.world:id/tvSiteAddressValue");

	}

	public String get_ClaimDetails_ToastMsg() {
		return getText(claimDetails_PDFDownloadStarted_Text_Element);

	}

	public void clickOn_DownloadPdf() {
		clickElement(claimDetails_DownloadPDF_Element);
	}

	public void clickOn_ClaimDetails_CancelBtn() {
		clickIfPresent(claimDetails_CancelBtn_Element, 0);
	}

}
