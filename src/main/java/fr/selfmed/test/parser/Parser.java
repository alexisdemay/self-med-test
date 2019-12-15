package fr.selfmed.test.parser;

public abstract class Parser {

    public abstract <T> T readObject(String object, Class<T> aClass);

    public abstract <T> String writeObject(T object);

}
