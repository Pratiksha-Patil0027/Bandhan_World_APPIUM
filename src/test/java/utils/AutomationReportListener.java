package utils;

import org.testng.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;

public class AutomationReportListener implements ISuiteListener {

    private static boolean mailSent = false;
    protected ConfigReader configReader;
    private static long startTime;

    @Override
    public void onStart(ISuite suite) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public synchronized void onFinish(ISuite suite) {
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        String executionTime = formatDuration(totalTime);
        configReader = new ConfigReader();

        if (mailSent)
            return;
        mailSent = true;

        int passed = 0, failed = 0, skipped = 0;
        int appiumFail = 0, actualFail = 0;

        for (ISuiteResult result : suite.getResults().values()) {
            ITestContext ctx = result.getTestContext();
            passed += ctx.getPassedTests().size();
            failed += ctx.getFailedTests().size();
            skipped += ctx.getSkippedTests().size();

            // NEW: Categorize failures
            for (ITestResult failedTest : ctx.getFailedTests().getAllResults()) {

                Object failureTypeObj = failedTest.getAttribute("FailureType");
                String failureType = failureTypeObj != null ? failureTypeObj.toString() : "NA";
                System.out.println("FailureType from Listener: " + failureType);

                if ("APPIUM_FAILURE".equalsIgnoreCase(failureType)) {
                    appiumFail++;
                } else if ("ACTUAL_FAILURE".equalsIgnoreCase(failureType)) {
                    actualFail++;
                }
            }
        }

        int total = passed + failed + skipped;

        String dateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm").format(new Date());
        String subject = "Bandhan World Mobile Automation Report - " + dateTime;

        String body = "<html><body style='font-family:Arial; font-size:14px;'>" +

                "Hello Team,<br/><br/>" +

                "Please find the attached automation report.<br/><br/>" +

                "<b>Execution Summary</b><br/>" +

                "<table border='1' cellspacing='0' cellpadding='6' " +
                "style='border-collapse:collapse; text-align:center;'>" +

                "<tr style='background-color:#f2f2f2; font-weight:bold;'>" +
                "<th>Total</th><th>Passed</th><th>Failed</th><th>Appium Fail</th><th>Actual Fail</th><th>Skipped</th>" +
                "</tr>" +

                "<tr>" +
                "<td>" + total + "</td>" +
                "<td style='color:green; font-weight:bold;'>" + passed + "</td>" +
                "<td style='color:red; font-weight:bold;'>" + failed + "</td>" +
                "<td style='color:orange; font-weight:bold;'>" + appiumFail + "</td>" +
                "<td style='color:#d63384; font-weight:bold;'>" + actualFail + "</td>" +
                "<td>" + skipped + "</td>" +
                "</tr>" +

                "</table><br/><br/>" +

                "<b>Build Version: </b><br/>" +
                "Build Version : " + configReader.getProperty("BUILDVERSION") + "<br/><br/>" +

                "<b>Device Details: </b><br/>" +
                "Device Type : " + configReader.getProperty("INFO_DEVICE_TYPE") + "<br/>" +
                "Device Name : " + configReader.getProperty("INFO_DEVICE_NAME") + "<br/>" +
                "Android Version : " + configReader.getProperty("INFO_ANDROID_VERSION") + "<br/>" +
                "API Level : " + configReader.getProperty("INFO_API_LEVEL") + "<br/><br/>" +

                "<b>Execution Details: </b><br/>" +
                "Total Execution Time : " + executionTime + "<br/><br/><br/><br/>" +

                "Thanks & Regards,<br/>" +
                "<b>Bandhan World Automation</b>" +

                "</body></html>";

        Optional<String> latestReport = GlobalStore.getAllReportPaths().stream()
                .map(File::new)
                .max(Comparator.comparingLong(File::lastModified))
                .map(File::getAbsolutePath);

        if (latestReport.isPresent()) {
            OutlookMailSender.sendOutlookMailWithAttachments(
                    Credentials.getOutlookSenderMail(), // getOutlookSenderMail,getOutlookToRecipients
                    subject,
                    body,
                    List.of(latestReport.get()));
            System.out.println("Automation email sent.");
        }
    }

    public String formatDuration(long millis) {

        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        seconds = seconds % 60;
        minutes = minutes % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
