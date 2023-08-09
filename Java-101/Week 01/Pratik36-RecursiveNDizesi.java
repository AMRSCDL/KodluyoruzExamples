import java.util.Scanner;

public class Main {
    static String donguN(int sayi) {
        String output = "";
        output += sayi + " ";
        if (sayi <= 0) {
            return output;
        }

        output += donguN(sayi - 5);
        output += sayi + " ";
        return output;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int sayi = input.nextInt();
        System.out.println("N sayısı: " + sayi);

        System.out.println("Çıktısı: " + donguN(sayi));
    }
}
