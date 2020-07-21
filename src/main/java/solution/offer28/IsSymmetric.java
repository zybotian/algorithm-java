package solution.offer28;

import common.TreeNode;
import utils.TreeNodeUtils;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorTree(root.left, root.right);
    }

    private boolean isMirrorTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirrorTree(left.right, right.left) && isMirrorTree(left.left, right.right);
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(TreeNodeUtils.create(new int[]{1, 2, 2, 3, 4, 4, 3})));
    }
}
