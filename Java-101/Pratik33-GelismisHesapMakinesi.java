import java.util.Scanner;

public class Main {
    static int toplama(int... sayilar) {
        int total = 0;
        for (int sayi : sayilar) {
            total += sayi;
        }
        return total;
    }

    static int cikarma(int... sayilar) {
        int total = 0;
        for (int sayi : sayilar) {
            total -= sayi;
        }
        return total;
    }

    static int carp(int... sayilar) {
        int total = 1;
        for (int sayi : sayilar) {
            total *= sayi;
        }
        return total;
    }

    static int bol(int a, int b) {
        int islem = a / b;
        if (a < b) {
            System.out.println("Bu işlem geçersizdir.Bölünen bölenden küçük olamaz.");
            return 0;
        }
        return islem;
    }

    static int ustHesapla(int a, int b) {
        int sonuc = 1;
        for (int i = 1; i <= b; i++) {
            sonuc *= a;
        }
        return sonuc;
    }

    static int faktoriyel(int a) {
        int faktoriyel = 1;
        for (int i = 1; i <= a; i++) {
            faktoriyel *= i;
        }
        return faktoriyel;
    }

    static int mod(int a, int b) {
        int islem = a % b;
        return islem;
    }
    public static int[] dikdortgen(int a, int b) {
        int cevre = 2 * (a + b);
        int alan = a * b;

        int[] sonuclar = {cevre, alan};
        return sonuclar;
    }


    public static void main(String[] args) {
        boolean keepItOpen = true;
        Scanner input = new Scanner(System.in);



        while (keepItOpen){
            System.out.println("1-Toplama\n2-Çıkartma\n3-Çarpma\n4-Bölme\n5-Üst Hesaplama\n6-Faktoriyel\n7-Mod\n8-Dikdörtgen Çevre ve Alan\nYapmak istediğiniz işlemi seçiniz");
            int islem = input.nextInt();
            if (islem >= 1 && islem <= 8) {
                if (islem >= 1 && islem <= 3) {
                    System.out.println("Kaç tane sayı ile işlem yapacaksınız: ");
                    int say = input.nextInt();
                    if (say <= 0) {
                        System.out.println("Geçersiz giriş yaptınız. Tekrar deneyiniz.");
                    } else {
                        int[] sayilar = new int[say];
                        for (int i = 0; i < say; i++) {
                            System.out.println((i + 1) + " Numaralı sayıyı giriniz: ");
                            sayilar[i] = input.nextInt();
                        }

                        switch (islem) {
                            case 1:
                                System.out.println("Sonuç: " + toplama(sayilar));
                                break;
                            case 2:
                                System.out.println("Sonuç: " + cikarma(sayilar));
                                break;
                            case 3:
                                System.out.println("Sonuç: " + carp(sayilar));
                                break;
                        }
                    }
                } else if (islem == 4 || islem == 5 || islem == 7 || islem==8) {
                    System.out.println("İlk sayıyı giriniz: ");
                    int a = input.nextInt();
                    System.out.println("İkinci sayıyı giriniz: ");
                    int b = input.nextInt();

                    switch (islem) {
                        case 4:
                            System.out.println("Sonuç: " + bol(a, b));
                            break;
                        case 5:
                            System.out.println("Sonuç: " + ustHesapla(a, b));
                            break;
                        case 7:
                            System.out.println("Sonuç: " + mod(a, b));
                            break;
                        case 8:
                            int[] dikdortgenSonuc = dikdortgen(a, b);
                            int dikdortgenCevre = dikdortgenSonuc[0];
                            int dikdortgenAlan = dikdortgenSonuc[1];
                            System.out.println("Dikdörtgen Çevre: " + dikdortgenCevre);
                            System.out.println("Dikdörtgen Alan: " + dikdortgenAlan);
                            break;
                    }
                } else {
                    System.out.println("Sayı giriniz: ");
                    int a = input.nextInt();
                    switch (islem) {
                        case 6:
                            System.out.println("Sonuç: " + faktoriyel(a));
                            break;
                        default:
                            System.out.println("Geçersiz bir işlem numarası girdiniz.");
                    }
                }
            } else {
                System.out.println("Geçersiz bir işlem numarası girdiniz.");
            }
            System.out.println("\n1-Evet\n2-Hayır\nBaşka bir işlem yapmak ister misiniz?");
            int choice = input.nextInt();
            if (choice == 1) {
            } else if (choice == 2) {
                keepItOpen = false;
            } else {
                System.out.println("Geçersiz bir rakam girdiniz.");
            }
        }
        input.close();
    }
}
