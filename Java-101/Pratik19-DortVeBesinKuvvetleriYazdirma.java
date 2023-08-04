import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi;
        boolean a = true;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Ekrana bir sayı girin: ");
            sayi = input.nextInt();
            if (sayi < 0) {
                System.out.println("Pozitif bir sayı giriniz");
                a = true;
            } else {
                System.out.println(sayi + " sayısına kadar olan 4'ün katları:");
                for (int i = 1; i < sayi; i *= 4) {
                    System.out.print(i + ", ");

                }
                System.out.println("\n" + sayi + " sayısına kadar olan 5'in katları:");
                for (int j = 1; j < sayi; j *= 5) {
                    System.out.print(j + ", ");
                }

                a = false;
            }
        } while (a);
    }
}
