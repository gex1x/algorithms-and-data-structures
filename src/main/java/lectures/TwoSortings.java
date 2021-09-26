package lectures;

import java.util.Random;

public class TwoSortings {

    public static void main(String[] args) {
        System.out.println("------------------------------");

        final Random random = new Random();

        int arrSize = 10;
        int[] arr = new int[] {9,8,7,6,5,4,3,2,1,0};
/*
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = random.nextInt(arrSize);
        }
*/

        output(arr);
//        sortChoice(arr);
        sortBubble1(arr);
        output(arr);
    }

    static void output(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("------------------------------");
    }

    static void sortBubble1(int[] arr) {
        for (int j = 0; j < arr.length - 2; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    static void sortBubble2(int[] arr) {
        for (int j = 0; ; j++) {
            boolean sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                System.out.println("j=" + j);
                break;
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void sortChoice(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            int x = arr[j];
            int pos = -1;
            for (int i = j; i < arr.length; i++) {
                if (arr[i] < x) {
                    x = arr[i];
                    pos = i;
                }
            }
            if (pos > -1) {
                swap(arr, j, pos);
            }
        }
    }
}
