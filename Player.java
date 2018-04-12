import java.util.*;

public class Player
{
   //FIELDS
   private String name;
   private ArrayList<String> itemInventory = new ArrayList<String>();
   
   //METHODS
   public String getName()
   {
      return name;
   }
   
   public void setName(String name)
   {
      this.name = name;
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
   
}