/**
 * Created by bulat on 4/27/17.
 */
public class Perceptron {
    double[] w;
    double[][] patterns = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    double[] results = {0, 1, 1, 1};

    public Perceptron() {
        int n = patterns[0].length;
        w = new double[n];
        for (int i = 0; i < n; i++) {
            w[i] = Math.random() * 0.2 + 0.1;
            System.out.println("Начальные значения весов");
            System.out.println("w[" + i + "]=" + w[i]);
        }
    }

    public Perceptron(double[][] pat, double[] res) {
        this();
        patterns = pat;
        results = res;
    }

    public double f(double[] x) {
        double y = 0;
        for (int i = 0; i < x.length; i++) {
            y += x[i] * w[i];
        }
        System.out.println("Взвешенная сумма входных значений = " + y);
        return y > 0.5 ? 1 : 0;
    }

    public void study() {
        double gEr = 0, y = 0;
        double[] x;
        int m = 0;
        do {
            gEr = 0;
            for (int p = 0; p < patterns.length; p++) {
                x = java.util.Arrays.copyOf(patterns[p], patterns[p].length);
                y = f(x);
                double er = results[p] - y;
                gEr += Math.abs(er);
                for (int i = 0; i < x.length; i++) {
                    w[i] += 0.1 * er * x[i];
                }
            }
            m++;
        } while (gEr != 0);
        System.out.println("m=" + m);
    }

    public double test(double[] x) {
        study();
        return f(x);
//        for (int p = 0; p < patterns.length; p++) {
//            x = java.util.Arrays.copyOf(patterns[p], patterns[p].length);
//            y = f();
//            System.out.println("y = " + y);
//        }
    }
}
