package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static final Map<String, ObjectMapper> CHOICE = Map.of(
            "json", new ObjectMapper(),
            "yaml", new YAMLMapper(),
            "yml", new YAMLMapper());
    public static Map<String, Object> parserData(File inputFile) throws Exception {
        String formatFile = getFormat(inputFile);
        if (checkEmptyFile(inputFile)) {
            return new HashMap<>();
        }
        return CHOICE.get(formatFile).readValue(inputFile, new TypeReference<>() {
        });
    }
    public static String getFormat(File inputFile) throws Exception {
        String absolutePath = inputFile.getAbsolutePath();
        String formatFile = absolutePath.substring(absolutePath.lastIndexOf(".") + 1);
        if (CHOICE.containsKey(formatFile)) {
            return formatFile;
        } else {
            throw new Exception("Incorrectly format of files, needed YAML or JSON");
        }
    }
    public static boolean checkEmptyFile(File inputFile) throws IOException {
        return Files.readString(inputFile.toPath()).isEmpty();
    }
}
