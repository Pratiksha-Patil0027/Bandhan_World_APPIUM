package pages.dashboard;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class DashboardPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_insurance")
	public WebElement family_Insurance_Window_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_skip_btn")
	public WebElement family_Insurance_WindowSkipBtn_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhan.world:id/blinkItem\").instance(0)")
	public WebElement claimPoints_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhan.world:id/blinkItem\").instance(3)")
	public WebElement redemptions_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhan.world:id/blinkItem\").instance(6)")
	public WebElement callMe_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Digital Business Card\")")
	public WebElement businessCard_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"My Web Site\")")
	public WebElement myWebSite_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Catalogue\")")
	public WebElement catalogue_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"My Health Benefits\")")
	public WebElement myHealthBenefits_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Dream Gift\")")
	public WebElement dreamGift_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Query List\")")
	public WebElement queryList_Menu_Element;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhan.world:id\").instance(11)")
	public WebElement digital_business_card_Menu_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvMyBalance")
	public WebElement myBalancePoints_Element;

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

	@AndroidFindBy(accessibility = "Crop")
	public WebElement camera_DoneBtn_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	public DashboardPage(AndroidDriver driver) {
		super(driver);
	}

	public void clickOn_SkipBtnOf_FamilyInsuranceWindow() {
		try {
			clickIfPresent(family_Insurance_WindowSkipBtn_Element, 0);
		} catch (Exception e) {
			System.out.println("Insurance dialog not shown");
		}
	}

	public void clickOn_ClaimPoints_Menu() {
		claimPoints_Menu_Element.click();
	}

	public void clickOn_Redemptions_Menu() {
		clickElement(redemptions_Menu_Element);
	}

	public void clickOn_CallMe_Menu() {
		clickElement(callMe_Menu_Element);
	}

	public void clickOn_RewardCatalogue_Menu() {
		driver.findElement(AppiumBy.androidUIAutomator(
			"new UiScrollable(new UiSelector().resourceId(\"com.prowess.apps.bandhan.world:id/recyclerviewMenu\").instance(1))" +
			".setAsHorizontalList()" +
			".scrollIntoView(new UiSelector().text(\"Reward Catalogue\"));"
		)).click();
	}


	public void clickOn_CostCalculation_Menu() {
		driver.findElement(AppiumBy.androidUIAutomator(
			"new UiScrollable(new UiSelector().scrollable(true))" +
			".setAsVerticalList()" +
			".scrollIntoView(new UiSelector().text(\"Cost Calculator\"))"
		)).click();
	}

	public void scrollAndClick(String visibleText) {
    	boolean found = false;
    	int retry = 0;
    
    	while (!found && retry < 5) {
        	try {
            	driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + visibleText + "\")")).click();
            	found = true;
        	} catch (Exception e) {
            	// Use a PointerInput/Sequence to swipe up here
            	swipeUp(); 
            	retry++;
        	}
    	}
	}


	public void swipeUp() {
		// 1. Get screen dimensions
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = (int) (size.getHeight() * 0.8); // Start at 80% of the screen height
		int endY = (int) (size.getHeight() * 0.2);   // End at 20% of the screen height

		// 2. Setup PointerInput
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);

		// 3. Define the sequence of actions
		// Move to start position
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		// Press down
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		// Move to end position (the actual swipe)
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
		// Lift up
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// 4. Perform the action
		driver.perform(Arrays.asList(swipe));
	}

public void clickOn_BusinessCard_Menu() {
		clickElement(businessCard_Menu_Element);
	}


	public boolean claimPointsMenuIsDisplay() {
		return isElementVisible(claimPoints_Menu_Element);
	}


	public void navigateBackToHomeDashboard() {

		int maxBackPress = 5; // safety limit

		while (!isElementVisible(claimPoints_Menu_Element) && maxBackPress-- > 0) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		}

		if (!isElementVisible(claimPoints_Menu_Element)) {
			throw new RuntimeException("Failed to navigate back to Home Dashboard");
		}
	}

	public String get_MyBalancePoints()
	{
		String balancePoints = getText(myBalancePoints_Element);
       return String.valueOf((int) Double.parseDouble(balancePoints));	
	}

	public void clickOn_MyWebSite_Menu() {
		clickElement(myWebSite_Menu_Element);
	}

	
	public void clickOn_Catalogue_Menu() {
		clickElement(catalogue_Menu_Element);
	}

	public void clickOn_DreamGift_Menu() {
		clickElement(dreamGift_Menu_Element);
	}

	public void clickOn_QueryList_Menu() {
		clickElement(queryList_Menu_Element);
	}

	public void clickOn_MyHealthBenefits_Menu() {
		clickElement(myHealthBenefits_Menu_Element);
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

	public void clickOn_BrowseFileOption() {
		clickElement(browseFile_Option_Element);
	}

	public void clickOn_CameraCaptureOption() {
		clickElement(camera_Option_Element);
	}

	public void clickOn_GallaryDoneButton() {
		clickElement(camera_DoneBtn_Element);
	}
	
}