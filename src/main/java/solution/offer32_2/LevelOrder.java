package solution.offer32_2;

import common.TreeNode;
import utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树,输出无需区分层数
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(TreeNodeUtils.create()));
    }
}
