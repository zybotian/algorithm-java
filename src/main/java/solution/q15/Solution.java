package solution.q15;

import common.ListNode;
import utils.ListNodeUtils;

/**
 * 求链表的倒数第k个节点
 */
public class Solution {

    // 快慢指针
    public ListNode findKthNodeFromTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (k > 1) {
            k--;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode findKthNodeFromTail2(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        // 倒数第k个是整数第n-k+1个
        int count = length - k + 1;
        if (count > 0) {
            p = head;
            while (count > 1) {
                p = p.next;
                count--;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNodeFromTail(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7}), 3));
        System.out.println(solution.findKthNodeFromTail2(ListNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7}), 3));
    }
}
