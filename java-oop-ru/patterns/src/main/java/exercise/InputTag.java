package exercise;

// BEGIN
public class InputTag implements TagInterface {
    private String type;
    private String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String render() {
        return "<input type=\"" + type + "\" " + "value=" + "\"" + value + "\"" + ">";
    }

    public static void main(String[] args) {
        var tmp = new InputTag("submit", "Save");
        var labelTag = new LabelTag("Press Submit", tmp);
        System.out.println(labelTag.render());
    }
}
// END
