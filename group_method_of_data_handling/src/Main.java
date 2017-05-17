import Jama.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static double[][] group(Generator g, int N) {
        int K = (int) Math.pow(2, N);

        List<Integer> vars = new ArrayList<Integer>();
        Model[] tmp_models = new Model[3];
        ModelBuilder[] builders = new ModelBuilder[3];
        double[] bests = {0, 0, 0};
        Model[] models  = new Model[3];

        for(int i = 1; i < K; i++) {
            int k = i;
            vars.clear();
            for (int j = 0; j < N; j++) {
                if (k % 2 == 1) vars.add(j);
                k /= 2;
            }

            tmp_models[0] = new LinearModel(g.getX(), g.getY(), vars);
            tmp_models[1] = new QuadraticModel(g.getX(), g.getY(), vars);
            tmp_models[2] = new LogarithmicModel(g.getX(), g.getY(), vars);

            for (int j = 0; j < 3; j++)
                builders[j] = new ModelBuilder(tmp_models[j]);

            for (int j = 0; j < 3; j++) {
                builders[j].run();
            }

            try {
                for (int j = 0; j < 3; j++)
                    builders[j].join();
            } catch(InterruptedException e) {
                return new double[1][1];
            }

            for (int j = 0; j < 3; j++) {
                if (bests[j] < builders[j].getC()) {
                    bests[j] = builders[j].getC();
                    models[j] = tmp_models[j];

                    System.out.println("Model #" + i + " (" + j + ") Better C = " + bests[j]);
                }
            }

        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Best model C = " + bests[i]);
        }

        double[][] result = {models[0].getY(), models[1].getY(), models[2].getY()};
        Matrix Res = new Matrix(result);
        Res = Res.transpose();

        return Res.getArray();
    }

    public static void main(String[] args) {
        double[] b = {100, 10, 5, 6, 8, 0, 12, 9};
        int N = 7;
        int M = 10;
        Generator g = new Generator(b, M);

        double[][] result = group(g, N);

        Model[] models = {new LinearModel(result, g.getY()), new QuadraticModel(result, g.getY()), new LogarithmicModel(result, g.getY())};
        for (int i = 0; i < 3; i++) {
            models[i].perform();
            System.out.println("Model " + i + " R = " + models[i].R());
        }
    }
}

