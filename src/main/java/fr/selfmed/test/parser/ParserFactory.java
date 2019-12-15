package fr.selfmed.test.parser;

import fr.selfmed.test.exception.InvalidFormatException;

public class ParserFactory {

    public static Parser getParser(ParserFormat format) {
        Parser parser = null;
        if (format != null) {
            switch (format) {
                case JSON:
                    parser = new JsonParser();
                    break;
                case XML:
                    parser = new XmlParser();
                    break;
                case SELF_MED:
                    parser = new SelfMedParser();
                    break;
                default:
                    throw new InvalidFormatException("The format " + format + " is invalid.");
            }
        }
        return parser;
    }

}
