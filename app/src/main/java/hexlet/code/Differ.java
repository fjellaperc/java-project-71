package hexlet.code;

import hexlet.code.formatters.Formatter;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        Map<String, Object> parsMap1 = Parser.parserData(filepath1);
        Map<String, Object> parsMap2 = Parser.parserData(filepath2);
        return Formatter.represent(parsMap1, parsMap2, formatName);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    /*public static Map<String, Object> generateJSON(String filepath1, String filepath2) throws Exception {
        Map<String, Object> parsMap1 = Parser.parserData(filepath1);
        Map<String, Object> parsMap2 = Parser.parserData(filepath2);
        return Formatter.representJSON(parsMap1, parsMap2);
    }*/

}

