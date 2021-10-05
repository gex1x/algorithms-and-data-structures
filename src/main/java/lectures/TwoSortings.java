package lectures;

import java.util.Random;

public class TwoSortings {

    public static void main(String[] args) {
        System.out.println("------------------------------");

        final Random random = new Random();

        int arrSize = 10;
        int[] arr = new int[] {9,8,7,6,5,4,3,2,1,0};
        int[] arr1 = new int[] {1,2,6};
        int[] arr2 = new int[] {3,4,9};
/*
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = random.nextInt(arrSize);
        }
*/

        output(arr);
//        sortChoice(arr);
//        sortBubble1(arr);
//        sortInserts(arr);
        sortMerge2(arr);

//        output(arr1);
//        output(arr2);
//        output(merge(arr1, arr2));
        output(arr);
    }

    static void output(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        System.out.println("------------------------------");
    }

    static void sortBubble1(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
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

    static void sortInserts(int[] arr) {
        int[] tmpArr = new int[arr.length];
        tmpArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int pos = -1;
            for (int j = 0; j < i; j++) {
                if (tmpArr[j] > arr[i]) {
                    pos = j;
                    break;
                }
            }
            if (pos > -1) {
                shift(tmpArr, i, pos);
                tmpArr[pos] = arr[i];
            } else {
                tmpArr[i] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmpArr[i];
        }
    }

    static void shift(int[] arr, int size, int pos) {
        if (pos >= size) {
            throw new IllegalArgumentException("pos must be less than size");
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    static int[] merge1(int[] arrA, int[] arrB) {
        int[] arr = new int[arrA.length + arrB.length];
        int posA = 0;
        int posB = 0;
        for (int i = 0; i < arr.length; i++) {
            if (posA == arrA.length) {
                arr[i] = arrB[posB++];
                continue;
            }
            if (posB == arrB.length) {
                arr[i] = arrA[posA++];
                continue;
            }
            if (arrA[posA] < arrB[posB]) {
                arr[i] = arrA[posA++];
            } else {
                arr[i] = arrB[posB++];
            }
        }
        return arr;
    }

    static void merge2(int[] arr, int[] tmpArr, int a, int m, int b) {
        int posA = a;
        int posB = m;
        for (int i = a; i < b; i++) {
            if (posA == m) {
                tmpArr[i] = arr[posB++];
                continue;
            }
            if (posB == b) {
                tmpArr[i] = arr[posA++];
                continue;
            }
            if (arr[posA] < arr[posB]) {
                tmpArr[i] = arr[posA++];
            } else {
                tmpArr[i] = arr[posB++];
            }
        }
        for (int i = a; i < b; i++) {
            arr[i] = tmpArr[i];
        }
    }

    static int[] sortMerge1(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int sizeL = arr.length / 2;
        int sizeR = arr.length - arr.length / 2;
        int[] arrL = new int[sizeL];
        int[] arrR = new int[sizeR];
        for (int i = 0; i < sizeL; i++) {
            arrL[i] = arr[i];
        }
        for (int i = 0; i < sizeR; i++) {
            arrR[i] = arr[i + sizeL];
        }
        arrL = sortMerge1(arrL);
        arrR = sortMerge1(arrR);
        return merge1(arrL, arrR);
    }

    static void sortMerge2(int[] arr) {
        int[] tmpArr = new int[arr.length];
        sortMerge2(arr, tmpArr, 0, arr.length);
    }

    static void sortMerge2(int[] arr, int[] tmpArr, int a, int b) {
        if (b - a <= 1) {
            return;
        }
        sortMerge2(arr, tmpArr, a, (a + b) / 2);
        sortMerge2(arr, tmpArr, (a + b) / 2, b);
        merge2(arr, tmpArr, a, (a + b) / 2, b);
    }
}
