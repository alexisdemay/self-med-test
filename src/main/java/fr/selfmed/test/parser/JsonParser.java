package fr.selfmed.test.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import fr.selfmed.test.exception.JsonParserException;

public class JsonParser extends Parser {

    private static ObjectMapper mapper;

    public JsonParser() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
    }

    @Override
    public <T> T readObject(String object, Class<T> aClass) {
        try {
            return mapper.readValue(object, aClass);
        } catch (JsonProcessingException e) {
            throw new JsonParserException("An error has occurred while reading json object", e);
        }
    }

    @Override
    public <T> String writeObject(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JsonParserException("An error has occurred while writing json object", e);
        }
    }

}
