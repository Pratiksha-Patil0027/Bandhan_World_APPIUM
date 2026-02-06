
package utils;

import java.util.Map;

public class ExcelPathResolver {
    public static String resolvePath(Map<String, String> meta) {
        return FrameworkConstants.BASE_RESOURCE_PATH + "/" +
               meta.get("MODULE") + "/" +
               meta.get("FEATURE") + "/" +
               meta.get("FILE_NAME");
    }
}
