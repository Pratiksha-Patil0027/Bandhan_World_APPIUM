package executors.cost_calculator;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.KeywordExecutor;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pages.cost_calculator.CostCalculatorPage;
import pages.dashboard.DashboardPage;
import pages.login.CompanyLoginPage;

public class CostCalculatorExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
    private CostCalculatorPage costCalculatorPage;
    String materialName= "";
    
    
    @Override
    public Object execute(
            String step,
            Map<String, String> data,
            AndroidDriver driver) throws InterruptedException {

        if (driver == null) {
            throw new IllegalStateException(
                    "AndroidDriver is NULL. Appium session not initialized.");
        }

        if (dashboardPage == null) {

            companyLoginPage = new CompanyLoginPage(driver);
            dashboardPage = new DashboardPage(driver);
            costCalculatorPage = new CostCalculatorPage(driver);
        }

        switch (step.toLowerCase()) {
            case "click_cost_calculator":
                dashboardPage.scrollAndClick("Cost Calculator");
                return true;

            case "fill_the_filelds_without_area":
                costCalculatorPage.enter_texts(data.get("Customer_name"),costCalculatorPage.customer_name_Element);
                costCalculatorPage.enter_texts(data.get("Quantity"),costCalculatorPage.city_Element);
                costCalculatorPage.enter_texts(data.get("Contact_number"),costCalculatorPage.contact_no_Element);
                return null;

            case "click_on_next":
                return costCalculatorPage.clickOn_next(costCalculatorPage.next_btn_Element);
                

            case "fill_the_filelds_with_area":
                costCalculatorPage.enter_texts(data.get("Builtup_area"),costCalculatorPage.area_Element);
                return null;

            case "add_project_quantities":
                return costCalculatorPage.add_project_quantities();

            case "add_material_click":
                return costCalculatorPage.clickOn_next(costCalculatorPage.addMaterial_btn_Element);

            case "fill_details_to_add_material":
                costCalculatorPage.enter_texts(data.get("Material name"), costCalculatorPage.materialEditText_Element);
                costCalculatorPage.enter_texts(data.get("Cost"), costCalculatorPage.costEditText_Element);
                costCalculatorPage.enter_texts(data.get("Qty"), costCalculatorPage.qtyEditText_Element);
                return true;

            case "fill_details_to_add_project_details_all":
                costCalculatorPage.enter_texts(data.get("Customer_name"),costCalculatorPage.customer_name_Element);
                costCalculatorPage.enter_texts(data.get("Quantity"),costCalculatorPage.city_Element);
                costCalculatorPage.enter_texts(data.get("Contact_number"),costCalculatorPage.contact_no_Element);
                costCalculatorPage.enter_texts(data.get("Builtup_area"), costCalculatorPage.area_Element);
                return true;

            case "fill_project_quantities":
                int floor = Integer.parseInt(data.get("Floor"));
                for(int i = 0; i < floor; i++){
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(0));
                }

                int bedroom = Integer.parseInt(data.get("Bedroom"));
                for(int i = 0; i < bedroom; i++){
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(1));
                }

                int bathroom = Integer.parseInt(data.get("Bathroom"));
                for(int i = 0; i < bathroom; i++){
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(2));
                }
                // Scroll
                costCalculatorPage.scrollDownSafe();
                Thread.sleep(500);
                int hall = Integer.parseInt(data.get("Hall"));
                for(int i = 0; i < hall; i++){
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(1));
                }
                Thread.sleep(500);
                costCalculatorPage.scrollDownSafe();
                int kitchen = Integer.parseInt(data.get("Kitchen"));
                for(int i = 0; i < kitchen; i++){
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(2));
                }
                Thread.sleep(500);
                costCalculatorPage.scrollDownSafe();
                int balcony = Integer.parseInt(data.get("Balcony"));
                for(int i = 0; i < balcony; i++){
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(1));
                }
                return true;

            case "verify_ui_title":
                return costCalculatorPage.get_PageTitle(costCalculatorPage.title_Element);

            case "click_on_dream_gift":
                costCalculatorPage.clickOn_dream_gift();
                return null;

            case "check_success_msg":
                return costCalculatorPage.checkIfTextIsNotNull(costCalculatorPage.success_msg_cost_calculation_Element);

            case "click_on_success_ok":
                return costCalculatorPage.clickOn_next(costCalculatorPage.success_ok_cost_calculation_Element);

            case "hidekeyboard":  
                companyLoginPage.hideKeyboardIfVisible();
                return null ;
                
            case "navigatebacktodashboardpage": 
                dashboardPage.navigateBackToHomeDashboard();
                return  null;

            case "clickonskipbtnofinsurancewindow":
                dashboardPage.clickOn_SkipBtnOf_FamilyInsuranceWindow();
                return null;

            case "openredemptionsmenu":
                dashboardPage.clickOn_Redemptions_Menu();
                return null;

            case "check_warning_toast_msg":
                return costCalculatorPage.get_Warning_ToastMsg();

            case "check_area":
                return costCalculatorPage.getText(costCalculatorPage.area_Element);

            case "click_back":
                return costCalculatorPage.clickOn_next(costCalculatorPage.back_Element);

            case "click_on_delete":
                materialName = costCalculatorPage.getText(costCalculatorPage.material_name_material_estimated_Element.get(0));
                return costCalculatorPage.clickOn_next(costCalculatorPage.delete_btn_material_estimated_Element.get(0));

            case "click_on_add":
                costCalculatorPage.clickOn_next(costCalculatorPage.add_btn_material_estimated_Element.get(0));
                if (materialName.equals(costCalculatorPage.getText(costCalculatorPage.material_name_material_estimated_Element.get(0)))) {
                    return true;
                } else {
                    return false;
                }

            case "click_exit_ok":
                return costCalculatorPage.clickOn_next(costCalculatorPage.btn_yes_dialog_Element);

            case "verify_first_material":
                costCalculatorPage.verify_first_material(data.get("Material name"));
                return true;

            case "verify_materials":
                costCalculatorPage.verify_material_quantity(data.get("Material name"),data.get("Qty"));
                return true;
            
            case "verify_materials_water_tank":
                costCalculatorPage.verify_material_water_tank(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_cables":
                costCalculatorPage.verify_material_cables(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_electrical_fittings":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_tmt":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_cement":
                costCalculatorPage.verify_material_cables(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_construction_chemicals":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_interior_paint":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_exterior_paint":
                costCalculatorPage.verify_material_cables(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_primer":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"),data.get("Qty"));
                return true;
            
            case "verify_materials_putty":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_doors":
                costCalculatorPage.verify_material_cables(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_locks":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_windows":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_plywoods":
                costCalculatorPage.verify_material_cables(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_laminates":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"),data.get("Qty"));
                return true;                
            
            case "verify_materials_pipes":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_tiles":
                costCalculatorPage.verify_material_cables(data.get("Material name"),data.get("Qty"));
                return true;

            case "verify_materials_sanitary_ware":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"),data.get("Qty"));
                return true;                
            
            case "verify_materials_bathroom_fittings":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"),data.get("Qty"));
                return true;                
            

            case "verify_quantities":
                return costCalculatorPage.verifyQuantities(data.get("Door"),data.get("Lock"),data.get("Windows"),data.get("Sanitaryware"),data.get("Bathroom Fittings"),data.get("Electrical Fittings"));

            case "verify_costing":
                return costCalculatorPage.verify_costing(data.get("Material name"), data.get("Cost"), data.get("Qty"));
            
            case "verify_costing_plumbing":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.scrollDownSafe();
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),0);
            
            case "verify_costing_civil_work":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),1);    

            case "verify_costing_paint_work":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),2);
            
            case "verify_costing_carpentary":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),3);    

            case "verify_costing_electrical":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),4);    
            
            case "verify_total":
                return costCalculatorPage.verify_total(data.get("Cost"), data.get("Qty"));


            case "verify_costing_dream_gift_plumbing":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.scrollDownSafe();
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),0);
            
            case "verify_costing_dream_gift_civil_work":
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),1);    

            case "verify_costing_dream_gift_paint_work":
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),2);
            
            case "verify_costing_dream_gift_carpentary":
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),3);    

            case "verify_costing_dream_gift_electrical":
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"), data.get("Cost"), data.get("Qty"),4);    
            
            case "verify_total_dream_gift":
                return costCalculatorPage.verify_total_dream_gift(data.get("Cost"), data.get("Qty"));    
            

            case "change_qty_of_each_material":
                costCalculatorPage.changeQtyOfEachMaterial(costCalculatorPage.qtyEditText_material_estimated_Element);
                return null;

            case "click_ok":
                costCalculatorPage.clickOn_next(costCalculatorPage.ok_btn_Element);
                return null;

            case "add_project_quantities_test_2":
                return costCalculatorPage.add_project_quantities_test_2();


            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }
}
