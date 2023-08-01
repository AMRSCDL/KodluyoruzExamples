import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int say1,say2,say3;


        Scanner input = new Scanner(System.in);

        System.out.println("Sayı 1'i girin: ");
        say1 =input.nextInt();

        System.out.println("Sayı 2'yi girin: ");
        say2 =input.nextInt();

        System.out.println("Sayı 3'ü girin: ");
        say3 =input.nextInt();

        System.out.println("Sayı 1 :"+say1+"\nSayı 2: "+say2+"\nSayı 3: "+say3);

        if ((say1>say2)&&(say1>say3)){
            if (say2>say3){
                System.out.println("say3<say2<say1");
            }else if (say2<say3){
                System.out.println("Say2<say3<say1");
            }else {
                System.out.println("Sasy1>say2=say3");
            }
        } else if ((say2>say1)&&(say2>say3)) {
            if (say1>say3){
                System.out.println("Say3<say1<say2");
            } else if (say3>say1) {
                System.out.println("say1<say3<say2");
            }else {
                System.out.println("Say2>say1=say3");
            }
        } else if ((say3>say1)&&(say3>say2)) {
            if (say1>say2){
                System.out.println("Say2<say1<say3");
            } else if (say2>say1) {
                System.out.println("Say1<say2<say3");
            }else {
                System.out.println("say3>say1=say2");
            }
        }else {
            System.out.println("say1=say2=say3");
        }

    }
}
