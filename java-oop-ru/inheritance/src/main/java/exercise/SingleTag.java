package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    private Map<String, String> attributes;

    public SingleTag(String name, Map<String, String> attributes) {
        super(name);
        this.attributes = attributes;
    }

    public String toString() {
        if (attributes.isEmpty()) {
            return "<" + super.getName() + ">";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> iterator : attributes.entrySet()) {
            stringBuilder.append(iterator.getKey() + "=" + "\"" + iterator.getValue() + "\"" + " ");
        }
        String removeSpace = stringBuilder.toString().trim();
        return "<" + super.getName() + " " + removeSpace + ">";
    }

    public static void main(String[] args) {
        Tag img = new SingleTag("img", Map.of());
        System.out.println(img.toString());
    }

}
// END
