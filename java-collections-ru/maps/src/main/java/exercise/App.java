package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> map = new HashMap<>();
        if (text.length() == 0) {
            return map;
        }
        String[] splittedLine = text.trim().split(" ");
        Arrays.sort(splittedLine);
        for (int i = 0; i < splittedLine.length; i++) {
            String currentWord = splittedLine[i];
            int counter = 0;
            if (!map.containsKey(splittedLine[i])) {
                for (int j = i; j < splittedLine.length; j++) {
                    if (currentWord.equals(splittedLine[j])) {
                        counter++;
                    }
                }
                map.put(currentWord, counter);
            }

        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.size() == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (String i : map.keySet()) {
            stringBuilder.append("  " + i + ": " + map.get(i) + "\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
//END
