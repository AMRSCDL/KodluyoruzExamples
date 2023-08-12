public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        int[][] transposeArr = new int[3][2];
        int say = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = say;
                say++;
            }
        }

        System.out.println("Matris: ");
        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                transposeArr[j][i] = arr[i][j];
            }
        }

        System.out.println("Transpoze: ");
        for (int[] row : transposeArr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
