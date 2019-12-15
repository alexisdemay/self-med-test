package fr.selfmed.test.service.impl;

import fr.selfmed.test.parser.ParserFormat;
import fr.selfmed.test.parser.ParserFactory;
import fr.selfmed.test.service.ExternalService;
import fr.selfmed.test.service.OutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OutputServiceImpl implements OutputService {

    private final ExternalService externalApiService;

    @Autowired
    public OutputServiceImpl(ExternalService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @Override
    public <T> String getOutput(ParserFormat inputFormat, ParserFormat outputFormat, Class<T> classType) {
        T objectToConvert = getInput(inputFormat, classType);
        return ParserFactory.getParser(outputFormat).writeObject(objectToConvert);
    }

    private <T> T getInput(ParserFormat inputFormat, Class<T> classType) {
        String data = externalApiService.getData(inputFormat).block();
        return ParserFactory.getParser(inputFormat).readObject(data, classType);
    }

}
