import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi;
        int toplam = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Bir sayı giriniz: ");
            sayi = input.nextInt();
            if (sayi % 2 == 1) {
                break;
            } else if (sayi % 4 == 0) {
                toplam += sayi;
            }
        }


        System.out.println("Girilen sayılardan çift ve 4'ün katı olan sayıların toplamı: " + toplam);
    }
}

