package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> storage = new HashMap<>();

    public InMemoryKV(Map<String, String> map) {
        storage.putAll(map);
    }

    public void set(String key, String value) {
        storage.put(key, value);
    }

    public void unset(String key) {
        storage.remove(key);
    }

    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        HashMap<String, String> copyStorage = new HashMap<>();
        copyStorage.putAll(storage);
        return copyStorage;

    }
}
// END
