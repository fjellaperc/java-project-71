package hexlet.code;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;

public class Tree {
    public static List<Map<String, Object>> buildTree(Map<String, Object> parsMap1,
                                                      Map<String, Object> parsMap2) {
        Map<String, Object> commonMap = new HashMap<>();
        List<Map<String, Object>> result = new ArrayList<>();
        commonMap.putAll(parsMap1);
        commonMap.putAll(parsMap2);
        List<String> sortedKeys = commonMap.keySet().stream().sorted().toList();
        for (String key : sortedKeys) {
            if (parsMap1.containsKey(key) && !parsMap2.containsKey(key)) { //В первой есть во второй нет
                result.add(Map.of("key", key, "type", "deleted", "value",
                        Objects.requireNonNullElse(parsMap1.get(key), "null")));
            } else if (!parsMap1.containsKey(key) && parsMap2.containsKey(key)) { // Во второй есть в первой нет
                result.add(Map.of("key", key, "type", "added", "value",
                        Objects.requireNonNullElse(parsMap2.get(key), "null")));
            } else {
                if (Objects.equals(parsMap1.get(key), parsMap2.get(key))) { //Значения равны
                    result.add(Map.of("key", key, "type", "notChanged", "value",
                            Objects.requireNonNullElse(parsMap1.get(key), "null")));
                } else {
                    result.add(Map.of("key", key, "type", "changed", "value1",
                            Objects.requireNonNullElse(parsMap1.get(key), "null"),
                            "value2", Objects.requireNonNullElse(parsMap2.get(key), "null")));
                }
            }
        }
        return result;
    }
}
