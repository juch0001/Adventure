import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();
    Scanner scanner = new Scanner(System.in);

    public String getInput() {
        while (!scanner.hasNextLine()) {
            scanner.next();
            System.out.println("What you entered is not an option, write help, exit or look.");
        }
        return scanner.nextLine();
    }

    public void startGame() {
        adventure.buildMap();

        //TODO navngiv spil
        System.out.println("Welcome to the Mouse Trap.");
        System.out.println("Write help if you need help.");
        System.out.println("Directions: You enter a labyrinth as a mouse, and need to find your way to the holy grail of cheese. You can go north, east, south or west." +
                "\nDepending on where you are, you may only be able to go certain ways, in certain places." +
                "\nTo choose a direction, write 'go' and the direction you would like to go.");

        boolean runProgram = true;

        String menu = "";

        //Todo menu
        while (runProgram) {

            menu = getInput();

            if (menu.equals("help")) {
                System.out.println("To go south, write 'go south'. To go north, write 'go north'. To go east, write 'go east'." +
                        " To go west, write 'go west'.");
                System.out.println("Look");
                System.out.println("Exit ");
            } else if (menu.equals("exit")) {
                System.out.println("We hope to see you again soon");
                runProgram = false;
            } else if (menu.equals("look")) {
                System.out.println(adventure.getCurrentRoom().getDescription());
            } else if (menu.contains("go")) {
                adventure.directions(menu);
            }

        }
    }
}
