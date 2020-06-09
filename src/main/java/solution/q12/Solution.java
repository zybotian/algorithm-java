package solution.q12;

public class Solution {

    // 输入n，输出1到最大的n位数
    public void printToMaxOfDigits(int n) {
        if (n == 0) {
            return;
        }

        int[] result = new int[n];
        printArray(result, 0);
    }

    // 递归调用
    private void printArray(int[] result, int curr) {
        if (curr == result.length) {
            // 转成数字
            final int convert = convert(result);
            // 等于0的过滤掉
            if (convert > 0) {
                System.out.println(convert);
            }
        } else {
            for (int j = 0; j < 10; j++) {
                result[curr] = j;
                printArray(result, curr + 1);
            }
        }
    }

    private int convert(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum = sum * 10 + digits[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printToMaxOfDigits(3);
    }
}
