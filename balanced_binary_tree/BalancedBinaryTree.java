public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = { 5, 7, 3, 4, 1, 0 };
        tree.print();
        tree.push(values);
        tree.print();
        tree.fixHeight();
        System.out.println("===========");
        tree.print();

        tree.balance();
        System.out.println("===========");
        tree.print();
    }
}