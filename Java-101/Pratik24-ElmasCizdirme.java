import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Satır sayısını girin: ");
        n = input.nextInt();

        for (int i = 1; i <= n; i += 2) {
            for (int j = 1; j <= n - i; j += 2) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n - 2; i >= 1; i -= 2) {
            for (int j = 1; j <= n - i; j += 2) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
