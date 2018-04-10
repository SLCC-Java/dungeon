import java.util.*;

public class Dungeon
{
   private static int itemXAxis;
   private static int itemYAxis;
   private static int xAxis;
   private static int yAxis;
   private static Rooms[][] roomArray = new Rooms[3][3];
   
   
   public static void main (String[] args)
   {
      Random rand = new Random();
      
      Scanner input = new Scanner(System.in);
      ArrayList<Integer> roomGenerator = new ArrayList<Integer>();
      
      
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
      
      
      //PLACE ITEMS IN ROOMS
      
      ArrayList<Object> itemList = new ArrayList<Object>();
      itemXAxis = rand.nextInt(3);
      itemYAxis = rand.nextInt(3);
      //KEY
      itemList.add(roomArray[itemXAxis][itemYAxis]);
      roomArray[itemXAxis][itemYAxis].hasItem("key");
      
      //BONE
      while(itemList.contains(roomArray[itemXAxis][itemYAxis]))
      {
         itemXAxis = rand.nextInt(3);
         itemYAxis = rand.nextInt(3);
      }
      itemList.add(roomArray[itemXAxis][itemYAxis]);
      roomArray[itemXAxis][itemYAxis].hasItem("bone");
      
      //COMBINATION
      while(itemList.contains(roomArray[itemXAxis][itemYAxis]))
      {
         itemXAxis = rand.nextInt(3);
         itemYAxis = rand.nextInt(3);
      }
      itemList.add(roomArray[itemXAxis][itemYAxis]);
      roomArray[itemXAxis][itemYAxis].hasItem("combination");
      
      //CABLE CUTTERS
      while(itemList.contains(roomArray[itemXAxis][itemYAxis]))
      {
         itemXAxis = rand.nextInt(3);
         itemYAxis = rand.nextInt(3);
      }
      itemList.add(roomArray[itemXAxis][itemYAxis]);
      roomArray[itemXAxis][itemYAxis].hasItem("cable cutters");   
      

      //CREATE AN INSTANCE OF PLAYER
      System.out.print("Enter your name: ");
      String playerName = input.nextLine();
      Player player = new Player(playerName);
      
      //BEGIN GAME
      System.out.println("You wake up in a room that you don't recognize.\n The last thing you remember is going to bed at \nhome. As you stand up, a piece of paper falls to \nthe ground. You reach down and pick it up.");
      
      String option = "";
      while (!option.equals("quit"))
      {
         System.out.print("\nWhat do you do next? ");
         option = input.nextLine();
         option = option.toLowerCase();
         System.out.print(option);
         options(option);
      }
      
   }
   
   private static void options(String option)
   {
      switch (option)
      {
         case "go west": 
         case "move west":
            if(xAxis != 0)
            {
               xAxis--;
               roomArray[xAxis][yAxis].getDescription();
            }
            else
            {
               System.out.print(xAxis);
               System.out.println("You cannot go that direction.");
            }
            break;
         
      

      
      //LOOK AROUND
         case "look around": 
         case "look":
            System.out.println(roomArray[xAxis][yAxis].getDescription());
      
      
      
      }
   }
}