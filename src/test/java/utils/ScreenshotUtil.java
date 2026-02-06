package utils;

public class ScreenshotUtil {

    // /**
    //  * Captures screenshot with timestamp and returns the full file path.
    //  * Works even if test fails due to exception.
    //  */
    // public static String captureScreenshot(AppiumDriver driver, String testCaseId, String baseDirPath) {
    //     String dateFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    //     String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

    //     try {
    //         // Prepare screenshot directory
    //         File screenshotsDir = new File(baseDirPath + File.separator + "screenshots" + File.separator + dateFolder);
    //         if (!screenshotsDir.exists()) {
    //             screenshotsDir.mkdirs();
    //         }

    //         // Take screenshot
    //         File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    //         String fileName = testCaseId + "_" + timestamp + ".png";
    //         File destFile = new File(screenshotsDir, fileName);

    //         // Copy file to destination
    //         Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

    //         System.out.println("📸 Screenshot saved at: " + destFile.getAbsolutePath());
    //         return destFile.getAbsolutePath();

    //     } catch (Exception e) {
    //         System.err.println(" Failed to capture screenshot for test case: " + testCaseId);
    //         e.printStackTrace();
    //         return "";
    //     }
    // }

    // /**
    //  * Helper method for fail-safe screenshot capture (no exception thrown)
    //  */
    // public static String safeCapture(AppiumDriver driver, String testCaseId, String baseDirPath) {
    //     try {
    //         return captureScreenshot(driver, testCaseId, baseDirPath);
    //     } catch (Exception ignored) {
    //         return "";
    //     }
    // }
}
