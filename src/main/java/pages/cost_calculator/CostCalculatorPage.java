package pages.cost_calculator;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;
import java.time.Duration;
import org.openqa.selenium.interactions.Sequence;

public class CostCalculatorPage extends BasePage {

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/showProfile")
    public WebElement profileShow_Element;

     @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/profileLabel")
    public WebElement profileLabel_Element;

    // @AndroidFindBy(uiAutomator  = "new UiSelector().text(\"English\")")
    // public WebElement english_Language_Element;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"com.prowess.apps.bandhan.world:id/blinkItem\").instance(9)")
    public WebElement cost_calculator_menu;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/tvName")
    public WebElement name_Element;

    @AndroidFindBy(id  = "com.prowess.apps.bandhan.world:id/customerNameEditText")
    public WebElement customer_name_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/cityEditText")
    public WebElement city_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/contactNoEditText")
    public WebElement contact_no_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/areaEditText")
    public WebElement area_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnPlus")
    public List<WebElement> plus_btn_cost_calculator_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCount")
    public List<WebElement> count_cost_calculator_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnMinus")
    public List<WebElement> minus_btn_cost_calculator_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/next")
    public WebElement next_btn_Element;

    By next_btn_Locator = By.id("com.prowess.apps.bandhan.world:id/next");

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/title")
    public WebElement title_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnPlus")
    public List<WebElement> plus_btn_quantities_cost_calculator_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnMinus")
    public List<WebElement> minus_btn_quantities_cost_calculator_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/addMaterial")
    public WebElement addMaterial_btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/materialEditText")
    public WebElement materialEditText_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/costEditText")
    public WebElement costEditText_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/qtyEditText")
    public WebElement qtyEditText_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/uomAutoComplete")
    public WebElement uom_spinner_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/ivClose")
    public WebElement close_btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/costEditText")
    public List<WebElement> costEditText_material_estimates_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/qtyEditText")
    public List<WebElement> qtyEditText_material_estimated_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/ivDelete")
    public List<WebElement> delete_btn_material_estimated_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/ivAdd")
    public List<WebElement> add_btn_material_estimated_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvItemName")
    public List<WebElement> material_name_material_estimated_Element;

    @AndroidFindBy(uiAutomator  = "new UiSelector().text(\"Doors\")")
    public WebElement quantities_Door_Element;
   

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/customerNameValue")
    public WebElement summary_customerName_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvDreamGiftTitle")
    public List<WebElement> dream_gift_item_Element;

    @AndroidFindBy(uiAutomator  = "new UiSelector().text(\"Ferrari Car\")")
    public WebElement dreamgift_FerrariCar_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_alert_title")
    public WebElement submit_dream_gift_dialog_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_yes")
    public WebElement btn_yes_dialog_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/button_no")
    public WebElement btn_no_dialog_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_text")
    public WebElement success_msg_cost_calculation_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_success_title")
    public WebElement success_title_cost_calculation_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/dialog_universal_info_ok")
    public WebElement success_ok_cost_calculation_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/back")
    public WebElement back_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvCount")
    public List<WebElement> count_project_details_estimation_summary_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvItemName")
    public List<WebElement> name_project_details_estimation_summary_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvItemName")
    public List<WebElement> cost_project_details_estimation_summary_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalEstimatedPointsValue")
    public WebElement points_grand_total_estimation_summary_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalEstimatedCostValue")
    public WebElement cost_grand_total_estimation_summary_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvItemName")
    public List<WebElement> name_section_dream_gift_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPoints")
    public List<WebElement> points_section_dream_gift_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvItemName")
    public List<WebElement> name_section_material_dream_gift_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/tvPoints")
    public List<WebElement> points_section_material_dream_gift_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/btnOk")
    public WebElement ok_btn_Element;

    @AndroidFindBy(id = "com.prowess.apps.bandhan.world:id/totalPointsValue")
    public WebElement total_points_dream_gift_Element;

     @AndroidFindBy(uiAutomator  = "new UiSelector().className(\"android.view.ViewGroup\").instance(7)")
    public WebElement dreamGift_Element;

