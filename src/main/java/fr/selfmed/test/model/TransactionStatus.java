package fr.selfmed.test.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TransactionStatus implements Serializable {

    ASSIGNED("ASSIGNED", 0),
    NOTASSIGNED("NOTASSIGNED", 1);

    @Getter
    private String display;

    @Getter
    private Integer value;

}
