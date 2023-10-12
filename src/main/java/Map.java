import java.util.ArrayList;

public class Map {

    private Room currentRoom;
    public ArrayList<Weapon> weaponList;

    public void buildMap() {
        Room room1 = new Room("Room 1 ","You are in something that looks like a basement, with a bit of food as well as some barrels scattered around." +
                "\nNothing really stands out to you apart from 2 possible paths leading away from the basement, one more well lit than the other.");
        Room room2 = new Room("Room 2 ", "You enter a room, with dim lighting, theres some furniture as well as a grandiose canvas picturing a impressive looking mouse." +
                "\nThe paths extends on either side of the room.");
        Room room3 = new Room("Room 3 ", "You have reached a corner where a broken light is slightly lighting up the area." +
                "\nYou can just about make out that there are 2 possible paths to take.");
        Room room4 = new Room("Room 4 ", "The paths extends on either side of you.");
        Room room5 = new Room("Room 5 ", "You are in a huge and magnificent room, with long tables as far as your eyes can see." +
                "\nThe tables are decorated with flowers, and filled with cheese, however what catches your eyes is the giant cheese in the back." +
                "\nThe holy grail of Cheese! You hurry down, and relish in the taste of the cheese.");
        Room room6 = new Room("Room 6 ", "As you walk, the light grows in strenght. You can now make out the interior of your surroundings." +
                "\nIt is not the usual place for a mouse such as yourself. The paths extends on either side of you, and theres a conveniently placed door.");
        Room room7 = new Room("Room 7 ", "You have entered a large library." +
                "\nThe smell of old books is overwhelming and although it at a quick glimpse appears as if nobody has been here for a while," +
                " you notice signs of life in certain parts of the library." +
                "\nThere are 2 possible paths to take");
        Room room8 = new Room("Room 8 ", "The path opens up to a large outside garden, blocked off with large heavy stone walls." +
                "\nIt feels like somethings watching you, although you cannot place it." +
                "The path splits, and there are now 3 paths to choose between.");
        Room room9 = new Room("Room 9 ", "You enter a kitchen. There are pots and pans as well as knives scattered about." +
                "\nThere are 2 possible paths to take");
        Room room10 = new Room("Room 10", "You enter a bathroom. Theres no other way to go but back.");

        this.currentRoom = room1;

        //Room 1
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addItem(new Item("Flowerbomb", " - A bomb which sprays a soothing flower smell to distract enemies and lower their speed."));
        room1.addItem(new MeleeWeapon("Sword" , " - A sharp sword for defense and combat." , 100));
        room1.addItem(new Food("Cheese", " - A tasty slice of cheese for a hungry mouse.", 10));

        //Room 2
        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItem(new Item("Flashlight", " - A flashlight to illuminate dark areas."));
        room2.addItem(new Item("Map", " - A map to help you navigate the maze."));
        room2.addItem(new Food("Carrot" , " - A fresh and crunchy carrot stick.", 10));
        room2.addItem(new Food("Cheese" , " - A piece of cheese gone bad. Yuck! ", -30));
        room2.addItem(new RangedWeapon("Tail" , " - Whip-like tail." , 20, 5));
        room2.addEnemy(new Enemy("Feet", "A humans feet, tippy tapping around", shoes, 100));
        room2.addItem(new MeleeWeapon("Shoes", " - The shoes the human was wearing", 15));

        //Room 3
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItem(new Item("Compass", " - A compass that points to the nearest exit or objective."));
        room3.addItem(new Item("Shield" , " - A sturdy shield for added defense."));
        room3.addItem(new Food("Drink" , " - A drink that boosts energy but isn't good for health." , -15));
        room3.addItem(new Food("Pineapple" , " - A juicy slice of pineapple." , 15));


        //Room 4
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItem(new MeleeWeapon("Claws", " - extensions of your claws.", 7));
        room4.addItem(new Item("Key", " - A mysterious key. Its purpose is unknown."));
        room4.addItem(new Food("Mushroom", " - A suspicious looking mushroom", -15));
        room4.addItem(new Food("Almonds" , " - Almonds coated in sweet honey glaze." , 25));

        //Room 5
        room5.setSouth(room8);
        room5.addItem(new Item("Key", " - A mysterious key. Its purpose is unknown."));
        room5.addItem(new Food("Cheese", " - A cheese that seems extraordinary beyond whats normal.", 100));

        //Room 6
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setEast(room10);
        room6.addItem(new Item("Gloves", " - A pair of gloves to protect your paws."));
        room6.addItem(new Item("Bucket", " - A bucket that could be useful to carry things."));
        room6.addItem(new MeleeWeapon("Teeth", "Sharp metal extension to your teeth", 8));
        room6.addItem(new Food("Donut", " - A sugary donut, delicious but not very healthy" , -25));

        //Room 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.addItem(new Item("Book", " - An old book with strange symbols. What could it mean?"));
        room7.addItem(new Item("Boots" , " - Boots that enhance the player's movement speed temporarily."));
        room7.addItem(new Food("Nuts", " - A handful of mixed nuts, packed with energy", 10));
        room7.addItem(new Food("Shake" , " - A protein shake to aid in strength and recovery" ,30));
        room7.addEnemy(new Enemy("Book", "A human arm holding a book", book, 100));


        // Room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room8.addItem(new Item("Book", " - An old book with strange symbols. What could it mean?"));
        room8.addItem(new Item("Candle", " - A flickering candle that casts eerie shadows."));
        room8.addItem(new Food("Platter" , " - A platter with a variety of cheese." , 45));
        room8.addItem(new Food("Buttercream", " - A delectable dollop of creamy, smooth buttercream frosting, oozing with richness and sweetness." , -40));
        room8.addEnemy(new Enemy("Cat" , "dangerous kitty cat, with only one eye", claws, 100));

        //Room 9
        room9.setNorth(room6);
        room9.setWest(room8);
        room9.addItem(new Item("Candle", " - A flickering candle that casts eerie shadows."));
        room9.addItem(new MeleeWeapon("Knife", " - A big cooking knife. It seems dangerous." , 10));
        room9.addItem(new Food("Apple", " - A shiny red apple.", 15));

        //Room 10
        room10.setWest(room6);
        room10.addItem(new Item("Toothbrush", " - Does someone need brushing?"));
        room10.addItem(new Food("Brie", " - +" + "Innocent looking brie.", -100));
    }

    Weapon shoes = new MeleeWeapon("Shoes", " - Shoes the human was wearing", 15);
    Weapon claws = new MeleeWeapon("Claws"," - Far reaching legs with sharp claws", 15);
    Weapon book = new MeleeWeapon("Book", " - Long arms with a book, it might get worn out after a while", 20);
    public Map() {
        this.weaponList = new ArrayList<>();
        weaponList.add(shoes);
        weaponList.add(claws);
        weaponList.add(book);
    }

    public Room getStarterRoom() {
        return currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public ArrayList<Enemy> getEnemyList() {
        return currentRoom.getEnemyList();
    }
}
