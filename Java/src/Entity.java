/**
 * Representation of an Entity, which can be a moving or inmutable being.
 */
public class Entity {
    private String name;
    private char tag;
    private Position position;

    /**
     * Default constructor
     * 
     * @param name Name for the entity
     */
    public Entity(String name) {
        this(name, 0, 0);
    }

    /**
     * Model Constructor
     * 
     * @param name Name for the entity
     * @param x    x coordinate of the entity
     * @param y    y coordinate of the entity
     */
    public Entity(String name, int x, int y) {
        this.name = name;
        this.tag = name.charAt(0);
        this.position = new Position(x, y);
    }

    /**
     * Sets the given name for this entity
     * 
     * @param name New name to be given to this entity
     */
    public void setName(String name) {
        this.name = name;
        this.tag = name.charAt(0);
    }

    /**
     * Returns the tag of this entity (first character of the name)
     * 
     * @return first character of the name
     */
    public char getTag() {
        return this.tag;
    }

    /**
     * Returns the name of this entity
     * 
     * @return Name of this entity
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the position of this entity
     * 
     * @return Position of this entity
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * Returns the x coordinate of this entity
     * 
     * @return x coordinate of this entity
     */
    public int getX() {
        return this.position.getX();
    }

    /**
     * Returns the y coordinate of this entity
     * 
     * @return y coordinate of this entity
     */
    public int getY() {
        return this.position.getY();
    }

    /**
     * Sets the x coordinate of this entity
     * 
     * @param x x coordinate of this entity
     */
    public void setX(int x) {
        this.position.setX(x);
    }

    /**
     * Sets the y coordinate of this entity
     * 
     * @param y y coordinate of this entity
     */
    public void setY(int y) {
        this.position.setY(y);
    }

    /**
     * Outputs the information of this entity "<name> (<tag>) at <position>"
     */
    @Override
    public String toString() {
        return String.format("%s (%c) at %s\n", this.name, this.tag, this.position);
    }
}
