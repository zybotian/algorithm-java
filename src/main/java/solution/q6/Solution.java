package solution.q6;

import common.TreeNode;
import utils.TreeNodeUtils;

public class Solution {
    // 先根+中根序列构建二叉树
    public TreeNode reCreate(int[] preOrder, int[] inOrder) {
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
        Solution solution = new Solution();
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        final TreeNode treeNode = solution.reCreate(preOrder, inOrder);
        TreeNodeUtils.preOrder(treeNode);
        System.out.println();
        TreeNodeUtils.inOrder(treeNode);
        System.out.println();
        TreeNodeUtils.postOrder(treeNode);
    }
}
