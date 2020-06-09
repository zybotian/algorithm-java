package solution.q7;

import java.util.Stack;

public class Solution {

    // 两个栈实现一个队列
    public class NewQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int value) {
            stack1.push(value);
        }

        public int pop() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        NewQueue queue = new Solution().new NewQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
