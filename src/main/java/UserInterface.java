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

    public String getInput() {
        while (!scanner.hasNextLine()) {
            scanner.next();
            System.out.println("What you entered is not an option, write help, exit or look.");
        }
        return scanner.nextLine();
    }

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }

    public void startGame() {
        adventure.buildMap();

        //TODO navngiv spil
        System.out.println(BLUE_UNDERLINED + BLUE_BOLD + "Welcome to the Mouse Trap." + "\u001B[0m");
        printMouseArt();
        System.out.println(BLACK_BOLD + "Directions: You enter a labyrinth as a mouse, and need to find your way to the holy grail of cheese." +
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
                System.out.println("'look' to see surroundings and items in the room.");
                System.out.println("Exit ");
            } else if (menu.equals("exit")) {
                System.out.println("We hope to see you again soon");
                runProgram = false;
            } else if (menu.equals("look")) {
                Room currentRoom = adventure.getCurrentRoom();
                System.out.println(currentRoom.getDescription());
                adventure.showAvailableItems(currentRoom);
            } else if (menu.contains("go")) {
                adventure.directions(menu);
            } else if (menu.equals("inventory") || menu.equals("inv") || menu.equals("invent")) {
                adventure.showInventory();
            } else if (menu.contains("take")) {
                String[] command = menu.split(" ");
                boolean successTake = adventure.takeItem(command[1]);
                if (successTake) {
                    System.out.println("You have taken " + command[1]);
                } else {
                    System.out.println(" You cant take this item");
                }
            } else if (menu.startsWith("drop")) {
                adventure.dropItem(menu.substring(5));
            }else if (menu.contains("eat")) {
                String[] command = menu.split(" ");
                FoodEnum isFood = adventure.eatFood(command[1]);
                if (isFood == FoodEnum.FOOD) {
                    System.out.println("You have eaten: " + command[1]);
                    System.out.println("Your health in points: " + adventure.getHealth());
                    System.out.println(adventure.printHealthDescription());
                } else if (isFood == FoodEnum.NOT_FOUND) {
                    System.out.println(command[1] + " is not available.");
                } else if (isFood == FoodEnum.NO_FOOD) {
                    System.out.println("You cannot eat " + command[1]);
                }
            }else if(menu.contains("health")) {
                System.out.println("Your health in points: " + adventure.getHealth());
                System.out.println(adventure.printHealthDescription());
            }
        }
    }
}