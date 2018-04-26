import java.util.Scanner;

public class EscapeGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Escape Game!\nWould you like to play a game?\nYes\\No");
        String decision = input.nextLine().toLowerCase();
        while (!decision.equals("yes") && !decision.equals("no") && !decision.equals("quit")) {
            decision = input.nextLine();
        }
        if(decision.equals("yes")) {
            Dungeon dungeon = new Dungeon();
            System.out.println("What is your name?");
            Player player = new Player(input.nextLine(), dungeon.getStartLocation());
            dungeon.start(player);
            while (!dungeon.escaped) {
                player.options(input.nextLine(), dungeon.getRoom(player.getLocation()), dungeon);
                dungeon.getRoom(player.getLocation()).getDescription();
            }
            dungeon.endgame();
        }

        input.close();
    }
}