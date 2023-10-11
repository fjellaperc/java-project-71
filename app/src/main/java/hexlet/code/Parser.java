package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parserData(String data, String formatFile) throws Exception {
        if (data.isEmpty()) { //Если данных нет, вернем пустую мапу
            return new HashMap<>();
        }
        switch (formatFile) {
            case "json":
                ObjectMapper mapperJSON = new ObjectMapper();
                return mapperJSON.readValue(data, new TypeReference<>() {
                });
            case ("yaml"), ("yml"):
                YAMLMapper mapperYAML = new YAMLMapper();
                return mapperYAML.readValue(data, new TypeReference<>() {
                });
            default: throw new Exception("Incorrect format, needed JSON or YAML");
        }
    }
}
