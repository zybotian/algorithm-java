package utils;

import java.util.Arrays;

public class ArrayUtils {
    public static int[][] create(int m, int n) {
        int[][] arr = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ++k;
            }
        }
        return arr;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
