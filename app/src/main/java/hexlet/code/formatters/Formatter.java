package hexlet.code.formatters;

import hexlet.code.Tree;
import hexlet.code.formatters.json.Json;
import hexlet.code.formatters.plain.Plain;
import hexlet.code.formatters.stylish.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String represent(Map<String, Object> parsMap1, Map<String, Object> parsMap2, String format)
            throws Exception {
        final Map<String, Represent> formats = Map.of(
                "plain", new Plain(),
                "stylish", new Stylish(),
                "json", new Json());
        List<Map<String, Object>> statusKeys = Tree.buildTree(parsMap1, parsMap2);
        if (formats.containsKey(format)) {
            return formats.get(format).representFormat(statusKeys);
        } else {
            throw new Exception("Unknown format, enter genDiff -h for more information");
        }
    }
}

