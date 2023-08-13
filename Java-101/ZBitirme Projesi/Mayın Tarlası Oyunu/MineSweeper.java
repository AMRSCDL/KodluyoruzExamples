import java.util.*;

public class MineSweeper {
    public int[][] area;
    public boolean[][] opened;

    public MineSweeper(int row, int col) {
        area = new int[row][col];
        opened = new boolean[row][col];
    }

    public void printArea() {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (opened[i][j]) {
                    if (area[i][j] == -1) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" " + area[i][j] + " ");
                    }
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public void randomBomb() {
        int bombCount = area.length * area[0].length / 4;
        Random rand = new Random();

        for (int i = 0; i < bombCount; i++) {
            int randomRow = rand.nextInt(area.length);
            int randomCol = rand.nextInt(area[0].length);
            area[randomRow][randomCol] = -1;
            //bombaların konum bilgisine ulaşmak için
            //System.out.println("Bombanın olduğu row: " + randomRow + ", col: " + randomCol);
        }
    }

    public void printBombs() {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] == -1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }


    public void degerAl() {
        Scanner scanner = new Scanner(System.in);
        boolean dongu = true;
        int remainingNonBombCells = area.length * area[0].length - area.length * area[0].length / 4;

        do {
            System.out.print("Satır değerini girin: ");
            int row = scanner.nextInt();

            System.out.print("Sütun değerini girin: ");
            int col = scanner.nextInt();

            if (row < 0 || row >= area.length || col < 0 || col >= area[0].length) {
                System.out.println("Geçersiz satır veya sütun değeri.");
                continue;
            }

            opened[row][col] = true;

            if (area[row][col] == -1) {
                System.out.println("Bomba! Oyun bitti.");
                dongu = false;
            } else {
                int bombCount = 0;
                for (int i = Math.max(0, row - 1); i <= Math.min(area.length - 1, row + 1); i++) {
                    for (int j = Math.max(0, col - 1); j <= Math.min(area[0].length - 1, col + 1); j++) {
                        if (area[i][j] == -1) {
                            bombCount++;
                        }
                    }
                }
                area[row][col] = bombCount;
                printArea();


                remainingNonBombCells--;
                if (remainingNonBombCells == 0) {
                    System.out.println("Tebrikler! Oyunu kazandınız.");
                    dongu = false;
                }
            }
        } while (dongu);
        scanner.close();
    }
}