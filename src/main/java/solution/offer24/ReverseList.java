package solution.offer24;

import common.ListNode;
import utils.ListNodeUtils;

/**
 * 链表反转
 */
public class ReverseList {

    // 直接反转
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 递归反转
    public ListNode reverse2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode tmpHead = reverse2(head.next);
        if (tmpHead != null) {
            ListNode curr = tmpHead;
            while (curr != null && curr.next != null) {
                curr = curr.next;
            }
            curr.next = head;
            head.next = null;
        }
        return tmpHead;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNodeUtils.println(reverseList.reverse(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7})));
        ListNodeUtils.println(reverseList.reverse(ListNodeUtils.create(new int[]{1})));
        ListNodeUtils.println(reverseList.reverse(ListNodeUtils.create(new int[]{1, 2})));
        ListNodeUtils.println(reverseList.reverse(ListNodeUtils.create(new int[]{1, 2, 3})));

        ListNodeUtils.println(reverseList.reverse2(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7})));
        ListNodeUtils.println(reverseList.reverse2(ListNodeUtils.create(new int[]{1})));
        ListNodeUtils.println(reverseList.reverse2(ListNodeUtils.create(new int[]{1, 2})));
        ListNodeUtils.println(reverseList.reverse2(ListNodeUtils.create(new int[]{1, 2, 3})));
    }
}
