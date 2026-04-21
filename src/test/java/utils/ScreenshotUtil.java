package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(AppiumDriver driver, String testCaseId) {

    String timestamp = new SimpleDateFormat("HHmmss").format(new Date());
    String fileName = testCaseId + "_" + timestamp + ".png";

    //String dateFolder = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
    //  Use SAME execution folder (created once)
    String screenshotDir = System.getProperty("user.dir") 
        + "/failed_Testcases_Screenshots/" + ExcelLogger.executionFolder + "/";

    new File(screenshotDir).mkdirs();

    String filePath = screenshotDir + fileName;

    try {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(filePath));
    } catch (Exception e) {
        e.printStackTrace();
    }

    return filePath; // full path
}
}
