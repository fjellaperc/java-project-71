package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.File;
import java.util.Map;

public class Differ {
    public static String generate(File file1, File file2, String formatName) throws Exception {
        Map<String, Object> parsMap1 = Parser.parserData(file1);
        Map<String, Object> parsMap2 = Parser.parserData(file2);
        return Formatter.represent(parsMap1, parsMap2, formatName);
    }
}
