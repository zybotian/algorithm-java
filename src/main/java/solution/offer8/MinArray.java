package solution.offer8;

import java.util.Arrays;

public class MinArray {

    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public static void main(String[] args) {
        MinArray test = new MinArray();
        System.out.println(test.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(test.minArray(new int[]{3, 4, 5, 6, 1, 2}));
        System.out.println(test.minArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.minArray(new int[]{3, 4, 5, 5, 2}));
        System.out.println(test.minArray(new int[]{3, 4, 4, 1, 2}));
    }
}
