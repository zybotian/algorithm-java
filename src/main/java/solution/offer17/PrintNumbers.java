package solution.offer17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintNumbers {

    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n) - 1;
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }

        return result;
    }

    // 输入n，输出1到最大的n位数
    public int[] printToMaxOfDigits(int n) {
        if (n == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        int[] tmp = new int[n];
        printArray(tmp, 0, result);
        int[] ret = new int[result.size()];
        int count = 0;
        for (Integer integer : result) {
            ret[count++] = integer;
        }
        return ret;
    }

    // 递归调用
    private void printArray(int[] result, int curr, List<Integer> collect) {
        if (curr == result.length) {
            // 转成数字
            final int convert = convert(result);
            // 等于0的过滤掉
            if (convert > 0) {
                collect.add(convert);
            }
        } else {
            for (int j = 0; j < 10; j++) {
                result[curr] = j;
                printArray(result, curr + 1, collect);
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
        PrintNumbers printNumbers = new PrintNumbers();
        final int[] ints = printNumbers.printNumbers(3);
        final int[] ints1 = printNumbers.printToMaxOfDigits(3);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
