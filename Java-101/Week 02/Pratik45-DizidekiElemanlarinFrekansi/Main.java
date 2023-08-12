import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 20, 10, 10, 20, 5, 20};

        System.out.println("Dizi: " + Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {
            int count = 1;


            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                    numbers[j] = -1;
                }
            }

            if (count > 1 && numbers[i] != -1) {
                System.out.println(numbers[i] + " sayısı " + count + " kere tekrar ediyor.");
            } else if (count == 1 && numbers[i] != -1) {
                System.out.println(numbers[i] + " sayısı 1 kere tekrar etti.");
            }
        }
    }
}
