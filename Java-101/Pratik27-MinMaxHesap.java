import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int howMuch;

        Scanner input = new Scanner(System.in);

        System.out.println("Kaç tane sayı gireceksiniz?");
        howMuch = input.nextInt();

        int sayi;
        int currentsayi;

        System.out.print("1. sayınızı girin: ");
        sayi = input.nextInt();

        int max = sayi;
        int min = sayi;

        for (int i = 2; i <= howMuch; i++) {
            System.out.print(i + ". sayınızı girin: ");
            currentsayi = input.nextInt();

            if (currentsayi > max) {
                max = currentsayi;
            }
            if (currentsayi < min) {
                min = currentsayi;
            }
        }

        System.out.println("En büyük sayı: " + max);
        System.out.println("En küçük sayı: " + min);
    }
}
