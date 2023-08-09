import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mat,turk,ing,fizik,kimya,resim;

        System.out.println("Matemetik notunuzu giriniz: ");
        mat = input.nextInt();
        System.out.println("Türkçe notunuzu giriniz: ");
        turk = input.nextInt();
        System.out.println("İngilizce notunuzu giriniz: ");
        ing = input.nextInt();
        System.out.println("Fizik notunuzu giriniz: ");
        fizik = input.nextInt();
        System.out.println("Kimya notunuzu giriniz: ");
        kimya = input.nextInt();
        System.out.println("Resim notunuzu giriniz: ");
        resim = input.nextInt();

        int toplam =(mat+turk+ing+fizik+kimya+resim);
        double islem = toplam/6;
        double ortalama = 65.0;
        String sonuc = (ortalama> islem)?"Sınfıfta Kaldı":"Sınıfı Geçti";
        System.out.println(sonuc+" Not Ortalamanız: "+islem);
    }
}