package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) {
        Path fullpath = path.toAbsolutePath().normalize();
        String json = car.serialize();
        try {
            Files.writeString(fullpath, json, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) {
        Path fullpath = path.toAbsolutePath().normalize();
        String json = "";
        try {
            json = Files.readString(fullpath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Car car = Car.unserialize(json);
        return car;
    }
}
// END
