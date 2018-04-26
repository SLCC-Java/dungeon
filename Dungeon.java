import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dungeon {
    private Room[][] rooms;
    private int[] startLocation = {0,0};
    public Boolean escaped = false;

    public Dungeon(){
        this(3);
    }
    
    public Dungeon(int size){
        ConstructDungeon(size);
    }

    public int[] getStartLocation() {
        return startLocation;
    }

    public Room getRoom(int[] location){
        return rooms[location[0]][location[1]];
    }

    public void endgame() {
        System.out.println("Congradulations! You escaped! Would you like to play again?\nYes\\No");
    }

    private void ConstructDungeon(int size) {
        Random r = new Random();
        int randnum;
        this.rooms = new Room[size][size];
        String[][] room = new Room(null,null, null).defaultRooms();
        String[][] item = new Item(null,null).defaultItems();

        for (int i = 0; i < size; i++) {
            randnum = r.nextInt(size*size);
            for (int j = 0; j < size; j++) {
                while (checkForRoom(rooms, room[0][randnum])) {
                    randnum = r.nextInt(size*size);
                }
                System.out.printf("[%d,%d] is %s%n", i,j, room[0][randnum]);
                this.rooms[i][j] = new Room(room[0][randnum], room[1][randnum], room[2][randnum]);
                if(room[0][randnum].equals("bedroom")){
                   startLocation[0] = i;
                   startLocation[1] = j;
                }
            }
        }

        randomlyPlaceItems(size, item, r);
    }

    private boolean checkForRoom(Room[][] rooms, String value) {
        boolean result = false;
        loop:
        for (Room[] row : rooms) {
            for (Room room : row) {
                if( room == null){
                    break loop;
                }
                else if( room != null && room.getName().equals(value)){
                    result = true;
                    break loop;
                }

            }
        }
        return result;
    }

    private void randomlyPlaceItems(int size, String[][] items, Random r) {
        int x;
        int y;
        int i = 0;
        for (String item : items[0]) {
            x = r.nextInt(size);
            y = r.nextInt(size);
            System.out.printf("Placing %s at %s: [%d,%d]%n", item, rooms[x][y].getName(), x, y);
            rooms[x][y].setItems(items[0][i], items[1][i]);
            i++;
        }
    }
    
}