    public CostCalculatorPage(AndroidDriver driver) {
        super(driver);
    }


    public void enter_texts(String input, WebElement webElement) {
		sendText(webElement, input);
	}

    public Boolean clickOn_next(WebElement webElement) {
		try {
            Thread.sleep(1000);
			clickIfPresent(webElement, 2);
            return true;
		} catch (Exception e) {
            // System.out.println("Profile dialog not shown");
            return false;
		}
    }

     public void clickOn_NextBtn_try(WebElement webElement)
     {
            clickUntilElementVisible(next_btn_Locator, webElement);
     }
   

    public String get_ui_title(WebElement webElement){
        return getText(webElement);
    }

    public boolean checkIfTextIsNotNull(WebElement webElement) {
        if (getText(webElement).isBlank() || getText(webElement).isEmpty()) {
            return false;
        }
		return true;
	}

    public String get_PageTitle(WebElement element){
        return getText(element);
    }


    public String get_text_after_scroll(String resourceId) {
    try {
        // 1. Scroll using the ID string
        scrollToId(resourceId);
        
        // 2. Locate the element immediately after scrolling
        WebElement el = driver.findElement(By.id(resourceId));
        clickOn_next(el);
        return el.getText().trim();
    } catch (Exception e) {
        // 3. Fallback: Reset to top and try one more time
        scrollToTop();
        scrollToId(resourceId);
        return driver.findElement(By.id(resourceId)).getText().trim();
    }
}

