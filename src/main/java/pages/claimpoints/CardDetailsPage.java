package pages.claimpoints;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class CardDetailsPage  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalClaimText")
	public WebElement totalClaim_Points_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_categoryName")
      public List<WebElement> added_CategoryName_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/product_count")
	public List<WebElement> product_Count_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_arrow")
	public List<WebElement> arrowIcon_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProductCode")
	public WebElement productCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDescription")
	public WebElement productDescription_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_delete")
	public WebElement deleteBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_plus")
	public WebElement plusIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/edt_qty")
	public WebElement qty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/iv_minus")
	public WebElement minusIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/uomText")
	public WebElement uomText_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/pointText")
	public WebElement points_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalPointText")
	public WebElement totalPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement submitBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
	public WebElement alert_DialogBox_Title_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_text")
	public WebElement alert_DialogBox_Text_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_no")
	public WebElement alert_DialogBox_NoBtn_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
	public WebElement alert_DialogBox_YesBtn_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;
	


	
	public CardDetailsPage(AndroidDriver driver) {
		super(driver);
	}

	


}

