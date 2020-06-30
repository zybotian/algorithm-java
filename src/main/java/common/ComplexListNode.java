package common;

public class ComplexListNode {
    public int val;
    public ComplexListNode next;
    public ComplexListNode random;

    public ComplexListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ComplexListNode{" +
                "val=" + val +
                ",next=" + (next != null ? next.val : "next") +
                ",random=" + (random != null ? random.val : "random") +
                '}';
    }
}
