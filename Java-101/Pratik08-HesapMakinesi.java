import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int var1,var2;
        String islem;


        Scanner input = new Scanner(System.in);

        System.out.println("İlk değerinizi giriniz: ");
        var1 =input.nextInt();

        System.out.println("ikinci değeri giriniz: ");
        var2= input.nextInt();

        System.out.println("1-Toplama\n2-Çıkartma\n3-Çarpma\n4-Bölme\nYapmak istediğiniz işlem numarasını girin: ");
        islem= input.next();

        int topla = (var1+var2),cikar = (var1-var2),carp = (var1*var2),bol = (var1/var2);

        switch (islem){
            case "1":
                System.out.println("Toplama işlemi sonucunuz: "+topla);
                break;
            case "2":
                System.out.println("Çıkartma işlemi sonucunuz: "+cikar);
                break;
            case "3":
                System.out.println("Çarpma işlemi sonucunuz: "+carp);
                break;
            case "4":
                if (var1 == 0 || var2 == 0 ) {
                    System.out.println("Bir sayı 0'a bölünmez.");
                } else {
                    System.out.println("Bölme işlemi sonucunuz: " + bol);
                }
                break;
            default:
                System.out.println("İşlem adını yanlış girdiniz");
        }

    }
}
