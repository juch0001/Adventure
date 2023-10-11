import java.util.ArrayList;

public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;
    private Weapon enemyWeapon;

    private ArrayList <Enemy> enemyList = new ArrayList<>();


    public Enemy(String enemyName, String enemyDescription,Weapon enemyWeapon, int enemyHealth) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
    }

    public void setEnemyHealth(int damage) {
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
