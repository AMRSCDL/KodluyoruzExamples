import java.util.*;

public class Main {

    public static void main(String[] args) {
        int sayi = (int) (Math.random() * 100);
        int tahmin;
        int hak = 5;
        boolean devam = true;
        Scanner input = new Scanner(System.in);

        System.out.println("0-100 arası bir sayı arıyorsunuz");

        do {
            System.out.println("Tahmininizi giriniz:");
            tahmin = input.nextInt();

            if (tahmin < 0 || tahmin > 100) {
                System.out.println("Hatalı giriş yaptınız. Tekrar deneyin");
            } else {
                if (tahmin == sayi) {
                    System.out.println("Doğru tahmin.");
                    devam = false;
                } else if (hak <= 1) {
                    devam = false;
                } else {
                    hak--;
                    if (tahmin > sayi) {
                        System.out.println("Girdiğiniz sayı gizli sayıdan daha büyük.");
                    } else {
                        System.out.println("Girdiğiniz sayı gizli sayıdan daha küçük.");
                    }
                    System.out.println("Tekrar deneyiniz. Kalan can: " + hak);
                }
            }
        } while (devam);

        System.out.println("Aradığınız sayı: " + sayi);
        if (tahmin == sayi) {
            System.out.println("Oyun bitti. Kazandınız!");
        } else {
            System.out.println("Oyun bitti. Kaybettiniz!");
        }
    }
}
