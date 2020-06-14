package solution.q14;

import java.util.Arrays;

/**
 * 将数组中的奇数移动到偶数前
 */
public class Solution {

    public int[] reOrder(int[] data) {
        if (data == null || data.length == 0) {
            return data;
        }

        int left = 0, right = data.length - 1;
        while (left < right) {
            while (left < right && data[left] % 2 == 1) {
                left++;
            }
            while (right > left && data[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = data[left];
                data[left] = data[right];
                data[right] = tmp;
            }
        }

        return data;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(solution.reOrder(array)));
    }

}
