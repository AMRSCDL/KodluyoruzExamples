public class Main {
    public static void main(String[] args) {
        String[][] b_harfi = new String[7][5];

        for (int i = 0; i < b_harfi.length; i++) {
            for (int j = 0; j < b_harfi[i].length; j++) {
                if (i == 0 || i == 3 || i == 6 || j == 0 || j == 4) {
                    b_harfi[i][j] = " * ";
                } else {
                    b_harfi[i][j] = "    ";
                }
            }
        }

        for (String[] row : b_harfi){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
