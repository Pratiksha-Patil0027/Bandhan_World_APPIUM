package core;

import java.util.Map;


public class FlowExecutor {

    public static Object executeStep(
            String step,
            Map<String, String> data,
            KeywordExecutor executor) throws InterruptedException {

        return executor.execute(step, data);
    }
}
