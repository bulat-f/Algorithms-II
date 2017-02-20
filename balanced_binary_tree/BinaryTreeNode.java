class BinaryTreeNode {
    private int key;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        key = value;
        left = null;
        right = null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void add(int value) {
        if (key < value)
        {
            right = addToNode(right, value);
        } else {
            left = addToNode(left, value);
        }
    }

    public void print() {
        print(0);
    }

    public void print(int level) {
        if (right != null) {
            right.print(level + 1);
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(key);

        if (left != null) {
            left.print(level + 1);
        }
    }

    private BinaryTreeNode addToNode(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        } else {
            node.add(value);
            return node;
        }
    }
}