public class Main {
    public static void main(String[] args) {
        double[] b = {100, 10, 5, 6, 8, 0, 12, 9};

        Generator g = new Generator(b, 10);
        int[] vars_2 = {};

        LinearModel model_1 = new LinearModel(g.getX(), g.getY());
        LinearModel model_2 = new LinearModel(g.getX(), g.getY(), vars_2);

        printB(model_1.getB());
        printB(model_2.getB());

        System.out.println("Model 1 R = " + model_1.R());
        System.out.println("Model 2 R = " + model_2.R());

    }

    public static void printB(double[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "] = " + b[i]);
        }
        System.out.println();
    }
}

