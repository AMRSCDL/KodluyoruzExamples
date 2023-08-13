import java.util.Scanner;

public class Main {
    static boolean isPolindrom(String kelime){
        String cevir=String.valueOf(kelime);
        String tersineYaz= new StringBuilder(cevir).reverse().toString();
        if (kelime.equals(tersineYaz)){
            System.out.println(kelime+" Bu Kelime Palindromik Kelimedir.");
            return true;
        }else {
            System.out.println(kelime+"  Bu Kelime Palindromik Kelime değildir.");
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Bir kelime giriniz:");
        String kelime=input.next();
        isPolindrom(kelime);
    }
}
