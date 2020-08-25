package solution.offer35;

import common.ComplexListNode;
import utils.ListNodeUtils;

/**
 * 复杂链表的复制
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        final ComplexListNode complex = ListNodeUtils.createComplex(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.println(complex);
        final ComplexListNode clone = solution.copyRandomList(complex);
        ListNodeUtils.println(clone);
    }

    public ComplexListNode copyRandomList(ComplexListNode head) {
        if (head == null) {
            return null;
        }

        // next指针将clone的节点串在原节点的next处
        ComplexListNode p = head;
        while (p != null) {
            ComplexListNode cloneNode = new ComplexListNode(p.val);
            cloneNode.next = p.next;
            p.next = cloneNode;
            p = cloneNode.next;
        }

        // cloned节点的random指针指向源节点的random指针指向元素的下一个节点
        p = head;
        while (p != null && p.next != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 拆分开
        ComplexListNode p1 = head;
        ComplexListNode p2 = head.next, newHead = head.next;
        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            if (p2.next != null) {
                p2.next = p2.next.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return newHead;
    }
}
