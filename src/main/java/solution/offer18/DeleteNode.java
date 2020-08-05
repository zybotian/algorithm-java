package solution.offer18;

import common.ListNode;

public class DeleteNode {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点
     * 各节点值互不相同
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            if (curr.val == val) {
                pre.next = next;
                break;
            }
            pre = curr;
            curr = curr.next;
        }
        return head;
    }

}
