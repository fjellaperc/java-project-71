package hexlet.code.formatters.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Represent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json implements Represent {
    @Override
    public final String representFormat(List<Map<String, Object>> statusKeys) throws JsonProcessingException {
        if (statusKeys.isEmpty()) {
            return "";
        }

//        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        for (Map<String, Object> map : statusKeys) {
            result = result + mapper.writeValueAsString(map);
            /*if (map.get("type").equals("deleted")) {
                result.put("  - " + map.get("key") + ":", map.get("value"));
            } else if (map.get("type").equals("added")) {
                result.put("  + " + map.get("key") + ":", map.get("value"));
            } else if (map.get("type").equals("changed")) {
                result.put("  - " + map.get("key") + ":", map.get("value1"));
                result.put("  + " + map.get("key") + ":", map.get("value2"));
            } else if (map.get("type").equals("notChanged")) {
                result.put("   " + map.get("key") + ":", map.get("value"));
            }*/
        }
        System.out.println(result);
        return result;
    }
}


