package solution.q59;

import common.TreeNode;
import utils.TreeNodeUtils;

public class Solution {
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }

        return tree1.val == tree2.val && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSymmetrical(TreeNodeUtils.create(new int[]{1, 2, 2, 3, 4, 4, 3})));
    }
}
