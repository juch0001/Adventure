import java.util.ArrayList;

public class Room {
    //Todo objekt og variabler
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private ArrayList <Item> itemList;
    private ArrayList <Enemy> enemyList;

    public Room (String name, String description){
        this.name = name;
        this.description = description;
        this.east = null;
        this.west = null;
        this.north = null;
        this.south = null;
        this.itemList =new ArrayList<>();
        this.enemyList = new ArrayList<>();
    }

    //TODO Enemy
    public void addEnemy (Enemy enemy) {
     enemyList.add(enemy);
    }

    public void removeEnemy (Enemy enemyName) {
        enemyList.remove(enemyName);
    }

    public Enemy findEnemyByName (String enemyName) {
        for (Enemy enemy : enemyList) {
            if (enemy.getEnemyName().equalsIgnoreCase(enemyName)){
                return enemy;
            }
        }
        return null;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    //TODO Item
    public void addItem(Item item) {
        itemList.add(item);
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public Room showAvailableItems(Room room) {
        ArrayList<Item> itemList = room.getItemList();
        if (!itemList.isEmpty()) {
            System.out.println("Available items in the room: ");
            int index = 1;

            for (Item item : itemList) {
                System.out.println(index + ". " + item.getItemName() + item.getItemDescription());
                index++;
            }
        } else {
            System.out.println("There are no items in this room.");
        }
        return null;
    }

    //TODO GET og SET variabler
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }
    public void setNorth(Room north){
        this.north=north;
    }

    public Room getSouth() {
        return south;
    }
    public void setSouth(Room south){
        this.south=south;
    }

    public Room getEast() {
        return east;
    }
    public void setEast(Room east){
        this.east=east;
    }

    public Room getWest() {
        return west;
    }
    public void setWest(Room west){
        this.west=west;
    }



}