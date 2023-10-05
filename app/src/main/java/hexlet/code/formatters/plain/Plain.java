package hexlet.code.formatters.plain;


import hexlet.code.formatters.Represent;

import java.util.List;
import java.util.Map;

public class Plain implements Represent {
    public static String checkPrimitive(Object obj) {
        final List<String> classes = List.of("class java.lang.String", "class java.lang.Boolean",
                    "class java.lang.Integer", "class java.lang.Character", "class java.lang.Long",
                    "class java.lang.Float", "class java.lang.Double");

        if (!classes.contains(obj.getClass().toString())) {
            return "[complex value]";
        } else {
            if (obj instanceof String && !obj.equals("null")) {
                return "'" + obj + "'";
            } else {
                return obj.toString();
            }
        }
    }
    @Override
    public final String representFormat(List<Map<String, Object>> statusKeys) {
        if (statusKeys.isEmpty()) {
            return "";
        }
        String result = "";
        for (Map<String, Object> map : statusKeys) {
            if (map.get("type").equals("deleted")) {
                result = result + "Property '" + map.get("key") + "' was removed\n";
            } else if (map.get("type").equals("added")) {
                result = result + "Property '" + map.get("key") + "' was added with value: "
                        + checkPrimitive(map.get("value")) + "\n";
            } else if (map.get("type").equals("changed")) {
                result = result + "Property '" + map.get("key") + "' was updated. From "
                        + checkPrimitive(map.get("value1")) + " to " + checkPrimitive(map.get("value2")) + "\n";
            }
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
        return result;
    }
}
