package fr.selfmed.test.parser;

import fr.selfmed.test.exception.ParserException;
import fr.selfmed.test.exception.XmlParserException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlParser extends Parser {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T readObject(String object, Class<T> aClass) throws ParserException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(aClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(object);
            return (T) unmarshaller.unmarshal(stringReader);
        } catch (JAXBException e) {
            throw new XmlParserException("An error has occurred during reading xml object", e);
        }
    }

    @Override
    public <T> String writeObject(T object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", false);
            StringWriter sw = new StringWriter();
            marshaller.marshal(object, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new XmlParserException("An error has occurred during reading xml object", e);
        }
    }

}
