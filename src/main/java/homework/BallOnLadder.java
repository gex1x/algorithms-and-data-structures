package homework;

import java.util.Scanner;

public class BallOnLadder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] routeArr = new int[31];

        if (n > routeArr.length) {
            return;
        }

        routeArr[0] = 0;
        routeArr[1] = 1;
        routeArr[2] = 2;
        routeArr[3] = 4;
        for (int i = 4; i <= n; i++) {
            routeArr[i] = routeArr[i - 1] + routeArr[i - 2] + routeArr[i - 3];
        }

        System.out.println(routeArr[n]);
    }
}
