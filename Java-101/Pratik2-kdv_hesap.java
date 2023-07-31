import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tutar;

        System.out.println("Tutarı giriniz: ");
        tutar = input.nextInt();

        double kdv18 = tutar*18/100;
        double kdv8 = tutar*8/100;
        double sonucKdv18= kdv18+tutar;
        double sonucKdv8= kdv8+tutar;

        boolean buyukMu = tutar >= 1000;
        String sonuc = buyukMu ? "Tutar 1000'den büyük olduğu için %8 kdv li hesap : "+ sonucKdv8 : "Tutar 1000'den küçük olduğu için %18 kdv li hesap :"+sonucKdv18;
        System.out.println(sonuc);
    }
}
