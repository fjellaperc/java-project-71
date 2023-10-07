package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parserData(String filepath) throws Exception {
        File inputFile = new File(filepath);
        if (Files.readString(new File(filepath).toPath()).isEmpty()) { //Если файл пуст вернем пустой словарь
            return new HashMap<>();
        }
        String formatFile = filepath.substring(filepath.lastIndexOf(".") + 1);
        switch (formatFile) {
            case "json": {
                ObjectMapper mapperJSON = new ObjectMapper();
                return mapperJSON.readValue(inputFile, new TypeReference<>() {
                });
            }
            case ("yaml"), ("yml"): {
                YAMLMapper mapperYAML = new YAMLMapper();
                return mapperYAML.readValue(inputFile, new TypeReference<>() {
                });
            }
            default: throw new Exception("Incorrect format, needed JSON or YAML");
        }
    }
}
