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
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
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

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public AttackEnum attackPlayer (Player player) {
        if (enemyWeapon == null){
            System.out.println("no weapon");
            return AttackEnum.NO_AMMO;
        }
        int enemyDamage = enemyWeapon.getDamage();
        player.receiveDamage(enemyDamage);
        if (player.getHealth() <=0 ){
            System.out.println("You have been defeated");
        }
        return (enemyWeapon instanceof MeleeWeapon) ? AttackEnum.ATTACK_MELEE : AttackEnum.ATTACK_RANGED;
    }

    public Weapon getEnemyWeapon() {
        return enemyWeapon;
    }

}
