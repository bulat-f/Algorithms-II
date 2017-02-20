public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void add(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
        } else {
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
        } else {
            root.print();
        }
    }
}