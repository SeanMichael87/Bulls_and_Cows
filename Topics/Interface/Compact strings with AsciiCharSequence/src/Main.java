import java.util.*;

class AsciiCharSequence implements CharSequence {
    byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int i) {
        return (char) array[i];
    }

    @Override
    public CharSequence subSequence(int from, int to) {
        return new AsciiCharSequence(Arrays.copyOfRange(array, from, to));
    }

    @Override
    public String toString() {
        return new String(this.array);
    }
}