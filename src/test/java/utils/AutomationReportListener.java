package utils;

import org.testng.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;

public class AutomationReportListener implements ISuiteListener {

    private static boolean mailSent = false;

    @Override
    public synchronized void onFinish(ISuite suite) {

        if (mailSent) return;
        mailSent = true;

        int passed = 0, failed = 0, skipped = 0;

        for (ISuiteResult result : suite.getResults().values()) {
            ITestContext ctx = result.getTestContext();
            passed += ctx.getPassedTests().size();
            failed += ctx.getFailedTests().size();
            skipped += ctx.getSkippedTests().size();
        }

        int total = passed + failed + skipped;

        String dateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm").format(new Date());
        String subject = "Bandhan World Mobile Automation Report - " + dateTime;

        String body =
            "<html><body>" +
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

            "Thanks & Regards,<br/><b>Bandhan World Automation</b>" +
            "</body></html>";

        Optional<String> latestReport =
                GlobalStore.getAllReportPaths().stream()
                .map(File::new)
                .max(Comparator.comparingLong(File::lastModified))
                .map(File::getAbsolutePath);

        if (latestReport.isPresent()) {
            OutlookMailSender.sendOutlookMailWithAttachments(
                    Credentials.getOutlookSenderMail(),
                    subject,
                    body,
                    List.of(latestReport.get())
            );
            System.out.println("Automation email sent.");
        }
    }
}
