public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = { 5, 7, 3, 4, 1 };
        tree.print();
        tree.push(values);
        tree.print();
    }
}