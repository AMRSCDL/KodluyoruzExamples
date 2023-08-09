import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mesafe,yoltip,yas;
        double km = 0.10;

        Scanner input = new Scanner(System.in);


        System.out.println("Gideceğiniz mesafeyi km cinsinden giriniz: ");
        mesafe = input.nextInt();

        System.out.println("Yaşınızı giriniz: ");
        yas = input.nextInt();

        System.out.println("1-Tek Yön\n2-Gidiş Dönüş\nYolculuk tercihinize göre yanda yazan numarayı giriniz: ");
        yoltip = input.nextInt();

        double total = mesafe*km;
        double a50 =total-(total*0.50);
        double a10 =total-(total*0.10);
        double a30 =total-(total*0.30);

        if (yas<=12){
            if (yoltip==1){
                System.out.println("Toplam tutarınız: "+a50+" TL");
            }else{
                System.out.println("Toplam tutarınız:"+(((a50)*2)-(((a50)*2)*0.20))+" TL");
            }
        } else if (yas>12 && yas<=24) {
            if (yoltip==1){
                System.out.println("Toplam tutarınız: "+a10+" TL");
            }else{
                System.out.println("Toplam tutarınız: "+(((a10)*2)-(((a10)*2)*0.20))+" TL");
            }
        } else if (yas>24 && yas<65) {
            if (yoltip==1){
                System.out.println("Toplam tutarınız: "+total+" TL");
            }else{
                System.out.println("Toplam tutarınız: "+(((total)*2)-(((total)*2)*0.20))+" TL");
            }
        }else {
            if (yoltip==1){
                System.out.println("Toplam tutarınız: "+a30+" TL");
            }else{
                System.out.println("Toplam tutarınız: "+(((a30)*2)-(((a30)*2)*0.20))+" TL");
            }
        }
        //Hata mesajı
        if ((mesafe<=0)||(yoltip<1 || yoltip>2)||(yas<0)){
            System.out.println("Hatalı veri giridiniz");
        }

    }
}
