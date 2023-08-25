package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartmensts, int value) {
        List<String> list = new ArrayList<>();
        Collections.sort(apartmensts);
        if (value <= apartmensts.size()) {
            for (int i = 0; i < value; i++) {
                list.add(apartmensts.get(i).toString());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }
}
// END
