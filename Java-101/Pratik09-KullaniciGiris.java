import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName,password,degistir,yenipassword;


        Scanner input = new Scanner(System.in);

        System.out.println("Kullanıcı adınızın giriniz: ");
        userName =input.next();

        System.out.println("Şifrenizi giriniz: ");
        password= input.next();

        if (userName.equals("patika") && password.equals("java123")){
            System.out.println("Giriş yapıldı");
        }else{
            System.out.println("Hatalı giriş yaptınız!");
            System.out.println("1-Evet\n2-Hayır\nŞifrenizi sıfırlamak ister misiniz? ");
            degistir=input.next();
            switch (degistir){
                case "1":
                    System.out.println("Yeni şifrenizi giriniz: ");
                    yenipassword= input.next();
                    if (yenipassword.equals("java123")){
                        System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz");
                    }else{
                        System.out.println("Şifre oluşturuldu.");
                    }
                    break;
                case "2":
                    System.out.println("Yeniden giriş yapmayı deneyin");
                    break;
                default:

            }

        }
    }
}
