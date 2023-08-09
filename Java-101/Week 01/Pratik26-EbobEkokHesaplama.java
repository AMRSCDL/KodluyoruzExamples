import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int say1, say2, choice;

        Scanner input = new Scanner(System.in);

        System.out.println("1-EKOK \n2-EBOB\nYapmak istediğiniz işlemi seçiniz.");
        choice = input.nextInt();


        if (choice < 0 || choice > 2) {
            System.out.println("Hatalı işlem yaptınız. Tekrar deneyiniz.");
        } else {
            System.out.print("Sayı 1'i giriniz: ");
            say1 = input.nextInt();
            System.out.print("Sayı 2'yi giriniz: ");
            say2 = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 1; i <= (say1 * say2); i++)
                        if (i % say1 == 0 && i % say2 == 0) {
                            System.out.println("En küçük ortak katınız: "+i);
                            break;
                        }
                    break;
                case 2:
                    int ebob = 1;
                    for (int i = 1; i <= say1 && i <= say2; i++) {
                        if (say1 % i == 0 && say2 % i == 0) {
                            ebob = i;

                        }
                    }
                    System.out.println("En büyük ortak böleniniz: "+ebob);
            }
        }
    }
}
