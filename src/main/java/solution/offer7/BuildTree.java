package solution.offer7;

import common.TreeNode;
import utils.TreeNodeUtils;

import java.util.Arrays;

public class BuildTree {
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                node.left = buildTree2(Arrays.copyOfRange(preorder, 1, 1 + i), Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree2(Arrays.copyOfRange(preorder, 1 + i, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                return node;
            }
        }
        return null;

    }


    // 先根+中根序列(数字不重复)构建二叉树
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }

        return reCreate(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private TreeNode reCreate(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int inOrderRootIndex = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrder[i] == root.val) {
                inOrderRootIndex = i;
                break;
            }
        }
        root.left = reCreate(preOrder, preLeft + 1, preLeft + inOrderRootIndex - inLeft, inOrder, inLeft, inOrderRootIndex - 1);
        root.right = reCreate(preOrder, preLeft + inOrderRootIndex - inLeft + 1, preRight, inOrder, inOrderRootIndex + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        final TreeNode treeNode = buildTree.buildTree(preOrder, inOrder);
        TreeNodeUtils.preOrder(treeNode);
        System.out.println();
        TreeNodeUtils.inOrder(treeNode);
        System.out.println();
        TreeNodeUtils.postOrder(treeNode);
    }
}
