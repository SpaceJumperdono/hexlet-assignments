package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String path;
    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        String json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    public void set(String key, String value) {
        String readFile = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(readFile);
        map.put(key, value);
        String writeFile = Utils.serialize(map);
        Utils.writeFile(path, writeFile);
    }

    public void unset(String key) {
        String readFile = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(readFile);
        map.remove(key);
        String writeFile = Utils.serialize(map);
        Utils.writeFile(path, writeFile);
    }

    public String get(String key, String defaultValue) {
        String readFile = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(readFile);
        return map.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        String readFile = Utils.readFile(path);
        Map<String, String> map = Utils.unserialize(readFile);
        return map;
    }
}
// END
