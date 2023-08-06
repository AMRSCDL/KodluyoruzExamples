import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Fibonacci serisinin uzunluğunu giriniz: ");
        int uzun = input.nextInt();

        System.out.println(uzun+" Elemanlı Fibonacci Serisi:");
        int ilk = 0;
        int iki = 1;

        for (int i = 0; i < uzun; i++) {
            System.out.print(ilk + " ");
            int sıradaki = ilk + iki;
            ilk = iki;
            iki = sıradaki;
        }
    }
}