    public String get_Warning_ToastMsg() {

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

    public boolean verify_first_material(String material_name){
        if (getText(material_name_material_estimated_Element.get(0)).equals(material_name)) {
            return true;
        }
        return false;
    }

    public boolean verify_material_quantity(String material_name, String qty) {
            try {
                if (!getText(qtyEditText_material_estimated_Element.get(0)).equals(qty)) {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Element not found after scrolling: " + e.getMessage());
            }
            return true;    
        }

    public boolean verify_material_water_tank(String material_name, String qty) {
            try {
                if (!getText(material_name_material_estimated_Element.get(0)).equals(material_name)) {
                    return false;
                }
                if (!getText(qtyEditText_material_estimated_Element.get(0)).equals(qty)) {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Element not found after scrolling: " + e.getMessage());
            }
            return true;    
        }

    public boolean verify_material_cables(String material_name, String qty) {
            try {
                if (!getText(material_name_material_estimated_Element.get(1)).equals(material_name)) {
                    return false;
                }
                if (!getText(qtyEditText_material_estimated_Element.get(1)).equals(qty)) {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Element not found after scrolling: " + e.getMessage());
            }
            return true;    
        }
    
    public boolean verify_materials_electrical_fittings(String material_name, String qty){
        try {
                if (!getText(material_name_material_estimated_Element.get(2)).equals(material_name)) {
                    return false;
                }
                if (!getText(qtyEditText_material_estimated_Element.get(2)).equals(qty)) {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Element not found after scrolling: " + e.getMessage());
            }
            return true; 
    }


    public boolean verifyQuantities(String door, String lock, String windows, String sanitaryware, String bathroom_fittings,String electrical_fittings) {
        if (!getText(count_cost_calculator_Element.get(0)).equals(door)) {
            return false;
        }
        if (!getText(count_cost_calculator_Element.get(1)).equals(lock)) {
            return false;
        }
        if (!getText(count_cost_calculator_Element.get(2)).equals(windows)) {
            return false;
        }
        if (!getText(count_cost_calculator_Element.get(3)).equals(sanitaryware)) {
            return false;
        }
        if (!getText(count_cost_calculator_Element.get(4)).equals(bathroom_fittings)) {
            return false;
        }
        if (!getText(count_cost_calculator_Element.get(5)).equals(electrical_fittings)) {
            return false;
        }
        return true;
    }

    public boolean verify_costing(String material_name, String cost, String qty){
        for(int i= 0; i < 5; i++) {
            if(getText(name_project_details_estimation_summary_Element.get(i)).equals(material_name)) {
                if(!getText(cost_project_details_estimation_summary_Element.get(i)).equals(cost)) {
                    return false;
                }
                if(!getText(count_project_details_estimation_summary_Element.get(i)).equals(qty)) {
                    return false;
                }   
                break;
            }
        }
        return true;
    }

    public boolean verify_costing_plumbing(String material_name, String cost, String qty, int position){
        if(getText(name_project_details_estimation_summary_Element.get(position)).equals(material_name)) {
            if(!getText(cost_project_details_estimation_summary_Element.get(position)).equals(cost)) {
                return false;
            }
            if(!getText(count_project_details_estimation_summary_Element.get(position)).equals(qty)) {
                return false;
            }   
        }
        return true;
    }

    public boolean verify_total(String cost, String qty){
        System.out.println("compare actaul total cost" + getText(cost_grand_total_estimation_summary_Element) + " " + cost );
        System.out.println("compare actaul total points" + getText(points_grand_total_estimation_summary_Element) + " " + qty );
        if(!getText(cost_grand_total_estimation_summary_Element).equals(cost)) {
            return false;
        }
        if(!getText(points_grand_total_estimation_summary_Element).equals(qty)) {
            return false;
        }   
        return true;
    }

    public boolean verify_costing_dream_gift_plumbing(String material_name, String cost, String qty, int position){
        if(getText(name_section_material_dream_gift_Element.get(position)).equals(material_name)) {
            if(!getText(points_section_material_dream_gift_Element.get(position)).equals(qty)) {
                return false;
            }   
        }
        return true;
    }

    public boolean verify_total_dream_gift(String cost, String qty){
        System.out.println("compare actaul total points" + getText(points_grand_total_estimation_summary_Element) + " " + qty );
        if(!getText(total_points_dream_gift_Element).equals(qty)) {
            return false;
        }
        return true;
    }


    public void incrementalSwipe() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.6); // Start slightly below middle
        int endY = (int) (size.getHeight() * 0.4);   // Move slightly up

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);
        
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        driver.perform(Collections.singletonList(scroll));
    }

    public boolean clickOn_dream_gift() {
		try {
			Thread.sleep(1000);
                       clickIfPresent(dreamGift_Element,0);
            return true;
		} catch (Exception e) {
             System.out.println("element not found.");
            return false;
		}
	}

    public boolean add_project_quantities() throws InterruptedException{
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();

         scrollDownSafe();
        Thread.sleep(500);
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        Thread.sleep(500);
        scrollDownSafe();
        Thread.sleep(500);
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        Thread.sleep(500);

        return true;
    }

    public boolean add_project_quantities_test_2() throws InterruptedException{
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(0).click();

        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(1).click();
        
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
       
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
         scrollDownSafe();
        Thread.sleep(500);
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(2).click();
       
        Thread.sleep(500);
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        driver.findElements(AppiumBy.id("com.prowess.apps.bandhan.world:id/btnPlus")).get(3).click();
        Thread.sleep(500);

        return true;
    }


    public boolean changeQtyOfEachMaterial(List<WebElement> element) throws InterruptedException{
        sendText(element.get(0), "5");
        sendText(element.get(1), "5");
        sendText(element.get(2), "5");
        scrollDownSafe();
        sendText(element.get(0), "5");
        sendText(element.get(1), "5");
        sendText(element.get(2), "5");
        scrollDownSafe();
        Thread.sleep(500);
        sendText(element.get(0), "5");
        sendText(element.get(1), "5");
        sendText(element.get(2), "5");
        Thread.sleep(500);
        scrollDownSafe();
        Thread.sleep(500);
        sendText(element.get(0), "5");
        sendText(element.get(1), "5");
        sendText(element.get(2), "5");
        Thread.sleep(500);
        scrollDownSafe();
        Thread.sleep(500);
        sendText(element.get(0), "5");
        sendText(element.get(1), "5");
        sendText(element.get(2), "5");
        Thread.sleep(500);
        scrollDownSafe();
        Thread.sleep(500);
        sendText(element.get(2), "5");
        Thread.sleep(500);

        return true;
    }
}
