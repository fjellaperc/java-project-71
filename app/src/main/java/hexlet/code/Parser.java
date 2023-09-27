package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parserData(String filepath) throws IOException {
        String emptyFile = Files.readString(new File(filepath).toPath());
        if (emptyFile.isEmpty()) {
            return new HashMap<>();
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filepath), new TypeReference<>() {
        });
    }
}
