package exercise;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

// BEGIN
class AppTest {

    @Test
    void enlargeArrayImageTest() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };
        String[][] result = App.enlargeArrayImage(image);
        for (int i = 0; i < expected.length; i++) {
            List<Object> expectedList = Arrays.asList(expected[i]);
            List<Object> resultList = Arrays.asList(result[i]);
            Assertions.assertEquals(expectedList, resultList);
        }
    }
}
// END
