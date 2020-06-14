package utils;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtils {
    public static TreeNode create() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    public static TreeNode create(int[] arr) {
        if (arr.length == 1) {
            return new TreeNode(arr[0]);
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodeList.add(new TreeNode(arr[i]));
        }
        int temp = 0;
        while (temp <= (arr.length - 2) / 2) { //注意这里，数组的下标是从零开始的
            if (2 * temp + 1 < arr.length)
                nodeList.get(temp).left = nodeList.get(2 * temp + 1);
            if (2 * temp + 2 < arr.length)
                nodeList.get(temp).right = nodeList.get(2 * temp + 2);
            temp++;
        }
        return nodeList.get(0);
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "\t");
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + "\t");
        }
    }
}
