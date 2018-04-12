import java.util.*;

public class Dungeon
{
   private static int itemXAxis;
   private static int itemYAxis;
   private static int xAxis;
   private static int yAxis;
   private static Rooms[][] roomArray = new Rooms[3][3];
   private static Player player = new Player();
   private static boolean endGame;
   private static ExitRoom exitRoom = new ExitRoom();

   
   
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
      player.setName(playerName);
            
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
      
      //END GAME
      if (endGame)
      {
         System.out.println("You walk out into the blazing midday sun. It takes a moment for your eyes to adjust, and when they do you're struck with horror. Your hometown lies in ruins before you. Demolished buildings scatter the street, and there is not a soul in  sight. A newspaper blows by in the wind. You pick it up, and the date immediately jumps out at you. The year is 2218. You’ve somehow been asleep for 200 years.");
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
               System.out.println(roomArray[yAxis][xAxis].getDescription());
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
               System.out.println(roomArray[yAxis][xAxis].getDescription());
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
               System.out.println(roomArray[yAxis][xAxis].getDescription());
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
               System.out.println(roomArray[yAxis][xAxis].getDescription());
            }
            else
            {
               messages(1);
            }
            break;
         

         
      

      
         //LOOK AROUND
         case "look around": 
         case "look":
            System.out.println(roomArray[yAxis][xAxis].getDescription());
            break;
            
         //SEARCH
         case "search garbage can":
         case "search garbage":
            if (roomArray[yAxis][xAxis].getRoom().equals("kitchen"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the garbage, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the garbage you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the garbage you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the garbage you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the trash, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            break;
         
         case "search dresser":
            if (roomArray[yAxis][xAxis].getRoom().equals("bedroom"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In one of the dresser drawers, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In one of the dresser drawers, you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In one of the dresser drawers you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In one of the dresser drawers you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the dresser, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            break;

         
         case "search medicine cabinet":
         case "search cabinet":
            if (roomArray[yAxis][xAxis].getRoom().equals("bathroom"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the medicine cabinet, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the medicine cabinet you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the medicine cabinet you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the medicine cabinet you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the medicine cabinet, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            break;

         
         case "search bookshelf":
         case "search book shelf":
         case "search shelf":
            if (roomArray[yAxis][xAxis].getRoom().equals("den"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the shelf, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the shelf you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the shelf you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the shelf you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the shelf, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            break;

         
         case "search desk":
         case "search metal desk":
            if (roomArray[yAxis][xAxis].getRoom().equals("laboratory"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the desk, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the desk you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the desk you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the desk you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the desk, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            break;
         
         case "search armoire":
            if (roomArray[yAxis][xAxis].getRoom().equals("dining room"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the armoire, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the armoire you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the armoire you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the armoire you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the armoire, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            break;

         
         case "search car":
            if (roomArray[yAxis][xAxis].getRoom().equals("garage"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the car, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the car you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the car you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the car you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the car, but there was nothing of interest.");
               }
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            roomArray[yAxis][xAxis].setSearched();
            break;

         
         case "search box":
         case "search metal box":
            if (roomArray[yAxis][xAxis].getRoom().equals("storage closet"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the box, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the box you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the box you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the box you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the box, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }
            break;

         
         case "search coat rack":
         case "search rack":
            if (roomArray[yAxis][xAxis].getRoom().equals("front entrance"))
            {
               if (roomArray[yAxis][xAxis].hasKey)
               {
                  System.out.println("In the coat rack, you find a discarded key.");
               }
               else if (roomArray[yAxis][xAxis].hasBone)
               {
                  System.out.println("In the coat rack you find a bone.");
               }
               else if (roomArray[yAxis][xAxis].hasCombination)
               {
                  System.out.println("In the coat rack you find a piece of paper with a lock combination on it.");                  
               }
               else if (roomArray[yAxis][xAxis].hasCableCutters)
               {
                  System.out.println("In the coat rack you find some cable cutters.");
               }
               else 
               {
                  System.out.println("You searched through the coat rack, but there was nothing of interest.");
               }
               roomArray[yAxis][xAxis].setSearched();
            }
            else
            {
               System.out.println("There's nothing like that here");
            }

            break;
            
         //PICK UP
         case "pick up key":
            if (roomArray[yAxis][xAxis].getSearched() && roomArray[yAxis][xAxis].hasKey)
            {
               System.out.println("Key added to your inventory");
               player.addInventory("key");
            }
            break;
         case "pick up bone":
            if (roomArray[yAxis][xAxis].getSearched() && roomArray[yAxis][xAxis].hasBone)
            {
               System.out.println("Bone added to your inventory");
               player.addInventory("bone");
            }
            break;
         case "pick up combination":
            if (roomArray[yAxis][xAxis].getSearched() && roomArray[yAxis][xAxis].hasCombination)
            {
               System.out.println("Combination added to your inventory");
               player.addInventory("combination");
            }
            break;
         case "pick up cable cutters":
            if (roomArray[yAxis][xAxis].getSearched() && roomArray[yAxis][xAxis].hasCableCutters)
            {
               System.out.println("Cable Cutters added to your inventory");
               player.addInventory("cable cutters");
            }
            break;
            
         //USE
         case "use bone":
            if (player.getInventory().contains("bone"))
            {
               if (roomArray[yAxis][xAxis].getRoom().equals("front entrance"))
               {
                  if(exitRoom.isGuarded)
                  {
                     System.out.println("the dog takes the bone and starts chewing on it in the corner. He seems distracted enough for you to try the door.");
                     exitRoom.isGuarded = false;
                  }
               }
               else 
               {
                  System.out.println("I don't see a use for it.");
               }
            }
            break;
            
         //HELP MESSAGE
         case "help":
            System.out.println("Welcome to DUNGEON!\nThe object of the game is to explore the rooms and find a way to escape.");
            System.out.println("\nPossible Commands:\n\nlook at\nsearch\npick up\nuse\ngo north, go south, go east, go west\nquit");
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