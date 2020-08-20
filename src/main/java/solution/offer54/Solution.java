package solution.offer54;

import common.TreeNode;
import utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 求二叉搜索树第k大/小的节点
 */
public class Solution {

    List<Integer> result = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        inOrderVisit(root);
        return result.get(result.size() - k);
    }

    private void inOrderVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrderVisit(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inOrderVisit(root.right);
        }
    }

    public TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        // 计算左子树的节点数目
        int countLeft = count(root.left);
        // 左子树节点数刚好等于k-1，则根节点是第k小的节点
        if (countLeft == k - 1) {
            return root;
        }
        // 左子树的节点数大于k-1，则在左子树中查找即可
        if (countLeft > k - 1) {
            return kthNode(root.left, k);
        }
        // 左子树的节点数小于k-1，则在右子树中查找第k-1-countleft个节点
        return kthNode(root.right, k - 1 - countLeft);
    }

    // 计算二叉树的节点数
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNodeUtils.create(new int[]{10, 8, 20, 6, 9, 18, 30, 4});
        for (int i = 1; i <= 8; i++) {
            System.out.println(solution.kthLargest(treeNode, i) + "==" + solution.kthNode(treeNode, 8 - i + 1));
        }
    }
}
