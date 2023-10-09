package hexlet.code.formatters.stylish;

import hexlet.code.formatters.Represent;

import java.util.List;
import java.util.Map;

public class Stylish implements Represent {
    @Override
    public final String representFormat(List<Map<String, Object>> statusKeys) {
        String result = "{\n";
        for (Map<String, Object> map : statusKeys) {
            String status = map.get("type").toString();
            if (status.equals("deleted")) {
                result = result + "  - " + map.get("key") + ": " + map.get("value") + "\n";
            } else if (status.equals("added")) {
                result = result + "  + " + map.get("key") + ": " + map.get("value") + "\n";
            } else if (status.equals("changed")) {
                result = result + "  - " + map.get("key") + ": " + map.get("value1") + "\n";
                result = result + "  + " + map.get("key") + ": " + map.get("value2") + "\n";
            } else if (status.equals("notChanged")) {
                result = result + "    " + map.get("key") + ": " + map.get("value") + "\n";
            }
        }
        result = result + "}";
        System.out.println(result);
        return result;
    }
}
