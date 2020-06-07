package utils;

import common.ListNode;

public class ListNodeUtils {
    public static ListNode create() {
        int[] nodes = {1, 3, 5, 6, 7, 8, 9};
        ListNode node = new ListNode(nodes[0]);
        ListNode current = node;
        for (int i = 1; i < nodes.length; i++) {
            ListNode listNode = new ListNode(nodes[i]);
            current.next = listNode;
            current = current.next;
        }
        return node;
    }
}
