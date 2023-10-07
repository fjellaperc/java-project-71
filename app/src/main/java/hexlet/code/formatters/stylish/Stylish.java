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
            switch (status) {
                case "deleted":
                    result = result + "  - " + map.get("key") + ": " + map.get("value") + "\n";
                case "added":
                    result = result + "  + " + map.get("key") + ": " + map.get("value") + "\n";
                case "changed":
                    result = result + "  - " + map.get("key") + ": " + map.get("value1") + "\n";
                    result = result + "  + " + map.get("key") + ": " + map.get("value2") + "\n";
                case "notChanged":
                    result = result + "    " + map.get("key") + ": " + map.get("value") + "\n";
            }
        }
        result = result + "}";
        System.out.println(result);
        return result;
    }
}
