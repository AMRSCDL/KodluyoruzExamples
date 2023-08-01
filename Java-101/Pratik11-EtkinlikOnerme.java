import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sicak;


        Scanner input = new Scanner(System.in);

        System.out.println("Sıcaklığı girin: ");
        sicak =input.nextInt();

        if (sicak<5){
            System.out.println("Kayak yapabilirsiniz.");
        } else if (sicak>=5 && sicak<15) {
            System.out.println("Sinemaya Gidebilirsiniz.");
        } else if (sicak>=15 && sicak<25) {
            System.out.println("Pikniğe gidebilrisiniz.");
        }else {
            System.out.println("Yüzmeye gidebilrisiniz.");
        }
    }
}
