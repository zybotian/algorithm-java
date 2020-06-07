package solution.q5;

import common.ListNode;
import utils.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution {

    // 使用栈
    public List<Integer> printReverse(ListNode list) {
        if (Objects.isNull(list)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode curr = list;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    // 递归
    public List<Integer> printReverse2(ListNode list) {
        if (Objects.isNull(list)) {
            return null;
        }
        // 先递归输出首节点后面的节点
        List<Integer> tmpResults = printReverse2(list.next);
        if (tmpResults == null) {
            tmpResults = new ArrayList<>();
        }
        // 在将首节点加入到后续节点的逆序序列中
        tmpResults.add(list.val);
        return tmpResults;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list = ListNodeUtils.create();
        List<Integer> result1 = solution.printReverse(list);
        System.out.println(result1);

        List<Integer> result2 = solution.printReverse2(list);
        System.out.println(result2);
    }
}
