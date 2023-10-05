public class MeleeWeapon extends Weapon {
    private int meleeDamage;

    public MeleeWeapon(String itemName, String itemDescription, int meleeDamage) {
        super(itemName, itemDescription);
        this.meleeDamage = meleeDamage;
    }

    public int getMeleeDamage() {
        return meleeDamage;
    }
}
