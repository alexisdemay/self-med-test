package fr.selfmed.test.converter;

import fr.selfmed.test.parser.ParserFormat;
import org.springframework.core.convert.converter.Converter;

public class FormatConverter implements Converter<String, ParserFormat> {

    @Override
    public ParserFormat convert(String s) {
        return ParserFormat.getEnumFromString(s);
    }

}
