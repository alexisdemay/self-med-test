package fr.selfmed.test.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.commons.lang3.StringUtils;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String date) {
        return StringUtils.isNotBlank(date) ? LocalDate.parse(date, DATE_FORMAT) : null;
    }

    @Override
    public String marshal(LocalDate date) {
        return date != null ? date.format(DATE_FORMAT) : null;
    }

}
