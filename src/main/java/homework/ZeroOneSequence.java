package homework;

import java.math.BigInteger;
import java.util.Scanner;

public class ZeroOneSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        n += 1;

        BigInteger[] sequence = new BigInteger[2];
        sequence[0] = BigInteger.ONE;
        sequence[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            sequence[i % 2] = sequence[0].add(sequence[1]);
        }

        System.out.println(sequence[n % 2]);
    }
}
