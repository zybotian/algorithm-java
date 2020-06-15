package solution.q38;

/**
 * 统计一个数字在排序数组中出现的次数
 */
public class Solution {
    public int getNumOfK(int[] sortedArray, int k) {
        if (sortedArray == null || sortedArray.length == 0) {
            return 0;
        }
        return getNumOfK(sortedArray, k, 0, sortedArray.length - 1);
    }

    private int getNumOfK(int[] sortedArray, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (sortedArray[mid] == k) {
            return count(sortedArray, mid);
        }
        if (sortedArray[mid] > k) {
            return getNumOfK(sortedArray, k, start, mid - 1);
        }
        return getNumOfK(sortedArray, k, mid + 1, end);
    }

    private int count(int[] sortedArray, int mid) {
        int k = sortedArray[mid];
        int result = 0;
        for (int i = mid; i < sortedArray.length; i++) {
            if (sortedArray[i] == k) {
                result++;
            } else {
                break;
            }
        }
        for (int i = mid - 1; i >= 0; i--) {
            if (sortedArray[i] == k) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getNumOfK(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7}, 1));
        System.out.println(solution.getNumOfK(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7}, 2));
        System.out.println(solution.getNumOfK(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7}, 3));
        System.out.println(solution.getNumOfK(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7}, 4));
        System.out.println(solution.getNumOfK(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7}, 5));
        System.out.println(solution.getNumOfK(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7}, 6));
        System.out.println(solution.getNumOfK(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7}, 7));
    }
}
