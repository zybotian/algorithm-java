package solution.offer59_1;

import java.util.*;

/**
 * 求滑动窗口的最大值
 */
public class Solution {

    // 直接遍历窗口，求窗口中的最大值
    public int[] maxSlidingWindow(int[] data, int k) {
        if (data == null || k < 1 || data.length < k) {
            throw new RuntimeException("illegal arguments");
        }
        int newSize = data.length + 1 - k;
        int[] max = new int[newSize];
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < newSize; i++) {
            for (int j = i; j < i + k; j++) {
                max[i] = Math.max(max[i], data[j]);
            }
        }
        return max;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            throw new RuntimeException("illegal arguments");
        }
        int newSize = nums.length + 1 - k;
        int[] max = new int[newSize];
        Arrays.fill(max, Integer.MIN_VALUE);
        Deque<Integer> deque = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            deque.addFirst(nums[i]);
            priorityQueue.add(nums[i]);
        }
        int index = 0;
        max[index] = priorityQueue.peek();
        Integer last = deque.removeLast();
        priorityQueue.remove(last);

        for (int i = k; i < nums.length; i++) {
            deque.addFirst(nums[i]);
            priorityQueue.add(nums[i]);
            max[++index] = priorityQueue.peek();
            last = deque.removeLast();
            priorityQueue.remove(last);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1, 2, 5, -3, -2, 3, 4, 1, 2}, 3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow2(new int[]{1, -1, 2, 5, -3, -2, 3, 4, 1, 2}, 3)));

    }
}
