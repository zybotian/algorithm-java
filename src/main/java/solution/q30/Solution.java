package solution.q30;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    public List<Integer> kMin(int[] data, int k) {
        if (data == null || data.length == 0 || k <= 0 || data.length < k) {
            throw new RuntimeException("illegal arguments");
        }

        // 容量为k的大根堆
        Queue<Integer> result = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < data.length; i++) {
            if (result.size() < k) {
                result.add(data[i]);
            } else {
                if (result.peek() > data[i]) {
                    result.poll();
                    result.add(data[i]);
                }
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[100];
        for (int i = 100; i >= 1; i--) {
            data[100 - i] = i;
        }
        System.out.println(solution.kMin(data, 10));
    }
}
