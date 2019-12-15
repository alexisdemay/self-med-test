package fr.selfmed.test.serializer;

public abstract class SelfMedSerializer<S> {

    protected SelfMedSerializer() {
        // Empty constructor
    }

    public abstract String writeInString(S source);

}