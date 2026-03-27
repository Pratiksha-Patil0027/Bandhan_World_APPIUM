package pages.redemptions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class RedemptionCartPage  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalClaimText")
	public WebElement CartPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cartProductName")
	public WebElement productCode_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cartProductDecription")
	public WebElement productDesc_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public WebElement productPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvMinus")
	public WebElement minusIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPlus")
	public WebElement plusIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cartQty")
	public WebElement qty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cartItemDelete")
	public WebElement deleteIcon_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSPoint")
	public WebElement TDSPoints_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement cancelBtn_Element;
	private By cancelBtn_Locator= By.id("com.prowess.apps.bandhan.world:id/tvCancel");

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement checkoutBtn_Element;
	private By checkoutBtn_Locator= By.id("com.prowess.apps.bandhan.world:id/tvSubmit");

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/noCartItem")
	public WebElement cartIsEmpty_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement warning_ToastMsg_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSPointLabel")
	public WebElement tdsPercentage_Element;

	
	// @AndroidFindBy(id = "")
	// public WebElement _Element;

	
	
	public RedemptionCartPage(AndroidDriver driver) {
		super(driver);
	}


	 public String get_CartPoints() {
    return getText(CartPoints_Element);
}

 public String get_ProductCode() {
    return getText(productCode_Element);
}

 public String get_ProductDesc() {
    return getText(productDesc_Element);
}

 public String get_ProductPoints() {
    return getText(productPoints_Element);
}

 public void clickOn_MinusBtn()
	{
     clickElement(minusIcon_Element);
	}

	public void clickOn_PlusBtn()
	{
     clickElement(plusIcon_Element);
	}

	public boolean verify_AdditionQty_Increased_By_One() {
    int beforeQty = Integer.parseInt(qty_Element.getText().trim());
    clickOn_PlusBtn();
    int afterQty = Integer.parseInt(qty_Element.getText().trim());
    return afterQty == beforeQty + 1;
}

public boolean verify_AdditionQty_decreased_By_One() {
    int beforeQty = Integer.parseInt(qty_Element.getText().trim());
    clickOn_MinusBtn();
    int afterQty = Integer.parseInt(qty_Element.getText().trim());
    return afterQty == beforeQty - 1;
}

	public String get_QtyText() {
    return getText(qty_Element);
}

public void clickOn_DeleteIcon()
	{
     clickElement(deleteIcon_Element);
	}

	public String get_TDSPoints() {
    return getText(TDSPoints_Element);
}

public String get_TDSPerscentage() {
    return getText(tdsPercentage_Element);
}

public void clickOn_CancelBtn()
	{
     clickIfPresent(cancelBtn_Locator,5);
	}

	public void clickOn_CheckoutBtn()
	{
     clickIfPresent(checkoutBtn_Locator,5);
	}
 
public String get_CartIsEmpty_Text() {
    return getText(cartIsEmpty_Element);
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


public void waitForSnackbarToDisappear() {
    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");

    new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.invisibilityOfElementLocated(snackbar));
}
public String verify_CartPoints_Calculation()
	{ 
        String qty_str = get_QtyText();
        String points_str = get_ProductPoints();
         String tdspoints_str = get_TDSPoints();

         int points_int = Integer.parseInt(points_str);
int qty_int = Integer.parseInt(qty_str);
int tdspoints_int = (int) Double.parseDouble(tdspoints_str);
 int cartPoints_int = (points_int * qty_int) + tdspoints_int;
 System.out.println("cartPoints_int : " + cartPoints_int);
String cartPoints = String.format("%.1f", (double) cartPoints_int);
System.out.println("cartPoints : " + cartPoints);
      return cartPoints;
	}

public String verify_TDSPoints_Calculation(String tdsPer)
	{ 
        String qty_str = get_QtyText();
        String points_str = get_ProductPoints();
         int tdsPercent = Integer.parseInt(tdsPer);

         int points_int = Integer.parseInt(points_str);
int qty_int = Integer.parseInt(qty_str);
 int actual_tdspoints_int = (points_int * qty_int * tdsPercent)/100 ;
 
 System.out.println("actual_tdspoints_int : " + actual_tdspoints_int);
String actual_tdspoints = String.format("%.1f", (double) actual_tdspoints_int);
System.out.println("actual_tdspoints : " + actual_tdspoints);
      return actual_tdspoints;
	}

    
}
	
	



