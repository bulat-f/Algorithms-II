import Jama.Matrix;

/**
 * Created by bulat on 4/26/17.
 */
public class LinearModel implements Model {
    private Matrix X;
    private Matrix Y;
    private Matrix b;

    public LinearModel(double[][] _X, double[] _Y, int[] vars) {
        int n = _X.length, m = vars.length;
        double[][] new_X = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            new_X[i][0] = 1;
            for (int j = 0; j < m; j++)
                new_X[i][j + 1] = _X[i][vars[j]];
        }
        X = new Matrix(new_X);
        Y = new Matrix(_Y, _Y.length);

        Matrix X_t = X.transpose();
        b = X_t.times(X).inverse().times(X_t).times(Y);
    }

    public LinearModel(double[][] _X, double[] _Y) {
        this(_X, _Y, genVars(_X));
    }

    public double[] getB() {
        return b.getColumnPackedCopy();
    }

    public Matrix Y_approx() {
        return X.times(b);
    }

    public double R() {
        return 1 - S1() / S2();
    }

    public double DW() {
        return 2;
    }

    private double S1() {
        return Y.minus(Y_approx()).norm2();
    }

    private double S2() {
        Matrix Y_ = Y_approx();
        double mean = Y_.norm1();
        Matrix Y_mean = new Matrix(Y_.getRowDimension(), Y_.getColumnDimension(), mean);
        return Y.minus(Y_mean).norm2();
    }

    private static int[] genVars(double[][] _X) {
        int[] vars = new int[_X[0].length];
        for (int i = 0; i < vars.length; i++)
            vars[i] = i;
        return vars;
    }
}
