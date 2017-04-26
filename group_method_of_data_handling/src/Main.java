public class Main {
    public static void main(String[] args) {
        double[] b = {10, 5, 6, 8};
        Generator g = new Generator(b, 10);
        double[] b_ = Modeling.perform(g.getX(), g.getY());
        for (int i = 0; i < b_.length; i++) {
            System.out.println("b[" + i + "] = " + b_[i]);
        }
    }
}

