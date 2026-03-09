package pages.claimpoints;

import org.openqa.selenium.WebElement;

import core.GlobalStore;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class ClaimDetailsPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dealerNameText")
	public WebElement added_DealerName_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/invoiceText")
	public WebElement added_ClaimInvNo_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dateText")
	public WebElement added_ClaimInvDate_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/total")
	public WebElement added_ClaimTotalPoints_OnHeader_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/claimIdText")
	public WebElement added_ClaimIdText_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/productCode")
	public WebElement added_ProductCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/downLoadPDF")
	public WebElement pdfIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/qtyText")
	public WebElement added_ClaimQty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/PointText")
	public WebElement added_ClaimPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalPointText")
	public WebElement added_ClaimTotalPoints_Element;

	@AndroidFindBy(xpath = "//android.widget.Toast[@text=\"PDF download started.\"]")
	public WebElement pdfDownloadStartedText_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement close_Btn_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	public ClaimDetailsPage(AndroidDriver driver) {
		super(driver);
	}

	
	public String get_DealerName() {
		return getText(added_DealerName_Text_Element);
	}

	public String get_ClaimInvNo() {
		return getText(added_ClaimInvNo_Text_Element);
	}

	public String get_ClaimInvDate() {
		return getText(added_ClaimInvDate_Text_Element);
	}

	public String get_ClaimTotalPoints_OnHeader() {
    String points = getText(added_ClaimTotalPoints_OnHeader_Element);
    return points.split("\\.")[0];   // returns only 10 from 10.000
}

	public String get_ClaimId() {
		return getText(added_ClaimIdText_Element);
	}

	public boolean verifyClaimIdNotEmpty() {
    String claimId = get_ClaimId().trim();
    
  return claimId != null && !claimId.trim().isEmpty();
}

	public String get_ProductCode() {
		return getText(added_ProductCode_Element);
	}

	public String get_Code() {
    return get_ProductCode().split("\\|")[0].trim();
}

public String get_Description() {
    return get_ProductCode().split("\\|")[1].trim();
}

	public void clickOn_PdfIcon() {
		clickElement(pdfIcon_Element);
	}

	public String get_ClaimQty() {
		GlobalStore.put("GENERATED_CLAIMQTY", getText(added_ClaimQty_Element));

		return getText(added_ClaimQty_Element);
	}

	public String getQuantity() {
    return get_ClaimQty().split(" ")[0].trim();
}

public String getUOM() {
    return getText(added_ClaimQty_Element).split(" ")[1].trim();
}

	public String get_ClaimPoints() {
		String points = getText(added_ClaimPoints_Element);
		GlobalStore.put("GENERATED_TOTALPOINTS", points);
		return points;
	}

	public String get_ClaimTotalPoints() {
		
		double number = Double.parseDouble(getText(added_ClaimTotalPoints_Element));
    
    if (number == (long) number) {
        return String.valueOf((long) number);  // 10
    } else {
        return String.valueOf(number);         // 10.25 stays 10.25
    }
	}

	public String get_PdfDownloadStartedText() {
		return getText(pdfDownloadStartedText_Element);
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

	public void clickOn_CloseBtn() {
		clickElement(close_Btn_Element);
	}

}
