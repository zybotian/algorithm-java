package solution.offer52;

import common.ListNode;
import utils.ListNodeUtils;

import java.util.Stack;

public class GetIntersectionNode {

    // 最简单的寻找链表第一个公共节点的方法,但是这个方法针对两个链表没有公共节点的情况，会死循环
    public ListNode firstSameNode(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != p2) {
            p1 = p1.next != null ? p1.next : list2;
            p2 = p2.next != null ? p2.next : list1;
        }
        return p1;
    }

    // 使用栈
    public ListNode firstSameNode2(ListNode list1, ListNode list2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p = list1;
        while (p != null) {
            stack1.push(p);
            p = p.next;
        }

        p = list2;
        while (p != null) {
            stack2.push(p);
            p = p.next;
        }
        ListNode same = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            same = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return same;
    }

    // 快慢指针
    public ListNode firstSameNode3(ListNode list1, ListNode list2) {
        int length1 = 0, length2 = 0;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null) {
            length1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            length2++;
            p2 = p2.next;
        }

        int diff = Math.abs(length1 - length2);
        p1 = list1;
        p2 = list2;
        if (length1 > length2) {
            while (diff > 0) {
                p1 = p1.next;
                diff--;
            }
        } else if (length1 < length2) {
            while (diff > 0) {
                p2 = p2.next;
                diff--;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode list2 = ListNodeUtils.create(new int[]{10, 20, 30});
        list2.next.next.next = list1.next.next.next;
        System.out.println(new GetIntersectionNode().firstSameNode(list1, list2));
        System.out.println(new GetIntersectionNode().firstSameNode2(list1, list2));
        System.out.println(new GetIntersectionNode().firstSameNode3(list1, list2));
    }
}
