public class AVLBalancer implements IBalancer {
    public AVLBalancer() {
    }

    public BinaryTreeNode balance(BinaryTreeNode node) {
        if (node != null) {
            node.left = balance(node.left);
            node.right = balance(node.right);
            fixHeight(node);
            byte bfactor = bfactor(node);
            if (bfactor > 1) {
                if (bfactor(node.right) < 0) {
                    node = rotateRightLeft(node);
                } else {
                    node = rotateLeft(node);
                }
            } else if (bfactor < -1) {
                if (bfactor(node.left) > 0) {
                    node = rotateLeftRight(node);
                } else {
                    node = rotateRight(node);
                }
            }
        }

        return node;
    }

    protected BinaryTreeNode rotateRight(BinaryTreeNode node) {
        BinaryTreeNode tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        fixHeight(node);
        fixHeight(tmp);
        return tmp;
    }

    protected BinaryTreeNode rotateLeft(BinaryTreeNode node) {
        BinaryTreeNode tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        fixHeight(node);
        fixHeight(tmp);
        return tmp;
    }

    protected BinaryTreeNode rotateRightLeft(BinaryTreeNode node) { // BigLeft
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    protected BinaryTreeNode rotateLeftRight(BinaryTreeNode node) { // BigLeft
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    protected byte bfactor(BinaryTreeNode node) {
        return (byte) (height(node.right) - height(node.left));
    }

    protected byte height(BinaryTreeNode node) {
        return node == null ? 0 : node.height;
    }

    protected void fixHeight(BinaryTreeNode node) {
        byte h1 = height(node.left),
             h2 = height(node.right);

        node.height = (byte) ((h1 > h2 ? h1 : h2) + 1);
    }
}