package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parserData(String filepath) throws Exception {
/*        String emptyFile = Files.readString(new File(filepath).toPath());
        if (emptyFile.isEmpty()) {
            return new HashMap<>();
        }*/
        if (filepath.toLowerCase().contains("json")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filepath), new TypeReference<>() {
            });
        } else if (filepath.contains("yaml") || filepath.contains("yml")) {
            ObjectMapper mapper = new YAMLMapper();
            return mapper.readValue(new File(filepath), new TypeReference<>() {
            });
        } else {
            throw new Exception("Incorrectly format of files, needed YAML or JSON");
        }
    }
}
