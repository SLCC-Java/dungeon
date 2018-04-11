public class Rooms
{
   //FIELDS
   private static final String[] roomsArray = {"kitchen", "bedroom", "bathroom", "den", "laboratory", "dining room", "garage", "storage closet", "front entrance"};
   private static String[] roomTextArray = new String[9];
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
      roomTextArray[0] = "You are in a dilapidated kitchen. You smell rotting food, and there's mildew on the walls. On the floor, there's an overflowing garbage can.";
      roomTextArray[1] = "You are in a simple bedroom. Aside from the bed, the only furniture is a dresser with three drawers and a lamp in the corner.";
      roomTextArray[2] = "You are in a bathroom. It looks as if it has never been used. Everything is clean except for the medicine cabinet mirror, which has some fingerprints on it.";
      roomTextArray[3] = "You are in a den of some kind. It has thick carpet and a sofa that doesn't look very comfortable. There's a tall bookshelf in the corner of the room.";
      roomTextArray[4] = "You are in a large laboratory. Beakers filled with strange liquids cover the surface of a metal desk, and there's a crooked picture hanging on the wall.";
      roomTextArray[5] = "You are in a small dining room. There's just enough room for a table with chairs and a small armoire.";
      roomTextArray[6] = "You are in a poorly lit garage. A car sits on the floor with the engine taken out. The garage door has been welded shut.";
      roomTextArray[7] = "You are in a large closet. It's cluttered with piles of clothes. On a shelf there is a metal box.";
      roomTextArray[8] = "You are in a room with a ladder leading to a trapdoor in the ceiling. There is light showing through edges of the door. This may be your way out. There is also a coat rack sitting in the corner.";

      
      description = roomTextArray[type];
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
<<<<<<< HEAD
      if (item.equals("key"))
      {
         hasKey = true;
      }
      else if (item.equals("bone"))
      {
         hasBone = true;
      }
      else if (item.equals("combination"))
      {
         hasCombination = true;
      }
      else if (item.equals("cable cutters"))
      {
         hasCableCutters = true;
      }
=======
        switch (item) {
            case "key":
                this.hasKey = true;
                break;
            case "bone":
                this.hasBone = true;
                break;
            case "combination":
                this.hasCombination = true;
                break;
            case "cable cutters":
                this.hasCableCutters = true;
                break;
            default:
                break;
        }
>>>>>>> dbad420d0a25f0cf1f2e850653823af68a2f29cf
   }
   
   public boolean checkKey()
   {
      if(hasKey)
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
}