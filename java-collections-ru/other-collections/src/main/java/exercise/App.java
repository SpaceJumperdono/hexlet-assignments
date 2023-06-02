package exercise;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> setKeyMap1 = new HashSet<>(map1.keySet());
        Set<String> setKeyMap2 = new HashSet<>(map2.keySet());

        Set<String> deletedKey = new HashSet<>(setKeyMap1);
        deletedKey.removeAll(setKeyMap2);

        Set<String> addKey = new HashSet<>(setKeyMap2);
        addKey.removeAll(setKeyMap1);

        Set<String> containKey = new HashSet<>(setKeyMap1);
        containKey.retainAll(setKeyMap2);

        LinkedHashMap<String, String> resultDiff = new LinkedHashMap<>();

        for (String iterator : containKey) {
            if (map1.get(iterator).equals(map2.get(iterator))) {
                resultDiff.put(iterator, "unchanged");
            } else {
                resultDiff.put(iterator, "changed");
            }
        }

        for (String iterator : deletedKey) {
            resultDiff.put(iterator, "deleted");
        }

        for (String iterator : addKey) {
            resultDiff.put(iterator, "added");
        }
        return resultDiff;
    }
}
//END
