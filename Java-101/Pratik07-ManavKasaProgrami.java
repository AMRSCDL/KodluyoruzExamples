import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double ArmutF=2.24;
        double ElmaF=3.67;
        double DomatesF=1.11;
        double MuzF=0.95;
        double PatlicanF=5.00;

        int Armut;
        int Elma;
        int Domates;
        int Muz;
        int Patlican;




        System.out.println("Kaç kilo armut istiyorsunuz? : ");
        Armut = input.nextInt();

        System.out.println("Kaç kilo elma istiyorsunuz? : ");
        Elma = input.nextInt();

        System.out.println("Kaç kilo domates istiyorsunuz? : ");
        Domates = input.nextInt();

        System.out.println("Kaç kilo muz istiyorsunuz? : ");
        Muz = input.nextInt();

        System.out.println("Kaç kilo patlıcan istiyorsunuz? : ");
        Patlican = input.nextInt();

        double total = (Armut*ArmutF)+(Elma*ElmaF)+(Domates*DomatesF)+(Muz*MuzF)+(Patlican*PatlicanF);

        System.out.println("Toplam tutar: "+total+" Tl");

    }
}
