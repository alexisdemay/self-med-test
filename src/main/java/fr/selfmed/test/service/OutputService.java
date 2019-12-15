package fr.selfmed.test.service;

import fr.selfmed.test.parser.ParserFormat;

public interface OutputService {

    <T> String getOutput(ParserFormat inputFormat, ParserFormat outputFormat, Class<T> classType);

}
