package hexlet.code.formatters.stylish;

import hexlet.code.formatters.Represent;

import java.util.List;
import java.util.Map;

public class Stylish implements Represent {
    @Override
    public String representFormat(List<Map<String, Object>> statusKeys) {
        String result = "{\n";
        for (Map<String, Object> map : statusKeys) {
            if (map.get("type").equals("deleted")) {
                result = result + "  - " + map.get("key") + ": " + map.get("value") + "\n";
            } else if (map.get("type").equals("added")) {
                result = result + "  + " + map.get("key") + ": " + map.get("value") + "\n";
            } else if (map.get("type").equals("changed")) {
                result = result + "  - " + map.get("key") + ": " + map.get("value1") + "\n";
                result = result + "  + " + map.get("key") + ": " + map.get("value2") + "\n";
            } else if (map.get("type").equals("notChanged")) {
                result = result + "    " + map.get("key") + ": " + map.get("value") + "\n";
            }
        }
        result = result + "}";
        System.out.println(result);
        return result;
    }
}