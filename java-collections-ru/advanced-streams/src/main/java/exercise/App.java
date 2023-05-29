package exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        return Stream.of(content)
                .flatMap(string -> Stream.of(string.split("\n")))
                .filter(string -> string.startsWith("environment="))
                .map(string -> {
                    int indexOfBeginningVar = string.indexOf("\"") + 1;
                    int indexOfEndVar = string.lastIndexOf("\"");
                    return string.substring(indexOfBeginningVar, indexOfEndVar);
                })
                .flatMap(string -> Stream.of(string.split(",")))
                .filter(element -> element.startsWith("X_FORWARDED_"))
                .map(element -> element.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
