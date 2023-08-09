import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int yil;

        Scanner input = new Scanner(System.in);


        System.out.println("Doğum yılınızı giriniz: ");
        yil = input.nextInt();

        int islem = yil%12;

        switch (islem) {
            case 0 -> System.out.println("Çin Zodyağınız Maymun");
            case 1 -> System.out.println("Çin Zodyağınız Horoz");
            case 2 -> System.out.println("Çin Zodyağınız Köpek");
            case 3 -> System.out.println("Çin Zodyağınız Domuz");
            case 4 -> System.out.println("Çin Zodyağınız Fare");
            case 5 -> System.out.println("Çin Zodyağınız Öküz");
            case 6 -> System.out.println("Çin Zodyağınız Kaplan");
            case 7 -> System.out.println("Çin Zodyağınız Tavşan");
            case 8 -> System.out.println("Çin Zodyağınız Ejder");
            case 9 -> System.out.println("Çin Zodyağınız Yılan");
            case 10 -> System.out.println("Çin Zodyağınız At");
            case 11 -> System.out.println("Çin Zodyağınız Koyun");
            default -> {
            }
        }
    }
}
