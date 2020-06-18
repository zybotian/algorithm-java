package solution.q24;

/**
 * 输入一个整数数组，判断该数组是不是二叉搜索树的后序遍历的结果。
 * 如果是则输出true否则输出false
 * 假设输入的数组的任意两个数字都互不相同
 */
public class Solution {

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySequenceOfBST(int[] array, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int root = array[end];
        int firstMax = -1;
        for (int index = begin; index < end; index++) {
            if (array[index] > root) {
                firstMax = index;
                break;
            }
        }
        // 如果没有找到比根节点大的，说明没有右子树，那么直接判断左子树
        if (firstMax == -1) {
            return verifySequenceOfBST(array, begin, end - 1);
        }

        // 如果有右子树，那么检查右子树是否全部大于根节点
        for (int i = firstMax + 1; i < end; i++) {
            //如果右子树存在比根节点小的，返回false
            if (array[i] < root) {
                return false;
            }
        }
        // 递归检查左右子树
        return verifySequenceOfBST(array, begin, firstMax - 1) && verifySequenceOfBST(array, firstMax, end - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifySequenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(solution.verifySequenceOfBST(new int[]{5, 7, 6}));
        System.out.println(solution.verifySequenceOfBST(new int[]{5, 6}));
        System.out.println(solution.verifySequenceOfBST(new int[]{7, 6}));
        System.out.println(solution.verifySequenceOfBST(new int[]{7, 4, 6, 5}));
    }
}
