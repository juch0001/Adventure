import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static final String BLUE_BOLD = "\033[1;34m"; //farvekode til blå
    public static final String BLUE_UNDERLINED = "\033[4;34m"; //blå linje under tekst
    public static final String BLACK_BOLD = "\033[1;30m"; //Markeret sort (hvis man har hvid skærm)
    public static void printMouseArt() {
        String mouseArt =

                "     _   _        \n" +
                        "    (q\\_/p)      \n" +
                        ".-.  |. .|        \n" +
                        "  \\  =\\,/=/     \n" +
                        "   ) / _ \\      |\\ \n" +
                        "   (/\\):(/\\)     )\\ \n" +
                        "    \\_   _/     |Oo\\ \n" +
                        "    `\"\"^\"\"`     `\"\"`";

        System.out.println(mouseArt);
    }

    private Adventure adventure;
    Scanner scanner = new Scanner(System.in);

    private void look(){
        Room currentRoom = adventure.getCurrentRoom();
        System.out.println(currentRoom.getDescription());
        showItemsInRoom(currentRoom);
    }

    public String getInput() {
        while (!scanner.hasNextLine()) {
            scanner.next();
            System.out.println("What you entered is not an option, write help, exit or look.");
        }
        return scanner.nextLine();
    }

    public UserInterface(Adventure adventure) {
        this.adventure =adventure;
    }

    public void startGame() {
        adventure.buildMap();

        //TODO navngiv spil
        System.out.println(BLUE_UNDERLINED + BLUE_BOLD + "Welcome to the Mouse Trap." + "\u001B[0m");
        printMouseArt();
        System.out.println(BLACK_BOLD +"Directions: You enter a labyrinth as a mouse, and need to find your way to the holy grail of cheese." +
                "\nYou can go north, east, south or west." +
                "\nTo choose a direction, write 'go' and the direction you would like to go." + "\u001B[0m");
        System.out.println("Write help if you need help.");

        boolean runProgram = true;

        String menu = "";

        //Todo menu
        while (runProgram) {

            menu = getInput();

            if (menu.equals("help")) {
                System.out.println("To go south, write 'go south'. To go north, write 'go north'. To go east, write 'go east'." +
                        " To go west, write 'go west'.");
                //System.out.println("Look");
                System.out.println("Exit ");

            } else if (menu.equals("exit")) {
                System.out.println("We hope to see you again soon");
                runProgram = false;
            } else if (menu.equals("look")) {
                look();
            } else if (menu.contains("go")) {
                adventure.directions(menu);
            }else if (menu.equals("inventory") || menu.equals("inv") || menu.equals("invent")) {
                showInventory(adventure.getPlayer());
            }else if (menu.startsWith("Take")) {
                takeItem(adventure.getPlayer(), menu.substring(5));
            } else if (menu.startsWith("Drop")) {
                dropItem(adventure.getPlayer(), menu.substring(5));
            }else {
                System.out.println("Not avalible, Type `help´");
            }
        }
    }

    private void showItemsInRoom (Room room){
        ArrayList<Item> itemList = room.getItemList();
        if (!itemList.isEmpty()){
            System.out.println("Items in the room:");
            for (Item item : itemList) {
                System.out.println(" Du kan bruge dette våben " + item.getItemDescription());
            }
        }else {
            System.out.println("There are no items in this room.");
        }
    }


    private void showInventory(Player player) {
        ArrayList<Item> inventory = player.getInventory();
        if (inventory.isEmpty()){
            System.out.println("your inventory is empty.");
        }else {
            System.out.println("Inventory");
            for (Item item : inventory) {
                System.out.println("- " + item.getItemDescription());
            }
        }
    }

    private void takeItem (Player player, String itemName) {
        Item item = player.findItem(itemName);
        if (item != null) {
            if (player.takeItem(item)) {
                player.getCurrentRoom().removeItem(item);
                System.out.println("you have taken " + item.getItemDescription());
            } else {
                System.out.println("Your inventory is full. Drop some items first.");
            }
        } else {
            System.out.println("There is nothing like " + itemName + " to take around here.");
        }
    }


    private void dropItem (Player player, String itemName) {
        Item item = player.findItem(itemName);
        if (item !=null) {
            player.dropItem(item);
            player.getCurrentRoom().addItem(item);
            System.out.println("You have dropped " + item.getItemDescription());
        }else {
            System.out.println("You dont have anything like " + itemName + " in your inventory.");
        }
    }
}



// lave Item om til String inde i player
