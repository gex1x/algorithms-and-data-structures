package homework;

import java.util.Scanner;

public class CheapWay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();

                if (i > 0 && j > 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
                } else {
                    if (i > 0) {
                        matrix[i][j] += matrix[i - 1][j];
                    } else if (j > 0) {
                        matrix[i][j] += matrix[i][j - 1];
                    }
                }
            }
        }

        System.out.println(matrix[n - 1][m - 1]);
    }
}
