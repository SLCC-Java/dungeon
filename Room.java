import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Room {

    // Fields
    private String name;
    private String description;
    private String object;
    private ArrayList<Item> items = new ArrayList<>();

    // Constructor
    public Room(String name, String description, String object){
        this.name = name;
        this.description = description;
        this.object = object;
    }

    // Class Methods

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getObject() {
        return object;
    }

    public ArrayList<Item> getItems() {
        if (items.isEmpty()) return null;
        else return items;
    }

    public void setItems(String name, String description) {
        Item item = new Item(name, description);
        items.add(item);
    }

    public void takeItem (Player player,Item item) {
        if(items.contains(item)){
            player.addInventory(item);
            items.remove(item);
        }
    }

    public String[][] defaultRooms(){
        String[] roomNames = {
            "bedroom",
            "bathroom",
            "kitchen",
            "front entrance",
            "den",
            "laboratory",
            "dining room",
            "garage",
            "storage closet"
        };
        String[] roomObjects = {
            "dresser",
            "cabinet",
            "garbage",
            "rack",
            "shelf",
            "desk",
            "armoire",
            "car",
            "box"
        };
        String[] roomDescriptions = {
            "You are in a simple bedroom. Aside from the bed, the only furniture is a dresser with three drawers and a lamp in the corner.",
            "You are in a bathroom. It looks as if it has never been used. Everything is clean except for the medicine cabinet mirror, which has some fingerprints on it.",
            "You are in a dilapidated kitchen. You smell rotting food, and there's mildew on the walls. On the floor, there's an overflowing garbage can.",
            "You are in a room with a ladder leading to a trapdoor in the ceiling. There is light showing through edges of the door. This may be your way out. There is also a coat rack sitting in the corner.",
            "You are in a den of some kind. It has thick carpet and a sofa that doesn't look very comfortable. There's a tall bookshelf in the corner of the room.",
            "You are in a large laboratory. Beakers filled with strange liquids cover the surface of a metal desk, and there's a crooked picture hanging on the wall.",
            "You are in a small dining room. There's just enough room for a table with chairs and a small armoire.",
            "You are in a poorly lit garage. A car sits on the floor with the engine taken out. The garage door has been welded shut.",
            "You are in a large closet. It's cluttered with piles of clothes. On a shelf there is a metal box."
        };
        return new String[][]{roomNames,roomDescriptions, roomObjects};

    }
    
}