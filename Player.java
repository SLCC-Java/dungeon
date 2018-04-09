import java.util.*;

public class Player
{
   //FIELDS
   private String name;
   private ArrayList<String> itemInventory = new ArrayList<String>();
   
   //CONSTRUCTOR
   public Player(String name)
   {
      name = this.name;      
   }
   
   //METHODS
   public String getName()
   {
      return name;
   }
   
   public ArrayList<String> getinventory()
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
   
}