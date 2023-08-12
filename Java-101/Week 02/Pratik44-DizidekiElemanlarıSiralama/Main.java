import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n;
        int[] numbers;
        Scanner input = new Scanner(System.in);

        System.out.println("Kaç elemanlı bir dizi oluşturacaksınız:");
        n = input.nextInt();

        numbers = new int[n];

        System.out.println("Dizinin boyutu n: "+n);
        System.out.println("Dizinin elemanlarını giriniz: ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Elemanı: ");
            numbers[i] = input.nextInt();
        }


        System.out.print("Sıralama: ");
        for (int i = 0; i < n; i++) {
            Arrays.sort(numbers);
            System.out.print(numbers[i] + " ");
        }
    }
}
