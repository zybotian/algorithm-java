package solution.q60;

import common.TreeNode;
import utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 之字形打印二叉树
 */
public class Solution {

    public List<List<Integer>> visit(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 结果列表
        List<List<Integer>> result = new ArrayList<>();
        int depth = 0;
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (depth % 2 == 0) {
                    tmp.add(poll.val);
                } else {
                    tmp.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(tmp);
            depth++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.visit(TreeNodeUtils.create()));
    }
}
