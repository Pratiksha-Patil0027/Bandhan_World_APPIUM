package utils;

public class Utils {
/* 
	public static String resolvePlaceholders(String input) {
		if (input == null)
			return null;

		String resolved = input;
		// Replace all other placeholders using GlobalStore
		Pattern pattern = Pattern.compile("\\{(\\w+)}"); // matches {PLACEHOLDER}
		Matcher matcher = pattern.matcher(resolved);
		while (matcher.find()) {
			String key = matcher.group(1);
			String value = GlobalStore.getOrDefault(key, ""); // default to empty string if not found
			resolved = resolved.replace("{" + key + "}", value);
		}

		return resolved;
	}

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

	

	
	






}
