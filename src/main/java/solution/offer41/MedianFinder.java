package solution.offer41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？ 如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。 如果从数据流中读出偶数个数
 * 值， 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianFinder {

    // 容器左边是大根堆，放较小的数，每次取最大的值
    private PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());

    // 容器右边是小根堆，放较大的数， 每次取最小的值
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (left.size() < right.size()) {
            left.add(right.poll());
        }
//        System.out.println("left:" + left + ",right:" + right);
    }

    public double findMedian() {
        // 元素个数为偶数时，取大根堆的堆顶元素
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) * 0.5;

        }
        // 元素个数为奇数时，取两个堆的堆顶元素的平均值
        return left.peek();
    }

    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        solution.addNum(10);
        System.out.println(solution.findMedian());
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(30);
        System.out.println(solution.findMedian());
        solution.addNum(4);
        System.out.println(solution.findMedian());
        solution.addNum(40);
        System.out.println(solution.findMedian());
        solution.addNum(12);
        System.out.println(solution.findMedian());
        solution.addNum(8);
        System.out.println(solution.findMedian());
        solution.addNum(4);
        System.out.println(solution.findMedian());
        solution.addNum(20);
        System.out.println(solution.findMedian());
        solution.addNum(24);
        System.out.println(solution.findMedian());
    }
}
