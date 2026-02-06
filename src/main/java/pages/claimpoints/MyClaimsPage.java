package pages.claimpoints;


import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class MyClaimsPage extends BasePage {

	@AndroidFindBy(id = "")
	public WebElement _Element;

	


	public MyClaimsPage(AndroidDriver driver) {
		super(driver);
	}

	

}
