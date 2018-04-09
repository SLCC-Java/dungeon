import java.util.*;

public class Dungeon
{
   
   public static void main (String[] args)
   {
      Random rand = new Random();
      Rooms[][] roomArray = new Rooms[3][3];
      Scanner input = new Scanner(System.in);
      ArrayList<Integer> roomGenerator = new ArrayList<Integer>();
      int xAxis;
      int yAxis;
      
      
      //CREATE ROOM GRID
      int roomInitializer = rand.nextInt(9);
      ArrayList<Integer> numUsed = new ArrayList<Integer>(); 
         
         for(int i = 0; i < 3; ++i)
         {
            for(int j = 0; j < 3; ++j)
            {
               if(roomInitializer == 1)
               {
                  xAxis = j;
                  yAxis = i;
                  
               }
               roomArray[i][j] = new Rooms(roomInitializer);
               while (numUsed.contains(roomInitializer))
               {
                  roomInitializer = rand.nextInt(9);
               }
            }
         }
         
      

      //CREATE AN INSTANCE OF PLAYER
      System.out.print("Enter your name: ");
      String playerName = input.nextLine();
      Player player = new Player(playerName);
      
      //BEGIN GAME
      System.out.println("You wake up in a room that you don't recognize.\n The last thing you remember is going to bed at \nhome. As you stand up, a piece of paper falls to \nthe ground. You reach down and pick it up.");
      System.out.print("\nWhat do you do next? ");
      String option = string.toLowerCase(input.nextLine());
      
      
   }
   
   private void options(String option)
   {
      //MOVE IN A DIRECTION
      if (option == "go west" || option == "move west")
      {
         if(xAxis != 0)
         {
            xAxis--;
            roomArray[xAxis][yAxis].getDescription;
         }
      }
      
      //LOOK AROUND
   }
}