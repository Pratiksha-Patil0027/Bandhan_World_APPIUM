
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

        System.out.println("======================================");
        System.out.println("MODULE       : " + module);
        System.out.println("TESTCASE_ID  : " + testcaseId);
        System.out.println("TEST_DESC    : " + testDesc);
        System.out.println("======================================");

         
        // ===== Store static values for Excel Listener =====
        TestContext.put("ModuleName", module);
        TestContext.put("TestID", testcaseId);
        TestContext.put("TestDesc", testDesc);
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

                    String assertType = data.getOrDefault("ASSERT_TYPE", "EXACT").toUpperCase();

                    // Update TestContext with actual verification result
                    TestContext.put("Actual", actualText);


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