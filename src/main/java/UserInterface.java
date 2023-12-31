import java.util.Scanner;

public class UserInterface {
    public static final String BLUE_BOLD = "\033[1;34m"; //farvekode til blå
    public static final String BLUE_UNDERLINED = "\033[4;34m"; //blå linje under tekst
    public static final String BLACK_BOLD = "\033[1;30m"; //Markeret sort (hvis man har hvid skærm)
    public static final String RESET = "\033[0m";

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
        System.out.println(BLUE_UNDERLINED + BLUE_BOLD + "Welcome to the Mouse Trap." + RESET);
        printMouseArt();
        System.out.println(BLACK_BOLD + "Directions: You enter a labyrinth as a mouse, and need to find your way to the holy grail of cheese." +
                "\nYou can go north, east, south or west." +
                "\nTo choose a direction, write 'go' and the direction you would like to go." + RESET);
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
                System.out.println("write 'inventory' or 'inv' to see the items in your inventory.");
                System.out.println("write 'take' followed by the name of the item, to pick up an item.");
                System.out.println("write 'drop' followed by the name of the item you would like to drop.");
                System.out.println("write 'eat' followed by the name of the food you would like to eat.");
                System.out.println("write 'health' to get your health.");
                System.out.println("write 'equip' followed by the name of the weapon you would like to equip.");
                System.out.println("write 'attack' followed by the name of the enemy you would like to attack.");
                System.out.println("write 'exit' to leave the game.");
            } else if (menu.equals("exit")) {
                System.out.println("We hope to see you again soon");
                runProgram = false;
            } else if (menu.equals("look")) {
                Room currentRoom = adventure.getCurrentRoom();
                System.out.println();
                System.out.println(currentRoom.getDescription());
                adventure.showAvailableItems(currentRoom);
                System.out.println();
                adventure.showAvailableEnemies(currentRoom);
            } else if (menu.contains("go")) {
                adventure.directions(menu);
            } else if (menu.equals("inventory") || menu.equals("inv") || menu.equals("invent")) {
                adventure.showInventory();
            } else if (menu.contains("take")) {
                String[] command = menu.split(" ");
                boolean successTake = adventure.takeItem(command[1]);
                if (successTake) {
                    System.out.println(BLACK_BOLD + "You have taken " + command[1] + RESET);
                } else {
                    System.out.println(BLACK_BOLD + " You cant take this item" + RESET);
                }
            } else if (menu.startsWith("drop")) {
                adventure.dropItem(menu.substring(5));
            } else if (menu.contains("eat")) {
                String[] command = menu.split(" ");
                FoodEnum isFood = adventure.eatFood(command[1]);
                if (isFood == FoodEnum.FOOD) {
                    System.out.println("You have eaten: " + command[1]);
                    System.out.println(BLUE_BOLD + "Your health in points: " + adventure.getHealth() + RESET);
                    System.out.println(adventure.printHealthDescription());
                } else if (isFood == FoodEnum.NOT_FOUND) {
                    System.out.println(command[1] + " is not available.");
                } else if (isFood == FoodEnum.NO_FOOD) {
                    System.out.println("You cannot eat " + command[1]);
                }
            } else if (menu.contains("health")) {
                System.out.println(BLUE_BOLD + "Your health in points: " + adventure.getHealth() + RESET);
                System.out.println(adventure.printHealthDescription());
            } else if (menu.contains("equip")) {
                String[] command = menu.split(" ");
                WeaponEnum isWeapon = adventure.equipWeapon(command[1]);
                if (isWeapon == WeaponEnum.Weapon) {
                    System.out.println("You have equipped " + command[1]);
                } else if (isWeapon == WeaponEnum.NOT_FOUND) {
                    System.out.println(command[1] + " is not available.");
                } else if (isWeapon == WeaponEnum.NOT_WEAPON) {
                    System.out.println("You cannot equip " + command[1]);
                }
            } else if (menu.startsWith("attack")) {
                String enemyName = menu.substring(7).toLowerCase();
                Enemy enemy = adventure.getPlayer().getCurrentRoom().findEnemyByName(enemyName);
                if (enemy != null) {
                    AttackEnum attackPossible = adventure.getPlayer().attack(enemy);
                    if (attackPossible == AttackEnum.ATTACK_MELEE){
                        System.out.println();
                        System.out.println("You have attacked " + enemyName);
                        System.out.println("You dealt " + adventure.getPlayerDamage() + " damage to " + enemyName + ".");
                        if (enemy.getEnemyHealth() > 0)
                            System.out.println(enemyName + " health: " + enemy.getEnemyHealth());
                            System.out.println(enemyName + " has dealt " + adventure.getEnemyDamage() + " damage to you.");
                            System.out.println("Your health: " + adventure.getPlayer().getHealth());
                            System.out.println(adventure.printHealthDescription());
                    } else if (attackPossible == AttackEnum.ATTACK_RANGED) {
                        System.out.println("You have shot " + enemyName);
                        System.out.println("You dealt " + adventure.getPlayerDamage() + "damage" + enemyName + ".");
                        if (enemy.getEnemyHealth() > 0)
                            System.out.println(enemyName + " health: " + enemy.getEnemyHealth());
                        System.out.println(enemyName + " has dealt " + adventure.getEnemyDamage() + " damage to you.");
                        System.out.println("Your health: " + adventure.getPlayer().getHealth());
                        System.out.println(adventure.printHealthDescription());
                    } else if (attackPossible == AttackEnum.NO_AMMO) {
                        System.out.println("You have no ammo left. ");
                    } else if (attackPossible == AttackEnum.WEAPON_NOT_FOUND) {
                        System.out.println("You have no weapon equipped");

                    }else if (attackPossible == AttackEnum.ENEMY_DEAD) {
                        System.out.println("You defeated " + enemyName + "!");
                        adventure.dropWeapon(enemy.getEnemyWeapon());
                        adventure.removeEnemy(enemy);
                    }
                } else {
                    System.out.println("No enemy found with the name: " + enemyName);
                }
            } if (adventure.getPlayerIsDead()) {
                System.out.println();
                System.out.println("You have died!");
                runProgram = false;
            }
        }
    }
}