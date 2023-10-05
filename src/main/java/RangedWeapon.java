public class RangedWeapon extends Weapon {
    private int ammo;

   public RangedWeapon(String itemName, String itemDescription, int ammo) {
       super(itemName, itemDescription);
       this.ammo = ammo;
   }

   public int getAmmo() {
       return ammo;
   }

}
