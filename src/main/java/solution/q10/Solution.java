package solution.q10;

public class Solution {
    // 二进制中1的个数

    // n & (n-1)将最右边的1变成0，能操作多少次就说明有几个1
    public int calcOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    // Integer.ToBinaryString(n)将整数准成二进制字符串，逐个比较
    public int calcOne2(int n) {
        final String string = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = -257; i < 258; i++) {
            System.out.println(i + "=" + (solution.calcOne(i) == solution.calcOne2(i)));
        }
    }
}
