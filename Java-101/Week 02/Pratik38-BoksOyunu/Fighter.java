import java.util.Random;
public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    double dodge;

    public Fighter(String name,  int health, int weight) {
        this.name = name;
        this.health = health;
        this.weight = weight;

        Random random = new Random();
        this.dodge = random.nextDouble() * 100;
    }

    public int hit(Fighter foe) {
        System.out.println("------------");

        Random random = new Random();
        int inflictedDamage = random.nextInt(21);

        System.out.println(this.name + " => " + foe.name + " " +  inflictedDamage + " hasar vurdu.");

        if (foe.dodge()) {
            System.out.println(foe.name + " gelen hasarı savurdu.");
            return foe.health;
        }

        if (foe.health - inflictedDamage < 0)
            return 0;

        return foe.health - inflictedDamage;
    }

    public boolean dodge() {
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        return randomValue <= this.dodge;
    }
}