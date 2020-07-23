package solution.offer10_1;

import java.util.Arrays;

public class Fib {
    // 斐波那契数列
    // f0=0 f1=1 f2=1 f(n)=f(n-1)+f(n-2)

    static int[] cache = new int[101];

    static {
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
    }

    // 递归
    public int fib(int n) {
        if (cache[n] > 0) {
            return cache[n];
        }
        for (int i = 3; i <= n; i++) {
            final int res = (fib(i - 1) + fib(i - 2)) % 1000000007;
            cache[i] = res;
        }
        return cache[n];
    }

    // 迭代
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long result = 0;
        long preOne = 1;
        long preTwo = 0;

        for (int i = 2; i <= n; i++) {
            result = (preOne + preTwo) % 1000000007;
            preTwo = preOne;
            preOne = result;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Fib solution = new Fib();
        System.out.println(solution.fib(10));
        System.out.println(solution.fib(45));
        System.out.println(solution.fib(48));
        System.out.println(solution.fib(69));
        System.out.println(solution.fib(100));
        System.out.println(solution.fib2(10));
        System.out.println(solution.fib2(45));
        System.out.println(solution.fib2(48));
        System.out.println(solution.fib2(69));
        System.out.println(solution.fib2(100));

    }
}
