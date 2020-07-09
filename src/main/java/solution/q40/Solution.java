package solution.q40;

import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中仅出现一次的数字
 */
public class Solution {

    /**
     * 数组中有且仅有一个数字只出现了一次，其他每个数字都出现了两次，要求找出只出现一次的数字，不允许使用辅助空间
     *
     * @param array
     * @return
     */
    public int findOnlyOnce(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("illegal arguments");
        }
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    /**
     * 数组中有且仅有两个数字只出现了一次，其他每个数字都出现了两次，要求找出只出现一次的数字，不允许使用辅助空间
     */
    public List<Integer> findOnlyOnce2(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("illegal arguments");
        }

        int resultXor = array[0];
        for (int i = 1; i < array.length; i++) {
            resultXor ^= array[i];
        }

        // 整数的二进制表示中第一个1出现index
        int first1Index = Integer.numberOfTrailingZeros(resultXor);

        int result1 = 0, result2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (((array[i] >> first1Index) & 1) == 0) {
                result1 ^= array[i];
            } else {
                result2 ^= array[i];
            }
        }
        return Arrays.asList(result1, result2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findOnlyOnce(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 6, 5}));
        System.out.println(new Solution().findOnlyOnce2(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 6, 5, 7}));
    }
}
