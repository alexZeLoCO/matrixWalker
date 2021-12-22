import java.util.ArrayList;
import java.util.Iterator;

public class Board<E> implements Iterable<E> {
    static private final int DEFAULT_SIZE = 10;
    private final E defaultElement;

    private E[][] back;
    private E[][] data;
    private Members<Character> members;
    private int rows;
    private int cols;

    /**
     * Default constructor
     * 
     * @param defaultElement Element to be used as null
     */
    public Board(E defaultElement) {
        this(DEFAULT_SIZE, DEFAULT_SIZE, defaultElement);
    }

    /**
     * Basic Constructor
     * 
     * @param rows           Number of rows
     * @param cols           Number of columns
     * @param defaultElement Element to be used as null
     */
    @SuppressWarnings("unchecked")
    public Board(int rows, int cols, E defaultElement) {
        this.rows = rows;
        this.cols = cols;
        this.defaultElement = defaultElement;
        this.data = (E[][]) new Object[rows][cols];
        this.fill();
        this.members = new Members<Character>();
        this.back = (E[][]) new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.back[i][j] = this.data[i][j];
            }
        }
    }

    /**
     * Model constructor. Uses an already existing E[][] matrix that will be
     * copy-pasted as board.
     * 
     * @param rows           Number of rows
     * @param cols           Number of columns
     * @param data           Matrix to be copied
     * @param defaultElement Element to be used as null
     */
    public Board(int rows, int cols, E[][] data, E defaultElement) {
        this(rows, cols, defaultElement);
        this.setData(data);
        this.fill();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.back[i][j] = this.data[i][j];
            }
        }
    }

    public Members<Character> getCharacters() {
        return this.members;
    }

    public int getNCharacters() {
        return this.members.getNElements();
    }

    @SuppressWarnings("unchecked")
    public boolean spawn(Character c) {
        if (c == null) {
            throw new NullPointerException();
        }
        if (this.legalPosition(c.getPosition()) && this.members.add(c) && this.add((E) c)) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean move(Pathfinder c, Position p) {
        if (c == null || p == null) {
            throw new NullPointerException();
        }
        if (this.legalPosition(p) && !this.members.contains(c)) {
            this.getData()[c.getY()][c.getX()] = this.back[c.getY()][c.getX()];
            c.setX(p.getX());
            c.setY(p.getY());
            this.getData()[c.getX()][c.getY()] = (E) c;
            return true;
        }
        return false;
    }

    /**
     * Returns the Default Element of the Board, this will be used as null.
     * 
     * @return Defaul element of the board.
     */
    public E getDefaultElement() {
        return this.defaultElement;
    }

    /**
     * Returns the number of rows in this board
     * 
     * @return Number of rows
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Returns the number of columns in this board
     * 
     * @return Number of columns
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * Sets a new number of rows for this board
     * 
     * @param rows New number of rows to be set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Sets a new number of columns for this board
     * 
     * @param cols New number of columns to be set
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * Returns the E[][] matrix that is represented by this board
     * 
     * @return basic matrix represented
     */
    public E[][] getData() {
        return this.data;
    }

    /**
     * Sets a new matrix to be copy-pasted as this board
     * 
     * @param data Matrix to be set as board
     */
    public void setData(E[][] data) {
        if (data == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    /**
     * Adds the element in the specific position
     * 
     * @param e   element to be added
     * @param col column where e will be added
     * @param row row where e will be added
     * @return True if the element was added successfully
     */
    public boolean add(E e, int col, int row) {
        if (e == null) {
            throw new NullPointerException();
        }
        this.getData()[row][col] = e;
        return true;
    }

    /**
     * Adds the element in the first positon possible
     * 
     * @param e element to be added
     * @return True if the element was added successfully
     */
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (e instanceof Entity && this.legalPosition(((Entity) e).getPosition())) {
            return this.add(e, ((Entity) e).getX(), ((Entity) e).getY());
        }
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                if (this.legalPosition(j, i) && this.get(j, i) == null || this.get(j, i) == this.getDefaultElement()) {
                    return this.add(e, j, i);
                }
            }
        }
        return false;
    }

    /**
     * Adds all elements to this board
     * 
     * @param e elements to be added
     * @return True if all the elements could be added correctly
     */
    @SuppressWarnings("unchecked")
    public boolean addAll(E... e) {
        for (E elem : e) {
            if (!this.add(elem)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements to this board
     * 
     * @param e elements to be added
     * @return True if all the elements were added correctly
     */
    public boolean addAll(ArrayList<? extends E> e) {
        for (E elem : e) {
            if (!this.add(elem)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Fills all null positions of the board with the default element
     */
    public void fill() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                if (this.get(j, i) == null && this.legalPosition(j, i)) {
                    this.getData()[i][j] = this.getDefaultElement();
                }
            }
        }
    }

    /**
     * Returns the element in the designated position
     * 
     * @param col Column to be searched
     * @param row Row to be searched
     * @return Element in position (col, row)
     */
    public E get(int col, int row) {
        return this.getData()[row][col];
    }

    /**
     * Removes the element in the designated position
     * 
     * @param col Column where the target element is
     * @param row Row where the target element is
     * @return The element that was removed
     */
    public E remove(int col, int row) {
        E tmp = this.get(row, col);
        this.getData()[col][row] = null;
        return tmp;
    }

    /**
     * Checks if a specific element is in the board
     * 
     * @param e Element to be searched for
     * @return True if the element is in the board
     */
    public boolean contains(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                if (this.get(j, i) == e) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board is full. Note that this also includes positions with the
     * default element
     * 
     * @return True if there is any null position in the board
     */
    public boolean isFull() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                if (this.get(j, i) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns an iterator for the board
     * 
     * @return Board iterator
     */
    public Iterator<E> iterator() {
        return new BITR();
    }

    private final class BITR implements Iterator<E> {

        int row;
        int col;

        public BITR() {
            this.row = 0;
            this.col = 0;
        }

        @Override
        public boolean hasNext() {
            return this.row < Board.this.getRows() - 1 || this.col < Board.this.getCols() - 1;
        }

        @Override
        public E next() {
            int tmpCol, tmpRow;
            tmpCol = this.col;
            tmpRow = this.row;
            if (this.col < Board.this.getCols() - 1) {
                this.col++;
            } else {
                this.row++;
                this.col = 0;
            }
            return get(tmpCol, tmpRow);

        }

    }

    // -------GAME LOGIC--------
    /**
     * Checks if the position provided is legal or not
     * 
     * @param col Column to be checked
     * @param row Row to be checked
     * @return True if the position is in the board and is not already occuppied
     */
    private boolean legalPosition(int col, int row) {
        if (col < 0 || col > this.getCols() || row < 0 || row > this.getRows()) {
            return false;
        }
        return this.get(col, row) == this.getDefaultElement() || this.get(col, row) == null;
    }

    /**
     * Checks if the position provided is legal or not
     * 
     * @param p Position to be checked
     * @return True if the position is in the board and is not already occuppied
     */
    private boolean legalPosition(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        return this.legalPosition(p.getX(), p.getY());
    }

    // -------I/O--------
    /**
     * Outputs the board on the console with board format, only the characters
     */
    public void show() {
        for (int i = 0; i < this.getCols(); i++) {
            System.out.printf("\t%d", i);
        }
        for (int i = 0; i < rows; i++) {
            System.out.printf("\n%d\t", i);
            for (int j = 0; j < cols; j++) {
                if (this.get(i, j) instanceof Entity) {
                    System.out.printf("%c\t", ((Entity) this.get(j, i)).getTag());
                }
            }
        }
        System.out.println();
    }

    /**
     * Outputs the board on the console, listing every character in it.
     */
    public String toString() {
        String out = "Board:\n";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.get(j, i) instanceof Character) {
                    out += ("\t" + this.get(j, i));
                }
            }
        }

        return out;
    }
}