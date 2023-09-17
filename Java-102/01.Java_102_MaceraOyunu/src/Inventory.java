public class Inventory {
    private Weapon weapon;
    private Armour armour;
    private boolean water;
    private boolean firewood;
    private boolean food;

    public Inventory() {
        this.weapon = new  Weapon("Yumruk",-1,0,0);
        this.armour = new Armour("Yok",-1,0,0);
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }
}
