import java.util.ArrayList;

public class Player {
    public static final String BLACK_BOLD = "\033[1;30m"; //Markeret sort (hvis man har hvid skærm)

    private Room currentRoom;
    private int health;
    private int enemyHealth;
    private int playerDamage;
    private Weapon enemyDamage;
    private Weapon currentWeapon;
    private Enemy currentEnemy;
    private ArrayList<Item> inventory;

    public Player(Room currentRoom) {
        this.inventory = new ArrayList<>();
        this.currentRoom = currentRoom;
        this.health = 100;
        this.enemyHealth = 100 ;
        this.currentWeapon = null;
        this.currentEnemy = null;
    }



    //TODO Enemy attack
   /* public AttackEnum enemyAttack(Enemy enemy) {
        if (enemy attack after player) {

            int playerDamage = currentWeapon.getDamage();
            int enemyDamage = currentEnemy.getEnemyWeapon().getDamage();

            getHealth(enemyDamage);
            this.health -= enemyDamage;


        } else if (enemy.getEnemyHealth() > 0){
            System.out.println("You damage to " + enemy.getEnemyName() + ".");


            int enemyDamage = currentWeapon.getDamage();


            setHealth(enemyDamage);
        this.health -= enemyDamage;

        return AttackEnum.ATTACKED;

        }else if(this.health <= 0){
            System.out.println("You have been defeated.");
            // TODO Reset spillet
            return AttackEnum.PLAYER_DEAD;
        }
        return null;
    }*/

    public void receiveDamage (int damage) {
        this.health -= damage;
    }


    //TODO Attack
    public AttackEnum attack(Enemy enemy) {
        playerDamage = currentWeapon.getDamage();

        enemy.setEnemyHealth(playerDamage);
        this.enemyHealth -= playerDamage;

        if (enemyHealth <= 0) {
            return AttackEnum.ENEMY_DEAD;
        } else {
            enemyDamage = currentEnemy.getEnemyWeapon();

            setHealth(enemyDamage);
            this.health -= enemyDamage;

            if (health <= 0) {
                return AttackEnum.PLAYER_DEAD;
            }
        }
        return (currentWeapon instanceof MeleeWeapon) ? AttackEnum.ATTACK_MELEE : AttackEnum.ATTACK_RANGED;
    }

    //TODO Equip
    public WeaponEnum equipWeapon(String itemName) {
        Item equipItem = findItem(itemName);
        if (equipItem instanceof Weapon) {
            currentWeapon = (Weapon) equipItem;
            inventory.remove(equipItem);
        return (equipItem instanceof Weapon) ? WeaponEnum.Weapon: WeaponEnum.NOT_WEAPON;
        } else if (equipItem == null) {
            return WeaponEnum.NOT_FOUND;
        } else {
            return WeaponEnum.NOT_WEAPON;
        }
    }

    //TODO Health
    public void setHealth(Item item) {
        if (item instanceof Food) {
            this.health += ((Food) item).getHealthPoints();
        }if (health > 100) {
            health = 100;
        } else if (item instanceof Weapon) {
            this.health -= currentEnemy.getEnemyWeapon();
        }
    }

    public String printHealthDescription() {
        String printHealthPoints = "";
        if (health > 0 && health <= 20) {
            printHealthPoints = "You are very low on health. You should eat something straight away.";
        }
        if (health > 20 && health <= 40) {
            printHealthPoints = "You are low on health. You should consider eating something.";
        }
        if (health > 40 && health <= 60) {
            printHealthPoints = "You have decent health. You could eat something, if you would like.";
        }
        if (health > 60 && health <= 80) {
            printHealthPoints = "You have plenty of health.";
        }
        if (health > 80 && health <= 100) {
            printHealthPoints = "You have full health.";
        }
        return printHealthPoints;
    }

    //TODO Eat
    public FoodEnum eatFood(String itemName) {
        Item eatItem = findItem(itemName);
        if (eatItem instanceof Food) {
            setHealth(eatItem);
            inventory.remove(eatItem);
            return FoodEnum.FOOD;
        } else if (eatItem == null) {
            return FoodEnum.NOT_FOUND;
        } else {
            return FoodEnum.NO_FOOD;
        }
    }

    //TODO Inventory
    public Player showInventory() {
        ArrayList<Item> inventory = getInventory();
        if (inventory.isEmpty()){
            System.out.println("your inventory is empty.");
        }else {
            System.out.println("Inventory");
            for (Item item : inventory) {
                System.out.println("- " + item.getItemName() + item.getItemDescription());
            }
        }
        return null;
    }

    public Item findItem (String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    //TODO Take item
    public boolean takeItem (String itemName) {
        for (Item item : currentRoom.getItemList()){
            if (item.getItemName().toLowerCase().equals(itemName.toLowerCase())){
                inventory.add(item);
                currentRoom.getItemList().remove(item);
                return true;
            }
        }
        return false;
    }

    //TODO Drop item
    public Player dropItem (String itemName) {
        Item item = findItem(itemName);
        if (item != null) {
            dropItem(item);
            currentRoom.addItem(item);
            System.out.println("You have dropped " + item.getItemName());
        } else {
            System.out.println("You dont have anything like " + itemName + " in your inventory.");
        }
        return null;
    }

    public void dropItem(Item item) {
        inventory.remove(item);
    }

    public Room showAvailableItems(Room room) {
        return currentRoom.showAvailableItems(room);
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
                    for (Item item : currentRoom.getItemList()) {
                    }
                    System.out.println("\n Type Look, to see which items are in the room.");
                } else {
                    System.out.println("Where would you like to go?");
                }
                break;
            case "go east":
                arrow = " → ";
                String eastResult = moveToRoom("go east");
                if (eastResult != null) {
                    System.out.println(BLACK_BOLD + "going east" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    for (Item item : currentRoom.getItemList()) {
                    }
                    System.out.println("\n Type Look, to see which items are in the room.");
                } else {
                    System.out.println("Where would you like to go?");
                }
                break;

            case "go south":
                arrow = " ↓ ";
                String southResult = moveToRoom("go south");
                if (southResult != null) {
                    System.out.println(BLACK_BOLD + "going south" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    for (Item item : currentRoom.getItemList()) {
                    }
                    System.out.println("\n Type Look, to see which items are in the room.");
                } else {
                    System.out.println("Where would you like to go?");
                }
                break;
            case "go west":
                arrow = " ← ";
                String westResult = moveToRoom("go west");
                if (westResult != null) {
                    System.out.println(BLACK_BOLD + "going west" + arrow + "\u001B[0m");
                    System.out.println("You are now in " + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    for (Item item : currentRoom.getItemList()) {
                }
                    System.out.println("\n Type Look, to see which items are in the room.");
                } else {
                    System.out.println("Where would you like to go?");
                }
                break;
            default:
                System.out.println("not avaliable");
                break;
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }


    public int getHealth() {
        return health;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }
}