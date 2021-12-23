import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representation of variable-size list of Characters
 */
public class Members<E> extends ArrayList<E> {

    private static final int DEFAULT_SIZE = 3;
    private ArrayList<E> data;
    private int nElements;

    /**
     * Default constructor
     */
    public Members() {
        this(DEFAULT_SIZE);
    }

    /**
     * Sized constructor
     * 
     * @param size Size of the array
     */
    public Members(int size) {
        this.data = new ArrayList<E>(size);
    }

    /**
     * Sized constructor with starting content
     * 
     * @param size Size of the array
     * @param e    Elements to be added to the array
     */
    @SafeVarargs
    public Members(int size, E... e) {
        this(size);
        for (E elem : e) {
            this.add(elem);
        }
    }

    /**
     * Starting content constructor
     * 
     * @param e Elements to tbe added to the array
     */
    @SafeVarargs
    public Members(E... e) {
        this(e.length, e);
    }

    /**
     * Copy constructor
     * 
     * @param al ArrayList to be copied
     */
    public Members(ArrayList<E> al) {
        this(al.size());
        this.addAll(al);
    }

    /**
     * Returns the number of elements in this array
     * 
     * @return Number of elements int his array
     */
    public int getNElements() {
        return this.nElements;
    }

    /**
     * Adds the element to the array if it is not already in. Resizes if needed.
     * 
     * @param e Element to be added
     * @return True if the element was added successfully
     */
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

    /**
     * Increses the size of the array by a given multiplier
     * 
     * @param multiplier Times the size will be incremented
     * @return True if the size was incremented successfully
     */
    public boolean resize(int multiplier) {
        if (multiplier < 1) {
            throw new IllegalArgumentException();
        }
        ArrayList<E> neu = new ArrayList<E>(this.size() * multiplier);
        neu.addAll(this.data);
        this.data = neu;
        return true;
    }

    /**
     * Removes the element from the array if possible
     * 
     * @param e Element to be removed
     * @return True if the element was removed successfully
     */
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

    /**
     * Checks if the element is in the array
     * 
     * @param e Element to be searched
     * @return True if the element was found in the array
     */
    @Override
    public boolean contains(Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.getNElements(); i++) {
            if (this.data.get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this members list is empty
     * 
     * @return True if there are no members in this list
     */
    public boolean isEmpty() {
        for (E e : this) {
            if (e != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes every element from this list
     */
    public void clear() {
        if (this.data == null) {
            throw new NullPointerException();
        }

        ArrayList<E> prevData = new ArrayList<E>(this.data);
        for (E e : prevData) {
            this.remove(e);
        }
    }

    /**
     * Returns an iterator
     * 
     * @return An iterator for this array
     */
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

    /**
     * Outputs the elements of the array
     */
    @Override
    public String toString() {
        return String.format("%s", this.data);
    }
}
