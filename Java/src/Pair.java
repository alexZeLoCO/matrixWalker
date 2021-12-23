public class Pair<k, v> {
    private k key;
    private v value;

    public Pair(k k, v v) {
        this.key = k;
        this.value = v;
    }

    public k getKey() {
        return this.key;
    }

    public v getValue() {
        return this.value;
    }

    public void setKey(k k) {
        if (k == null) {
            throw new NullPointerException();
        }
        this.key = k;
    }

    public void setValue(v v) {
        if (v == null) {
            throw new NullPointerException();
        }
        this.value = v;
    }

    @Override
    public String toString() {
        return String.format("%o --> %o", key.toString(), value.toString());
    }
}
