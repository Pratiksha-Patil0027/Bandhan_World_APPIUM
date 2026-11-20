package core;

import java.util.Map;
import io.appium.java_client.android.AndroidDriver;

public class FlowExecutor {

    public static Object executeStep(
            String step,
            Map<String, String> data,
            KeywordExecutor executor,
            AndroidDriver driver) throws InterruptedException {

        return executor.execute(step, data, driver);
    }
}
