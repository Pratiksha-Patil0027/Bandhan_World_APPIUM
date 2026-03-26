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

        for (ISuiteResult result : suite.getResults().values()) {
            ITestContext ctx = result.getTestContext();
            passed += ctx.getPassedTests().size();
            failed += ctx.getFailedTests().size();
            skipped += ctx.getSkippedTests().size();
        }

        int total = passed + failed + skipped;

       

// ==================  EMAIL SKIP LOGIC ==================

// 1. Failure %
double failurePercent = (total == 0) ? 0 : ((failed * 100.0) / total);

// 2. Infra failure detection
boolean infraFailure = false;

for (ISuiteResult result : suite.getResults().values()) {
    ITestContext ctx = result.getTestContext();

    for (ITestResult fail : ctx.getFailedTests().getAllResults()) {

        String error = fail.getThrowable() != null
                ? fail.getThrowable().toString()
                : "";

        if (error.contains("session is either terminated") ||
            error.contains("instrumentation process is not running") ||
            error.contains("UiAutomator2") ||
            error.contains("StaleObjectException")) {

            infraFailure = true;
            break;
        }
    }
}

// 3. Skip conditions
if (failurePercent > 80 || infraFailure || (passed == 0 && failed == 0)) {
    System.out.println("Skipping email due to unstable execution");

    System.out.println("Failure %: " + failurePercent);
    System.out.println("Infra failure detected: " + infraFailure);

    return;
}

        String dateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm").format(new Date());
        String subject = "Bandhan World Mobile Automation Report - " + dateTime;

        String body = "<html><body>" +
                "Hello Team,<br/><br/>" +
                "Please find the attached automation report.<br/><br/>" +

                "<b>Execution Summary</b><br/>" +
                "<table border='1' cellspacing='0' cellpadding='6' " +
                "style='border-collapse:collapse;font-family:Arial;font-size:14px;'>" +
                "<tr style='background-color:#f2f2f2;'>" +
                "<th>Total</th><th>Passed</th><th>Failed</th><th>Skipped</th></tr>" +
                "<tr>" +
                "<td align='center'>" + total + "</td>" +
                "<td align='center'>" + passed + "</td>" +
                "<td align='center'>" + failed + "</td>" +
                "<td align='center'>" + skipped + "</td>" +
                "</tr></table><br/><br/>" +

                "<b>Build Version</b><br/>" +
                "------------------------------<br/>" +
                "Build Version : " + configReader.getProperty("BUILDVERSION") + "<br/><br/>" +

                "<b>Device Details</b><br/>" +
                "------------------------------<br/>" +
                "Device Type : " + configReader.getProperty("INFO_DEVICE_TYPE") + "<br/>" +
                "Device Name : " + configReader.getProperty("INFO_DEVICE_NAME") + "<br/>" +
                "Android Version : " + configReader.getProperty("INFO_ANDROID_VERSION") + "<br/>" +
                "API Level : " + configReader.getProperty("INFO_API_LEVEL") + "<br/><br/>" +

                "<b>Execution Details</b><br/>" +
                "------------------------------<br/>" +
                "Total Execution Time : " + executionTime + "<br/><br/>" +

                

                "Thanks & Regards,<br/><b>Bandhan World Automation</b>" +
                "</body></html>";

        Optional<String> latestReport = GlobalStore.getAllReportPaths().stream()
                .map(File::new)
                .max(Comparator.comparingLong(File::lastModified))
                .map(File::getAbsolutePath);

        if (latestReport.isPresent()) {
            OutlookMailSender.sendOutlookMailWithAttachments(
                    Credentials.getOutlookSenderMail(), // getOutlookSenderMail, getOutlookToRecipients
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
