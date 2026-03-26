package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
 
	public static String resolvePlaceholders(String input) {

    if (input == null) return null;

    Pattern pattern = Pattern.compile("\\{(\\w+)}");
    Matcher matcher = pattern.matcher(input);

    StringBuffer result = new StringBuffer();

    while (matcher.find()) {

        String key = matcher.group(1);

        String value = GlobalStore.get(key);

        if (value == null) {
            System.out.println("GlobalStore missing key: " + key);
            value = "";
        }

        System.out.println("Replacing {" + key + "} with -> " + value);

        matcher.appendReplacement(result, Matcher.quoteReplacement(value));
    }

    matcher.appendTail(result);

    return result.toString();
}

/* 
	public static void removeFieldsRecursive(JsonNode node, List<String> fieldsToRemove) {
		if (node.isObject()) {
			ObjectNode objNode = (ObjectNode) node;
			for (String field : fieldsToRemove) {
				objNode.remove(field);
			}
			Iterator<String> fieldNames = objNode.fieldNames();
			while (fieldNames.hasNext()) {
				String fieldName = fieldNames.next();
				removeFieldsRecursive(objNode.get(fieldName), fieldsToRemove);
			}
		} else if (node.isArray()) {
			for (JsonNode arrayItem : node) {
				removeFieldsRecursive(arrayItem, fieldsToRemove);
			}
		}
	}
*/
	public static String truncateText(String text) {
		final int MAX_LENGTH = 32767;
		if (text != null && text.length() > MAX_LENGTH) {
			return text.substring(0, MAX_LENGTH - 3) + "...";
		}
		return text;
	}


	public void setMockLocation(String lat, String lon) {
    try {
        String command = "adb emu geo fix " + lon + " " + lat;
        Runtime.getRuntime().exec(command);
        Thread.sleep(2000);
        //System.out.println("Mock location set: " + lat + ", " + lon);
    } catch (Exception e) {
        e.printStackTrace();
    }
	}

	
public static String setExpectedFromGlobal(String key) {
    String value = GlobalStore.get(key);
    if (value != null) {
        value = value.trim();
        TestContext.put("Expected", value);
    }
    return value;
}
	




}
