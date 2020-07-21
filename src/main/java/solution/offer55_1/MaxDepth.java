package solution.offer55_1;

import common.TreeNode;
import utils.TreeNodeUtils;

/**
 * 二叉树的深度
 */
public class MaxDepth {

    // 递归
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.depth(TreeNodeUtils.create()));
    }
}
