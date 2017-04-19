public class BalancedBinaryTree {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        tree.push(values);
        tree.print();
        System.out.println("==== Balancing ====");
        tree.balance();
        tree.print();
    }
}