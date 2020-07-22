package solution.offer10_1;

public class Fib {
    // 斐波那契数列
    // f0=0 f1=1 f2=1 f(n)=f(n-1)+f(n-2)

    // 递归
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
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
//        System.out.println(solution.fib(45));
        System.out.println(solution.fib2(10));
        System.out.println(solution.fib2(45));
        System.out.println(solution.fib2(48));
    }
}
