import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Bir sayı giriniz: ");
        int sayi = input.nextInt();

        int tempSayi = sayi;
        int basamak;
        int toplam=0;

        while (tempSayi != 0) {
            basamak = tempSayi % 10;
            tempSayi /= 10;
            toplam +=basamak;
        }
        System.out.println("Girdiğiniz "+sayi +" sayısının basamaklarının rakam rakam toplamı: " +toplam);
    }
}
