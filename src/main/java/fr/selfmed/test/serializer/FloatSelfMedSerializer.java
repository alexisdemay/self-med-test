package fr.selfmed.test.serializer;

import java.text.DecimalFormat;

public class FloatSelfMedSerializer extends SelfMedSerializer<Float> {

    public FloatSelfMedSerializer() {
        super();
    }

    @Override
    public String writeInString(Float numberInFloat) {
        if (numberInFloat != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            return decimalFormat.format(numberInFloat).replace(",", "");
        } else {
            return null;
        }
    }

}
