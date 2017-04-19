public class BinaryTree {
    protected BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    protected BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            node = new BinaryTreeNode(value);
        } else {
            if (value > node.key)
                node.right = insert(node.right, value);
            else
                node.left = insert(node.left, value);
        }

        return node;
    }

    public byte height(BinaryTreeNode node) {
        return node == null ? 0 : node.height;
    }

    public byte bfactor(BinaryTreeNode node) {
        return (byte) (height(node.right) - height(node.left));
    }

    public void fixHeight(BinaryTreeNode node) {
        byte h1 = height(node.left),
             h2 = height(node.right);

        node.height = (byte) ((h1 > h2 ? h1 : h2) + 1);
    }

    public void fixHeightR(BinaryTreeNode node) {
        if (node != null) {
            fixHeightR(node.left);
            fixHeightR(node.right);
            fixHeight(node);
        }
    }

    public void fixHeight() {
        fixHeightR(root);
    }

    public void push(int values[]) {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            print(root, 0);
        }
    }

    protected void print(BinaryTreeNode node, int level) {
        if (node != null) {
            print(node.right, level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }
            System.out.print("+->");
            System.out.println(node);

            print(node.left, level + 1);
        }
    }
}