import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ay, gun;

        Scanner input = new Scanner(System.in);

        System.out.println("1-Ocak\n2-Şubat\n3-Mart\n4-Nisan\n5-Mayıs\n6-Haziran\n7-Temmuz\n8-Ağustos\n9-Eylül\n10-Ekim\n11-Kasım\n12-Aralık\nDoğduğunuz ayın numarasını girin: ");
        ay = input.nextInt();

        System.out.println("Hangi gün doğdunuzu: ");
        gun = input.nextInt();

        switch (ay) {
            case 1:
                if (gun >= 22) {
                    System.out.println("Kova Burcusunuz");
                } else {
                    System.out.println("Oğlak Burcusunuz");
                }
                break;
            case 2:
                if (gun >= 20) {
                    System.out.println("Balık Burcusunuz");
                } else {
                    System.out.println("Kova Burcusunuz");
                }
                break;
            case 3:
                if (gun >= 21) {
                    System.out.println("Koç Burcusunuz");
                } else {
                    System.out.println("Balık Burcusunuz");
                }
                break;
            case 4:
                if (gun >= 21) {
                    System.out.println("Boğa Burcusunuz");
                } else {
                    System.out.println("Koç Burcusunuz");
                }
                break;
            case 5:
                if (gun >= 22) {
                    System.out.println("İkizler Burcusunuz");
                } else {
                    System.out.println("Boğa Burcusunuz");
                }
                break;
            case 6:
                if (gun >= 22) {
                    System.out.println("Yengeç Burcusunuz");
                } else {
                    System.out.println("İkizler Burcusunuz");
                }
                break;
            case 7:
                if (gun >= 23) {
                    System.out.println("Aslan Burcusunuz");
                } else {
                    System.out.println("Yengeç Burcusunuz");
                }
                break;
            case 8:
                if (gun >= 23) {
                    System.out.println("Başak Burcusunuz");
                } else {
                    System.out.println("Aslan Burcusunuz");
                }
                break;
            case 9:
                if (gun >= 23) {
                    System.out.println("Terazi Burcusunuz");
                } else {
                    System.out.println("Başak Burcusunuz");
                }
                break;
            case 10:
                if (gun >= 23) {
                    System.out.println("Akrep Burcusunuz");
                } else {
                    System.out.println("Terazi Burcusunuz");
                }
                break;
            case 11:
                if (gun >= 22) {
                    System.out.println("Yay Burcusunuz");
                } else {
                    System.out.println("Akrep Burcusunuz");
                }
                break;
            case 12:
                if (gun >= 22) {
                    System.out.println("Oğlak Burcusunuz");
                } else {
                    System.out.println("Yay Burcusunuz");
                }
                break;
            default:
                System.out.println("Geçersiz bir ay numarası girdiniz");
        }

        if (gun > 31 || gun < 1) {
            System.out.println("Geçersiz gün sayısı girdiniz");
        }
    }
}
