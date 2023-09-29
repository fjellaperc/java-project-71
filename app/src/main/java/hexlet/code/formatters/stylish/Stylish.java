package hexlet.code.formatters.stylish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Stylish {
    public static String stylishFormmater(Map<String, Object> parsMap1, Map<String, Object> parsMap2) {
        System.out.println("Map1Stylish " + parsMap1.isEmpty());
        System.out.println("Map2Stylish " + parsMap2.isEmpty());
        if (parsMap1.isEmpty() && parsMap2.isEmpty()) {
            return "";
        }
        Map<String, Object> commonMap = new HashMap<>();
        commonMap.putAll(parsMap1);
        commonMap.putAll(parsMap2);
        List<String> keys = commonMap.keySet().stream().sorted().toList();
        String result = "{\n";
        for (String key : keys) {
            if (parsMap1.containsKey(key) && !parsMap2.containsKey(key)) { // В первой есть во 2 нет
                result = result + "  - " + key + ": " + parsMap1.get(key) + "\n";
            } else if (!parsMap1.containsKey(key) && parsMap2.containsKey(key)) { // Во второй есть в 1 нет
                result = result + "  + " + key + ": " + parsMap2.get(key) + "\n";
            } else {
                if (Objects.equals(parsMap1.get(key), parsMap2.get(key))) { //Ключи есть и значения равны
                    result = result + "    " + key + ": " + parsMap1.get(key) + "\n";
                } else { //Значения не равны
                    result = result + "  - " + key + ": " + parsMap1.get(key) + "\n";
                    result = result + "  + " + key + ": " + parsMap2.get(key) + "\n";
                }
            }
        }
        result = result + "}";
        return result;
    }
}
