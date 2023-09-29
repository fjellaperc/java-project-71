package hexlet.code.formatters.plain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {
    static List<String> classes = List.of("class java.lang.String", "class java.lang.Boolean",
            "class java.lang.Integer", "class java.lang.Character", "class java.lang.Long",
            "class java.lang.Float", "class java.lang.Double");
    public static String representPlainStyle(Map<String, Object> parsMap1, Map<String, Object> parsMap2) {
        if (parsMap1.isEmpty()) { //Если обе мапы пустые возвращаем пустую строку
            if (parsMap2.isEmpty()) {
                return "";
            }
        }
        Map<String, Object> commonMap = new HashMap<>();
        commonMap.putAll(parsMap1);
        commonMap.putAll(parsMap2);
        List<String> keys = commonMap.keySet().stream().sorted().toList();
        String result = "";
        for (String key : keys) {
            if (parsMap1.containsKey(key) && !parsMap2.containsKey(key)) { // В первой есть во 2 нет
                result = result + "Property '" + key + "' was removed\n";
            } else if (!parsMap1.containsKey(key) && parsMap2.containsKey(key)) { // Во второй есть в 1 нет
                if (!classes.contains(parsMap2.get(key).getClass().toString()) //Проверка на примитивность
                        && parsMap2.get(key) != null) {
                    result = result + "Property '" + key + "' was added with value: [complex value]\n";
                } else {
                    if (parsMap2.get(key) instanceof String) { //Если значение строка то ставми кавычки ' '
                        result = result + "Property '" + key + "' was added with value: '" + parsMap2.get(key) + "'\n";
                    } else {
                        result = result + "Property '" + key + "' was added with value: "
                                + parsMap2.get(key) + "\n";
                    }
                }
            } else {
                if (!Objects.equals(parsMap1.get(key), parsMap2.get(key))) { //Значения не равны
                    if (parsMap1.get(key) != null  //Проверка на примитивность
                            && !classes.contains(parsMap1.get(key).getClass().toString())) {
                        result = result + "Property '" + key + "' was updated. From [complex value]";
                    } else {
                        if (parsMap1.get(key) instanceof String) { //Если значение строка то ставми кавычки ' '
                            result = result + "Property '" + key + "' was updated. From '" + parsMap1.get(key) + "'";
                        } else {
                            result = result + "Property '" + key + "' was updated. From " + parsMap1.get(key);
                        }
                    }
                    if (parsMap2.get(key) != null  //Проверка на примитивность
                            && !classes.contains(parsMap2.get(key).getClass().toString())) {
                        result = result + " to [complex value]\n";
                    } else {
                        if (parsMap2.get(key) instanceof String) {
                            result = result + " to '" + parsMap2.get(key) + "'\n";
                        } else {
                            result = result + " to " + parsMap2.get(key) + "\n";
                        }
                    }
                }
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
