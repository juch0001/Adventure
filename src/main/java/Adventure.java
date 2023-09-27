import javax.sound.midi.Soundbank;

public class Adventure {

    private Room current;

    public void buildMap() {
    Room room1 = new Room("Room 1", "beskrivelse");
    Room room2 = new Room("Room 2", "beskrivelse");
    Room room3= new Room("Room 3", "beskrivelse");
    Room room4= new Room("Room 4", "beskrivelse");
    Room room5= new Room("Room 5", "beskrivelse");
    Room room6= new Room("Room 6", "beskrivelse");
    Room room7= new Room("Room 7", "beskrivelse");
    Room room8= new Room("Room 8", "beskrivelse");
    Room room9= new Room("Room 9", "beskrivelse");

        //Room 1
        room1.setEast(room2);
        room1.setSouth(room4);

        //Room 2
        room2.setWest(room1);
        room2.setEast(room3);

        //Room 3
        room3.setWest(room2);
        room3.setWest(room6);

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
        switch (menu) {
            case "go north":
                String northResult = moveToRoom("go north");
                if (northResult != null) {
                    System.out.println("going north");
                    System.out.println("You are now in " + getCurrentRoom().getName());
                    System.out.println(getCurrentRoom().getDescription());
                } else {
                    System.out.println("This path is not available");
                }
                break;

            case "go east":
                System.out.println("going east");
                moveToRoom("go east");
                System.out.println(getCurrentRoom().getName());
                break;
            case "go south":
                System.out.println("going south");
                moveToRoom("go south");
                System.out.println(getCurrentRoom().getName());
                break;
            case "go west":
                System.out.println("going west");
                moveToRoom("go west");
                System.out.println(getCurrentRoom().getName());
                break;

            default:
                System.out.println("not avaliable");
                break;
        }
    }


