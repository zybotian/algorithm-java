package solution.offer15;

public class HammingWeight {
    // 二进制中1的个数

    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            count += (n & flag) != 0 ? 1 : 0;
            flag = flag << 1;
        }
        return count;
    }

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
        HammingWeight hammingWeight = new HammingWeight();
        for (int i = -257; i < 258; i++) {
            System.out.println(i + "=" + (hammingWeight.calcOne(i) == hammingWeight.calcOne2(i) && hammingWeight.calcOne(i) == hammingWeight.hammingWeight(i)));
        }
    }
}
