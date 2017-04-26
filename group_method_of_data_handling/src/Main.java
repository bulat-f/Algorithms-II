public class Main {
    public static void main(String[] args) {
        double[] b = {100, 10, 5, 6, 8};

        Generator g = new Generator(b, 10);
        int[] vars_2 = {0, 2, 3};

        LinearModel model_1 = new LinearModel(g.getX(), g.getY());
        LinearModel model_2 = new LinearModel(g.getX(), g.getY(), vars_2);

        printB(model_1.getB());
        printB(model_2.getB());
    }

    public static void printB(double[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "] = " + b[i]);
        }
        System.out.println();
    }
}

