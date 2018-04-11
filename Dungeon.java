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
            numUsed.add(roomInitializer);
            while (numUsed.contains(roomInitializer) && numUsed.size() != 9)
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
         options(option);
      }
      
   }
   
   //USER INPUT OPTIONS
   private static void options(String option)
   {
      switch (option)
      {
         case "go west": 
         case "move west":
            if(xAxis != 0)
            {
               xAxis--;
               System.out.println(roomArray[xAxis][yAxis].getDescription());
            }
            else
            {
               messages(1);
            }
            break;
         
         case "go east":
         case "move east":
            if (xAxis != 2)
            {
               xAxis++;
               System.out.println(roomArray[xAxis][yAxis].getDescription());
            }
            else
            {
               messages(1);
            }
            break;
            
         case "go north":
         case "move north":
            if (yAxis != 0)
            {
               yAxis--;
               System.out.println(roomArray[xAxis][yAxis].getDescription());
            }
            else
            {
               messages(1);
            }
            break;
            
         case "go south":
         case "move south":
            if (yAxis != 2)
            {
               yAxis++;
               System.out.println(roomArray[xAxis][yAxis].getDescription());
            }
            else
            {
               messages(1);
            }
            break;
         

         
      

      
         //LOOK AROUND
         case "look around": 
         case "look":
            System.out.println(roomArray[xAxis][yAxis].getDescription());
            break;
         case "search garbage can":
         case "search garbage":
            if (roomArray[xAxis][yAxis].getRoom().equals("kitchen"))
            {
               if (roomArray[xAxis][yAxis].checkKey())
               {
               
               }
            }
         
         case "search dresser":
         
         case "search medicine cabinet":
         case "search cabinet":
         
         case "search bookshelf":
         case "search book shelf":
         case "search shelf":
         
         case "search desk":
         case "search metal desk":
         
         case "search armoire":
         
         case "search car":
         
         case "search box":
         case "search metal box":
         
         case "search coat rack":
         case "search rack":
            break;
         
         //ERROR MESSAGE
         default: 
            System.out.println("I don't understand. Type 'help' to see list of possible commands.");

      }
   }
   
   //REUSABLE MESSAGES
   private static void messages(int choice)
   {
      if (choice == 1)
      {
         System.out.println("You cannot go in that direction");
      }
   }
}