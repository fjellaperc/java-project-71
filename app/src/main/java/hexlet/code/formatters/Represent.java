package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface Represent {
    String representFormat(List<Map<String, Object>> statusKeys) throws JsonProcessingException;
}
