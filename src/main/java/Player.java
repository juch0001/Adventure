import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static final String BLACK_BOLD = "\033[1;30m"; //Markeret sort (hvis man har hvid skærm)

    private Room currentRoom;
    private ArrayList<Item> inventory;

    public Player(Room currentRoom){
        this.inventory =new ArrayList<>();
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean takeItem(Item item) {
        return inventory.add(item);
    }

    public Item findItem (String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void dropItem(Item item) {
        inventory.remove(item);
    }

    public void pickUpItem (Item item){
        if (currentRoom.hasItem(item)){
            currentRoom.removeItem(item);
            takeItem(item);
            System.out.println("You picked up: " + item.getItemDescription());
        } else {
            System.out.println("The item is not avalible in this room.");
        }
    }

    //TODO if bruger skriver east -> go east osv.
    public String moveToRoom(String input) {
        Room nextRoom = null;
        if (input.equals("go east") && currentRoom.getEast() != null) {
            nextRoom = currentRoom.getEast();
        } else if (input.equals("go south") && currentRoom.getSouth() != null) {
            nextRoom = currentRoom.getSouth();
        } else if (input.equals("go west") && currentRoom.getWest() != null) {
            nextRoom = currentRoom.getWest();
        } else if (input.equals("go north") && currentRoom.getNorth() != null) {
            nextRoom = currentRoom.getNorth();
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return currentRoom.getDescription();
        } else {
            return null;
        }
    }

    public void directions(String menu) {
        String arrow = " "; //For at kunne tilføje pile retning

        switch (menu) {
            case "go north":
                arrow = " ↑ ";
                String northResult = moveToRoom("go north");
                if (northResult != null) {
                    System.out.println(BLACK_BOLD + "going north" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    for (Item item : currentRoom.getItemList()) {
                        System.out.println("\n Type Look, for at se hvilket items der er i rummet");
                    }
                } else {
                    System.out.println(" Hvor skal du hen nu?");
                }
                break;
            case "go east":
                arrow = " → ";
                String eastResult = moveToRoom("go east");
                if (eastResult != null) {
                    System.out.println(BLACK_BOLD + "going east" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    for (Item item : currentRoom.getItemList()) {
                        System.out.println("\n Type Look, for at se hvilket items der er i rummet");

                    }
                } else {
                    System.out.println("Hvor skal du hen nu?");
                }
                break;

            case "go south":
                arrow = " ↓ ";
                String southResult = moveToRoom("go south");
                if (southResult != null) {
                    System.out.println(BLACK_BOLD + "going south" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    for (Item item : currentRoom.getItemList()) {
                        System.out.println("\n Type Look, for at se hvilket items der er i rummet");

                    }
                } else {
                    System.out.println("Hvor skal du hen nu?");
                }
                break;
            case "go west":
                arrow = " ← ";
                String westResult = moveToRoom("go west");
                if (westResult != null) {
                    System.out.println(BLACK_BOLD + "going west" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    for (Item item : currentRoom.getItemList()) {
                        System.out.println("\n Type Look, for at se hvilket items der er i rummet");
                }
                } else {
                    System.out.println("Hvor skal du hen nu?");
                }
                break;
            default:
                System.out.println("not avaliable");
                break;
        }
    }

}