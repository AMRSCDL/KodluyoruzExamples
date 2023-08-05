import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi;
        double sonuc = 0.0;

        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz: ");
        sayi = input.nextInt();

        for (double i = 1; i <= sayi; i++) {
            sonuc += (1 / i);
        }

        System.out.println(sonuc);

    }
}