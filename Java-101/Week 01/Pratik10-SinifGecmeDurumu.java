import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mat,fiz,turk,kim,muz;
        int gecmeNot = 55;


        Scanner input = new Scanner(System.in);

        System.out.println("Matematik notunuzu girin: ");
        mat =input.nextInt();

        System.out.println("Fizik notunuzu girin: ");
        fiz= input.nextInt();

        System.out.println("Türkçe notunuzu girin: ");
        turk= input.nextInt();

        System.out.println("Kimya notunuzu girin: ");
        kim= input.nextInt();

        System.out.println("Müzik notunuzu girin: ");
        muz= input.nextInt();

        int ortalama = (mat+fiz+turk+kim+muz)/5;

        if ((mat<0 || mat>100)||(fiz<0 || fiz>100)||(turk<0 || turk>100)||(kim<0 || kim>100)||(muz<0 || muz>100)) {
            System.out.println("Geçersiz not girdiniz! 0 ile 100 arasında bir not girmeniz gerekmektedir.");
        }else if (ortalama>=gecmeNot){
            System.out.println("Tebrikler geçtiniz. Ortalamanız: "+ortalama);
        } else {
            System.out.println("Üzgünüm kaldınız. Ortalamanız: "+ortalama);
        }
    }
}