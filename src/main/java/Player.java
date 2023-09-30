public class Player {
    public static final String BLACK_BOLD = "\033[1;30m"; //Markeret sort (hvis man har hvid skærm)

    private Room currentRoom;
    private Item item;

    ArrayList<Item> itemList = new ArrayList<>();

    public void addItem(String itemName, String itemDescription) {
        Item item = new Item(itemName, itemDescription);
        itemList.add(item);
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
                } else {
                    System.out.println("This path is not available");
                }
                break;
            case "go east":
                arrow = " → ";
                String eastResult = moveToRoom("go east");
                if (eastResult != null) {
                    System.out.println(BLACK_BOLD + "going east" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                } else {
                    System.out.println("This path is not available");
                }
                break;
            case "go south":
                arrow = " ↓ ";
                String southResult = moveToRoom("go south");
                if (southResult != null) {
                    System.out.println(BLACK_BOLD + "going south" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                } else {
                    System.out.println("This path is not available");
                }
                break;
            case "go west":
                arrow = " ← ";
                String westResult = moveToRoom("go west");
                if (westResult != null) {
                    System.out.println(BLACK_BOLD + "going west" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                } else {
                    System.out.println("This path is not available");
                }
                break;
            default:
                System.out.println("not avaliable");
                break;
        }
    }
}
