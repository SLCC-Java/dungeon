public class Item {
    private String name;
    private String description;

    public Item (String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[][] defaultItems(){
        String[] itemNames = {
            "key",
            "bone",
            "combination",
            "cable cutters"
        };
        String[] itemDescriptions = {
            "A DISCARDED KEY. Looks like it goes to a door.",
            "A BONE. Looks like it has some teeth marks in it.",
            "A PAPER. Looks like it has a lock combination on it",
            "A CABLE CUTTER. Looks rusty, but the blades are still sharp"
        };

        return new String[][]{itemNames, itemDescriptions};
    }
    
}