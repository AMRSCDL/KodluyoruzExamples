import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int kenarA;
        int kenarB;

        System.out.println("A yüksekliğini giriniz: ");
        kenarA = input.nextInt();

        System.out.println("B tabanını giriniz: ");
        kenarB = input.nextInt();

        int kenarCkare =(kenarA*kenarA)+(kenarB*kenarB);
        double kenarCdouble=Math.sqrt(kenarCkare);
        int kenarC = (int) kenarCdouble;

        int u = (kenarA+kenarB+kenarC)/2;
        int cevre= 2*u;

        int alanKare =u*(u-kenarA)*(u-kenarB)*(u-kenarC);
        double alanKareDouble=Math.sqrt(alanKare);
        int alan = (int) alanKareDouble;

        System.out.println("A Yüksekliğiniz: "+ kenarA +"\nB Tabanınız: "+kenarB+"\nC Uzun kenarınız(hipotenüs): "+ kenarC +"\nÜçgenin çevresi: "+cevre+"\nÜçgenin alanı: "+ alan);

    }
}
