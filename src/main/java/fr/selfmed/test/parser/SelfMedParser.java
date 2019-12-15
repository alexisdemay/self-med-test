package fr.selfmed.test.parser;

import fr.selfmed.test.mapper.SelfMedMapper;
import fr.selfmed.test.exception.ParserException;

public class SelfMedParser extends Parser {

    private static SelfMedMapper selfMedMapper;

    public SelfMedParser() {
        if (selfMedMapper == null) {
            selfMedMapper = new SelfMedMapper();
        }
    }

    @Override
    public <T> T readObject(String object, Class<T> aClass) throws ParserException {
        return null;
    }

    @Override
    public <T> String writeObject(T object) {
        return selfMedMapper.writeValueAsString(object);
    }

}
