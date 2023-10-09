package hexlet.code.formatters.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Represent;

import java.util.List;
import java.util.Map;

public class Json implements Represent {
    @Override
    public final String representFormat(List<Map<String, Object>> statusKeys) throws JsonProcessingException {
        if (statusKeys.isEmpty()) {
            return "";
        }
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        for (Map<String, Object> map : statusKeys) {
            result = result + mapper.writeValueAsString(map);
        }
        System.out.println(result);
        return result;
    }
}


