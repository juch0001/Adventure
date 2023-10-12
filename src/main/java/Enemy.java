import java.util.ArrayList;

public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;
    private Weapon enemyWeapon;

    public Enemy(String enemyName, String enemyDescription,Weapon enemyWeapon, int enemyHealth) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
    }

    public void hitEnemy(int damage) {
        this.enemyHealth -= damage;
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public Weapon getEnemyWeapon() {
        return enemyWeapon;
    }
}
