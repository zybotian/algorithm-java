package solution.q13;

import common.ListNode;
import utils.ListNodeUtils;

/**
 * O1时间复杂度删除单链表指定元素
 */
public class Solution {

    public ListNode delete(ListNode head, ListNode toDelete) {
        if (head == null || toDelete == null) {
            return head;
        }
        // 待删除的是头节点
        if (head == toDelete) {
            head = head.next;
            return head;
        }
        // 待删除的是尾节点
        if (toDelete.next == null) {
            ListNode current = head;
            while (current.next != null && current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        } else {
            // 待删除的是中间节点
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 中间节点
        ListNode head1 = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode delete1 = solution.delete(head1, head1.next);
        ListNodeUtils.println(delete1);

        // 尾节点
        ListNode head2 = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode delete2 = solution.delete(head2, head2.next.next.next.next.next.next);
        ListNodeUtils.println(delete2);

        // 尾节点
        ListNode head3 = ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode delete3 = solution.delete(head3, head3);
        ListNodeUtils.println(delete3);

        // 一个元素，删除头节点
        ListNode head4 = ListNodeUtils.create(new int[]{1});
        ListNode delete4 = solution.delete(head4, head4);
        ListNodeUtils.println(delete4);

        // 两个元素，删除头节点
        ListNode head5 = ListNodeUtils.create(new int[]{1, 2});
        ListNode delete5 = solution.delete(head5, head5);
        ListNodeUtils.println(delete5);

        // 两个元素，删除头节点
        ListNode head6 = ListNodeUtils.create(new int[]{1, 2});
        ListNode delete6 = solution.delete(head6, head6.next);
        ListNodeUtils.println(delete6);
    }
}
