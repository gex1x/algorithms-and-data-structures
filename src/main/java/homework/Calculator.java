package homework;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int maxN = 1000000;

        if (n < 1 || n > maxN + 1) {
            return;
        }

        int[] operationArr = new int[n + 1];

        int minOperations;
        for (int i = 2; i <= n; i++) {
            minOperations = operationArr[i - 1];
            if (i % 2 == 0) {
                minOperations = Math.min(minOperations, operationArr[i / 2]);
            }
            if (i % 3 == 0) {
                minOperations = Math.min(minOperations, operationArr[i / 3]);
            }
            operationArr[i] = minOperations + 1;
        }

        StringBuilder sb = new StringBuilder();

        int i = n;
        while (i > 1) {
            if (operationArr[i] == operationArr[i - 1] + 1) {
                sb.insert(0, 1);
                i--;
                continue;
            }
            if (i % 2 == 0 && operationArr[i] == operationArr[i / 2] + 1) {
                sb.insert(0, 2);
                i /= 2;
                continue;
            }
            sb.insert(0, 3);
            i /= 3;
        }

        System.out.println(sb);
    }
}
