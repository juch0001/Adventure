import java.util.ArrayList;

public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private String enemyWeapon;
    private int enemyHealth;
    private int health;
    private ArrayList<Enemy> enemyList;

    public Enemy(String enemyName, String enemyDescription, String enemyWeapon, int enemyHealth) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyWeapon = enemyWeapon;
        this.enemyHealth = enemyHealth;
        this.enemyList = new ArrayList<>();
    }


        //ENEMYWEAPON SKAL IKKE VÆRE STRING MEN WEAPON

    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
    }

    public void damageHealth (int damage) {
        this.enemyHealth -= damage;
        if (this.enemyHealth <= 0) {
            System.out.println("You defeated the enemy!" + this.enemyName);
        }
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyWeapon() {
        return enemyWeapon;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int health) {
        this.enemyHealth = health;
    }

    public void receiveDamage (int damage) {
        this.enemyHealth -= damage;
        if (this.enemyHealth <0) {
            this.enemyHealth = 0;
        }
    }
}
