public class Obstacle {
    private String Name;
    private int id;
    private int damage;
    private int health;
    private int award;
    private int originalHealth;


    public Obstacle(String name, int id, int damage, int health ,int award) {
        Name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.originalHealth = health;
        this.award = award;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
