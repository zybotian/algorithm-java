package solution.q46;

public class Solution {

    /**
     * 不要循环、乘除法求1~n的和
     * @param n
     * @return
     */
    public static int sum(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(1));
        System.out.println(sum(5));
        System.out.println(sum(10));
        System.out.println(sum(100));
        System.out.println(sum(1000));

    }
}
