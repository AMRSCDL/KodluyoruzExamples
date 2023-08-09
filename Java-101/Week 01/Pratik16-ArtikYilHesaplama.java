import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int yil;

        Scanner input = new Scanner(System.in);

        System.out.println("Yıl giriniz: ");
        yil = input.nextInt();

        if (yil < 0) {
            System.out.println("Hatalı yıl girdiniz");
        } else {
            if ((yil % 4 == 0 && yil % 100 != 0) || yil % 400 == 0) {
                System.out.println(yil + " Artık yıldır.");
            } else {
                System.out.println(yil + " Artık yıl değildir.");
            }
        }
    }
}
