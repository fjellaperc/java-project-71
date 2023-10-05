package hexlet.code.formatters;

import hexlet.code.Tree;
import hexlet.code.formatters.json.Json;
import hexlet.code.formatters.plain.Plain;
import hexlet.code.formatters.stylish.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public final static Map<String, Represent> FORMAT = Map.of(
            "plain", new Plain(),
            "stylish", new Stylish(),
            "json", new Json());
    public static String represent(Map<String, Object> parsMap1, Map<String, Object> parsMap2, String format)
            throws Exception {
        List<Map<String, Object>> statusKeys = Tree.buildTree(parsMap1, parsMap2);
        if (FORMAT.containsKey(format)) {
            return FORMAT.get(format).representFormat(statusKeys);
        } else {
            throw new Exception("Unknown format, enter genDiff -h for more information");
        }
    }
}

