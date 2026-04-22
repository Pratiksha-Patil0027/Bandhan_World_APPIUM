package pages.claimpoints;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class CardDetailsPage extends BasePage {

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
	public List<WebElement> totalPoints_Elements;

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

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tv_no_data_found")
	public WebElement nodatafound_Element;

	
	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	public CardDetailsPage(AndroidDriver driver) {
		super(driver);
	}

	public String get_TotalClaimPoints_value() {
		return getText(totalClaim_Points_Element);
	}

	public String get_AddedCategoryName(int i) {
		waitForListToLoad(added_CategoryName_Elements);
		WebElement added_CategoryName_Element = added_CategoryName_Elements.get(i);
		return getText(added_CategoryName_Element);
	}

	public String get_ProductCount(int i) {
		waitForListToLoad(product_Count_Elements);
		WebElement product_Count_Element = product_Count_Elements.get(i);
		return getText(product_Count_Element);
	}

	public void clickOn_UpDownArrowIcon(int index) {
		waitForListToLoad(arrowIcon_Elements);
		WebElement arrowIcon_Element = arrowIcon_Elements.get(index);
		clickElement(arrowIcon_Element);
	}

	public String get_ProductCode() {
		return getText(productCode_Element);
	}

	

	public String get_ProductDescription() {
		return getText(productDescription_Element);
	}

	public void clickOn_DeleteIcon() {
		clickElement(deleteBtn_Element);
	}

	public void clickOn_PlusIcon() {
		clickElement(plusIcon_Element);
	}

	public void clickOn_MinusIcon() {
		clickElement(minusIcon_Element);
	}

	public String get_QtyText() {
		return getText(qty_Element);
	}

	public boolean verify_AdditionQty_Increased_By_One() {
    int beforeQty = Integer.parseInt(qty_Element.getText().trim());
    clickOn_PlusIcon();
    int afterQty = Integer.parseInt(qty_Element.getText().trim());
    return afterQty == beforeQty + 1;
}

public boolean verify_AdditionQty_decreased_By_One() {
    int beforeQty = Integer.parseInt(qty_Element.getText().trim());
    clickOn_MinusIcon();
    int afterQty = Integer.parseInt(qty_Element.getText().trim());
    return afterQty == beforeQty - 1;
}

	public String get_MinusQty() {
		return getText(qty_Element);
	}

	public String get_UOMText() {
		return getText(uomText_Element);
	}

	public String get_PointsText() {
		return getText(points_Element);
	}

	public String get_TotalPointsText() {
		WebElement totalPoints_Element = totalPoints_Elements.get(0);
		double number = Double.parseDouble(getText(totalPoints_Element));
    
    if (number == (long) number) {
        return String.valueOf((long) number);  // 10
    } else {
        return String.valueOf(number);         // 10.25 stays 10.25
    }
}


public String get_AdditionOfTotalPoints() {

    double total = 0.0;

    for (WebElement totalPoints_Element : totalPoints_Elements) {

        String text = getText(totalPoints_Element).trim();

        if (text.isEmpty()) continue;

        total += Double.parseDouble(text);
    }

    // If whole number → return without decimal
    if (total == (long) total) {
        return String.valueOf((long) total);   // 50
    } else {
        return String.valueOf(total);          // 50.25
    }
}


	public void clickOn_CancelBtn() {
		clickIfPresent(cancelBtn_Element,5);
	}

	public void clickOn_SubmitBtn() {
		clickElement(submitBtn_Element);
	}

	public String get_AlertDialogBoxTitle_Text() {
		return getText(alert_DialogBox_Title_Element);
	}

	public String get_AlertDialogBox_Text() {
		return getText(alert_DialogBox_Text_Element);
	}

	public void clickOn_Alert_DialogBox_NoBtn() {
		clickIfPresent(alert_DialogBox_NoBtn_Element,1);
	}

	public void clickOn_Alert_DialogBox_YesBtn() {
		clickIfPresent(alert_DialogBox_YesBtn_Element,1);
	}

	public String get_NoDataFound_Text() {
		return getText(nodatafound_Element);
	}

	public boolean verify_submitbtn_isEnable() {
    try {
        String enabledValue = submitBtn_Element.getAttribute("enabled");
        return Boolean.parseBoolean(enabledValue);
    } catch (Exception e) {
        return false;
    }
}
	
	
}
