package pages.redemptions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.GlobalStore;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class RewardCataloguePage  extends BasePage {

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
	public WebElement backArrow_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etSearch")
	public WebElement rewardSearch_Field_Element;

	@AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/eligible_gift")
	public WebElement eligibleGift_Checkbox_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvMyBalance")
	public WebElement myBalancePoints_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/sortIcon")
	public WebElement updownArrow_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalClaimTextReward")
	public WebElement cartPoints_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTitle")
	public List<WebElement> rewardProductCode_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDescription")
	public List<WebElement> rewardProductDesc_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public List<WebElement> rewardProductPoints_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvMinus")
	public List<WebElement> qtyMinus_Btn_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPlus")
	public List<WebElement> qtyPlus_Btn_Elements;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvRewardQty")
	public List<WebElement> addQty_Box_Elements;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvViewDetails")
	public List<WebElement> viewDetails_Btn_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProductName")
	public WebElement viewDetails_ProductCode_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProductDescriptionValue")
	public WebElement  viewDetails_ProductDesc_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPointsValue")
	public WebElement  viewDetails_ProductPoints_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_close")
	public WebElement  viewDetails_CrossIcon_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSPointLabel")
	public WebElement TDS_Percentage_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvTDSPoint")
	public WebElement TDS_PointsValue_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement submitBtn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/filter_grey")
	public WebElement filterIcon_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvBalance")
	public WebElement filter_AvailablePoints_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvStartRange")
	public WebElement filter_MinPoints_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvEndRange")
	public WebElement filter_MaxPoints_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/ivRefresh")
	public WebElement filter_RefreshIcon_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/checkboxEligable")
	public WebElement filter_EligibleGift_Checkbox_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/checkboxAllCategory")
	public WebElement filter_All_Checkbox_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/checkbox_category")
	public List<WebElement> filter_Categories_Checkbox_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/errorNote")
	public WebElement filter_ErrorMsg_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCancel")
	public WebElement filter_CancelBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvSubmit")
	public WebElement filter_ApplyBtn_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
	public WebElement warning_ToastMsg_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvNoDataView")
	public WebElement noRecordsAvailable_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/addedToCart")
	public WebElement cartIcon_Element;

    

    
    
	public RewardCataloguePage(AndroidDriver driver) {
		super(driver);
	}

	

    

    public String get_NoRecordsAvailable_Text()
	{
		return getText(noRecordsAvailable_Element);
	}

    public boolean isCartIconDisplay()
{
    return isElementVisible(cartIcon_Element);
}
    
    public String get_WarningToastMsg()
	{
		return getText(warning_ToastMsg_Element);
	}

	public void clickOn_BackArrow()
	{
     clickElement(backArrow_Element);
	}

    public void enter_SearchData(String input) {
        
     WebElement searchField = rewardSearch_Field_Element;
    searchField.click();        // focus the field
    searchField.clear();
     sendText(rewardSearch_Field_Element, input);   
}

public void clickOn_Keyboard_Searchicon()
	{
     ((JavascriptExecutor) driver).executeScript(
            "mobile: performEditorAction",
            Map.of("action", "search")
    );
	}

     public void clear_InputSearchField()
	{
     rewardSearch_Field_Element.clear();
	}

public void clickOn_Eligible_Checkbox()
	{
     clickElement(eligibleGift_Checkbox_Element);
	}

    public String get_MyBalancePoints()
	{
		String balancePoints = getText(myBalancePoints_Element);
       return String.valueOf((int) Double.parseDouble(balancePoints));	
	}


    public boolean verifyProductVisibility(boolean eligibleCheckboxChecked) {
    int balancePoints = Integer.parseInt(get_MyBalancePoints());
    int productPoints = Integer.parseInt(get_RewardProductPoints(0));

    if (eligibleCheckboxChecked) {
        // Only products user can afford
        return productPoints <= balancePoints;
    } else {
        // Products that require more points than balance
        return productPoints > balancePoints;
    }
}


    public void clickOn_upDown_Arrow()
	{
     clickElement(updownArrow_Element);
	}

    public boolean verifyNextProductGreaterThanFirst() {

    List<WebElement> elements = rewardProductPoints_Elements;

    int firstPoints = Integer.parseInt(elements.get(0).getText().replaceAll("[^0-9]", ""));
     System.out.println("firstPoints: "+ firstPoints);
    for (int i = 1; i < elements.size(); i++) {

        int nextPoints = Integer.parseInt(elements.get(i).getText().replaceAll("[^0-9]", ""));

         System.out.println("nextPoints: "+ nextPoints);

        if (nextPoints > firstPoints) {
            return true;
        }
    }

    return false;
}

     public String get_CartPoints_Text()
	{
     return getText(cartPoints_Element);
	}



    public String verify_CartPoints_Calculation()
	{ 
        String qty_str = get_RewardProductQty(0);
        String points_str = get_RewardProductPoints(0);
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

    public String verify_Balancepoints_Calculation()
{ 
    String old_balancepoints_str = GlobalStore.get("BALANCE_POINTS"); //146.
    String cartPoints_str = get_CartPoints_Text(); //110.0

    int points_int = (int) Double.parseDouble(old_balancepoints_str);
    int cartPoints_int = (int) Double.parseDouble(cartPoints_str);

    int actual_balancepoints_int = points_int - cartPoints_int;
    System.out.println("actual_balancepoints_int : " + actual_balancepoints_int);

    String actual_balancepoints = String.valueOf(actual_balancepoints_int);
    System.out.println("actual_balancepoints : " + actual_balancepoints);

    return actual_balancepoints;
}

   
    public String get_RewardProductCode(int i) {

    WebElement rewardProductCode_Element =rewardProductCode_Elements.get(i);

    return getText(rewardProductCode_Element);
}

public String get_RewardProductCodepart(int i) {

    WebElement rewardProductCode_Element =rewardProductCode_Elements.get(i);

    String expected = getText(rewardProductCode_Element);

String expectedProductName = expected.split("\\|")[1].trim();

System.out.println(" expectedProductName_Part : " + expectedProductName);

    return expectedProductName ;
}

 public String get_RewardProductDesc(int i) {

    WebElement rewardProductDesc_Element=rewardProductDesc_Elements.get(i);

    return getText(rewardProductDesc_Element);
}

 public String get_RewardProductPoints(int i) {

    WebElement rewardProductPoints_Element =rewardProductPoints_Elements.get(i);

    return getText(rewardProductPoints_Element);
}

public String get_RewardProductQty(int i) {

    WebElement addQty_Box_Element =addQty_Box_Elements.get(i);

    return getText(addQty_Box_Element);
}

   public void clickOn_QtyMinus_Btn(int i )
	{
        WebElement qtyMinus_Btn_Element =qtyMinus_Btn_Elements.get(i);
     clickElement(qtyMinus_Btn_Element);
	}

    public void clickOn_QtyPlus_Btn(int i )
	{
        WebElement qtyPlus_Btn_Element =qtyPlus_Btn_Elements.get(i);
     clickElement(qtyPlus_Btn_Element);
	}

    public void enter_Qty(int i, String qty)
	{

    By qtyLocator = By.id("com.prowess.apps.bandhan.world:id/tvRewardQty");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    wait.until(ExpectedConditions.presenceOfElementLocated(qtyLocator));

    WebElement qtyField = addQty_Box_Elements.get(i);

    qtyField.clear();
    qtyField.sendKeys(qty);
}
	

    public void clickOn_ViewDetails_Btn(int i )
	{
     WebElement viewDetails_Btn_Element =viewDetails_Btn_Elements.get(i);
     clickElement(viewDetails_Btn_Element);
	}

    public String get_ViewDetails_ProductCode() {
    return getText(viewDetails_ProductCode_Element);
}

public String get_ViewDetails_ProductDesc() {
    return getText(viewDetails_ProductDesc_Element);
}

public String get_ViewDetails_ProductPoints() {
    return getText(viewDetails_ProductPoints_Element);
}

     public void clickOn_ViewDetails_CrossIcon()
	{
     clickIfPresent(viewDetails_CrossIcon_Element,0);
	}

    public String get_TDSPercentage() {
    return getText(TDS_Percentage_Element);
}

public String get_TDSPoints() {
    return getText(TDS_PointsValue_Element);
}

public String verify_TDSPoints_Calculation(String tdsPer)
	{ 
        String qty_str = get_RewardProductQty(0);
        String points_str = get_RewardProductPoints(0);
         String tdspoints_str = get_TDSPoints();
         int tdsPercent = Integer.parseInt(tdsPer);
         System.out.println("expected_tdspoints_str : " + tdspoints_str);

         int points_int = Integer.parseInt(points_str);
int qty_int = Integer.parseInt(qty_str);
 int actual_tdspoints_int = (points_int * qty_int * tdsPercent)/100 ;
 
 System.out.println("actual_tdspoints_int : " + actual_tdspoints_int);
String actual_tdspoints = String.format("%.1f", (double) actual_tdspoints_int);
System.out.println("actual_tdspoints : " + actual_tdspoints);
      return actual_tdspoints;
	}



public void clickOn_SubmitBtn()
	{
     clickElement(submitBtn_Element);
	}

    public void clickOn_FilterIcon()
	{
     clickIfPresent(filterIcon_Element,0);
	}
     
    public String verify_Filter_AvailableBalance() {
 System.out.println("Expected available points : "+ GlobalStore.get("BALANCE_POINTS"));
       int availableBalance = Integer.parseInt(getText(filter_AvailablePoints_Element));
       String availableBalance_decimal = String.valueOf(availableBalance);
       System.out.println("Actual available points : "+ availableBalance_decimal);
    //return availableBalance_decimal.equals(GlobalStore.get("BALANCE_POINTS"));
    return availableBalance_decimal;
}

 public String get_Filter_MinPoints() {
    return getText(filter_MinPoints_Element);
}

public boolean verify_Catagories_filterwindow_open() {
    return isElementVisible(filter_MinPoints_Element);
}



 public String get_Filter_MaxPoints() {
    return getText(filter_MaxPoints_Element);
}


public boolean verify_filterMaxPoints(boolean eligibleCheckboxChecked) {
    int balancePoints = Integer.parseInt(GlobalStore.get("BALANCE_POINTS"));
    int maxPoints = Integer.parseInt(get_Filter_MaxPoints());

    if (eligibleCheckboxChecked) {
        
        return maxPoints <= balancePoints;
    } else {
        return maxPoints > balancePoints;
    }
}


 public void clickOn_Filter_AllCheckbox()
	{
     clickElement(filter_All_Checkbox_Element);
	}

    public void clickOn_Filter_Specific_Category_Checkbox(int i)
	{
        WebElement filter_Categories_CElements =filter_Categories_Checkbox_Elements.get(i);
     clickElement(filter_Categories_CElements);
	}

    public void clickOn_Filter_RefreshIcon()
	{
     clickElement(filter_RefreshIcon_Element);
	}

    public void clickOn_Filter_EligibleCheckbox()
	{
     clickElement(filter_EligibleGift_Checkbox_Element);
	}

    public String get_EligibleGift_CheckedAttributeValue() {
    return filter_EligibleGift_Checkbox_Element.getAttribute("checked");
}
    

      public String get_Filter_ErrorMsg() {
    return getText(filter_ErrorMsg_Element);
}

 public void clickOn_filter_CancelBtn()
	{
     clickElement(filter_CancelBtn_Element);
	}

     public void clickOn_filter_ApplyBtn()
	{
     clickElement(filter_ApplyBtn_Element);
	}
    

    public boolean verify_CategoriesDisplayed_WithScroll(String categories) {

    if (categories == null || categories.trim().isEmpty()) {
        throw new RuntimeException("categories list is empty!");
    }

    String[] fieldArray = categories.split(",");

    for (String field : fieldArray) {

        String categorieName = field.trim();
        System.out.println("Verifying categorieName: " + categorieName);

        try {

            WebElement element = driver.findElement(
                AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                    + ".scrollIntoView(new UiSelector().textContains(\""
                    + categorieName + "\"))"
                )
            );

            if (element.isDisplayed()) {
                System.out.println(categorieName + " is displayed");
            } else {
                System.out.println(categorieName + " is NOT displayed");
                return false;
            }

        } catch (Exception e) {
            System.out.println(categorieName + " NOT found even after scroll");
            return false;
        }
    }

    return true;
}

}
	
	



