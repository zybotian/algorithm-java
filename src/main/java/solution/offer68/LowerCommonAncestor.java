package solution.offer68;

import common.TreeNode;
import utils.TreeNodeUtils;

/**
 * 求二叉搜索树中两个节点的最低公共祖先
 */
public class LowerCommonAncestor {
    public TreeNode lowerCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowerCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowerCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.create(new int[]{10, 8, 20, 6, 9, 18, 30, 4});
        LowerCommonAncestor lowerCommonAncestor = new LowerCommonAncestor();
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(8), new TreeNode(10)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(8), new TreeNode(20)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(6), new TreeNode(20)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(6), new TreeNode(9)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(18), new TreeNode(30)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(6), new TreeNode(30)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(4), new TreeNode(30)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(4), new TreeNode(8)));
        System.out.println(lowerCommonAncestor.lowerCommonAncestor(root, new TreeNode(4), new TreeNode(9)));
    }

}
