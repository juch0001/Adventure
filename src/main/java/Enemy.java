import java.util.ArrayList;

public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private String enemyWeapon;
    private int enemyHealth;
    private ArrayList<Enemy> enemyList;

    public Enemy(String enemyName, String enemyDescription, String enemyWeapon, int enemyHealth) {
        this.enemyName = enemyName;
        this.enemyWeapon = enemyWeapon;
        this.enemyHealth = enemyHealth;
    }

        //ENEMYWEAPON SKAL IKKE VÆRE STRING MEN WEAPON

    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
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

    public void setEnemyHealth() {
        this.enemyHealth = enemyHealth;
    }
}
