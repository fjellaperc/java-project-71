package hexlet.code;

import java.util.*;

public class Tree {
    public static Map<String, Object> removeFormatMap(String key, Object value) {
        return Map.of("key", key, "type", "deleted", "value",
                Objects.requireNonNullElse(value, "null"));
    }

    public static Map<String, Object> addFormatMap(String key, Object value) {
        return Map.of("key", key, "type", "added", "value",
                Objects.requireNonNullElse(value, "null"));
    }

    public static Map<String, Object> changeFormatMap(String key, Object oldValue, Object newValue) {
        return Map.of("key", key, "type", "changed", "value1",
                Objects.requireNonNullElse(oldValue, "null"),
                "value2", Objects.requireNonNullElse(newValue, "null"));
    }
    public static Map<String, Object> withoutChange(String key, Object value) {
        return Map.of("key", key, "type", "notChanged", "value",
                Objects.requireNonNullElse(value, "null"));
    }
    public static List<Map<String, Object>> buildTree(Map<String, Object> parsMap1,
                                                      Map<String, Object> parsMap2) {
        Map<String, Object> commonMap = new HashMap<>();
        List<Map<String, Object>> result = new ArrayList<>();
        commonMap.putAll(parsMap1);
        commonMap.putAll(parsMap2);
        List<String> sortedKeys = commonMap.keySet().stream().sorted().toList();
        String value = "";
        for (String key : sortedKeys) {
                if (parsMap1.containsKey(key) && !parsMap2.containsKey(key)) { //В первой есть во второй нет
                    result.add(removeFormatMap(key, parsMap1.get(key)));
                } else if (!parsMap1.containsKey(key) && parsMap2.containsKey(key)) { // Во второй есть в первой нет
                    result.add(addFormatMap(key, parsMap2.get(key)));
                } else {
                    if (Objects.equals(parsMap1.get(key), parsMap2.get(key))) { //Значения равны
                        result.add(withoutChange(key, parsMap1.get(key)));
                    } else {
                        result.add(changeFormatMap(key, parsMap1.get(key), parsMap2.get(key)));
                    }
                }
            }
        return result;
    }
}
