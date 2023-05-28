package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] arr) {
        return Arrays.stream(arr)
                .flatMap(i -> {
                    String[] doubleArray = new String[i.length * 2];
                    for (int j = 0; j < i.length; j++) {
                        doubleArray[j * 2] = i[j];
                        doubleArray[j * 2 + 1] = i[j];
                    }
                    return Stream.of(doubleArray, doubleArray);
                })
                .toArray(String[][]::new);
    }
}
// END
