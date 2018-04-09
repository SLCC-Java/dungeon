public class Rooms
{
   //FIELDS
   private static final String[] roomsArray = {"kitchen", "bedroom", "bathroom", "den", "laboratory", "dining room", "garage", "storage closet", "front entrance"};
   private static final String[] roomDescriptionArray = new String[9];
   private boolean hasKey = false;
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
}