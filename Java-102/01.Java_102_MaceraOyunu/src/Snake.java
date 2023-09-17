import java.util.Random;

public class Snake extends Obstacle {
    public Snake() {
        super("Yılan", 4, generateRandomDamage(), 14,5); // award rastgele olacak
    }
    private static int generateRandomDamage() {
        Random random = new Random();
        return random.nextInt(6 - 3 + 1) + 3;
    }
}
