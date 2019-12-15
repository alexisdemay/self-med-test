package fr.selfmed.test.service.impl;

import fr.selfmed.test.exception.InvalidFormatException;
import fr.selfmed.test.exception.NotSupportFormatException;
import fr.selfmed.test.parser.ParserFormat;
import fr.selfmed.test.service.InputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InputServiceImpl implements InputService {

    @Value("#{T(fr.selfmed.test.resource.ResourceReader).readFileToString('classpath:input/xml-input.xml')}")
    private String xmlResource;

    @Value("#{T(fr.selfmed.test.resource.ResourceReader).readFileToString('classpath:input/json-input.json')}")
    private String jsonResource;

    @Override
    public String getInput(ParserFormat format) {
        String input = null;
        switch (format) {
            case JSON:
                input = jsonResource;
                break;
            case XML:
                input = xmlResource;
                break;
            case SELF_MED:
                throw new NotSupportFormatException(
                        "The " + ParserFormat.SELF_MED + " format is not currently supported");
            case INVALID:
                throw new InvalidFormatException("The format is invalid");
        }
        return input;
    }

}