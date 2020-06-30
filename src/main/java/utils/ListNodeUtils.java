package utils;

import common.ComplexListNode;
import common.ListNode;

import java.util.ArrayList;
import java.util.List;

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

    public static ComplexListNode createComplex(int[] nodes) {
        List<ComplexListNode> nodes1 = new ArrayList<>();
        ComplexListNode node = new ComplexListNode(nodes[0]);
        nodes1.add(node);
        ComplexListNode current = node;
        for (int i = 1; i < nodes.length; i++) {
            ComplexListNode listNode = new ComplexListNode(nodes[i]);
            current.next = listNode;
            current = current.next;
            nodes1.add(listNode);
        }

        nodes1.get(0).random = nodes1.get(2);
        nodes1.get(1).random = nodes1.get(2);
        nodes1.get(3).random = nodes1.get(1);
        nodes1.get(4).random = nodes1.get(3);
        return node;
    }

    public static void println(ComplexListNode result) {
        if (result == null) {
            System.out.println("####");
            return;
        }
        ComplexListNode cur = result;
        while (cur != null) {
            System.out.print(cur + "\t");
            cur = cur.next;
        }
        System.out.println();
    }
}