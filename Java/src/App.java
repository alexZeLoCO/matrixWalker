public class App {
    public static void main(String[] args) throws Exception {

        Entity wall = new Entity("Wall");

        Entity[][] map = new Entity[5][5];
        map[2][2] = wall;
        map[2][3] = wall;
        map[3][2] = wall;
        map[4][4] = wall;
        map[1][1] = wall;

        Board<Entity> board = new Board<Entity>(map.length, map.length, map, new Entity("Floor"));

        Character Target = new Character("Target", 4, 3);
        Pathfinder Pathfinder = new Pathfinder("Pathfinder", 0, 0, board, Target.getPosition());

        board.spawn(Target);
        board.spawn(Pathfinder);
        board.show();

        System.out.println(Pathfinder);
    }
}
