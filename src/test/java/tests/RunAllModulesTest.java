
package tests;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.testng.ITestResult;
import org.testng.Reporter;
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
    //,retryAnalyzer = retry.RetryAnalyzer.class
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
        TestContext.put("FailureType", "NA");

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

                  String expectedText = data.get("EXPECTED_RESULT");

    if(expectedText == null || expectedText.trim().isEmpty()) {

        String expectedKey = data.get("EXPECTED_KEY");

        if(expectedKey != null && !expectedKey.trim().isEmpty()) {
            expectedText = GlobalStore.get(expectedKey);

            if(expectedText != null) {
                expectedText = expectedText.trim();
            }
        }
    }

                    String assertType = data.getOrDefault("ASSERT_TYPE", "EXACT").toUpperCase();

                    // Update TestContext with actual verification result
                    TestContext.put("Actual", actualText);
                    TestContext.put("Expected", expectedText);


                    switch (assertType) {
                         case "EXACT":
        if (actualText == null || !actualText.equals(expectedText)) {

            String error = "ACTUAL_FAILURE | EXACT validation failed | Step: " + currentStep +
                    " expected [" + expectedText + "] but found [" + actualText + "]";

            TestContext.put("FailureType", "ACTUAL_FAILURE");
            TestContext.put("Actual", actualText);

            softAssert.fail(error);
        }
        break;

                       

                            case "CONTAINS":
        if (actualText == null || !actualText.contains(expectedText)) {

            String error = "ACTUAL_FAILURE | CONTAINS validation failed | Expected: "
                    + expectedText + " | Actual: " + actualText;

            TestContext.put("FailureType", "ACTUAL_FAILURE");
            TestContext.put("Actual", actualText);

            softAssert.fail(error);
        }
        break;

                       case "EXACT_LIST":

    if (!(actual instanceof VerifyResult)) {
        String error = "ACTUAL_FAILURE | Expected VerifyResult but got: "
                + (actual == null ? "null" : actual.getClass().getName());

        TestContext.put("FailureType", "ACTUAL_FAILURE");
        softAssert.fail(error);
        break;
    }

    VerifyResult result = (VerifyResult) actual;
    String expected = result.getExpected();
    List<String> actualLists = result.getActualList();

    TestContext.put("Actual", String.valueOf(actualLists));

    if (actualLists == null || actualLists.isEmpty()) {
        TestContext.put("FailureType", "ACTUAL_FAILURE");
        softAssert.fail("ACTUAL_FAILURE | Actual list is empty/null");
        break;
    }

    for (String route : actualLists) {
        if (route == null || !route.trim().equals(expected.trim())) {

            String error = "ACTUAL_FAILURE | EXACT_LIST failed | expected ["
                    + expected + "] but found [" + route + "]";

            TestContext.put("FailureType", "ACTUAL_FAILURE");
            softAssert.fail(error);
        }
    }
    break;

                       case "CONTAINS_LIST":

    if (!(actual instanceof VerifyResult)) {
        String error = "ACTUAL_FAILURE | Expected VerifyResult but got: "
                + (actual == null ? "null" : actual.getClass().getName());

        TestContext.put("FailureType", "ACTUAL_FAILURE");
        softAssert.fail(error);
        break;
    }

    VerifyResult resultContain = (VerifyResult) actual;

    String expectedContain = resultContain.getExpected();
    List<String> actualListsContain = resultContain.getActualList();

    TestContext.put("Actual", String.valueOf(actualListsContain));

    if (expectedContain == null || actualListsContain == null || actualListsContain.isEmpty()) {

        String error = "ACTUAL_FAILURE | Expected or Actual list is null/empty. Expected: "
                + expectedContain + ", Actual: " + actualListsContain;

        TestContext.put("FailureType", "ACTUAL_FAILURE");
        softAssert.fail(error);
        break;
    }

    String expectedValue = expectedContain.trim().toLowerCase();

    boolean found = actualListsContain.stream()
            .filter(Objects::nonNull)
            .map(String::trim)
            .map(String::toLowerCase)
            .anyMatch(val -> val.contains(expectedValue));

    if (!found) {

        String error = "ACTUAL_FAILURE | Expected value '" + expectedContain
                + "' not found in actual list: " + actualListsContain;

        TestContext.put("FailureType", "ACTUAL_FAILURE");
        softAssert.fail(error);
    }
    break;

                        default:
                            softAssert.fail("Invalid ASSERT_TYPE: " + assertType);
                    }
                }

            } catch (Exception e) {

    String error = "APPIUM_FAILURE | Step failed | " + currentStep + " | Reason: " + e.getMessage();
    System.err.println(error);
    e.printStackTrace();

    TestContext.put("FailureType", "APPIUM_FAILURE");
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

    if (TestContext.get("FailureType").equals("NA")) {
        TestContext.put("FailureType", "ACTUAL_FAILURE");
    }

    if (TestContext.get("Actual").equals("NA")) {
        TestContext.put("Actual", "Assertion Failed: " + e.getMessage());
    }

    throw e;
} finally {

    //  THIS IS THE IMPORTANT BLOCK
    ITestResult result = Reporter.getCurrentTestResult();

    if (result != null) {
        result.setAttribute("FailureType", TestContext.get("FailureType"));
        result.setAttribute("Actual", TestContext.get("Actual"));
    }
}
}}
    

