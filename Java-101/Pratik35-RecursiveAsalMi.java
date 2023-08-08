import java.util.Scanner;

public class Main {
    static boolean asalMi(int sayi) {
        if (sayi <= 1) {
            return false;
        }
        for (int i = 2; i * i <= sayi; i++) {
            if (sayi % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı giriniz: ");
        int sayi = input.nextInt();

        if (asalMi(sayi)) {
            System.out.println(sayi + " sayısı ASALDIR!");
        } else {
            System.out.println(sayi + " sayısı ASAL değildir!");
        }
    }
}
