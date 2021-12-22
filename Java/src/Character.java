/**
 * Representation of a Character, an Entity that can move.
 */
public class Character extends Entity {

    /**
     * Default Constructor
     * 
     * @param name Name of the character
     */

    public Character(String name) {
        super(name);
    }

    /**
     * Model constructor
     * 
     * @param name Name of the character
     * @param x    x coordinate of the character
     * @param y    y coordinate of the character
     */
    public Character(String name, int x, int y) {
        super(name, x, y);
    }

}
