import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName, password;
        int islem;
        int right = 3;
        int balance = 3000;
        int add, pull;
        boolean keepItOpen = true;

        Scanner input = new Scanner(System.in);


        while (right > 0) {
            System.out.print("Kullanıcı adınız: ");
            userName = input.next();
            System.out.print("Parolanız: ");
            password = input.next();

            if (userName.equals("Ahmet") && password.equals("12345")) {
                System.out.println("Merhaba, X bankasına hoşgeldiniz.");


                while (keepItOpen) {
                    System.out.println("1-Para Yatırma\n2-Para Çekme\n3-Bakiye sorgulama\n4-Çıkış yap\nYapmak istediğiniz işlemin numarasını giriniz: ");
                    islem = input.nextInt();
                    switch (islem) {
                        case 1:
                            System.out.print("Eklemek istediğiniz tutarı giriniz: ");
                            add = input.nextInt();
                            balance += add;
                            System.out.println(add + " tutarında hesabınıza ekleme yapıldı.Anlık Bakiyeniz: " + balance);
                            break;
                        case 2:
                            System.out.println("Çekmek istediğiniz tutarı giriniz: ");
                            pull = input.nextInt();
                            if (balance < pull) {
                                System.out.println("Bakiye yetersiz.Geçerli bir miktar giriniz");
                            } else {
                                balance -= pull;
                                System.out.println(pull + " tutarında çekim işleminiz onaylandı.Anlık bakiyeniz: " + balance);
                            }
                            break;
                        case 3:
                            System.out.println("Anlık bakiyeniz: " + balance);
                            break;
                        case 4:
                            System.out.println("İyi günler. Yine bekleriz");
                            keepItOpen = false;
                            break;
                        default:
                            System.out.println("Geçersiz bir işlem numarası girdiniz. Tekrar deneyin.");
                    }
                }
            } else {
                --right;
                System.out.println("Hatalı giriş yaptınız.Tekrar deneyin.Kalan deneme hakkınız: " + right);
            }
            break;
        }

        if (right == 0) {
            System.out.println("Hesabınız bloke edilmiştir.Lütfen bankayla iletişime geçiniz.");
        }
    }
}
