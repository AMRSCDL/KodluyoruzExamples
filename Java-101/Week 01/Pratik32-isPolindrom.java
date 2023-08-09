import java.util.Scanner;

public class Main {
    static boolean isPolindrom(int sayi){
        String cevir=String.valueOf(sayi);
        String tersineYaz= new StringBuilder(cevir).reverse().toString();
        int tersineSayi=Integer.parseInt(tersineYaz);
        if (sayi==tersineSayi){
            System.out.println(sayi+" Bu sayı polindrom bir sayıdır.");
            return true;
        }else {
            System.out.println(sayi+" Bu sayı polindrom bşir sayı değildir.");
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Bir sayı giriniz:");
        int sayi=input.nextInt();
        isPolindrom(sayi);
    }
}
