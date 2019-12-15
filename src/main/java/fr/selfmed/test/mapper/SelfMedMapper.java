package fr.selfmed.test.mapper;

import fr.selfmed.test.annotation.SelfMedProperty;
import fr.selfmed.test.annotation.SelfMedSerialize;
import fr.selfmed.test.exception.SelfMedMapperException;
import fr.selfmed.test.serializer.SelfMedSerializer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class SelfMedMapper {

    private static final String TAB_BEFORE_FIELD = "\t";

    private static final String COLON_AFTER_FIELD = ":";

    private static final String SPACE_BEFORE_FIELD = " ";

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public SelfMedMapper() {
        // Empty constructor
    }

    public <T> String writeValueAsString(T object) {
        StringBuilder sb = new StringBuilder();
        construct(object, sb);
        return sb.toString();
    }

    private <T> void construct(T object, StringBuilder sb) {
        try {
            List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());
            for (Field field : fields) {
                if (List.class.equals(field.getType())) {
                    field.setAccessible(true);
                    Object o1 = field.get(object);
                    List<T> listOfObjects = (List<T>) o1;
                    String name = getFieldName(field);
                    for (T o : listOfObjects) {
                        sb.append(name).append(COLON_AFTER_FIELD).append(LINE_SEPARATOR);
                        construct(o, sb);
                    }
                } else {
                    field.setAccessible(true);
                    Object o1 = field.get(object);
                    String name = getFieldName(field);
                    String value = getFieldValue(field, o1);
                    sb.append(TAB_BEFORE_FIELD).append(name).append(COLON_AFTER_FIELD)
                            .append(SPACE_BEFORE_FIELD).append(value).append(LINE_SEPARATOR);

                }
            }
        } catch (IllegalAccessException e) {
            throw new SelfMedMapperException("An error has occurred while writing self-med object",
                    e);
        }
    }

    private String getFieldName(Field field) {
        if (field.isAnnotationPresent(SelfMedProperty.class)) {
            String name = field.getAnnotation(SelfMedProperty.class).name();
            return StringUtils.isNotEmpty(name) ? name : field.getName();
        } else {
            return field.getName();
        }
    }

    private String getFieldValue(Field field, Object object) {
        try {
            if (field.isAnnotationPresent(SelfMedSerialize.class)) {
                Class<? extends SelfMedSerializer> serializer = field
                        .getAnnotation(SelfMedSerialize.class).using();
                Constructor<? extends SelfMedSerializer> constructor = serializer.getConstructor();
                Method serializeMethod = serializer.getMethod("writeInString", field.getType());
                return (String) serializeMethod.invoke(constructor.newInstance(), object);
            } else {
                return object.toString();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new SelfMedMapperException(
                    "An error has occurred while getting field " + object.getClass(), e);
        }
    }

}
