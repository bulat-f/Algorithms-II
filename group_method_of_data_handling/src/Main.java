import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double[] b = {100, 10, 5, 6, 8, 0, 12, 9};
        int N = 7;
        int M = 10;

        int K = (int) Math.pow(2, N);

        Generator g = new Generator(b, M);
        List<Integer> vars = new ArrayList<Integer>();
        Model model_1, model_2, model_3;

        for(int i = 1; i < K; i++) {
            int k = i;
            vars.clear();
            for (int j = 0; j < N; j++) {
                if (k % 2 == 1) vars.add(j);
                k /= 2;
            }
            System.out.println(i);
            model_1 = new LinearModel(g.getX(), g.getY(), vars);
            model_2 = new QuadraticModel(g.getX(), g.getY(), vars);
            model_3 = new LogarithmicModel(g.getX(), g.getY(), vars);

            System.out.println("Model 1 R = " + model_1.R());
            System.out.println("Model 1 DW = " + model_1.DW());
            System.out.println("Model 2 R = " + model_2.R());
            System.out.println("Model 2 DW = " + model_2.DW());
            System.out.println("Model 3 R = " + model_3.R());
            System.out.println("Model 3 DW = " + model_3.DW());

            System.out.println(vars);
        }
    }

    public static void printB(double[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "] = " + b[i]);
        }
        System.out.println();
    }
}

