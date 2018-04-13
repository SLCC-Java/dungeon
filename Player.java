import java.util.*;

public class Player
{
   //FIELDS
   private ArrayList<String> itemInventory = new ArrayList<String>();
   private String name;
   private int x;
   private int y;
   
   //METHODS
    Player(String name){
        this.name = name;
    }

   public String getName()
   {
      return name;
   }
   
   public ArrayList<String> getInventory()
   {
      return itemInventory;
   }
   
   public void addInventory(String inventoryItem)
   {
      itemInventory.add(inventoryItem);
   }
   
   public void removeInventory(String inventoryItem)
   {
      itemInventory.remove(inventoryItem);
   }

   public void options(String option){
       String[] check = option.split(" ", 2);

       if(check[0] == "go" || check[0] == "move") System.out.println("Moving " + check[1]);
       else System.out.println("You did something else");
   }
   
}