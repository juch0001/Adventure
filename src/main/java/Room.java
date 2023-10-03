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

    public Room (String name, String description){
        this.name = name;
        this.description = description;
        this.east = null;
        this.west = null;
        this.north = null;
        this.south = null;
        this.itemList =new ArrayList<>();
    }

    public Room showItemsInRoom(Room room) {
        ArrayList<Item> itemList = room.getItemList();
        if (!itemList.isEmpty()) {
            System.out.println("Items in the room:");
            for (Item item : itemList) {
            }
        } else {
            System.out.println("There are no items in this room.");
        }
        return null;
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

    public void addItem(Item item) {
        itemList.add(item);
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public boolean removeItem (Item item) {
        return itemList.remove(item);
    }

    public boolean hasItem(Item item) {
        return itemList.contains(item);
    }



    //Todo get og set for navn
    public String getName() {
        return name;
    }


    //Todo get og set for beskrivelse
    public String getDescription() {
        return description;
    }

    //Todo get og set for nord
    public Room getNorth() {
        return north;
    }
    public void setNorth(Room north){
        this.north=north;
    }

    //Todo get og set for syd
    public Room getSouth() {
        return south;
    }
    public void setSouth(Room south){
        this.south=south;
    }

    //Todo get og set for øst
    public Room getEast() {
        return east;
    }
    public void setEast(Room east){
        this.east=east;
    }

    //Todo get og set for vest
    public Room getWest() {
        return west;
    }
    public void setWest(Room west){
        this.west=west;
    }



}