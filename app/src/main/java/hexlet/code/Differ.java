package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        String dataFromFile1 = Files.readString(new File(filepath1).toPath()); //Данные первого файла
        String dataFromFile2 = Files.readString(new File(filepath2).toPath()); //Данные второго файла
        String formatFile1 = filepath1.substring(filepath1.lastIndexOf(".") + 1);
        String formatFile2 = filepath2.substring(filepath2.lastIndexOf(".") + 1);
        Map<String, Object> parsMap1 = Parser.parserData(dataFromFile1, formatFile1);
        Map<String, Object> parsMap2 = Parser.parserData(dataFromFile2, formatFile2);
        return Formatter.represent(parsMap1, parsMap2, formatName);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}

