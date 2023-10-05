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
    public static Map<String, Object> parserData(String filepath) throws Exception {
        String formatFile = getFormat(filepath);
        if (checkEmptyFile(new File(filepath))) {
            return new HashMap<>();
        }
        return CHOICE.get(formatFile).readValue(new File(filepath), new TypeReference<>() {
        });
    }
    public static String getFormat(String filepath) throws Exception {
        String formatFile = filepath.substring(filepath.lastIndexOf(".") + 1);
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
