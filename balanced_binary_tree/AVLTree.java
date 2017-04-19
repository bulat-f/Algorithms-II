public class AVLTree extends BinaryTree {
    private AVLBalancer balancer;

    public AVLTree() {
        root = null;
        balancer = new AVLBalancer();
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

    public void balance() {
        root = balancer.balance(root);
    }

    // protected BinaryTreeNode insert(BinaryTreeNode node, int value) {
    //     if (node == null) {
    //         node = new BinaryTreeNode(value);
    //         return node;
    //     } else {
    //         if (value > node.key)
    //             node.right = insert(node.right, value);
    //         else
    //             node.left = insert(node.left, value);
    //     }

    //     node = balance(node);
    //     return node;
    // }
}