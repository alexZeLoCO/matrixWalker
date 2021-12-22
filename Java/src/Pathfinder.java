/**
 * Representation of a character that will pathfind to a given position -usually
 * to another Character, named Target-.
 */
public class Pathfinder extends Character {

    /**
     * Basic constructor
     * 
     * @param name Name of the Pathfinder
     */
    public Pathfinder(String name) {
        super(name);
    }

    /**
     * Model constructor
     * 
     * @param name Name of the Pathfinder
     * @param x    x coordinate of the Pathfinder
     * @param y    y coordinate of the Pathfinder
     */
    public Pathfinder(String name, int x, int y) {
        super(name, x, y);
    }

    /**
     * Moves the Pathfinder's position once to the north (x-1)
     */
    public void moveNorth() {
        this.setX(this.getX() - 1);
    }

    /**
     * Moves the Pathfinder's position once to the south (x+1)
     */
    public void moveSouth() {
        this.setX(this.getX() + 1);
    }

    /**
     * Moves the Pathfinder's position once to the east (y+1)
     */
    public void moveEast() {
        this.setY(this.getY() + 1);
    }

    /**
     * Moves the Pathfinder's position once to the west (y-1)
     */
    public void moveWest() {
        this.setY(this.getY() - 1);
    }

}
