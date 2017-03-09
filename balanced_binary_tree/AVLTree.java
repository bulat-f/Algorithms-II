public class AVLTree extends BinaryTree {

    public AVLTree() {
        root = null;
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

    protected BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            node = new BinaryTreeNode(value);
            return node;
        } else {
            if (value > node.key)
                node.right = insert(node.right, value);
            else
                node.left = insert(node.left, value);
        }

        node = balance(node);
        return node;
    }
}