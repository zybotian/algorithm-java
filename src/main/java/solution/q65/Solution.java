package solution.q65;

import java.util.Arrays;

/**
 * 求滑动窗口的最大值
 */
public class Solution {

    // 直接遍历窗口，求窗口中的最大值
    public int[] maxWindow(int[] data, int size) {
        if (data == null || size < 1 || data.length < size) {
            throw new RuntimeException("illegal arguments");
        }
        int newSize = data.length + 1 - size;
        int[] max = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            for (int j = i; j < i + size; j++) {
                max[i] = Math.max(max[i], data[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxWindow(new int[]{1, -1, 2, 5, -3, -2, 3, 4, 1, 2}, 3)));
    }
}
