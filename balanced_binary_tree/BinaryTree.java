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

    public byte height(BinaryTreeNode node) {
        return node == null ? 0 : node.height;
    }

    public int bfactor(BinaryTreeNode node) {
        return height(node.right) - height(node.left);
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

    public BinaryTreeNode rotateRight(BinaryTreeNode node) {
        BinaryTreeNode tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        fixHeight(node);
        fixHeight(tmp);
        return tmp;
    }

    public BinaryTreeNode rotateLeft(BinaryTreeNode node) {
        BinaryTreeNode tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        fixHeight(node);
        fixHeight(tmp);
        return tmp;
    }

    public BinaryTreeNode balance(BinaryTreeNode node) {
        fixHeight(node);
        if (bfactor(node) == 2) {
            if (bfactor(node.right) < 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        if (bfactor(node) == -2) {
            if (bfactor(node.left) > 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        return node;
    }

    public void balance() {
        root = balance(root);
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