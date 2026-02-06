package pages.dashboard;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class DashboardPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_insurance")
	public WebElement family_Insurance_Window_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_skip_btn")
	public WebElement family_Insurance_WindowSkipBtn_Element;

	public DashboardPage(AndroidDriver driver) {
		super(driver);
	}

	public void clickOn_SkipBtnOf_FamilyInsuranceWindow() {
		try {
			clickElement(family_Insurance_WindowSkipBtn_Element);
		} catch (Exception e) {
			System.out.println("Insurance dialog not shown");
		}
	}

}