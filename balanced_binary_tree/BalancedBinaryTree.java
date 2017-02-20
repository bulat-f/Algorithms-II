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
        }
        else {
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
        }
        else {
            node.add(value);
            return node;
        }
    }
}

class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void add(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
        }
        else {
            root.add(value);
        }
    }

    public void push(int values[]) {
        for (int i = 0; i < values.length; i++) {
            add(values[i]);
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        else {
            root.print();
        }
    }
}


public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = { 5, 7, 3, 4, 1 };
        tree.print();
        tree.push(values);
        tree.print();
    }
}