import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
        this.costs = new Costs();
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

    /*
     * FIXME: Not sure of implementation, may need to rethink strategy.
     * {Position -> {hCost, gCost, tCost}}
     */
    /**
     * @see Pair.java
     */
    private final class Costs implements Iterable<Pair<Position, ArrayList<Integer>>> {
        private ArrayList<Pair<Position, ArrayList<Integer>>> data;

        public Costs() {
            this(0);
        }

        public Costs(int size) {
            this.data = new ArrayList<Pair<Position, ArrayList<Integer>>>(size);
        }

        public Costs(Collection<? extends Pair<Position, ArrayList<Integer>>> c) {
            this(c.size());
            this.data.addAll(c);
        }

        public ArrayList<Position> getKeys() {
            ArrayList<Position> keys = new ArrayList<Position>(this.size());
            for (Pair<Position, ArrayList<Integer>> p : this) {
                keys.add(p.getKey());
            }
            return keys;
        }

        public int size() {
            return this.data.size();
        }

        public boolean contains(Object o) {
            if (o == null) {
                throw new NullPointerException();
            }
            return this.data.contains(o);
        }

        public boolean add(Pair<Position, ArrayList<Integer>> p) {
            if (p == null) {
                throw new NullPointerException();
            }
            if (this.contains(p)) {
                return false;
            }
            return this.data.add(p);
        }

        @Override
        public Iterator<Pair<Position, ArrayList<Integer>>> iterator() {
            return new CI();
        }

        private final class CI implements Iterator<Pair<Position, ArrayList<Integer>>> {
            private int idx;

            public CI() {
                this.idx = 0;
            }

            public boolean hasNext() {
                return this.idx < Costs.this.size();
            }

            public Pair<Position, ArrayList<Integer>> next() {
                return Costs.this.data.get(idx++);
            }

            public Position getKey() {
                return Costs.this.data.get(idx).getKey();
            }

            public ArrayList<Integer> getValue() {
                return Costs.this.data.get(idx).getValue();
            }
        }

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
