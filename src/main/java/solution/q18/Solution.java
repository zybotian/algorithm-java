package solution.q18;

import common.TreeNode;
import utils.TreeNodeUtils;

/**
 * 二叉树A中是否包含子树B
 */
public class Solution {

    public boolean hasSubTree(TreeNode source, TreeNode target) {
        if (source == null || target == null) {
            return false;
        }
        if (doesTree1HaveTree2(source, target)) {
            return true;
        }
        return hasSubTree(source.left, target) || hasSubTree(source.right, target);
    }

    public static boolean doesTree1HaveTree2(TreeNode source, TreeNode target) {
        if (target == null) {
            return true;
        }
        if (source == null) {
            return false;
        }
        if (source.val != target.val) {
            return false;
        }
        return doesTree1HaveTree2(source.left, target.left) && doesTree1HaveTree2(source.right, target.right);
    }

    public static void main(String[] args) {
        TreeNode source = TreeNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode target = TreeNodeUtils.create(new int[]{2, 4, 5});
        TreeNodeUtils.preOrder(source);
        System.out.println();
        TreeNodeUtils.preOrder(target);
        System.out.println();

        TreeNodeUtils.inOrder(target);
        System.out.println();

        TreeNodeUtils.postOrder(target);
        System.out.println();

        Solution solution = new Solution();
        System.out.println(solution.hasSubTree(source, target));
        System.out.println(solution.hasSubTree(source, TreeNodeUtils.create(new int[]{2, 4})));
        System.out.println(solution.hasSubTree(source, TreeNodeUtils.create(new int[]{2, 5})));

    }
}
