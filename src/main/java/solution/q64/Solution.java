package solution.q64;

import java.util.*;

/**
 * 如何得到一个数据流中的中位数？ 如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。 如果从数据流中读出偶数个数
 * 值， 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution {

    // 元素总数
    private int count;

    // 小根堆中的元素都比大根堆中的大
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // 大根堆中的元素都比小根堆中的小
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void insert(int num) {
        count++;
        // 元素个数为奇数时，大根堆比小根堆多一个元素
        if (count % 2 == 1) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            //元素个数为偶数时，小根堆比大根堆多一个元素
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double getMedian() {
        if (count < 1) {
            throw new RuntimeException("illegal arguments");
        }
        // 元素个数为偶数时，取大根堆的堆顶元素
        if (count % 2 == 1) {
            return maxHeap.peek();
        }
        // 元素个数为奇数时，取两个堆的堆顶元素的平均值
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 100; i++) {
            solution.insert(i + 1);
            System.out.println(solution.getMedian());
        }
    }
}
