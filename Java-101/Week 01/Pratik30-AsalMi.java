import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int asal;
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        asal = input.nextInt();

        for (int i = 2; i <= asal; i++) {
            boolean asalMi = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    asalMi = false;
                    break;
                }
            }
            if (asalMi) {
                System.out.print(i+",");
            }
        }
    }
}