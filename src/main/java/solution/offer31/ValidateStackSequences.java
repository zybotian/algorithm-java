package solution.offer31;

import java.util.Stack;

public class ValidateStackSequences {

    // 输入入栈序列和出栈序列，判断出栈序列是否合法
    public boolean validateStackSequences(int[] push, int[] pop) {
        if ((push == null || push.length == 0) && (pop == null || pop.length == 0)) {
            return true;
        }

        if (!(push != null && push.length > 0 && pop != null && pop.length > 0)) {
            return false;
        }

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
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 2, 4, 5, 1};
        System.out.println(validateStackSequences.validateStackSequences(push, pop));
    }
}
