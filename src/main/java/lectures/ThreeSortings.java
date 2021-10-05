package lectures;

public class ThreeSortings {

    public static void main(String[] args) {
        System.out.println("------------------------------");

        int[] arr = new int[] {1,1,1,1,1};
//        int[] arr = new int[] {9,8,7,6,5,4,3,2,1,0};
//        int[] arr = new int[] {7,3,1,2,5,4,6};

        TwoSortings.output(arr);

//        qsort1(arr, 0, arr.length);
//        qsort2(arr, 0, arr.length);

        sortQuick3(arr, 0, arr.length - 1);

        TwoSortings.output(arr);

    }

    static int getMedian(int[] arr, int a, int b) {
        if (a < b) {
            int min = arr[a];
            int max = arr[a];
            for (int i = a + 1; i < b; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            int avg = (min + max) / 2;
            System.out.println("avg=" + avg);
            for (int i = a; i < b; i++) {
                if (arr[i] == avg) {
                    System.out.println("m=" + arr[i]);
                    return arr[i];
                }
            }
        }
        throw new IllegalArgumentException("a must be less than b");
    }

    static void qsort1(int[] arr, int a, int b) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        if (a + 1 >= b) {
            return;
        }
        int m = getMedian(arr, a, b);
        System.out.println("m=" + m);
        int i = a;
        System.out.println("i=" + i);
        System.out.println("------------------------------");
        for (int j = a; j < b; j++) {
            System.out.println("j=" + j);
            if (arr[j] <= m) {
                TwoSortings.swap(arr, i, j);
                i++;
            }
            TwoSortings.output(arr);
            System.out.println("i=" + i);
            System.out.println("------------------------------");
        }
        qsort1(arr, a, i);
        qsort1(arr, i, b);
    }

    static void qsort2(int[] arr, int a, int b) {
        if (a + 1 >= b) {
            return;
        }
        int m = getMedian(arr, a, b);
        int i = a;
        int j = b - 1;
        while (true) {
            while (i < b && arr[i] < m) {
                i++;
            }
            while (j >= a && arr[j] > m) {
                j--;
            }
            if (i > j) {
                break;
            }
            TwoSortings.swap(arr, i, j);
            i++;
            j--;
        }
        while (arr[j] == m) {
            j--;
        }
        qsort2(arr, a, j + 1);
        while (arr[i] == m) {
            i++;
        }
        qsort2(arr, i, b);
    }

    static void sortQuick3(int[] arr, int a, int b) {
        if (a < b) {
            int loc = partition(arr, a, b);
            sortQuick3(arr, a, loc - 1);
            sortQuick3(arr, loc + 1, b);
        }
    }

    static int partition(int[] arr, int begin, int end) {
        int left, right, loc;
        loc = left = begin;
        right = end;
        boolean flag = true;
        while (flag) {
            while (arr[loc] <= arr[right] && loc < right) {
                right--;
            }
            if (loc == right) {
                flag = false;
            } else if (arr[loc] > arr[right]) {
                TwoSortings.swap(arr, loc, right);
                loc = right;
            }
            if (flag) {
                while (arr[left] <= arr[loc] && left > loc) {
                    left++;
                }
                if (left == loc) {
                    flag = false;
                } else if (arr[left] > arr[loc]) {
                    TwoSortings.swap(arr, left, loc);
                    loc = left;
                }
            }
        }
        return loc;
    }
}
