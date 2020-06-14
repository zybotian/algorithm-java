package utils;

import common.ListNode;

public class ListNodeUtils {
    public static ListNode create() {
        int[] nodes = {1, 3, 5, 6, 7, 8, 9};
        return create(nodes);
    }

    public static ListNode create(int[] nodes) {
        ListNode node = new ListNode(nodes[0]);
        ListNode current = node;
        for (int i = 1; i < nodes.length; i++) {
            ListNode listNode = new ListNode(nodes[i]);
            current.next = listNode;
            current = current.next;
        }
        return node;
    }

    public static void println(ListNode result) {
        if (result == null) {
            System.out.println("####");
            return;
        }
        ListNode cur = result;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }
}
