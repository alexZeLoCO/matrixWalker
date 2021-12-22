import java.util.ArrayList;
import java.util.Iterator;

public class Members<E> extends ArrayList<E> {

    private static final int DEFAULT_SIZE = 3;
    private ArrayList<E> data;
    private int nElements;

    public Members() {
        this(DEFAULT_SIZE);
    }

    public Members(int size) {
        this.data = new ArrayList<E>(size);
    }

    @SafeVarargs
    public Members(int size, E... e) {
        this(size);
        for (E elem : e) {
            this.add(elem);
        }
    }

    public Members(ArrayList<E> al) {
        this(al.size());
        this.addAll(al);
    }

    public int getNElements() {
        return this.nElements;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (this.contains(e)) {
            return false;
        }
        if (this.nElements == this.size() - 1) {
            this.resize(2);
        }
        this.data.add(e);
        this.nElements++;
        return true;
    }

    public boolean resize(int multiplier) {
        if (multiplier < 1) {
            throw new IllegalArgumentException();
        }
        ArrayList<E> neu = new ArrayList<E>(this.size() * multiplier);
        neu.addAll(this.data);
        this.data = neu;
        return true;
    }

    @Override
    public boolean remove(Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (this.contains(e)) {
            if (this.data.remove(e)) {
                this.nElements--;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean contains(Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.data.get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MITR();
    }

    private final class MITR implements Iterator<E> {

        int idx;

        public MITR() {
            this.idx = 0;
        }

        @Override
        public boolean hasNext() {
            return idx < Members.this.getNElements();
        }

        @Override
        public E next() {
            return Members.this.data.get(idx++);
        }

    }

    @Override
    public String toString() {
        return String.format("%s\n", this.data);
    }
}
