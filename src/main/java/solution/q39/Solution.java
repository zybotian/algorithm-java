package solution.q39;

import common.TreeNode;
import utils.TreeNodeUtils;

/**
 * 二叉树的深度
 */
public class Solution {

    // 递归
    public int depth(TreeNode root) {
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
        Solution solution = new Solution();
        System.out.println(solution.depth(TreeNodeUtils.create()));
        System.out.println(solution.isBalanced(TreeNodeUtils.create()));
    }
}
