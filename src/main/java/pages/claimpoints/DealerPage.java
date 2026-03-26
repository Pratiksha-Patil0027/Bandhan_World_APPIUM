package pages.claimpoints;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class DealerPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_dealerValue")
	public WebElement dealerName_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_change")
	public WebElement change_Btn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/date")
	public WebElement inv_Date_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/invoiceEditText")
	public WebElement inv_No_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_Invoice_photo")
	public WebElement inv_PhotoIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvAttachlable")
	public WebElement attachDoc_lable_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cl_browse")
	public WebElement browseFile_Option_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cl_camera")
	public WebElement camera_Option_Element;

	@AndroidFindBy(id = "com.google.android.documentsui:id/icon_thumb")
	public List<WebElement> actualImage_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/manage")
	public WebElement gallary_ManageBtn_Element;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Photo taken')]")
	public List<WebElement> gallary_Manage_actualImage_Elements;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Done\")")
	public WebElement gallary_Manage_DoneBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/mediaImage")
	public WebElement gallary_Manage_SelectedImage_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnAttachSelected")
	public WebElement gallary_Manage_BtnAttachSelected_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement warning_ToastMsg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvNext")
	public WebElement nextBtn_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	public DealerPage(AndroidDriver driver) {
		super(driver);
	}

	public String get_DealerName() {
		return getText(dealerName_Element);
	}

	public void clickOn_ChnageBtn() {
		clickIfPresent(change_Btn_Element, 0);
	}

	public boolean get_ChangeBtnDisplay() {
		return isElementVisible(change_Btn_Element, 1);
	}

	public String get_PurchaseDate() {
		return getText(inv_Date_Element);
	}

	public void enter_InvNo(String invNo) {
		sendText(inv_No_Element, invNo);
	}

	public String get_InvNo() {
		return getText(inv_No_Element);
	}

	public void clickOn_InvPhotoIcon() {
		clickElement(inv_PhotoIcon_Element);
	}

	public String get_AttachDocLable() {
		return getText(attachDoc_lable_Element);
	}

	public void clickOn_BrowseFileOption() {
		clickElement(browseFile_Option_Element);
	}

	public String get_CameraOptionLable() {
		return getText(camera_Option_Element);
	}

	public String get_BrowseFileOptionLable() {
		return getText(browseFile_Option_Element);
	}

	public boolean verify_BrowseFile_Option_isDisplay() {

		clickIfPresent(inv_PhotoIcon_Element, 2);
		return isElementVisible(browseFile_Option_Element, 2);

	}

	public boolean verify_CaptureCamera_Option_isDisplay() {

		clickIfPresent(inv_PhotoIcon_Element, 2);
		return isElementVisible(camera_Option_Element, 2);

	}

	public void clickOn_BrowseFileOption(int i) {
		try {
			// Check if Manage button is present safely
			if (isElementVisible(gallary_ManageBtn_Element)) {

				clickElement(gallary_ManageBtn_Element);

				WebElement manageImage = gallary_Manage_actualImage_Elements.get(i);
				clickElement(manageImage);

				clickElement(gallary_Manage_DoneBtn_Element);
				clickElement(gallary_Manage_SelectedImage_Element);
				clickElement(gallary_Manage_BtnAttachSelected_Element);

			} else {
				// Fallback logic
				clickFromGallery(i);
			}

		} catch (Exception e) {
			System.out.println("Error while selecting image: " + e.getMessage());
			clickFromGallery(i); // fallback
		}
	}

	private void clickFromGallery(int i) {
       waitForListToLoad(actualImage_Elements);
		WebElement image = actualImage_Elements.get(i);
		clickElement(image);
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

	public void clickOn_CancelBtn() {

		clickElement(cancelBtn_Element);
	}

	public void clickOn_NextBtn() {

		clickElement(nextBtn_Element);
	}

}
