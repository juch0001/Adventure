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

    public Room showAvailableItems(Room room) {
        return player.showAvailableItems(room);
    }

    public String printHealthDescription() {
    return player.printHealthDescription();
    }

    public int getHealth() {
        return player.getHealth();
    }

    public FoodEnum eatFood(String food) {
        return player.eatFood(food);
    }

    public WeaponEnum equipWeapon(String weapon) {
        return player.equipWeapon(weapon);
    }

    public AttackEnum attack(String itemName) {
        return player.attack(itemName);
    }
}