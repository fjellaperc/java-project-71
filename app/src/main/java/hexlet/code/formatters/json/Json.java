package hexlet.code.formatters.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Json {
    public static Map<String, Object> parserJson(Map<String, Object> parsMap1, Map<String, Object> parsMap2) throws IOException {
        Map<String, Object> commonMap = new HashMap<>();
        commonMap.putAll(parsMap1);
        commonMap.putAll(parsMap2);
        List<String> keys = commonMap.keySet().stream().sorted()
                .toList();
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        for (String key : keys) {
            if (parsMap1.containsKey(key) && !parsMap2.containsKey(key)) { // В первой есть во 2 нет
                result.put("- " + key + ":", parsMap1.get(key));
            } else if (!parsMap1.containsKey(key) && parsMap2.containsKey(key)) { // Во второй есть в 1 нет
                result.put("+ " + key + ":", parsMap2.get(key));
            } else {
                if (Objects.equals(parsMap1.get(key), parsMap2.get(key))) { //Ключи есть и значения равны
                    result.put(" " + key + ":", parsMap1.get(key));
                } else { //Значения не равны
                    result.put("- " + key + ":", parsMap1.get(key));
                    result.put("+ " + key + ":", parsMap2.get(key));
                }
            }
        }
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File("/home/fjellaperc/test.json"), result);
        return result;
    }
}
