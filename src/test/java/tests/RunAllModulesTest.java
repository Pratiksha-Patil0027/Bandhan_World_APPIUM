
package tests;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClassTest;
import core.FlowExecutor;
import core.GlobalStore;
import core.ModuleDispatcher;
import core.VerifyResult;
import utils.TestContext;
import utils.Utils;

public class RunAllModulesTest extends BaseClassTest {

    @Test(dataProvider = "masterData", dataProviderClass = dataprovider.MasterDataProvider.class
    // retryAnalyzer = retry.RetryAnalyzer.class
    )
    public void runTests(Map<String, String> data) {

        SoftAssert softAssert = new SoftAssert();

        // ===== Read Excel Data =====
        String module = data.get("MODULE_NAME");
        String testcaseId = data.get("TESTCASE_ID");
        String testDesc = data.get("TEST_DESC");
        String influencerAccount = data.getOrDefault("INFLUENCER_ACCOUNT", "");
         String allSteps = data.get("ACTIONS");

         if (allSteps != null) {
    allSteps = allSteps.replace("\r\n", "\n"); // normalize newlines
}

        System.out.println("======================================");
        System.out.println("MODULE       : " + module);
        System.out.println("TESTCASE_ID  : " + testcaseId);
        System.out.println("TEST_DESC    : " + testDesc);
        System.out.println("======================================");

         
        // ===== Store static values for Excel Listener =====
        TestContext.put("ModuleName", module);
        TestContext.put("TestID", testcaseId);
        TestContext.put("TestDesc", testDesc);
        TestContext.put("Steps", allSteps);
        TestContext.put("InfluencerAcccount", influencerAccount);
        TestContext.put("Expected", data.getOrDefault("EXPECTED_RESULT", "NA"));
        TestContext.put("Actual", "NA"); // default

        String actions = data.get("ACTIONS");
        if (actions == null || actions.trim().isEmpty()) {
            softAssert.fail("ACTIONS column is empty in Excel");
            softAssert.assertAll();
            return;
        }

        // String[] steps = actions.split(",");
        String[] steps = actions.split("\\r?\\n");

        for (String step : steps) {

            // String currentStep = step.trim();
            String currentStep = step.trim().replaceFirst("^\\d+\\.\\s*", "");
            System.out.println("STEP -> " + currentStep);

            try {
                Object actual = FlowExecutor.executeStep(
                        currentStep,
                        data,
                        ModuleDispatcher.getExecutor(module),
                        driver);

                // ===== VERIFY STEPS =====
                if (currentStep.toLowerCase().startsWith("verify")) {
                    String actualText = actual != null ? actual.toString().trim() : "null";
                    String expectedText = data.get("EXPECTED_RESULT") != null
                            ? data.get("EXPECTED_RESULT").trim()
                            : "null";

                            if (expectedText.contains("{")) {
    expectedText = Utils.resolvePlaceholders(expectedText);
}
                    String assertType = data.getOrDefault("ASSERT_TYPE", "EXACT").toUpperCase();

                    // Update TestContext with actual verification result
                    TestContext.put("Actual", actualText);
                    TestContext.put("Expected", expectedText);


                

    


                    if(testcaseId.toLowerCase().equalsIgnoreCase("MyClaimsPageTest_10")) {
                        TestContext.put("Expected", GlobalStore.get("MYCLIAMS_CLAIMID"));
                        expectedText =GlobalStore.get("MYCLIAMS_CLAIMID").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("MyClaimsPageTest_11")) {
                        TestContext.put("Expected", GlobalStore.get("MYCLIAMS_DEALERNAME"));
                        expectedText =GlobalStore.get("MYCLIAMS_DEALERNAME").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("MyClaimsPageTest_12")) {
                        TestContext.put("Expected", GlobalStore.get("MYCLIAMS_PRODUCTDESC"));
                        expectedText =GlobalStore.get("MYCLIAMS_PRODUCTDESC").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("MyClaimsPageTest_13")) {
                        TestContext.put("Expected", GlobalStore.get("MYCLIAMS_INVNO"));
                        expectedText =GlobalStore.get("MYCLIAMS_INVNO").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("MyClaimsPageTest_14")) {
                        TestContext.put("Expected", GlobalStore.get("MYCLIAMS_CLAIMQTY"));
                        expectedText =GlobalStore.get("MYCLIAMS_CLAIMQTY").trim();
                    }

                     if(testcaseId.toLowerCase().equalsIgnoreCase("MyClaimsPageTest_15")) {
                        TestContext.put("Expected", GlobalStore.get("MYCLIAMS_CLAIMPOINTS"));
                        expectedText =GlobalStore.get("MYCLIAMS_CLAIMPOINTS").trim();
                    }

                     if(testcaseId.toLowerCase().equalsIgnoreCase("DealerPageTest_04")) {
                        TestContext.put("Expected", GlobalStore.get("DEALERLIST_DEALERNAME"));
                        expectedText =GlobalStore.get("DEALERLIST_DEALERNAME").trim();
                    }

                     if(testcaseId.toLowerCase().equalsIgnoreCase("CategoryPageTest_10")) {
                        TestContext.put("Expected", GlobalStore.get("PRODUCT_EXPECTED_TOTAL_POINTS"));
                        expectedText =GlobalStore.get("PRODUCT_EXPECTED_TOTAL_POINTS").trim();
                    }

                     if(testcaseId.toLowerCase().equalsIgnoreCase("CategoryPageTest_14")) {
                        TestContext.put("Expected", GlobalStore.get("CATEGORY_PRODUCTCODE"));
                        expectedText =GlobalStore.get("CATEGORY_PRODUCTCODE").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("CategoryPageTest_15")) {
                        TestContext.put("Expected", GlobalStore.get("CATEGORY_PRODUCTDESC"));
                        expectedText =GlobalStore.get("CATEGORY_PRODUCTDESC").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("CategoryPageTest_16")) {
                        TestContext.put("Expected", GlobalStore.get("CATEGORY_PRODUCTUOM"));
                        expectedText =GlobalStore.get("CATEGORY_PRODUCTUOM").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("CategoryPageTest_17")) {
                        TestContext.put("Expected", GlobalStore.get("PRODUCT_TOTAL_POINTS"));
                        expectedText =GlobalStore.get("PRODUCT_TOTAL_POINTS").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("CategoryPageTest_18")) {
                        TestContext.put("Expected", GlobalStore.get("PRODUCT_QTY"));
                        expectedText =GlobalStore.get("PRODUCT_QTY").trim();
                    }

                     if(testcaseId.toLowerCase().equalsIgnoreCase("CategoryPageTest_19")) {
                        TestContext.put("Expected", GlobalStore.get("CARDDETAILS_ADDITIONTOTALPOINTS"));
                        expectedText =GlobalStore.get("CARDDETAILS_ADDITIONTOTALPOINTS").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_03")) {
                        TestContext.put("Expected", GlobalStore.get("SELECTED_DEALERNAMESPLIT"));
                        expectedText =GlobalStore.get("SELECTED_DEALERNAMESPLIT").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_04")) {
                        TestContext.put("Expected", GlobalStore.get("INVOICE_NO"));
                        expectedText =GlobalStore.get("INVOICE_NO").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_05")) {
                        TestContext.put("Expected", GlobalStore.get("INVOICE_DATE"));
                        expectedText =GlobalStore.get("INVOICE_DATE").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_06")) {
                        TestContext.put("Expected", GlobalStore.get("CARD_TOTAL_CLAIMPOINTS"));
                        expectedText =GlobalStore.get("CARD_TOTAL_CLAIMPOINTS").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_08")) {
                        TestContext.put("Expected", GlobalStore.get("CATEGORY_PRODUCTCODE"));
                        expectedText =GlobalStore.get("CATEGORY_PRODUCTCODE").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_09")) {
                        TestContext.put("Expected", GlobalStore.get("CATEGORY_PRODUCTDESC"));
                        expectedText =GlobalStore.get("CATEGORY_PRODUCTDESC").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_10")) {
                        TestContext.put("Expected", GlobalStore.get("PRODUCT_QTY"));
                        expectedText =GlobalStore.get("PRODUCT_QTY").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_11")) {
                        TestContext.put("Expected", GlobalStore.get("CATEGORY_PRODUCTUOM"));
                        expectedText =GlobalStore.get("CATEGORY_PRODUCTUOM").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_12")) {
                        TestContext.put("Expected", GlobalStore.get("CARDDETAILS_POINTS"));
                        expectedText =GlobalStore.get("CARDDETAILS_POINTS").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_13")) {
                        TestContext.put("Expected", GlobalStore.get("CARDDETAILS_TOTALPOINTS"));
                        expectedText =GlobalStore.get("CARDDETAILS_TOTALPOINTS").trim();
                    }

                    

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_17")) {
                        TestContext.put("Expected", GlobalStore.get("INVOICE_DATE"));
                        expectedText =GlobalStore.get("INVOICE_DATE").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_18")) {
                        TestContext.put("Expected", GlobalStore.get("SELECTED_DEALERNAME"));
                        expectedText =GlobalStore.get("SELECTED_DEALERNAME").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_19")) {
                        TestContext.put("Expected", GlobalStore.get("INVOICE_NO"));
                        expectedText =GlobalStore.get("INVOICE_NO").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_20")) {
                        TestContext.put("Expected", GlobalStore.get("GENERATED_CLAIMQTY"));
                        expectedText =GlobalStore.get("GENERATED_CLAIMQTY").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_21")) {
                        TestContext.put("Expected", GlobalStore.get("CATEGORY_PRODUCTDESC"));
                        expectedText =GlobalStore.get("CATEGORY_PRODUCTDESC").trim();
                    }

                    if(testcaseId.toLowerCase().equalsIgnoreCase("AddClaimTest_22")) {
                        TestContext.put("Expected", GlobalStore.get("CARDDETAILS_TOTALPOINTS"));
                        expectedText =GlobalStore.get("CARDDETAILS_TOTALPOINTS").trim();
                    }



                    switch (assertType) {
                        case "EXACT":
                            softAssert.assertEquals(actualText, expectedText,
                                    "EXACT validation failed | Step: " + currentStep);
                            break;

                        case "CONTAINS":
                            softAssert.assertTrue(actualText.contains(expectedText),
                                    "CONTAINS validation failed | Expected: " + expectedText
                                            + " | Actual: " + actualText);
                            break;

                        case "EXACT_LIST":
                            if (!(actual instanceof VerifyResult)) {
                                softAssert.fail("Expected VerifyResult but got: "
                                        + actual.getClass().getName());
                                break;
                            }

                            VerifyResult result = (VerifyResult) actual;
                            String expected = result.getExpected();
                            System.out.println("expected list: " + expected);
                            List<String> actualLists = result.getActualList();
                            System.out.println("actual list: " + actualLists);

                            TestContext.put("Actual", actualLists.toString());

                            for (String route : actualLists) {
                                softAssert.assertEquals(
                                        route.trim(),
                                        expected.trim()

                                );
                            }
                            break;

                        case "CONTAINS_LIST":
                            if (!(actual instanceof VerifyResult)) {
                                softAssert.fail(
                                        "Expected VerifyResult but got: " +
                                                (actual == null ? "null" : actual.getClass().getName()));
                                break;
                            }

                            VerifyResult resultContain = (VerifyResult) actual;

                            String expectedContain = resultContain.getExpected();
                            List<String> actualListsContain = resultContain.getActualList();

                            // Safety checks
                            if (expectedContain == null || actualListsContain == null || actualListsContain.isEmpty()) {
                                softAssert.fail(
                                        "Expected or Actual list is null/empty. Expected: "
                                                + expectedContain + ", Actual: " + actualListsContain);
                                break;
                            }

                            String expectedValue = expectedContain.trim().toLowerCase();

                            boolean found = actualListsContain.stream()
                                    .filter(Objects::nonNull)
                                    .map(String::trim)
                                    .map(String::toLowerCase)
                                    .anyMatch(val -> val.contains(expectedValue));

                            // Store actual for report
                            TestContext.put("Actual", actualListsContain.toString());

                            softAssert.assertTrue(
                                    found,
                                    "Expected value '" + expectedContain
                                            + "' not found in actual list: " + actualListsContain);
                            break;

                        default:
                            softAssert.fail("Invalid ASSERT_TYPE: " + assertType);
                    }
                }

            } catch (Exception e) {
                String error = "Step failed | " + currentStep + " | Reason: " + e.getMessage();
                System.err.println(error);
                e.printStackTrace();

                // Update Actual with error message
                TestContext.put("Actual", "ERROR : " + e.getMessage());
                softAssert.fail(error);
            }
        }

        // ===== FINAL ASSERT =====
        try {
            softAssert.assertAll();
            System.out.println("TEST PASSED : " + testcaseId);
        } catch (AssertionError e) {
            System.err.println("TEST FAILED : " + testcaseId);
            // Update TestContext with final actual result if not already set
            if (TestContext.get("Actual").equals("NA")) {
                TestContext.put("Actual", "Assertion Failed: " + e.getMessage());
            }
            throw e;
        }
    }

    }