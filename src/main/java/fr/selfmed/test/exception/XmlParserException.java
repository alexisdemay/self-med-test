package fr.selfmed.test.exception;

public class XmlParserException extends ParserException {

    public XmlParserException(String message) {
        super(message);
    }

    public XmlParserException(String message, Throwable throwable) {
        super(message);
    }

}
