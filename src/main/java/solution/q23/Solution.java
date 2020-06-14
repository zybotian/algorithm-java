package solution.q23;

import common.TreeNode;
import utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树,输出无需区分层数
 */
public class Solution {

    public List<Integer> visit(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 结果列表
        List<Integer> result = new ArrayList<>();
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.visit(TreeNodeUtils.create()));
    }
}
