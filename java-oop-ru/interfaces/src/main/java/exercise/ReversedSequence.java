package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String string;
    public ReversedSequence(String string) {
        this.string = new StringBuilder(string).reverse().toString();
    }

    public int length() {
        return string.length();
    }

    public char charAt(int index) {
        return string.charAt(index);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return string.subSequence(i, i1);
    }

    @Override
    public String toString() {
        return string;
    }
}
// END
