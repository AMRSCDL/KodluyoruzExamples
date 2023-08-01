import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int boy;
        int kilo;

        System.out.println("Lütfen boyunuzu (metre cinsinden) giriniz: ");
        boy = input.nextInt();

        System.out.println("Lütfen kilonuzu giriniz: ");
        kilo = input.nextInt();

        float boy1 = (float) boy/100;
        double vki = kilo/(boy1*boy1);
        
        System.out.println("boy: "+boy1+"\nkilo: "+kilo+"\nVücut Kitle İndeksiniz :"+vki);

    }
}
