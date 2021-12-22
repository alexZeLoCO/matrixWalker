public class Pathfinder extends Character {

    public Pathfinder(String name) {
        super(name);
    }

    public Pathfinder(String name, int x, int y) {
        super(name, x, y);
    }

    public void moveNorth() {
        this.setX(this.getX() - 1);
    }

    public void moveSouth() {
        this.setX(this.getX() + 1);
    }

    public void moveEast() {
        this.setY(this.getY() + 1);
    }

    public void moveWest() {
        this.setY(this.getY() - 1);
    }

}
