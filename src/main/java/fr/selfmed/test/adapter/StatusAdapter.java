package fr.selfmed.test.adapter;

import fr.selfmed.test.model.TransactionStatus;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.commons.lang3.StringUtils;

public class StatusAdapter extends XmlAdapter<String, TransactionStatus> {

    @Override
    public TransactionStatus unmarshal(String value) {
        return StringUtils.isNotBlank(value) ? TransactionStatus.valueOf(value) : null;
    }

    @Override
    public String marshal(TransactionStatus value) {
        return value != null ? value.getDisplay() : null;
    }
}
