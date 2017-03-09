public class BalancedBinaryTree {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = { 7, 6, 5, 4, 3, 2, 1, 0 };
        tree.push(values);
        tree.print();
    }
}