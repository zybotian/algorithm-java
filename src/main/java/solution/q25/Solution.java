package solution.q25;

import common.TreeNode;
import utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Solution {

    // 临时结果
    List<Integer> tmp = new ArrayList<>();

    // 最终结果
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        tmp.add(root.val);
        target -= root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && target == 0) {
            result.add(new ArrayList<>(tmp));
        } else {
            findPath(root.left, target);
            findPath(root.right, target);
        }
        tmp.remove(tmp.size() - 1);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPath(TreeNodeUtils.create(new int[]{10, 5, 12, 4, 7}), 22));
    }
}
