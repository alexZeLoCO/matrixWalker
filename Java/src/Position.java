/**
 * Representation of a position in a plane of coordinates
 */
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
        this.x = x;
    }

    /**
     * Sets the y coordinate
     * 
     * @param y new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calculates a new position by increasing / decreasing the coordinate(s).
     * 1 stands for South-West
     * 2 stands for South
     * 3 stands for South-East
     * 4 stands for West
     * 5 is not valid
     * 6 stands for East
     * 7 stands for North-West
     * 8 stands for North
     * 9 stands for North-East
     * Any other number is not valid
     * 
     * @param p Position to be updated
     * @param d Direction of the update
     * @return Updated position
     */
    public static Position calculateNewPosition(Position p, int d) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (d < 1 || d > 9 || d == 5) {
            throw new IllegalArgumentException("Direction is not valid");
        }
        Position neu = new Position(p);
        switch (d) {
            case (1):
                neu.setX(neu.getX() - 1);
                neu.setY(neu.getY() + 1);
                break;
            case (2):
                neu.setY(neu.getY() + 1);
                break;
            case (3):
                neu.setX(neu.getX() + 1);
                neu.setY(neu.getY() + 1);
                break;
            case (4):
                neu.setX(neu.getX() - 1);
                break;
            case (6):
                neu.setX(neu.getX() + 1);
                break;
            case (7):
                neu.setX(neu.getX() - 1);
                neu.setY(neu.getY() - 1);
                break;
            case (8):
                neu.setY(neu.getY() - 1);
                break;
            case (9):
                neu.setX(neu.getX() + 1);
                neu.setY(neu.getY() - 1);
                break;
        }
        return neu;
    }

    /**
     * Returns the distance between two positions, given that one coordinate equals
     * one unit of distance measure
     * 
     * @param a Position 1
     * @param b Position 2
     * @return Distance between to positions
     */
    public static double distance(Position a, Position b) {
        return Math.sqrt(Math.pow(Math.abs(a.getX() - b.getX()), 2) + Math.pow(Math.abs(a.getY() - b.getY()), 2));
    }

    /**
     * Outputs the position "(<x>, <y>)"
     */
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}
