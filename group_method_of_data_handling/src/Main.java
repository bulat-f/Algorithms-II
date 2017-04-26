public class Main {
    public static void main(String[] args) {
        double[] b = {100, 10, 5, 6, 8};
        double[] b_approx;
        Generator g = new Generator(b, 10);
        LinearModel model = new LinearModel(g.getX(), g.getY());
        b_approx = model.getB();
        for (int i = 0; i < b_approx.length; i++) {
            System.out.println("b[" + i + "] = " + b_approx[i]);
        }
    }
}

