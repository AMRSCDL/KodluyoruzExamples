public class Main {
    static boolean isFind(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 2, 5, 4, 8, 8, 8, 7, 6, 3, 4, 5, 1, 2, 15, 65, 8, 5, 47, 95, 451, 1547, 154, 154, 235};
        int[] samenum = new int[numbers.length];
        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if ((i != j) && (numbers[i] == numbers[j])) {
                    if (!isFind(samenum, numbers[i])) {
                        samenum[index++] = numbers[i];

                    }
                    break;
                }
            }
        }
        for (int value : samenum) {
            if ((value != 0) && (value % 2 == 0)) {
                System.out.print(value + ", ");
            }
        }
    }
}

