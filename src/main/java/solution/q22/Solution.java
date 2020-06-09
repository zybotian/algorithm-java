package solution.q22;

import java.util.Stack;

public class Solution {

    // 输入入栈序列和出栈序列，判断出栈序列是否合法
    public boolean isMatch(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);

            while (!stack.isEmpty() && stack.peek() == pop[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 2, 4, 5, 1};
        System.out.println(solution.isMatch(push, pop));
    }
}
