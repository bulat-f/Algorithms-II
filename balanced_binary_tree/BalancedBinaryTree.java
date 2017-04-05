public class BalancedBinaryTree {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = { 3, 4, 5, 6, 7, 2, 1, 0 };
        tree.push(values);
        tree.print();
    }
}