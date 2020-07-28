package solution.q11;

public class Solution {

    public double power(double base, int exponent) {
        if (Math.abs(base) < 0.000001) {
            return 0;
        }
        if (Math.abs(base - 1) < 0.000001) {
            return 1;
        }
        if (Math.abs(base + 1) < 0.000001) {
            return Math.abs((long) exponent) % 2 == 0 ? Math.abs(base) : base;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            return multiply(base, exponent);
        }
        return multiply(1 / base, -(long) exponent);
    }

    private double multiply(double base, long exponent) {
        double result = 1.0;
        for (long i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.power(1, 3));
        System.out.println(solution.power(2, 3));
        System.out.println(solution.power(3, -2));
        System.out.println(solution.power(2.5, -1));
        System.out.println(solution.power(-4, 3));
        System.out.println(solution.power(2, Integer.MIN_VALUE));
        System.out.println(solution.power(1.00000, Integer.MIN_VALUE));
    }
}
