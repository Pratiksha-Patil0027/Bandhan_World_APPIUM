package pages.claimpoints;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class CategoryPage  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
	public WebElement backArrow_Element;

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

	


	
	public CategoryPage(AndroidDriver driver) {
		super(driver);
	}

	
	public void clickOn_BackArrow()
	{
     clickElement(backArrow_Element);
	}


	
	public boolean selectCategoryByHorizontalScroll(String categoryName) {

    int maxSwipes = 10; // safety limit

    for (int swipe = 0; swipe < maxSwipes; swipe++) {

        for (WebElement category : category_Elements) {
            try {
                if (category.isDisplayed()
                        && category.getText().equalsIgnoreCase(categoryName)) {

                    category.click(); //  FOUND & CLICKED
                    return true;
                }
            } catch (Exception e) {
                // ignore and continue
            }
        }

        //  not found → swipe horizontally
        swipeLeft();
    }

    return false; // not found after scrolling
}


	 
	//  brand_Elements;

	//  productSearch_Field_Element;

	//  qty_ShouldGreater_ErrorMsg_Element;

	//  qtyField_Elements;

	//  uomField_Elements;

	//  pointsvalue_Field_Elements;

	//  totalPointsValue_Field_Elements;

	//  addTocard_Btn_Elements;

	//  cartIcon_Element;

	//  refreshIcon_Element;

	//  addedProduct_PonitsText_Element;
	


}
