package fr.selfmed.test.parser;

import org.apache.commons.lang3.StringUtils;

public enum ParserFormat {
    JSON,
    XML,
    SELF_MED,
    INVALID;
    public static ParserFormat getEnumFromString(String value) {
        ParserFormat format;
        if (StringUtils.isNotBlank(value)) {
            try {
                format = ParserFormat.valueOf(value.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {
                format = ParserFormat.INVALID;
            }
        } else {
            format = ParserFormat.INVALID;
        }
        return format;
    }
}
