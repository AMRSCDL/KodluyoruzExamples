import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double pi =3.14;
        int r;
        int a;

        System.out.println("Dairenin yarıçapını(r) giriniz : ");
        r = input.nextInt();

        System.out.println("Alanını bulmak istediğiniz dilimin merkez açı ölçüsünü(a) giriniz : ");
        a = input.nextInt();

        double alan = pi*r*r;
        double cevre =2*pi*r;
        double merkez = (pi*(r*r)*a)/360;

        System.out.println("Dairenizin alanı: "+alan+"\nDairenizin çevresi: "+cevre+"\nBulmak istediğiniz daire diliminin alanı: "+merkez);


    }
}
