package solution.offer30;

import java.util.Stack;

/**包括min函数的栈
 */
public class MinStack {
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

    public int top() {
        return dataStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        System.out.println(minStack.min());
        System.out.println(minStack.top());

        minStack.push(8);
        System.out.println(minStack.min());

        minStack.push(5);
        System.out.println(minStack.min());

        minStack.push(9);
        System.out.println(minStack.min());

        minStack.push(9);
        System.out.println(minStack.min());

        System.out.println(minStack.pop());
        System.out.println(minStack.min());

        System.out.println(minStack.pop());
        System.out.println(minStack.min());

        System.out.println(minStack.pop());
        System.out.println(minStack.min());
    }
}
