import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mesafe;
        int acilis = 10;
        int minimum = 20;

        System.out.println("Km cinsinden gidilen mesafeyi giriniz: ");
        mesafe = input.nextInt();

        double islem = acilis+(mesafe*2.20);
        int tutar = (int) islem;

        boolean yirmi = islem >= 20;
        String sonuc = yirmi ? "Ödenecek tutar : "+ tutar+" lira" : "Ödenecek tutar :"+minimum+" lira";
        System.out.println(sonuc);


    }
}
