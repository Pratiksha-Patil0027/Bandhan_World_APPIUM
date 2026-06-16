package executors.cost_calculator;

import java.util.Map;

import core.KeywordExecutor;
import io.appium.java_client.android.AndroidDriver;
import pages.cost_calculator.CostCalculatorPage;
import pages.dashboard.DashboardPage;
import pages.dreamgift.DreamGiftPage;
import pages.login.CompanyLoginPage;

public class CostCalculatorExecutor implements KeywordExecutor {

    private DashboardPage dashboardPage;
    private CompanyLoginPage companyLoginPage;
    private CostCalculatorPage costCalculatorPage;
     private DreamGiftPage dreamGiftPage;
    String materialName = "";

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
            dreamGiftPage = new DreamGiftPage(driver);
        }

        switch (step.toLowerCase()) {
            case "click_cost_calculator":
                dashboardPage.scrollAndClick("Cost Calculator");
                return true;

            case "fill_the_filelds_without_area":
                costCalculatorPage.enter_texts(data.get("Customer_name"), costCalculatorPage.customer_name_Element);
                costCalculatorPage.enter_texts(data.get("City"), costCalculatorPage.city_Element);
                costCalculatorPage.enter_texts(data.get("Contact_number"), costCalculatorPage.contact_no_Element);
                costCalculatorPage.enter_texts(data.get("Contact_number"), costCalculatorPage.contact_no_Element);
                return null;

            case "clickon_projectdetails_nextbtn":
                costCalculatorPage.clickOn_NextBtn_try(costCalculatorPage.quantities_Door_Element);
                return null;

            case "clickon_quantities_nextbtn":
                costCalculatorPage.clickOn_NextBtn_try(costCalculatorPage.addMaterial_btn_Element);
                return null;

            case "clickon_material_nextbtn":
                costCalculatorPage.clickOn_NextBtn_try(costCalculatorPage.summary_customerName_Element);
                return null;

            case "clickon_add_dreamgiftbtn":
                costCalculatorPage.clickOn_NextBtn_try(costCalculatorPage.dreamgift_FerrariCar_Element);
                return null;

            case "click_on_next":
                return costCalculatorPage.clickOn_next(costCalculatorPage.next_btn_Element);

            case "fill_the_filelds_with_area":
                costCalculatorPage.enter_texts(data.get("Builtup_area"), costCalculatorPage.area_Element);
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
                costCalculatorPage.enter_texts(data.get("Customer_name"), costCalculatorPage.customer_name_Element);
                costCalculatorPage.enter_texts(data.get("Quantity"), costCalculatorPage.city_Element);
                costCalculatorPage.enter_texts(data.get("Contact_number"), costCalculatorPage.contact_no_Element);
                costCalculatorPage.enter_texts(data.get("Builtup_area"), costCalculatorPage.area_Element);
                return true;

            case "fill_project_quantities":
                int floor = Integer.parseInt(data.get("Floor"));
                for (int i = 0; i < floor; i++) {
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(0));
                }

                int bedroom = Integer.parseInt(data.get("Bedroom"));
                for (int i = 0; i < bedroom; i++) {
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(1));
                }

                int bathroom = Integer.parseInt(data.get("Bathroom"));
                for (int i = 0; i < bathroom; i++) {
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(2));
                }
                // Scroll
                costCalculatorPage.scrollDownSafe();
                Thread.sleep(500);
                int hall = Integer.parseInt(data.get("Hall"));
                for (int i = 0; i < hall; i++) {
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(1));
                }
                Thread.sleep(500);
                costCalculatorPage.scrollDownSafe();
                int kitchen = Integer.parseInt(data.get("Kitchen"));
                for (int i = 0; i < kitchen; i++) {
                    costCalculatorPage.clickOn_next(costCalculatorPage.plus_btn_cost_calculator_Element.get(2));
                }
                Thread.sleep(500);
                costCalculatorPage.scrollDownSafe();
                int balcony = Integer.parseInt(data.get("Balcony"));
                for (int i = 0; i < balcony; i++) {
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
                return null;

            case "navigatebacktodashboardpage":
                dashboardPage.navigateBackToHomeDashboard();
                return null;

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

                case "verify_area":
                return costCalculatorPage.getText(costCalculatorPage.area_Element);

            case "click_back":
                return costCalculatorPage.clickOn_next(costCalculatorPage.back_Element);

            case "click_on_delete":
                materialName = costCalculatorPage
                        .getText(costCalculatorPage.material_name_material_estimated_Element.get(0));
                return costCalculatorPage.clickOn_next(costCalculatorPage.delete_btn_material_estimated_Element.get(0));

                case "click_on_deleteicon_indexbased":
                materialName = costCalculatorPage
                        .getText(costCalculatorPage.material_name_material_estimated_Element.get(1));
                return costCalculatorPage.clickOn_next(costCalculatorPage.delete_btn_material_estimated_Element.get(1));

            case "click_on_add":
                costCalculatorPage.clickOn_next(costCalculatorPage.add_btn_material_estimated_Element.get(0));
                if (materialName.equals(costCalculatorPage
                        .getText(costCalculatorPage.material_name_material_estimated_Element.get(0)))) {
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
                costCalculatorPage.verify_material_quantity(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_water_tank":
                costCalculatorPage.verify_material_water_tank(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_cables":
                costCalculatorPage.verify_material_cables(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_electrical_fittings":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_tmt":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_cement":
                costCalculatorPage.verify_material_cables(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_construction_chemicals":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_interior_paint":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_exterior_paint":
                costCalculatorPage.verify_material_cables(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_primer":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_putty":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_doors":
                costCalculatorPage.verify_material_cables(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_locks":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_windows":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_plywoods":
                costCalculatorPage.verify_material_cables(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_laminates":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_pipes":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_material_water_tank(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_tiles":
                costCalculatorPage.verify_material_cables(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_sanitary_ware":
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_materials_bathroom_fittings":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.verify_materials_electrical_fittings(data.get("Material name"), data.get("Qty"));
                return true;

            case "verify_quantities":
                return costCalculatorPage.verifyQuantities(data.get("Door"), data.get("Lock"), data.get("Windows"),
                        data.get("Sanitaryware"), data.get("Bathroom Fittings"), data.get("Electrical Fittings"));

            case "verify_costing":
                return costCalculatorPage.verify_costing(data.get("Material name"), data.get("Cost"), data.get("Qty"));

            case "verify_costing_plumbing":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.scrollDownSafe();
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"),
                        data.get("Qty"), 0);

            case "verify_costing_civil_work":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"),
                        data.get("Qty"), 1);

            case "verify_costing_paint_work":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"),
                        data.get("Qty"), 2);

            case "verify_costing_carpentary":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"),
                        data.get("Qty"), 3);

            case "verify_costing_electrical":
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"),
                        data.get("Qty"), 4);

            case "verify_total":
                return costCalculatorPage.verify_total(data.get("Cost"), data.get("Qty"));

            case "verify_costing_dream_gift_plumbing":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.scrollDownSafe();
                return costCalculatorPage.verify_costing_plumbing(data.get("Material name"), data.get("Cost"),
                        data.get("Qty"), 0);

            case "verify_costing_dream_gift_civil_work":
                costCalculatorPage.scrollDownSafe();
                costCalculatorPage.scrollDownSafe();
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"),
                        data.get("Cost"), data.get("Qty"), 1);

            case "verify_costing_dream_gift_paint_work":
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"),
                        data.get("Cost"), data.get("Qty"), 2);

            case "verify_costing_dream_gift_carpentary":
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"),
                        data.get("Cost"), data.get("Qty"), 3);

            case "verify_costing_dream_gift_electrical":
                return costCalculatorPage.verify_costing_dream_gift_plumbing(data.get("Material name"),
                        data.get("Cost"), data.get("Qty"), 4);

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

            case "verify_addmaterial_headertext":
                return costCalculatorPage.get_AddMaterial_HeaderText();

                 case "verify_warningtoastmsg":
                return costCalculatorPage.get_WarningToastMsg();

            case "wait_untiletoastmsg_disapears":
                costCalculatorPage.waitForToastToDisappear();
                return null;

                case "verify_quantitiespage_quantities":
                return costCalculatorPage.get_Quantities();

                case "clickon_backbutton":
                 costCalculatorPage.clickOn_BackButton();
                 return null;

                 case "verify_addbtn_text":
                return costCalculatorPage.get_AddBtn_Text();

                case "clickon_addbutton":
                 costCalculatorPage.clickOn_AddButton();
                 return null;

                 case "clickon_addmaterial_closebtn":
                 costCalculatorPage.clickOn_Addmaterial_closebtn();
                 return null;
                
                  case "verify_summary_customername_text":
                return costCalculatorPage.get_Summary_CustomerName();

                 case "verify_summary_customermobileno_text":
                return costCalculatorPage.get_Summary_CustomerMobileNo();

                 case "verify_summary_customercity_text":
                return costCalculatorPage.get_Summary_CustomerCity();

                case "verify_summary_projectdetails":
                return costCalculatorPage.get_Summary_ProjectDetails();
         
                 case "scrolldown":
                dashboardPage.scrollDownSmall();
                return null;

                 case "scrolltop":
                dashboardPage.scrollToTop();
                return null;

                 

                 case "verify_summary_costestimation_cost":
                return costCalculatorPage.get_Summary_CostEstimation_Cost();

                 case "verify_summary_costestimation_points":
                return costCalculatorPage.get_Summary_CostEstimation_Points();

                 case "verify_summary_grandtotal_points":
                return costCalculatorPage.get_Summary_GrandTotal_Points();

                case "verify_summary_grandtotal_cost":
                return costCalculatorPage.get_Summary_GrandTotal_Cost();

                case "dreamgift_get_dreamgiftname":
                return costCalculatorPage.get_DreamGift_Name_Text();

                 case "verify_selecteddreamgift_name":
                return costCalculatorPage.get_SelectedDreamGift_Name();

                case "verify_dreamgift_totalrequiredpoints":
                return costCalculatorPage.get_DreamGift_TotalPointsRequired();

                 case "verify_dreamgift_availablepoints":
                return costCalculatorPage.get_DreamGift_AvailablePoints();

                 case "verify_dreamgift_remainingpoints":
                return costCalculatorPage.get_DreamGift_RemainingPoints();

                 case "verify_dreamgift_approxsite":
                return costCalculatorPage.get_DreamGift_ApproxSite();

                 case "verify_dreamgift_summarypoints_msg":
                return costCalculatorPage.get_DreamGift_MsgPointsSummary();

                 case "verify_dreamgift_summarypoints":
                return costCalculatorPage.get_DreamGift_SummaryPoints();

                case "verify_dreamgift_grandtotal":
                return costCalculatorPage.get_DreamGift_GrandTotal();

                case "verify_submitdialog_title":
                return costCalculatorPage.get_DreamGift_SubmitDialog_Title();

                 case "clickon_submitdialog_yesbtn":
                costCalculatorPage.clickOn_DreamGift_SubmitDialog_YesBtn();
                return null;

                 case "clickon_submitdialog_nobtn":
                costCalculatorPage.clickOn_DreamGift_SubmitDialog_NoBtn();
                return null;

                case "verify_successdialog_textmsg":
                return costCalculatorPage.get_DreamGift_SuccessDialog_Text();

                case "verify_successdialog_title":
                return costCalculatorPage.get_DreamGift_SuccessDialog_Title();
      
                case "clickon_successdialog_okbtn":
                costCalculatorPage.clickOn_DreamGift_SuccessDialog_okBtn();
                return null;

                case "open_dreamgift_menu":
                dashboardPage.clickOn_DreamGift_Menu();
                return null;

                case "verify_giftcodeinlist":
               return dreamGiftPage.get_GiftCode();

               case "clickon_alertdialog_yesbtn":
                dreamGiftPage.clickOn_AlertDialog_YesBtn();
                return null;

               case "clickon_deleteicon":
                dreamGiftPage.clickOn_DeleteIcon();
                return null;

                case "clickon_deleteicon_indexbased":
                dreamGiftPage.clickOn_DeleteIcon();
                return null;

                 case "quantitiespage_update_quantity":
                costCalculatorPage.update_quantities();
                return null;

                  case "verify_updated_quantities":
                return costCalculatorPage.verify_update_Quantities(data.get("Material name"),data.get("Qty"));

                 case "enter_cost":
                costCalculatorPage.enter_cost(data.get("Cost"));
                return null;

                case "enter_qty":
                costCalculatorPage.enter_qty(data.get("Qty"));
                return null;

                 case "verify_costtext":
                return costCalculatorPage.get_CostText();

                 case "verify_qtytext":
                return costCalculatorPage.get_QtyText();

                 case "verify_totalcosttext":
                return costCalculatorPage.get_TotalCostText();

                
                
                


            default:
                throw new RuntimeException("Invalid ACTION: " + step);
        }
    }
}
