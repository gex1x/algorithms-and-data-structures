package homework;

import java.util.Scanner;
import java.lang.Math;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int maxN = 1000000;

        if (n < 1 || n > maxN + 1) {
            return;
        }

        int[] operationArr = new int[n + 1];

        operationArr[1] = 0;

        int minOperations;
        for (int i = 2; i <= n; i++) {
            minOperations = operationArr[i - 1] + 1;
            if (i % 2 == 0) {
                minOperations = Math.min(minOperations, operationArr[i / 2] + 1);
            } else if (i % 3 == 0) {
                minOperations = Math.min(minOperations, operationArr[i / 3] + 1);
            }
            operationArr[i] = minOperations;
        }

        System.out.println(operationArr[n]);
    }
}
