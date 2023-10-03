import javax.sound.midi.Soundbank;

public class Adventure {

    private Map map = new Map();
    private Player player;

    public Adventure(){
        player = new Player(map.getCurrentRoom());
    }

    public void buildMap() {
        map.buildMap();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void directions(String menu) {
        player.directions(menu);
    }

    public Player getPlayer() {
        return player;
    }

    public Player showInventory() {
        return player.showInventory();
    }

    public boolean takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Player dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public Room showItemsInRoom(Room room) {
        return player.showItemsInRoom(room);
    }

    public Room showAvailableItems(Room room) {
        return player.showAvailableItems(room);
    }
}