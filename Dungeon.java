import java.util.Scanner;

public class Dungeon
{
   
   public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter your name: ");
      String playerName = input.nextLine();
      player player = new player(playerName);
   }
}