package solution.offer55_2;

import common.TreeNode;
import utils.TreeNodeUtils;

/**
 * 是否是平衡二叉树
 */
public class IsBalanceTree {

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    public static void main(String[] args) {
        IsBalanceTree isBalanceTree = new IsBalanceTree();
        System.out.println(isBalanceTree.isBalanced(TreeNodeUtils.create()));
    }
}
