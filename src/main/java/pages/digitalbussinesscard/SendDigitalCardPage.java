package pages.digitalbussinesscard;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class SendDigitalCardPage extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/mobileNo")
	public WebElement digitalcard_enterMobileNo_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/ivsendwhatsapp")
	public WebElement digitalcard_sendBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement digitalcard_warningMsg_Element;

	
	public SendDigitalCardPage(AndroidDriver driver) {
		super(driver);
	}




	public String get_WarningMsg() {
		return getText(digitalcard_warningMsg_Element);
	}

	public void clickOn_SendBtn() {
		clickElement(digitalcard_sendBtn_Element);
	}
	
	public String verify_SendBtnIsEnabled() {
		return digitalcard_sendBtn_Element.getAttribute("enabled");
	}

	public void enter_MobileNo(String input) {
		sendText(digitalcard_enterMobileNo_Element, input);;
	}

	public String get_entermobile_lableName() {
		return getText(digitalcard_enterMobileNo_Element);
	}

	

	
}