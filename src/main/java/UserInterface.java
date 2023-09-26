import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    Scanner scanner;

    public UserInterface(){
        adventure= new Adventure();
        scanner=new Scanner(System.in);
    }

    public void startProgram() {

            Scanner keyboard = new Scanner(System.in);

            String direction = keyboard.nextLine();

            boolean runProgram= true;
            String menu;

            //Todo kommandoer
            while (runProgram){
                System.out.println("Menu");
                System.out.println("\n Help");
                System.out.println("\n Exit ");
                System.out.println("\n Look");
            }

            //Todo if_menu
        String menu

            switch (direction) {
                case "Go north" :
                    System.out.println("going north");
                    break;
                case "Go east":
                    System.out.println("going east");
                    break;
                case "Go south":
                    System.out.println("going south");
                    break;
                case "GO west":
                    System.out.println("going west");
                    break;
            }
        }
    }