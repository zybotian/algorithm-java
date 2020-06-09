package solution.q9;

public class Solution {
    // 斐波那契数列
    // f1=1 f2=1 f(n)=f(n-1)+f(n-2)

    // 递归
    public int fun(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fun(n - 1) + fun(n - 2);
    }

    // 迭代
    public int fun2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int fn1 = 1, fn2 = 1, result = 0;
        for (int i = 3; i <= n; i++) {
            result = fn1 + fn2;
            fn1 = fn2;
            fn2 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fun(10));
        System.out.println(solution.fun(45));
        System.out.println(solution.fun2(10));
        System.out.println(solution.fun2(45));
    }
}
