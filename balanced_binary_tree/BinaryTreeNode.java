class BinaryTreeNode {
    public int key;
    public byte height;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        key = value;
        height = 1;
        left = null;
        right = null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public String toString() {
        return Integer.toString(key) + " height: " + Byte.toString(height);
    }
}