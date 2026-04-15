package pages.claimpoints;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class CategoryPage extends BasePage {

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
    public WebElement backArrow_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCategory")
    public List<WebElement> category_Elements;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.prowess.apps.bandhan.world:id/rvBrand\"]/android.view.ViewGroup/android.widget.TextView")
    public List<WebElement> brand_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/etSearch")
    public WebElement productSearch_Field_Element;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text=\"Quantity should be greater than 0\"]")
    public WebElement qty_ShouldGreater_ErrorMsg_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_qty")
    public List<WebElement> qtyField_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tiet_qty")
    public WebElement qtyField_Element;

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

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.prowess.apps.bandhan.world:id/ll\"]/android.widget.TextView[2]")
    public WebElement addedProduct_TonneUOMPonitsText_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/snackbar_text")
    public WebElement warning_ToastMsg_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProductCode")
    public WebElement productsInList_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvProductCode")
    public List<WebElement> productCode_Elements_InList;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDescription")
    public List<WebElement> productDescription_Elements_InList;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"* Product Remark\")")
    public List<WebElement> productRemark_Elements;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/autocom_uom")
    public List<WebElement> productUom_Elements_InList;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"* Diameter\")")
    public WebElement product_Diameter_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"* Size\")")
    public WebElement product_Size_Element;

    // @AndroidFindBy(id = "")
    // public WebElement _Element;

    public CategoryPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOn_BackArrow() {
        clickElement(backArrow_Element);
    }

    public boolean selectCategoryByHorizontalScroll(String categoryName) {

        By categoryItem = By.id("com.prowess.apps.bandhan.world:id/tvCategory");
        By categoryContainer = By.id("com.prowess.apps.bandhan.world:id/rvCategory");

        int maxSwipes = 8;
        String lastFirstItem = "";

        for (int i = 0; i < maxSwipes; i++) {

            List<WebElement> categories = driver.findElements(categoryItem);

            if (!categories.isEmpty()) {
                String first = categories.get(0).getText();

                if (first.equalsIgnoreCase(lastFirstItem)) {
                    System.out.println("No more new categories loaded. Stopping swipe.");
                    break;
                }
                lastFirstItem = first;
            }

            for (WebElement category : categories) {
                try {
                    if (category.isDisplayed()
                            && category.getText().trim().equalsIgnoreCase(categoryName)) {

                        category.click();
                        return true;
                    }
                } catch (StaleElementReferenceException ignored) {
                }
            }

            // Swipe on the container (not whole screen)
            swipeLeftOnElement(categoryContainer);

            try {
                Thread.sleep(600);
            } catch (Exception e) {
            }
        }

        return false;
    }

    By brandContainer = By.id("com.prowess.apps.bandhan.world:id/rvBrand");

    public boolean selectBrandByHorizontalScroll(String brandName) {

        // By categoryItem = By.id("com.prowess.apps.bandhan.world:id/tvCategory");

        int maxSwipes = 8;
        String lastFirstItem = "";

        for (int i = 0; i < maxSwipes; i++) {
            List<WebElement> categories = brand_Elements;
            if (!categories.isEmpty()) {
                String first = categories.get(0).getText();
                System.out.println("categories = " + first);

                if (first.equalsIgnoreCase(lastFirstItem)) {
                    System.out.println("No more new categories loaded. Stopping swipe.");
                    break;
                }
                lastFirstItem = first;
            }

            for (WebElement category : categories) {
                try {
                    if (category.isDisplayed()
                            && category.getText().trim().equalsIgnoreCase(brandName)) {

                        category.click();
                        return true;
                    }
                } catch (StaleElementReferenceException ignored) {
                }
            }

            // Swipe on the container (not whole screen)
            swipeLeftOnElement(brandContainer);

            try {
                Thread.sleep(600);
            } catch (Exception e) {
            }
        }

        return false;
    }

    public boolean isBrandListPresent() {

        List<WebElement> elements = driver.findElements(
                By.id("com.prowess.apps.bandhan.world:id/rvBrand"));

        return elements.size() > 0;
    }

    public void enter_searchData_InSearchField(String productName) {
        sendText(productSearch_Field_Element, productName);
    }

    public void clear_InputSearchField() {
        productSearch_Field_Element.clear();
    }

    public boolean verify_Qty_WarningToastMsg(String expectedMessage) {

        int attempts = 5;

        for (int i = 0; i < attempts; i++) {
            if (driver.getPageSource().contains(expectedMessage)) {
                return true;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }

        return false;
    }

    public void enter_QtyInputField(int index, String qty) {
        enterTextByResourceId("com.prowess.apps.bandhan.world:id/tiet_qty", index, qty);
    }

    public void select_UOM(int i, String uom) {
        waitForListToLoad(uomField_Elements);
        WebElement uomField_Element = uomField_Elements.get(i);
        clickElement(uomField_Element);

    }

    public String getPointsFieldValue(int index) {
        waitForListToLoad(pointsvalue_Field_Elements);
        WebElement element = pointsvalue_Field_Elements.get(index);
        String fullText = element.getText().trim();

        String[] parts = fullText.split("/");

        return parts[0].trim();

    }

    public String getPointsFieldValue_FullText(int index) {
        waitForListToLoad(pointsvalue_Field_Elements);
        WebElement element = pointsvalue_Field_Elements.get(index);
        return element.getText().trim();

    }

    public String get_TotalPointsField_value(int i) {
        waitForListToLoad(totalPointsValue_Field_Elements);
        WebElement totalPointsValue_Field_Element = totalPointsValue_Field_Elements.get(i);

        return getText(totalPointsValue_Field_Element);
    }

    public String verify_TotalPointsField_value(int i, String qty) {

        String basePoints_String = getPointsFieldValue(i);

        int basePoints = Integer.parseInt(basePoints_String.trim());
        int quantity = Integer.parseInt(qty.trim());

        int totalPoints = basePoints * quantity;

        return String.valueOf(totalPoints);
    }

    public void clickOn_AddToCartBtn(int i) {

        clickProductByIndex("com.prowess.apps.bandhan.world:id/tvAdd", i);
    }

    public void clickOn_CartIcon() {
        clickElement(cartIcon_Element);
    }

    public void clickOn_RefreshBtn() {

        clickIfPresent(refreshIcon_Element, 1);
    }

    public boolean verify_CartIconAndRefreshIcon_isDisplayed() {
        return isElementVisible(cartIcon_Element) && isElementVisible(refreshIcon_Element);
    }

    
public String get_WarningToastMsg() {

    By snackbar = By.id("com.prowess.apps.bandhan.world:id/snackbar_text");

    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    shortWait.pollingEvery(Duration.ofMillis(200)); // FAST polling

    try {
        WebElement element = shortWait.until(
                ExpectedConditions.presenceOfElementLocated(snackbar)
        );

        return element.getText().trim();

    } catch (Exception e) {
        throw new RuntimeException("Snackbar not found / disappeared too fast");
    }
}

    public boolean verify_ProductsInList_isDisplayed() {
        return isElementVisible(productsInList_Element);
    }

    public String get_ProductCode_InList(int i) {
        waitForListToLoad(productCode_Elements_InList);
        WebElement productCode_Element_InList = productCode_Elements_InList.get(i);
        return getText(productCode_Element_InList);
    }

    public String get_ProductDescription_InList(int i) {
        waitForListToLoad(productDescription_Elements_InList);
        WebElement productDescription_Element_InList = productDescription_Elements_InList.get(i);
        return getText(productDescription_Element_InList);
    }

    ;

    public void enter_ProductRemark(int i, String remark) {
        waitForListToLoad(productRemark_Elements);
        WebElement productRemark_Element = productRemark_Elements.get(i);
        sendText(productRemark_Element, remark);
    }

    public String get_TonneUom_Text() {
        String fullText = getText(addedProduct_TonneUOMPonitsText_Element);
        String[] parts = fullText.split("\n");
        return parts[1].trim(); // returns 0.005

    }

    public String get_ProductUom_Text(int index) {
        waitForListToLoad(productUom_Elements_InList);
        WebElement productUom_Element_InList = productUom_Elements_InList.get(index);
        return getText(productUom_Element_InList);
    }

    public void addProductsToCart(String productsData) {

        if (productsData == null || productsData.trim().isEmpty()) {
            throw new RuntimeException("Products data is empty!");
        }

        String[] products = productsData.split(",");

        for (String productEntry : products) {

            String[] data = productEntry.trim().split(":");

            if (data.length != 2) {
                System.out.println("Invalid product format: " + productEntry);
                continue;
            }

            String productName = data[0].trim();
            String qty = data[1].trim();

            System.out.println("Processing Product: " + productName + " | Qty: " + qty);

            try {
                // Enter product name in Search Field
                enter_searchData_InSearchField(productName);
                try {
                      if (((HasOnScreenKeyboard) driver).isKeyboardShown()) {
           driver.hideKeyboard();  // 
        }
                   
                } catch (Exception e) {

                }
                Thread.sleep(1000); // Better to use explicit wait

                // Select Product from list
                List<WebElement> elements = driver.findElements(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().text(\"" + productName + "\")"));

                if (!elements.isEmpty()) {

                    elements.get(0).click();
                    System.out.println("Selected product: " + productName);

                    // Enter Quantity

                    qtyField_Element.sendKeys(qty);
                    try {
                         if (((HasOnScreenKeyboard) driver).isKeyboardShown()) {
           driver.hideKeyboard();  // 
                         }
                    } catch (Exception e) {

                    }

                    // Click Add to Cart
                    clickOn_AddToCartBtn(0);
                    System.out.println("Added to cart: " + productName);

                } else {
                    System.out.println("Product not found: " + productName);
                }

            } catch (Exception e) {
                System.out.println("Error while adding product: " + productName + " -> " + e.getMessage());
            }
        }
    }

    public void clickOn_Product_Diameter_field() {
        clickIfPresent(product_Diameter_Element, 1);
    }

    public void select_Product_DiameterDropValue() throws InterruptedException {
        clickOn_Product_Diameter_field();
        Thread.sleep(1000);  
        selectDropValues(180,1573);
        //selectDropValueByAndroidKey(1);

    }

    public void smallWait() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void clickOn_Product_Size_field() {
        clickIfPresent(product_Size_Element, 1);
    }

    public void select_Product_SizeDropValue() throws InterruptedException {
        clickOn_Product_Size_field();
        selectDropValueByAndroidKey(1);

    }

}
