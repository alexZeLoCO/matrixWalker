import java.util.ArrayList;

/**
 * Representation of a character that will pathfind to a given position -usually
 * to another Character, named Target-.
 */
public class Pathfinder extends Character {

    private Board<Entity> playground;
    private Position target;

    private Costs costs;

    /**
     * Basic constructor
     * 
     * @param name Name of the Pathfinder
     */
    public Pathfinder(String name) {
        this(name, 0, 0);
    }

    /**
     * Model constructor
     * 
     * @param name Name of the Pathfinder
     * @param x    x coordinate of the Pathfinder
     * @param y    y coordinate of the Pathfinder
     */
    public Pathfinder(String name, int x, int y) {
        this(name, x, y, null, null);
    }

    /**
     * Creates a Pathfinder aware of its surroundings
     * 
     * @param name       Name of the Pathfinder
     * @param playground Board where the Pathfinder is
     */
    public Pathfinder(String name, Board<Entity> playground) {
        this(name, 0, 0, playground, null);
    }

    /**
     * Creates a Pathfinder aware of its surroundings with a custom spawnpoint
     * 
     * @param name       Name of the pathfinder
     * @param x          x coordinate of the pathfinder
     * @param y          y coordinate of the pathfinder
     * @param playground Board where the Pathfinder is
     */
    public Pathfinder(String name, int x, int y, Board<Entity> playground) {
        this(name, x, y, playground, null);
    }

    /**
     * Creates a Pathfinder aware of its surroundings, with a custom spawnpoint and
     * a target to go towards
     * 
     * @param name       Name of the Pathfinder
     * @param x          x coordinate of the Pathfinder
     * @param y          y coordinate of the Pathfinder
     * @param playground Board where the Pathfinder is
     * @param target     Position where the Pathfinder will go
     */
    public Pathfinder(String name, int x, int y, Board<Entity> playground, Position target) {
        super(name, x, y);
        this.playground = playground;
        this.target = target;
        this.costs = new Costs(new Position(playground.getRows(), playground.getCols()));
    }

    /**
     * Changes the target position of the Pathfinder
     * 
     * @param p New position to target
     * @return True if the position was switched successfully
     */
    public boolean setTarget(Position p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (this.playground.legalPosition(p)) {
            this.target = p;
            return true;
        }
        return false;
    }

    /**
     * Returns the target position of this Pathfinder
     * 
     * @return Position where the Pathfinder is going
     */
    public Position getTarget() {
        return this.target;
    }

    /**
     * Returns the Board where the Pathfinder is
     * 
     * @return Board where the Pathfinder is
     */
    public Board<Entity> getPlayground() {
        return this.playground;
    }

    /**
     * Moves the Pathfinder's position once to the north (x-1)
     */
    @Deprecated
    public void moveNorth() {
        this.setX(this.getX() - 1);
    }

    /**
     * Moves the Pathfinder's position once to the south (x+1)
     */
    @Deprecated
    public void moveSouth() {
        this.setX(this.getX() + 1);
    }

    /**
     * Moves the Pathfinder's position once to the east (y+1)
     */
    @Deprecated
    public void moveEast() {
        this.setY(this.getY() + 1);
    }

    /**
     * Moves the Pathfinder's position once to the west (y-1)
     */
    @Deprecated
    public void moveWest() {
        this.setY(this.getY() - 1);
    }

    /**
     * Checks if this Pathfinder is aware of its surroundings
     * 
     * @return True if the Pathfinder has a playground
     */
    public boolean isAware() {
        return this.playground != null;
    }

    /**
     * Checks if this Pathfinder has a target
     * 
     * @return True if the Pathfinder is heading somewhere
     */
    public boolean hasTarget() {
        return this.target != null;
    }

    // ----- MATH MODULE -----
    /**
     * Calculates the distance to a given position, given that one coordinate equals
     * 10 units of distance.
     * 
     * @param p Destination
     * @return Distante to destination
     */
    private int distanceTo(Position p) {
        return (int) (Position.distance(this.getPosition(), p) * 10);
    }

    /**
     * Calculates the distance to the target, given that one coordinate equals 10
     * units of distance.
     * 
     * @return Distance to target
     */
    private int distanceToTarget() {
        return this.distanceTo(this.getTarget());
    }

    public ArrayList<Position> getAdyacents() {
        if (!this.isAware()) {
            throw new IllegalStateException("This Pathfinder is not Aware");
        }
        ArrayList<Position> adyacents = new ArrayList<Position>();
        Position test = new Position(this.getPosition());
        // Testing East
        test.setX(test.getX() + 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        // Testing NorthEast
        test.setY(test.getY() - 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        // Testing North
        test.setX(test.getX() - 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        // Testing NorthWest
        test.setX(test.getX() - 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        // Testing West
        test.setY(test.getY() + 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        // Testing SouthWest
        test.setY(test.getY() + 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        // Testing South
        test.setX(test.getX() + 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        // Testing SouthEast
        test.setX(test.getX() + 1);
        if (this.playground.legalPosition(test)) {
            adyacents.add(test);
        }
        return adyacents;
    }

    public ArrayList<Position> pathfindToTarget() {
        if (!this.isAware()) {
            throw new IllegalStateException("This Pathfinder is not Aware");
        }
        if (!this.hasTarget()) {
            throw new IllegalStateException("This Pathfinder has no Target");
        }
        ArrayList<Position> accessible = new ArrayList<Position>();
        ArrayList<Position> path = new ArrayList<Position>();
        while (!path.contains(this.getTarget())) {
            path.add(this.getPosition());
            ArrayList<Position> adyacent = this.getAdyacents();
            adyacent.removeAll(path);
            accessible.addAll(adyacent);
        }
        return path;

    }

    // ----- I / O -----
    @Override
    public String toString() {
        String aware = "Unaware of its surroundings";
        if (this.isAware()) {
            aware = "Aware of its surroundings";
        }
        if (this.hasTarget()) {
            return String.format("%s\tGoing towards: %s\n\t%s", super.toString(), this.target.toString(), aware);
        }
        return String.format("%s\tGoing towards: %s\n\t%s", super.toString(), "No target", aware);
    }

}
