package solution.offer27;

import common.TreeNode;
import utils.TreeNodeUtils;

/**
 * 求输入的二叉树的镜像二叉树
 */
public class MirrorTree {

    public TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        // 递归求左子树的镜像
        TreeNode mirrorLeft = mirror(root.left);
        // 递归求右子树的镜像
        TreeNode mifforRight = mirror(root.right);
        // 新的左孩子节点指向右子树的镜像
        root.left = mifforRight;
        // 新的右孩子指向左子树的镜像
        root.right = mirrorLeft;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        MirrorTree mirrorTree = new MirrorTree();

        TreeNode mirror = mirrorTree.mirror(root);
        TreeNodeUtils.preOrder(mirror);
        System.out.println();
        TreeNodeUtils.inOrder(mirror);
        System.out.println();
        TreeNodeUtils.postOrder(mirror);

    }
}
