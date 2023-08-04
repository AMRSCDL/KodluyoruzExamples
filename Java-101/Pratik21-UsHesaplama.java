import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi, us;
        int sonuc = 1;

        Scanner input = new Scanner(System.in);

        System.out.println("Üssü alınacak sayıyı giriniz: ");
        sayi = input.nextInt();
        System.out.println(sayi + " üssü kaç olsun: ");
        us = input.nextInt();

        for (int i = 1; i <= us; i++) {
            sonuc *= sayi;
        }

        System.out.println("Sonuç: " + sonuc);
    }
}
