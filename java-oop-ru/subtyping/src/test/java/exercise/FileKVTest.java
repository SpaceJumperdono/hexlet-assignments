package exercise;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


// BEGIN
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    public void setTest() throws IOException {
        FileKV fileKV = new FileKV("src/test/resources/file", Map.of("key1", "value1", "key2", "value2"));
        fileKV.set("key3", "value3");
        String actual = Files.readString(filepath);
        Map<String, String> expected = Map.of("key1", "value1", "key2", "value2", "key3", "value3");
        assertThat(actual).isEqualTo(expected);
    }

    public void unsetTest() throws IOException {
        FileKV fileKV = new FileKV("src/test/resources/file", Map.of("key1", "value1", "key2", "value2"));
        fileKV.unset("key2");
        String actual = Files.readString(filepath);
        Map<String, String> expected = Map.of("key1", "value1");
        assertThat(actual).isEqualTo(expected);
    }

    public void getTest() {
        FileKV fileKV = new FileKV("src/test/resources/file", Map.of("key1", "value1", "key2", "value2"));
        String actual = fileKV.get("key1", "defaultValue");
        assertThat(actual).isEqualTo("value1");
    }

    public void toMapTest() {
        FileKV fileKV = new FileKV("src/test/resources/file", Map.of("key1", "value1", "key2", "value2"));
        Map<String, String> actual = fileKV.toMap();
        Map<String, String> expected = Map.of("key1", "value1", "key2", "value2");
        assertThat(actual).isEqualTo(expected);
    }

    // END
}
