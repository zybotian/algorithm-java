package solution.q3;

import utils.ArrayUtils;

public class Solution {
    // 二维有序数组中查找目标值，数组的行和列都是递增的

    public boolean find1(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        // 标准的双层for循环，O(N的平方)
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find2(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = array[0].length - 1;
        // 从右上角开始遍历,可以跳过行和列
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                // 找到
                return true;
            }
            if (array[row][col] < target) {
                // 当前行最大的元素都小于target，则跳过当前行
                row++;
            } else {
                // 当前列的最小值都大于target，跳过当前列
                col--;
            }
        }
        return false;
    }

    public boolean find3(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int rows = array.length;
        int cols = array[0].length;
        int size = rows * cols;
        int left = 0, right = size - 1;

        // 二维数组当成一维数组来处理
        for (int i = 0; i < size; i++) {
            int mid = (left + right) / 2;
            // (mid/cols,mid%cols)中间值
            int value = array[mid / cols][mid % cols];
            if (value == target) {
                return true;
            }
            if (value > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int[][] nums = ArrayUtils.create(3, 4);
        ArrayUtils.print(nums);

        for (int i = 1; i <= 12; i++) {
            System.out.println(solution.find1(nums, i));
        }
        System.out.println(solution.find1(nums, 100));

        System.out.println("***************************");

        for (int i = 1; i <= 12; i++) {
            System.out.println(solution.find2(nums, i));
        }

        System.out.println(solution.find2(nums, 100));
        System.out.println("***************************");


        for (int i = 1; i <= 12; i++) {
            System.out.println(solution.find3(nums, i));
        }
        System.out.println(solution.find3(nums, 100));
    }
}
