package common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
