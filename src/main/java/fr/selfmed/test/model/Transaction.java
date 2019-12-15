package fr.selfmed.test.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.selfmed.test.adapter.FloatAdapter;
import fr.selfmed.test.adapter.LocalDateAdapter;
import fr.selfmed.test.adapter.StatusAdapter;
import fr.selfmed.test.annotation.SelfMedSerialize;
import fr.selfmed.test.serializer.FloatSelfMedSerializer;
import fr.selfmed.test.serializer.LocalDateStdDeserializer;
import fr.selfmed.test.serializer.LocalDateStdSerializer;
import fr.selfmed.test.serializer.StatusSelfMedSerializer;
import java.io.Serializable;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction implements Serializable {

    @XmlAttribute(name = "id")
    private Long id;

    @XmlAttribute(name = "date")
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @JsonSerialize(using = LocalDateStdSerializer.class)
    @JsonDeserialize(using = LocalDateStdDeserializer.class)
    private LocalDate date;

    @XmlElement(name = "label")
    private String label;

    @XmlElement(name = "amount")
    @XmlJavaTypeAdapter(value = FloatAdapter.class)
    @SelfMedSerialize(using = FloatSelfMedSerializer.class)
    private Float amout;

    @XmlElement(name = "status")
    @XmlJavaTypeAdapter(value = StatusAdapter.class)
    @SelfMedSerialize(using = StatusSelfMedSerializer.class)
    private TransactionStatus status;

}
