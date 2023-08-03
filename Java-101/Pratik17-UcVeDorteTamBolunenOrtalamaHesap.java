import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi;
        int toplam = 0;
        int sayac = 0;
        boolean doruMu=true;

        Scanner input = new Scanner(System.in);

        while (doruMu){
            System.out.println("Sayı giriniz: ");
            sayi = input.nextInt();
            doruMu=true;
            if (sayi < 0) {
                System.out.println("Hatalı Giriş Yaptınız");
            } else {
                for (int i = 1; i <= sayi; i++) {
                    if (i % 3 == 0 && i % 4 == 0) {
                        System.out.println(i);
                        toplam += i;
                        sayac++;
                    }
                }
                int islem=toplam/sayac;
                System.out.println("3'e ve 4'e tam bölünen sayılarınızın toplamı: "+toplam+", ve bu sayıların ortalaması: "+islem);
                doruMu =false;
            }
        }
    }
}
