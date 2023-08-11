import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);
        System.out.println("Bir sayı giriniz: ");
        int sayi= input.nextInt();
        int k,b;
        int[] num = {15,12,788,1,-1,-778,2,0,sayi};
        int[] num1 = {15,12,788,1,-1,-778,2,0};

        System.out.println(" ");
        System.out.print("Dizi : {");
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i]);

            if (i < num1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");

        Arrays.sort(num);
        int index= Arrays.binarySearch(num,sayi);
        k=index-1;
        b=index+1;

        System.out.println("Girilen sayı: "+sayi);
        System.out.println("Girilen sayıdan küçük en yakın sayı: "+ num[k]);
        System.out.println("Girilen sayıdan büyük en yakın sayı: "+ num[b]);
    }
}
