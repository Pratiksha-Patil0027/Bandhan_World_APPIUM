package pages.dashboard;

import org.openqa.selenium.WebElement;

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

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.prowess.apps.bandhan.world:id\").instance(11)")
	public WebElement digital_business_card_Menu_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

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
}