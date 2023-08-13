public class Main {

    public static void main(String[] args) {
        MineSweeper oyun = new MineSweeper(3,3);
        oyun.printArea();
        oyun.randomBomb();
        oyun.degerAl();
        oyun.printBombs();

    }
}
