package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> nullField = new ArrayList<>();
        try {
            Class<?> clazz = address.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        nullField.add(field.getName());
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return nullField;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> log = new HashMap<>();
        try {
            Class<?> clazz = address.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (field.get(address) == null) {
                        log.put(field.getName(), new ArrayList<>());
                        log.get(field.getName()).add("can not be null");
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    if (field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength()) {
                        if (!log.containsKey(field.getName())) {
                            log.put(field.getName(), new ArrayList<>());
                        }
                        log.get(field.getName()).add("length less than 4");
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return log;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
        System.out.println(notValidFields);
    }
}
// END
