import java.util.*;

public class Main {
    public static void main(String[] args) {
        double harmsonuc = 0;
        int[] num = {2,5,7,8,1,45,26,78};


        System.out.println("Dizi Elemanları:");
        for (int nums : num) {
            System.out.print(nums + ",");
        }

        System.out.println("\nSıralanmış Dizi Elemanları:");
        Arrays.sort(num);
        for (int nums : num) {
            System.out.print(nums + ",");
        }

        for (int harmonic : num) {
            harmsonuc += 1.0 / harmonic;
        }

        double harmortalama= (num.length/harmsonuc);
        System.out.println("\nHarmonik Ortalama: " + harmortalama);
    }
}
