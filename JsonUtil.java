package zw.co.getcash.utilities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;

/**
 * @author autowired
 * Date    4/9/17
 */

public class JsonUtil {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final static Logger logger = Logger.getLogger(JsonUtil.class);

    static {
        objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Json error:" + e.getMessage());
            return null;
        }
    }

    public static JSONObject toJson(Object object) {
        try {
            return new JSONObject(objectMapper.writeValueAsString(object));
        } catch (Exception e) {
            return null;
        }

    }
}