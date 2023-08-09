import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, r;
        int faktoriyelN = 1, faktoriyelR = 1, faktoriyelNR = 1;

        boolean a = true;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("n sayısını giriniz sayısı: ");
            n = input.nextInt();
            System.out.println("r sayısını giriniz sayısı: ");
            r = input.nextInt();
            if (n < 0 || r < 0 || n<r) {
                System.out.println("C(" + n + "," + r + ") kombinasyonu geçersiz bir kombinasyondur! Tekrar veri girişi yapınız.");
                a = true;
            } else {
                for (int i = 1; i <= n; i++) {
                    faktoriyelN = faktoriyelN * i;
                }
                for (int i = 1; i <= r; i++) {
                    faktoriyelR = faktoriyelR * i;
                }
                for (int i = 1; i <= n - r; i++) {
                    faktoriyelNR = faktoriyelNR * i;
                }
                a = false;
            }
        } while (a);

        int islem = faktoriyelN / (faktoriyelR * faktoriyelNR);
        System.out.println("C(" + n + "," + r + ") kombinasyonu sonucunuz: " + islem);
    }
}
