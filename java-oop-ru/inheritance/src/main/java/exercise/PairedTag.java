package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends SingleTag {
    private String text;
    private List<Tag> children;


    public PairedTag(String name, Map<String, String> attributes, String text, List<Tag> children) {
        super(name, attributes);
        this.text = text;
        this.children = children;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(text);
        for (Tag element : children) {
            stringBuilder.append(element.toString());
        }
        stringBuilder.append("</" + super.getName() + ">");
        return stringBuilder.toString();
    }


}
// END
