package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Set<Map.Entry<String, String>> copy = storage.toMap().entrySet();
        for (Entry<String, String> i : copy) {
            storage.unset(i.getKey());
            storage.set(i.getValue(), i.getKey());
        }
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("foo", "bar", "bar", "zoo"));
        App.swapKeyValue(storage);

    }
}
// END
