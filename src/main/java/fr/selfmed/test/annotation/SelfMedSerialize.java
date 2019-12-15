package fr.selfmed.test.annotation;

import fr.selfmed.test.serializer.SelfMedSerializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SelfMedSerialize {

    Class<? extends SelfMedSerializer> using();

}
