package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClassTest;
import io.appium.java_client.AppiumDriver;

public class ExcelLogger implements ITestListener {

    static String executionFolder;
    private final List<Object[]> allResults = new ArrayList<>();

    /* ================= TESTNG EVENTS ================= */

    @Override
    public void onTestSuccess(ITestResult result) {
        recordResult(result, "PASS",null);
    }

    @Override
    public void onTestFailure(ITestResult result) {
       
         Object currentClass = result.getInstance();
    AppiumDriver driver = ((BaseClassTest) currentClass).getDriver();

    String testCaseId = getAttribute(result, "TestID", "TestID");

    // Capture screenshot
    String screenshotPath = ScreenshotUtil.captureScreenshot(driver, testCaseId);

    recordResult(result, "FAIL", screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        recordResult(result, "SKIP",null);
    }

    /* ================= CORE RECORDING ================= */

   private void recordResult(ITestResult result, String status, String screenshotPath) {

    String moduleName   = getAttribute(result, "ModuleName", "ModuleName");
    String testcaseId   = getAttribute(result, "TestID", "TestID");
    String testcaseDesc = getAttribute(result, "TestDesc", "TestDesc");
    String steps        = getAttribute(result, "Steps", "Steps");
    String influencerAccount = getAttribute(result, "InfluencerAcccount", "InfluencerAcccount");
    String expected     = getAttribute(result, "Expected", "Expected");
    String actual       = getAttribute(result, "Actual", "Actual");
    String failureType  = getAttribute(result, "FailureType", "FailureType");

    String assertionMessage = getAssertionMessage(result);

    Object[] row = new Object[]{
            moduleName,
            testcaseId,
            testcaseDesc,
            steps,
            influencerAccount,
            status,
            failureType,
            assertionMessage,
            expected,
            actual
           // screenshotPath == null ? "" : screenshotPath   //  NEW COLUMN
    };

    allResults.add(row);
}

    private String getAttribute(ITestResult result, String primaryKey, String fallbackKey) {
        // First try to get from test result attributes
        Object value = result.getAttribute(primaryKey);
        if (value != null) {
            return value.toString();
        }
        
        // Then try from TestContext
        String ctxValue = TestContext.get(fallbackKey);
        if (ctxValue != null && !ctxValue.trim().isEmpty()) {
            return ctxValue;
        }
        
        return "N/A";
    }

    private String getAssertionMessage(ITestResult result) {
        if (result.getThrowable() != null) {
            Throwable throwable = result.getThrowable();
            String message = throwable.getMessage();
            if (message == null || message.trim().isEmpty()) {
                return throwable.getClass().getSimpleName();
            }
            // Truncate very long messages
            return message.length() > 500 ? message.substring(0, 500) + "..." : message;
        }
        return "Assertion passed";
    }

    /* ================= REPORT GENERATION ================= */

    @Override
    public void onFinish(ITestContext context) {
        try {
            String dateFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            Path baseDir = Path.of("reports", dateFolder);
            Files.createDirectories(baseDir);

            generateSingleReport(baseDir);

        } catch (Exception e) {
            System.err.println("Error generating Excel report: " + e.getMessage());
            e.printStackTrace();
        }

        printStatistics();
       
    }

    private void generateSingleReport(Path baseDir) throws IOException {
        if (allResults.isEmpty()) {
            System.out.println("No test results to report");
            return;
        }

        // Sort results by module name and testcase ID
        allResults.sort((r1, r2) -> {
            int moduleCompare = r1[0].toString().compareTo(r2[0].toString());
            if (moduleCompare != 0) return moduleCompare;
            return r1[1].toString().compareTo(r2[1].toString());
        });

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Execution Report");

        CellStyle headerStyle = createHeaderStyle(workbook);
        CellStyle normalStyle = createNormalStyle(workbook);
        CellStyle passStyle   = createStatusStyle(workbook, "PASS");
        CellStyle failStyle   = createStatusStyle(workbook, "FAIL");
        CellStyle skipStyle   = createStatusStyle(workbook, "SKIP");

        String[] headers = {
                "MODULE_NAME", "TESTCASE_ID", "TEST_DESC","STEPS",
                "INFLUENCER_ACCOUNT", "STATUS", "FAILURE_TYPE", "ASSERTION_MESSAGE",
                "EXPECTED_RESULT", "ACTUAL_RESULT" //,"SCREENSHOT"
        };

        // Create header row
        Row header = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Create data rows
        int rowNum = 1;
        for (Object[] data : allResults) {
            Row row = sheet.createRow(rowNum++);

             //row.setHeightInPoints(150);
            
            for (int col = 0; col < data.length; col++) {
                Cell cell = row.createCell(col);
                String value = data[col] == null ? "" : data[col].toString();
                cell.setCellValue(value);
                
//                 //  Screenshot column (index 10)
//    if (col == 10 && value != null && !value.isEmpty() && "FAIL".equals(data[5])) {

//     try {
//         // Read image file
//         FileInputStream fis = new FileInputStream(value);
//         byte[] bytes = IOUtils.toByteArray(fis);
//         fis.close();

//         // Add image to workbook
//         int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);

//         // Create drawing object
//         CreationHelper helper = workbook.getCreationHelper();
//         Drawing<?> drawing = sheet.createDrawingPatriarch();

//         // Create anchor (position of image)
//         ClientAnchor anchor = helper.createClientAnchor();

//         anchor.setCol1(col);       // same column
//         anchor.setRow1(rowNum-1);  // current row

//         // Insert image
//         Picture pict = drawing.createPicture(anchor, pictureIdx);
       
//           //  Make image SMALL
//         pict.resize(0.1);   // change this value (0.2–0.4 best)

//         cell.setCellValue("Screenshot Attached");

//     } catch (Exception e) {
//         e.printStackTrace();
//         cell.setCellValue("Image Error");
//     }
// }
                // Apply style based on column
                if (col == 5) { // STATUS column
                    switch (value) {
                        case "PASS": cell.setCellStyle(passStyle); break;
                        case "FAIL": cell.setCellStyle(failStyle); break;
                        case "SKIP": cell.setCellStyle(skipStyle); break;
                        default: cell.setCellStyle(normalStyle);
                    }
                    
                } else if (col == 7 || col == 8 || col == 9) {// ASSERTION, EXPECTED, ACTUAL
                    // Wrap text for these columns
                    CellStyle wrapStyle = workbook.createCellStyle();
                    wrapStyle.cloneStyleFrom(normalStyle);
                    wrapStyle.setWrapText(true);
                    cell.setCellStyle(wrapStyle);
                } else {
                    cell.setCellStyle(normalStyle);
                }
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
            // Set minimum width
            if (sheet.getColumnWidth(i) < 3000) {
                sheet.setColumnWidth(i, 3000);
            }
        }

        // Set specific widths for certain columns
        sheet.setColumnWidth(6, 5000);  // FAILURE_TYPE
sheet.setColumnWidth(7, 8000);  // ASSERTION_MESSAGE
sheet.setColumnWidth(8, 12000); // EXPECTED_RESULT
sheet.setColumnWidth(9, 12000); // ACTUAL_RESULT
sheet.setColumnWidth(10, 15000); // Screenshot column


        // Create filename with timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = "Test_Execution_Report_" + timestamp + ".xlsx";
        Path filePath = baseDir.resolve(fileName);

        // Write to file
        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
            workbook.write(fos);
        }

        workbook.close();

        // Store path in GlobalStore
        GlobalStore.addReportPath(filePath.toString());

        System.out.println("Report generated: " + filePath.toAbsolutePath());

       // Open the file automatically if Desktop is supported
        // if (Desktop.isDesktopSupported()) {
        //     try {
        //         Desktop.getDesktop().open(filePath.toFile());
        //     } catch (Exception e) {
        //         System.out.println("Could not open report automatically: " + e.getMessage());
        //     }
        // }
    }

    /* ================= STYLE CREATION ================= */

    private CellStyle createHeaderStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 11);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private CellStyle createNormalStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setVerticalAlignment(VerticalAlignment.TOP);
        return style;
    }

    private CellStyle createStatusStyle(Workbook wb, String status) {
        CellStyle style = wb.createCellStyle();
        style.cloneStyleFrom(createNormalStyle(wb));
        style.setAlignment(HorizontalAlignment.CENTER);
        
        switch (status) {
            case "PASS":
                style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
                break;
            case "FAIL":
                style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
                Font font = wb.createFont();
                font.setBold(true);
                style.setFont(font);
                break;
            case "SKIP":
                style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
                break;
        }
        
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    /* ================= STATISTICS ================= */

    private void printStatistics() {
        long passCount = allResults.stream().filter(r -> "PASS".equals(r[4])).count();
        long failCount = allResults.stream().filter(r -> "FAIL".equals(r[4])).count();
        long skipCount = allResults.stream().filter(r -> "SKIP".equals(r[4])).count();

        long appiumFail = allResults.stream()
        .filter(r -> "APPIUM_FAILURE".equals(r[6])).count();

        long actualFail = allResults.stream()
        .filter(r -> "ACTUAL_FAILURE".equals(r[6])).count();
        
            System.out.println("Appium Failures: " + appiumFail);
            System.out.println("Actual Failures: " + actualFail);
        System.out.println("===============================\n");
    }

     @Override
public void onStart(ITestContext context) {

    System.out.println("Starting test execution: " + context.getName());

    //  Create folder ONLY ONCE per execution
    if (executionFolder == null) {
        executionFolder = new SimpleDateFormat("yyyy-MM-dd_HH-mm")
                .format(new Date());
    }

    //  Clear results ONLY ONCE
    allResults.clear();
}

   @Override
public void onTestStart(ITestResult result) {
    System.out.println("Starting test case: " + result.getName());
}

   


}