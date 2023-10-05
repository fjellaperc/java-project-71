package hexlet.code.formatters.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Represent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json implements Represent {
    @Override
    public String representFormat(List<Map<String, Object>> statusKeys) throws JsonProcessingException {
        if (statusKeys.isEmpty()) {
            return "";
        }

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> map : statusKeys) {
            if (map.get("type").equals("deleted")) {
                result.put("  - " + map.get("key") + ":", map.get("value"));
            } else if (map.get("type").equals("added")) {
                result.put("  + " + map.get("key") + ":", map.get("value"));
            } else if (map.get("type").equals("changed")) {
                result.put("  - " + map.get("key") + ":", map.get("value1"));
                result.put("  + " + map.get("key") + ":", map.get("value2"));
            } else if (map.get("type").equals("notChanged")) {
                result.put("   " + map.get("key") + ":", map.get("value"));
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(result));
        return mapper.writeValueAsString(result);
    }
}

    /*  public static String parserJson(List<Map<String, String>> statusKeys) throws IOException {*/

/*
        if (parsMap1.isEmpty()) { //Если обе мапы пустые возвращаем пустую строку
            if (parsMap2.isEmpty()) {
                return "";
            }
        }
        Map<String, Object> commonMap = new HashMap<>();
        commonMap.putAll(parsMap1);
        commonMap.putAll(parsMap2);
        List<String> keys = commonMap.keySet().stream().sorted()
                .toList();
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        for (String key : keys) {
            if (parsMap1.containsKey(key) && !parsMap2.containsKey(key)) { // В первой есть во 2 нет
                result.put("  - " + key + ":", parsMap1.get(key));
            } else if (!parsMap1.containsKey(key) && parsMap2.containsKey(key)) { // Во второй есть в 1 нет
                result.put("  + " + key + ":", parsMap2.get(key));
            } else {
                if (Objects.equals(parsMap1.get(key), parsMap2.get(key))) { //Ключи есть и значения равны
                    result.put("   " + key + ":", parsMap1.get(key));
                } else { //Значения не равны
                    result.put("  - " + key + ":", parsMap1.get(key));
                    result.put("  + " + key + ":", parsMap2.get(key));

*/

