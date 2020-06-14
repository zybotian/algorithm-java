package solution.q17;

import common.ListNode;
import utils.ListNodeUtils;

/**
 * 合并两个有序单向链表
 */
public class Solution {

    // 非递归
    public ListNode mergeSort(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = new ListNode(0);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode curr = head;
        while (p1 != null && p2 != null) {
            ListNode tmp;
            if (p1.val < p2.val) {
                tmp = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                tmp = new ListNode(p2.val);
                p2 = p2.next;
            }
            curr.next = tmp;
            curr = tmp;
        }
        while (p1 != null) {
            ListNode tmp = new ListNode(p1.val);
            curr.next = tmp;
            curr = tmp;
            p1 = p1.next;
        }

        while (p2 != null) {
            ListNode tmp = new ListNode(p2.val);
            curr.next = tmp;
            curr = tmp;
            p2 = p2.next;
        }

        return head.next;
    }

    // 递归
    public ListNode mergeSort2(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val < list2.val) {
            ListNode head = new ListNode(list1.val);
            head.next = mergeSort2(list1.next, list2);
            return head;
        } else {
            ListNode head = new ListNode(list2.val);
            head.next = mergeSort2(list1, list2.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = ListNodeUtils.create(new int[]{1, 3, 5, 7, 9, 10});
        ListNode list2 = ListNodeUtils.create(new int[]{2, 4, 6, 8, 10});

        Solution solution = new Solution();

        ListNodeUtils.println(solution.mergeSort(list1, list2));
        ListNodeUtils.println(solution.mergeSort2(list1, list2));
    }
}
