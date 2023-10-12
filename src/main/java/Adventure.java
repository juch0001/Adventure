import java.util.List;

public class Adventure {

    private Map map = new Map();
    private Enemy enemy;
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

    public void showAvalableEnemies (Room room) {
        List <Enemy> enemyList = room.getEnemyList();

        if (!enemyList.isEmpty()) {
            System.out.println("Enemies in this room: ");
            for (Enemy enemy : enemyList) {
                System.out.println(enemy.getEnemyName() + "- " + enemy.getEnemyDescription());
            }
        } else {
            System.out.println("There are no enemies in this room.");
        }
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

    public int getPlayerDamage() {
        return player.getPlayerDamage();
    }

    public Enemy dropWeapon (Weapon enemyWeapon) {
        map.weaponList.remove(enemyWeapon);
        map.getCurrentRoom().addItem(enemyWeapon);
        System.out.println("Enemy has dropped " + enemyWeapon.getItemName());
        return null;
    }

    public Enemy removeEnemy (Enemy enemyName) {
        map.getCurrentRoom().getEnemyList().remove(enemyName);
        return null;
    }

}