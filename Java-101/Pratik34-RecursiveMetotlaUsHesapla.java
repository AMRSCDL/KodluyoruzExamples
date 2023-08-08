import java.util.Scanner;

public class Main {
    static int usHeaspla(int base,int us) {
        int sonuc=1;
        for (int i = 1; i <= us; i++) {
            sonuc *= base;
        }
        return sonuc;
    }
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Taban sayı giriniz: ");
        int base= input.nextInt();
        System.out.println("Üssü giriniz: ");
        int us= input.nextInt();

        System.out.println(usHeaspla(base,us));

    }
}
