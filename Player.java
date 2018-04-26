import java.util.*;

public class Player {
    //FIELDS
    private ArrayList<Item> itemInventory = new ArrayList<Item>();
    private String name;
    private int x;
    private int y;

    //METHODS
    Player(String name, int[] startLocation) {
        this.name = name;
        x = startLocation[0];
        y = startLocation[1];
    }

    public String getName() {
        return name;
    }

    public int[] getLocation() {
        return new int[] { x, y };
    }

    public ArrayList<Item> getItemInventory() {
        return itemInventory;
    }

    private void lookAtInventory(){
        if (itemInventory.isEmpty()) System.out.println("You don't have anything!");
        for (Item item : itemInventory) {
            System.out.println(item.getName());
        }
    }

    public void addInventory(Item inventoryItem) {
        itemInventory.add(inventoryItem);
    }

    public void removeInventory(Item inventoryItem) {
        itemInventory.remove(inventoryItem);
    }

    public void options(String option, Room room, Dungeon dungeon) {
        String[] check = option.split(" ", 2);
        switch (check[0]) {
        case "go":
        case "move":
            if (check.length > 1)
                move(check[1], dungeon);
            else
                System.out.println("Where would you like to go?");
            break;
        case "help":
            if (check.length > 1 && check[1].contains("room"))
                help(room);
            //else if (check.length > 1 && check[1].contains("item")) help();
            else
                help();
            break;
        case "look":
        case "search":
            if(check.length > 1 && check[1].contains("inventory"))
                lookAtInventory();
            else if (check.length > 1)
                look(check[1], room);
            else
                look(room);
            break;
        case "use":
            use(check[1], room);
            break;
        default:
            System.out.println("I don't understand. Type 'help' to see list of possible commands.");
            break;
        }
    }

    private void move(String direction, Dungeon dungeon) {
        if((direction.equals("west") && x == 0)
        || (direction.equals("north") && y == 0)
        || (direction.equals("east") && x == 2)
        || (direction.equals("south") && y == 2)) {
            System.out.println("You cannot go that direction");
        } else {
            String moving = "";
            switch (direction) {
            case "north":
                moving = "Going " + direction;
                y--;
                break;
            case "south":
                moving = "Going " + direction;
                y++;
                break;
            case "east":
                moving = "Going " + direction;
                x++;
                break;
            case "west":
                moving = "Going " + direction;
                x--;
                break;
            default:
                System.out.println("Not a valid direction");
                break;
            }
            if (!moving.isEmpty())
                System.out.println(moving + "\n" + dungeon.getRoom(this.getLocation()).getDescription());
        }
    }

    private void look(Room room) {
        System.out.println(room.getDescription());
    }

    private void look(String object, Room room) {
        if (room.getObject().equalsIgnoreCase(object)) {
            if (room.getItems() == null)
                System.out.println("You looked through the " + room.getObject() + " but didn't find anything!");
            else {
                System.out.println("After looking through the " + room.getObject() + ", you found:");
                for (Item item : room.getItems()) {
                    String[] i = item.getDescription().split(".", 1);
                    System.out.println(i[0].toLowerCase());
                    this.addInventory(item);
                }
            }
        }
    }

    private void use(String object, Room room) {

    }

    private void help() {
        ArrayList<String> choices = new ArrayList<String>();
        if (y > 0) choices.add("Go in the north room");
        if (y < 2) choices.add("Go in the south room");
        if (x > 0) choices.add("Go in the east room");
        if (x < 2) choices.add("Go in the west room");
        choices.add("Look around the room");
        choices.add("Look at the items or an item in your inventory");
        choices.add("Grap or use an item from your inventory");
        choices.add("Get help in the room you're in");

        System.out.println("Possible Commands:");
        for (int i = 0; i < choices.size(); i++) {
            System.out.print(choices.get(i));
            if (i < choices.size() - 1)
                System.out.print(",");
            System.out.println();
        }
    }

    private void help(Room room) {
        System.out.println("Tip of the room");
    }

    private void help(Item items) {
        System.out.println("Tip for the item");
    }
}