
public class App {
    public static void main(String[] args) throws Exception {
        Members<Character> members = new Members<Character>(2);
        members.add(new Character("Pathfinder", 1, 2));
        members.add(new Character("Target", 7, 8));
        Board<Entity> board = new Board<Entity>(new Entity("Floor"));
        board.addAll(members);
        board.show();
    }
}
