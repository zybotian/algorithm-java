package solution.offer40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int[] kMin(int[] data, int k) {
        if (data == null || data.length == 0 || k <= 0 || data.length < k) {
            return new int[0];
        }

        // 容量为k的大根堆
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < data.length; i++) {
            if (queue.size() < k) {
                queue.add(data[i]);
            } else {
                if (queue.peek() > data[i]) {
                    queue.poll();
                    queue.add(data[i]);
                }
            }
        }

        int[] ret = new int[k];
        int count = 0;
        while (!queue.isEmpty()) {
            ret[count++] = queue.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] data = new int[100];
        for (int i = 100; i >= 1; i--) {
            data[100 - i] = i;
        }
        System.out.println(Arrays.toString(getLeastNumbers.kMin(data, 10)));
        System.out.println(Arrays.toString(getLeastNumbers.getLeastNumbers(data, 10)));
    }
}
