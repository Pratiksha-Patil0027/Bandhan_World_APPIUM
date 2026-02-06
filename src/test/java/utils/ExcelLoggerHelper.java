package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelLoggerHelper {
    
    private static final Map<String, List<Object[]>> testResults = new HashMap<>();
    
    public static void logTestResult(String module, String testcaseId, String testDesc,
                                     String userId, String status, String assertionMessage,
                                     String expected, String actual) {
        
        Object[] row = {
            module != null ? module : "",
            testcaseId != null ? testcaseId : "",
            testDesc != null ? testDesc : "",
            userId != null ? userId : "",
            status,
            assertionMessage != null ? assertionMessage : "",
            expected != null ? expected : "",
            actual != null ? actual : ""
        };
        
        String key = (userId == null || userId.isEmpty()) ? module : userId;
        
        if (!testResults.containsKey(key)) {
            testResults.put(key, new ArrayList<>());
        }
        testResults.get(key).add(row);
    }
    
    public static Map<String, List<Object[]>> getTestResults() {
        return testResults;
    }
}