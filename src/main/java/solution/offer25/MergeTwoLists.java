package solution.offer25;

import common.ListNode;
import utils.ListNodeUtils;

/**
 * 合并两个有序单向链表
 */
public class MergeTwoLists {

    // 非递归
    public ListNode mergeSort(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        curr.next = p1 == null ? p2 : p1;

        return head.next;
    }

    // 递归
    public ListNode mergeSort2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode p1 = l1, p2 = l2;
        if (p1.val < p2.val) {
            ListNode tmp = mergeSort2(p1.next, p2);
            p1.next = tmp;
            return p1;
        } else {
            ListNode tmp = mergeSort2(p1, p2.next);
            p2.next = tmp;
            return p2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = ListNodeUtils.create(new int[]{1, 3, 5, 7, 9, 10});
        ListNode list2 = ListNodeUtils.create(new int[]{2, 4, 6, 8, 10});

        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        ListNodeUtils.println(mergeTwoLists.mergeSort(list1, list2));

        ListNode list3 = ListNodeUtils.create(new int[]{1, 3, 5, 7, 9, 10});
        ListNode list4 = ListNodeUtils.create(new int[]{2, 4, 6, 8, 10});

        ListNodeUtils.println(mergeTwoLists.mergeSort2(list3, list4));
    }
}
