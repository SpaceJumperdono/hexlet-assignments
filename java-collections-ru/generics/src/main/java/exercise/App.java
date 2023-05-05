package exercise;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// BEGIN
public class App {
    public static ArrayList<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> iteratorList : books) {
            boolean flagContains = true;
            for (String keyWhere : where.keySet()) {
                if (!iteratorList.containsValue(where.get(keyWhere))) {
                    flagContains = false;
                }
            }
            if (flagContains) {
                result.add(Map.of("title", iteratorList.get("title"), "year",
                        iteratorList.get("year"), "author", iteratorList.get("author")));
            }
        }
        return result;
    }
}
//END
