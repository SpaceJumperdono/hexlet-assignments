package exercise;

// BEGIN
public abstract class Tag {
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public abstract String toString();

    public String getName() {
        return name;
    }
}
// END
