public class Rooms
{
   //FIELDS
   private static final String[] roomsArray = {"kitchen", "bedroom", "bathroom", "den", "laboratory", "dining room", "garage", "storage closet", "front entrance"};
   private static final String[] roomDescriptionArray = new String[9];
   private boolean hasKey = false;
   private boolean hasBone = false;
   private boolean hasCombination = false;
   private boolean hasCableCutters = false;
   private String room;
   private String description;
   
   
   
   //CONSTRUCTOR
   public Rooms(int type)
   {
      room = roomsArray[type];
      description = roomDescriptionArray[type];
   }
   
   //METHODS
   public String getRoom()
   {
      return room;
   }
   
   public String getDescription()
   {
      return description;
   }
   
   public void hasItem(String item)
   {
      if (item == "key")
      {
         hasKey = true;
      }
      else if (item == "bone")
      {
         hasBone = true;
      }
      else if (item == "combination")
      {
         hasCombination = true;
      }
      else if (item == "cable cutters")
      {
         hasCableCutters = true;
      }
   }
}