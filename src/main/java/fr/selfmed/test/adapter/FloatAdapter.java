package fr.selfmed.test.adapter;

import java.text.DecimalFormat;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.commons.lang3.StringUtils;

public class FloatAdapter extends XmlAdapter<String, Float> {

    @Override
    public Float unmarshal(String xmlFloatValue) {
        if (StringUtils.isNotBlank(xmlFloatValue) && xmlFloatValue.contains(",")) {
            return Float.valueOf(xmlFloatValue.replace(",", "."));
        }
        return null;
    }

    @Override
    public String marshal(Float floatValue) {
        if (floatValue != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            return decimalFormat.format(floatValue);
        }
        return null;
    }

}
