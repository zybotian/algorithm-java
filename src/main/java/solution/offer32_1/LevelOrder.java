package solution.offer32_1;

import common.TreeNode;
import utils.ArrayUtils;
import utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树,输出无需区分层数
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int k = 0;
        int[] array = new int[list.size()];
        for (Integer val : list) {
            array[k++] = val;
        }
        return array;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        ArrayUtils.print(levelOrder.levelOrder(TreeNodeUtils.create()));
    }
}
