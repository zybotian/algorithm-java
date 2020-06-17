package solution.q21;

import java.util.Stack;

/**包括min函数的栈
 */
public class Solution {
    // 数据栈
    Stack<Integer> dataStack = new Stack<>();
    // 最小值栈
    Stack<Integer> minStack = new Stack<>();

    public void push(int data) {
        dataStack.push(data);
        if (minStack.isEmpty() || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("illegal arguments");
        }
        Integer pop = dataStack.pop();
        minStack.pop();
        return pop;
    }


    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(10);
        System.out.println(solution.min());

        solution.push(8);
        System.out.println(solution.min());

        solution.push(5);
        System.out.println(solution.min());

        solution.push(9);
        System.out.println(solution.min());

        solution.push(9);
        System.out.println(solution.min());

        System.out.println(solution.pop());
        System.out.println(solution.min());

        System.out.println(solution.pop());
        System.out.println(solution.min());

        System.out.println(solution.pop());
        System.out.println(solution.min());
    }
}
