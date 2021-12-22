public class Position {
    int x;
    int y;

    /**
     * Default constructor, sets 0,0 as position
     */
    public Position() {
        this(0, 0);
    }

    /**
     * Model constructor
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * Copy constructor
     * 
     * @param p Position whose coordinates will be copied
     */
    public Position(Position p) {
        this(p.getX(), p.getY());
    }

    /**
     * Returns the x coordinate
     * 
     * @return x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the y coordinate
     * 
     * @return y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the x coordinate
     * 
     * @param x new x coordinate
     */
    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        this.x = x;
    }

    /**
     * Sets the y coordinate
     * 
     * @param y new y coordinate
     */
    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException();
        }
        this.y = y;
    }

    /**
     * Outputs the position "(<x>, <y>)"
     */
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}
