package fr.selfmed.test.serializer;

import fr.selfmed.test.model.TransactionStatus;

public class StatusSelfMedSerializer extends SelfMedSerializer<TransactionStatus> {

    public StatusSelfMedSerializer() {
        super();
    }

    @Override
    public String writeInString(TransactionStatus source) {
        return source != null ? String.valueOf(source.getValue()) : null;
    }

}
