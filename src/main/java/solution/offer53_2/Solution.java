package solution.offer53_2;

class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{1, 2, 3}));
        System.out.println(new Solution().missingNumber(new int[]{0, 1, 2, 3}));
        System.out.println(new Solution().missingNumber(new int[]{0, 1, 3, 4}));
    }
}