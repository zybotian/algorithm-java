package solution.offer57;

import utils.ArrayUtils;

public class TwoSum {
    /**
     * 排序数组中查找和为s的两个数
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int result = nums[left] + nums[right];
            if (result > target) {
                right--;
            } else if (result < target) {
                left++;
            } else {
                int[] tmp = new int[2];
                tmp[0] = nums[left];
                tmp[1] = nums[right];
                return tmp;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        ArrayUtils.print(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
        ArrayUtils.print(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 18));
        ArrayUtils.print(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 26));
        ArrayUtils.print(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 38));
    }
}
