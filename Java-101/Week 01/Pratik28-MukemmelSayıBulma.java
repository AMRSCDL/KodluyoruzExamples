import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi;
        int total=0;
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        sayi = input.nextInt();

        for (int i =1;i<sayi; i++){
            int islem = sayi%i;
            if (islem==0){
                total +=i;
            }
        }
        if (total==sayi){
            System.out.println(sayi+" Mükemmel sayıdır");
        }else {
            System.out.println(sayi+" Mükemmel sayı değildir");
        }

    }
}
