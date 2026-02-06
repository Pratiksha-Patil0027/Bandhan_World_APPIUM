package dataprovider;
import org.testng.annotations.DataProvider;

import core.GlobalStore;
import utils.ExcelPathResolver;
import utils.ExcelReader;
import java.util.*;

public class MasterDataProvider {
 @DataProvider(name = "masterData")
public static Object[][] getAllTestData() {
    List<Map<String, String>> finalData = new ArrayList<>();
    String masterFile = System.getProperty("user.dir") + "/src/test/resources/testdata/MasterExecution.xlsx";
    List<Map<String, String>> modules = ExcelReader.getData(masterFile, "Execution");
    System.out.println("modules: "+ modules);

    for (Map<String, String> module : modules) {
        if (!"YES".equalsIgnoreCase(module.get("EXECUTE"))) continue;


        String filePath = ExcelPathResolver.resolvePath(module);
        System.out.println("filePath: "+ filePath);
        GlobalStore.put("TESTCASES_FILE_PATH", filePath);
        String sheetName = module.get("SHEET");
        System.out.println("sheetName: "+ sheetName);

        List<Map<String, String>> testCases = ExcelReader.getData(filePath, sheetName);
        for (Map<String, String> testCase : testCases) {
            testCase.put("MODULE", module.get("MODULE"));
            testCase.put("FEATURE", module.get("FEATURE"));
            finalData.add(testCase);
        }
    }

    Object[][] data = new Object[finalData.size()][1];
    for (int i = 0; i < finalData.size(); i++) data[i][0] = finalData.get(i);
    return data;
}
}