package exercise;

import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String characters, String word) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char i : characters.toCharArray()) {
            chars.add(i);
        }
        for (int i = 0; i < word.length(); i++) {
            Character currentChar = Character.toLowerCase(word.charAt(i));
            if (chars.contains(currentChar)) {
                chars.remove(currentChar);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
