package exercise;

import java.util.List;
import java.util.Objects;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        int countFreeMails = (int) emails.stream()
                .filter(mail -> Objects.nonNull(mail))
                .filter(mail -> mail.endsWith("@gmail.com") || mail.endsWith("@yandex.ru")
                        || mail.endsWith("@hotmail.com"))
                .count();
        return countFreeMails;
    }

}
// END
