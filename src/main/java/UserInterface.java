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
        System.out.println("Welcome to your last day.");
        System.out.println("Directions: You enter a labyrinth, and need to find your way out. You can go north, east, south or west." +
                " Depending on where you are, you may only be able to go certain ways, in certain places. To choose a direction," +
                " write 'go' and the direction you would like to go.");
        boolean runProgram = true;

        String menu = "";

        //Todo menu
        while (runProgram) {
            System.out.println("\nMenu:");
            System.out.println("Help");
            System.out.println("Exit ");
            System.out.println("Look");

            menu = getInput();

            if (menu.equals("help")) {
                System.out.println("Help:");
                System.out.println("To go south, write 'go south'. To go north, write 'go north'. To go east, write 'go east'." +
                        " To go west, write 'go west'.");
            } else if (menu.equals("exit")) {
                System.out.println("We hope to see you again soon");
                runProgram = false;
            } else if (menu.equals("look")) {
                //metode for at fortælle om currentRoom
            } else if (menu.contains("go")) {
                System.out.println("vi vil gerne gå");
                go(menu);
            }
        }
    }
    public void go(String menu) {


        // TODO retning - public void metode
        switch (menu) {
            case "go north":
                System.out.println("going north");
                break;
            case "go east":
                System.out.println("going east");
                adventure.moveToRoom("go east");
                System.out.println(adventure.getCurrentRoom().getName());
                break;
            case "go south":
                System.out.println("going south");
                break;
            case "go west":
                System.out.println("going west");
                break;
        }
    }

}
