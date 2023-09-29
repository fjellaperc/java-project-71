package hexlet.code.formatters;

import hexlet.code.formatters.json.Json;
import hexlet.code.formatters.plain.Plain;
import hexlet.code.formatters.stylish.Stylish;
import java.util.Map;

public class Formatter {
    public static String represent(Map<String, Object> parsMap1, Map<String, Object> parsMap2, String format)
            throws Exception {
        switch (format) {
            case "plain":
                return Plain.representPlainStyle(parsMap1, parsMap2);
            case "stylish":
                return Stylish.stylishFormmater(parsMap1, parsMap2);
            case "json":
                return Json.parserJson(parsMap1, parsMap2);
            default:
                throw new Exception("Unknown format, enter gendiff -h for more infomation");
        }
    }
}
