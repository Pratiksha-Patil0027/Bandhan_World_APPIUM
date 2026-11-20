package core;

import java.util.Map;
import io.appium.java_client.android.AndroidDriver;

public interface KeywordExecutor {

    Object execute(
            String step,
            Map<String, String> data,
            AndroidDriver driver
    ) throws InterruptedException;
}
