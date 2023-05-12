package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> goals = new ArrayList<>(Arrays.asList(1, 2, 3));
        List take = App.take(numbers, 3);
        Assertions.assertEquals(take.size(), 3);
        Assertions.assertArrayEquals(take.toArray(), goals.toArray());
        assertThat(App.take(numbers, 3)).hasSize(3).isEqualTo(goals);
        // END
    }
}
