package fr.selfmed.test.model;

import fr.selfmed.test.annotation.SelfMedProperty;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transactions implements Serializable {

    @XmlElement(name = "transaction")
    @SelfMedProperty(name = "transaction")
    private List<Transaction> transactions;

}
