import javax.sound.midi.Soundbank;

public class Adventure {
    public static final String BLACK_BOLD = "\033[1;30m"; //Markeret sort (hvis man har hvid skærm)


    private Room current;

    public void buildMap() {
        Room room1 = new Room("Room 1", "You are in something that looks like a basement, with a bit of food as well as some barrels scattered around." +
                "\nNothing really stands out to you apart from 2 possible paths leading away from the basement, one more well lit than the other." +
                "\nWhich way would you like to go?");
        Room room2 = new Room("Room 2", "You enter a room, with dim lighting, theres some furniture as well as a grandiose canvas picturing a impressive looking mouse." +
                "\nThe paths extends on either side of the room." +
                "\nWhich way would you like to go?");
        Room room3 = new Room("Room 3", "You have reached a corner where a broken light is slightly lighting up the area." +
                "\nYou can just about make out that there are 2 possible paths to take." +
                "\nWhich way would you like to go?");
        Room room4 = new Room("Room 4", "" + "The paths extends on either side of you." +
                "\nWhich way would you like to go?");
        Room room5 = new Room("Room 5", "You are in a huge and magnificent room, with long tables as far as your eyes can see." +
                "\nThe tables are decorated with flowers, and filled with cheese, however what catches your eyes is the giant cheese in the back." +
                "\nThe holy grail of Cheese! You hurry down, and relish in the taste of the cheese.");
        Room room6 = new Room("Room 6", "As you walk, the light grows in strenght. You can now make out the interior of your surroundings." +
                "\nIt is not the usual place for a mouse such as yourself. The paths extends on either side of you." +
                "\nWhich way would you like to go?");
        Room room7 = new Room("Room 7", "You have entered a large library." +
                "\nThe smell of old books is overwhelming and although it at a quick glimpse appears as if nobody has been here for a while," +
                " you notice signs of life in certain parts of the library." +
                "\nThere are 2 possible paths to take" +
                "\nWhich way would you like to go?");
        Room room8 = new Room("Room 8", "The path opens up to a large outside garden, blocked off with large heavy stone walls." +
                "\nIt feels like somethings watching you, although you cannot place it." +
                "The path splits, and there are now 3 paths to choose between." +
                "\nWhich way would you like to go?");
        Room room9 = new Room("Room 9", "You enter a kitchen. There are pots and pans as well as knives scattered about." +
                "\nThere are 2 possible paths to take" +
                "\nWhich way would you like to go?");

        current = room1;

        //Room 1
        room1.setEast(room2);
        room1.setSouth(room4);

        //Room 2
        room2.setWest(room1);
        room2.setEast(room3);

        //Room 3
        room3.setWest(room2);
        room3.setSouth(room6);

        //Room 4
        room4.setNorth(room1);
        room4.setSouth(room7);

        //Room 5
        room5.setSouth(room8);

        //Room 6
        room6.setNorth(room3);
        room6.setSouth(room9);

        //Room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // Room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        //Room 9
        room9.setNorth(room6);
        room9.setWest(room8);
    }

    public Room getCurrentRoom() {
        return current;
    }

    //TODO if bruger skriver east -> go east osv.
    public String moveToRoom(String room) {
        Room nextRoom = null;
        if (room.equals("go east") && current.getEast() != null) {
            nextRoom = current.getEast();
        } else if (room.equals("go south") && current.getSouth() != null) {
            nextRoom = current.getSouth();
        } else if (room.equals("go west") && current.getWest() != null) {
            nextRoom = current.getWest();
        } else if (room.equals("go north") && current.getNorth() != null) {
            nextRoom = current.getNorth();
        }  if (nextRoom != null) {
            current = nextRoom;
            return current.getDescription();
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
                    System.out.println("You are now in " + getCurrentRoom().getName());
                    System.out.println(getCurrentRoom().getDescription());
                } else {
                    System.out.println("This path is not available");
                }
                break;
            case "go east":
                arrow = " → ";
                String eastResult = moveToRoom("go east");
                if (eastResult != null) {
                    System.out.println(BLACK_BOLD + "going east" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + getCurrentRoom().getName());
                    System.out.println(getCurrentRoom().getDescription());
                } else {
                    System.out.println("This path is not available");
                }
                break;
            case "go south":
                arrow = " ↓ ";
                String southResult = moveToRoom("go south");
                if (southResult != null) {
                    System.out.println(BLACK_BOLD + "going south" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + getCurrentRoom().getName());
                    System.out.println(getCurrentRoom().getDescription());
                } else {
                    System.out.println("This path is not available");
                }
                break;
            case "go west":
                arrow = " ← ";
                String westResult = moveToRoom("go west");
                if (westResult != null) {
                    System.out.println(BLACK_BOLD + "going west" + arrow + "\u001B[0m");
                    System.out.println("You are now in "+ getCurrentRoom().getName());
                    System.out.println(getCurrentRoom().getDescription());
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