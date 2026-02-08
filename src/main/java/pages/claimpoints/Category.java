package pages.claimpoints;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class Category  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCategory")
	public List<WebElement> category_Elements;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.prowess.apps.bandhan.world:id/rvBrand\"]/android.view.ViewGroup")
	public List<WebElement> brand_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etSearch")
	public WebElement productSearch_Field_Element;

	@AndroidFindBy(id = "//android.widget.Toast[@text=\"Quantity should be greater than 0\"]")
	public WebElement qty_ShouldGreater_ErrorMsg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_qty")
	public List<WebElement> qtyField_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/autocom_uom")
	public List<WebElement> uomField_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public List<WebElement> pointsvalue_Field_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTotalPointsValue")
	public List<WebElement> totalPointsValue_Field_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvAdd")
	public List<WebElement> addTocard_Btn_Elements;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/add_fab")
	public WebElement cartIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/filter")
	public WebElement refreshIcon_Element;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.prowess.apps.bandhan.world:id/ll\"]/android.widget.TextView")
	public WebElement addedProduct_PonitsText_Element;

	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	


	
	public Category(AndroidDriver driver) {
		super(driver);
	}

	


}
