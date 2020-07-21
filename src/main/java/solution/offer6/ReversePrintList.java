package solution.offer6;

import common.ListNode;
import utils.ListNodeUtils;

import java.util.*;

public class ReversePrintList {
    // 逆序输出单向链表
    // 使用栈
    public int[] printReverse(ListNode list) {
        if (Objects.isNull(list)) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        ListNode curr = list;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        int k = 0;
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) {
            result[k++] = stack.pop();
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
        ReversePrintList reversePrintList = new ReversePrintList();

        ListNode list = ListNodeUtils.create();
        int[] result1 = reversePrintList.printReverse(list);
        System.out.println(Arrays.toString(result1));

        List<Integer> result2 = reversePrintList.printReverse2(list);
        System.out.println(result2);
    }
}
